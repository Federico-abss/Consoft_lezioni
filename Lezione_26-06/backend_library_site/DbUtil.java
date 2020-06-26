package library;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DbUtil {
	
	private String host = "localhost";
	private String database = "biblioteca";
	private String username = "root";
	private String password = "";
	private boolean connected;
	private PreparedStatement stmt;
	private Connection conn;
	private Utente utente;
	
	/* questa query ritorna tutte le informazioni su tutti i libri inclusi dettagli su autori ed autori secondari */
	private final String queryCreazioneLibri = "SELECT\r\n" + 
			"l.*, diretti.id_persona, diretti.biografia, dirette.cognome, dirette.nome, dirette.data_nascita\r\n" + 
			", la.id_autore, indiretti.biografia AS biografia_secondario, indiretti.id_persona AS id_persona_secondaria, " +
		    " indiretti.id AS id_autore_secondario, indirette.cognome AS cognome_secondario, indirette.nome AS nome_secondario\r\n" + 
			", indirette.data_nascita AS data_nascita_secondario FROM libri l \r\n" +
			"INNER JOIN autori diretti ON l.id_autore = diretti.id\r\n" + 
			"LEFT OUTER JOIN libri_autori la ON la.id_libro = l.id\r\n" + 
			"LEFT OUTER JOIN autori indiretti ON indiretti.id = la.id_autore\r\n" + 
			"INNER JOIN persone dirette ON diretti.id_persona = dirette.id\r\n" + 
			"LEFT OUTER JOIN persone indirette ON indiretti.id_persona = indirette.id ";
	
	
	public DbUtil() {
	}
	
	public DbUtil(String host, String database, String username, String password) {
		this.host = host;
		this.database = database;
		this.username = username;
		this.password = password;
	}
	
	public boolean connect() {
		//tenta di effettuare connessione al db
		
		try {
			//registro driver			
			Class.forName("org.mariadb.jdbc.Driver");			
			
			String url = "jdbc:mariadb://" + host + ":3306/" + database + "?serverTimezone=UTC";
			
			//effettuo connessione database
			conn = DriverManager.getConnection(url,username,password);
			
			return true;
			
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	
	public boolean checkLogin(String email, String password) {
		// cerca utente usando mail e password e ritorna true se lo trova
		
		try {
			// query ricerca utente tramite mail e password e ritorna una riga per ogni ruolo che possiede
			String query = "SELECT p.nome, cognome, data_nascita, email, password_hash, tessera, r.nome AS ruolo"
					+ " FROM utenti u INNER JOIN persone p ON u.id_persona = p.id"
					+ " JOIN ruoli_utenti ru ON u.id = ru.id_utente JOIN ruoli r ON ru.id_ruolo = r.id"
					+ " WHERE email = ? AND password_hash = MD5(?) AND attivo = 1";
			
			stmt = conn.prepareStatement(query);			
			stmt.setString(1,email);
			stmt.setString(2,password);
			
			ResultSet rs = stmt.executeQuery();
			
			while (rs.next()) {
				
				if (utente == null) {
					//salva le info utente se non e' gia' stato creato
					utente = new Utente();
					
					utente.setEmail(rs.getString("email"));
					utente.setPasswordHash(rs.getString("password_hash"));
					utente.setTessera(rs.getString("tessera"));
					utente.setAttivo(true);
					utente.addRuolo(rs.getString("ruolo"));
					
					Persona persona = new Persona();
					
					persona.setCognome(rs.getString("cognome"));
					persona.setNome(rs.getString("nome"));
					persona.setDataNascita(rs.getDate("data_nascita"));
					
					utente.setPersona(persona);
				}
				else {
					//se utente e' gia' stato creato ma ci sono altri risultati so che 
					//rappresentano ruoli secondari e li aggiungo all'utente
					utente.addRuolo(rs.getString("ruolo"));
				}
			}
			
			if (utente != null) {
				return true;
			}
			else {
				return false;
			}			
		} 
		catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	
	public List<Libri> elencoLibri() {
		//mostra ogni libro presente nel database
				
		try {
					
			stmt = conn.prepareStatement(queryCreazioneLibri);
				
			//eseguo query ed ottengo resultset
			ResultSet rs = stmt.executeQuery();
			
			//in questa lista inseriro' ogni libro senza repliche
			ArrayList<Libri> elenco = creaListaLibri(rs);
			
			return elenco;
					
		} 
		catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	
	public List<Libri> ricercaParoleChiavi(String[] parole) {
		// ricerca libro basandosi su una o piu' parole chiavi
		
		// personalizza query per includere un qualsiasi numero di parole chiavi
		String query = queryCreazioneLibri + "WHERE ";
		
		for (int i = 0; i < parole.length; i++) {
			if (i>0)
				query += " OR ";
			query += " l.titolo LIKE ? OR dirette.cognome LIKE ? OR dirette.nome LIKE ? OR indirette.cognome LIKE ? OR indirette.nome LIKE ? ";
		}

		try {
			stmt = conn.prepareStatement(query);
			
			// inserisci parole chiavi nelle query
			for (int i = 0; i < parole.length; i++) {
				for (int j = 1; j <=5; j++) {
					stmt.setString( i*5 + j, "%" + parole[i] + "%" );			
				}
			}
			
			ResultSet rs = stmt.executeQuery();
			
			ArrayList<Libri> lista = creaListaLibri(rs);
			
			return lista;
							
		} 
		catch (Exception e) {
			e.printStackTrace();
			return null;
		}		
	}
	
	
	/*
	public Libri getLibroById(int id) {
		try {
			String nquery = query + "WHERE l.id = ?";
			
			stmt.setString(1, id.toString());
			
			stmt = conn.prepareStatement(nquery);
				
			//eseguo query ed ottengo resultset
			ResultSet rs = stmt.executeQuery();
			
			Libri libro = creaLibro(rs, null);	
			return libro;
		} 
		catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	*/
	
	
	public ArrayList<Libri> creaListaLibri(ResultSet rs) {
		ArrayList<Libri> lista = new ArrayList<Libri>();
		
		try {
			
			while(rs.next()) {
				
				// Controlla se il libro trovato nella query e' gia' nella lista
				boolean inLista = false;
				Libri libro = null;
				for (Libri l: lista) {
					if (rs.getInt("id") == l.getId()) {
						inLista = true;
						libro = l;
						break;
					}
				}
				
				// se non era presente crea libro ed aggiungi alla lista
				if (!inLista) {
					
					libro = creaLibro(rs);
					lista.add(libro);
				}
				else {
					//altrimenti aggiorno libro gia' presente in lista
					addAutoreSecondario(rs, libro);
				}
			}
			
			return lista;
		}
		catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	
	public Libri creaLibro(ResultSet rs) {
		
		try {				
			Libri libro = new Libri();
			
			libro.setId(rs.getInt("id"));
			libro.setDataPrimaPubblicazione(rs.getDate("data_prima_pubblicazione"));
			libro.setTitolo(rs.getString("titolo"));
			libro.setTitoloOriginale(rs.getString("titolo_originale"));
			
			Persona persona = new Persona();
			persona.setId(rs.getInt("id_persona"));
			persona.setCognome(rs.getString("cognome"));
			persona.setNome(rs.getString("nome"));
			persona.setDataNascita(rs.getDate("data_nascita"));
			
			Autore autore = new Autore();
			autore.setId(rs.getInt("id_autore"));
			autore.setBiografia(rs.getString("biografia"));
			autore.setPersona(persona);
			
			libro.setAutore(autore);
			
			// Se presente autore secondario chiamo metodo per aggiungerlo al libro
			if (rs.getString("nome_secondario") != null) {	
				
				addAutoreSecondario(rs, libro);				
			}
				
			return libro;
			
		}
		catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	
	public void addAutoreSecondario(ResultSet rs, Libri libro) {
		// aggiungi autore secondario ad un libro gia' esistente
		
		try {
			
			Persona persona = new Persona();
			persona.setId(rs.getInt("id_persona_secondaria"));
			persona.setCognome(rs.getString("cognome_secondario"));
			persona.setNome(rs.getString("nome_secondario"));
			persona.setDataNascita(rs.getDate("data_nascita_secondario"));
				
			Autore autore = new Autore();
			autore.setId(rs.getInt("id_autore_secondario"));
			autore.setBiografia(rs.getString("biografia_secondario"));
			autore.setPersona(persona);
				
			if (libro.getAutoriSecondari() != null) {
				libro.getAutoriSecondari().add(autore);
			}
			else {
				ArrayList<Autore> listaAut = new ArrayList<Autore>();
				listaAut.add(autore);
				libro.setAutoriSecondari(listaAut);
			}
		} 
		catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	
	public boolean isConnected() {
		return connected;
	}

	public void setConnected(boolean connected) {
		this.connected = connected;
	}

	public PreparedStatement getStmt() {
		return stmt;
	}

	public void setStmt(PreparedStatement stmt) {
		this.stmt = stmt;
	}

	public Connection getConn() {
		return conn;
	}

	public void setConn(Connection conn) {
		this.conn = conn;
	}

	public void setUtente(Utente utente) {
		this.utente = utente;
	}

	public Utente getUtente() {
		return utente;
	}
	
	public String getHost() {
		return host;
	}

	public void setHost(String host) {
		this.host = host;
	}

	public String getDatabase() {
		return database;
	}

	public void setDatabase(String database) {
		this.database = database;
	}

	public String getUsername() {
		return username;
	}
	
	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
