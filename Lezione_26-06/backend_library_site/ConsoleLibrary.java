package library;
import java.sql.Date;
import java.util.concurrent.TimeUnit;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;
import java.util.Scanner;

public class ConsoleLibrary {
	private static Scanner scanner;
	private static DbUtil db;

	public static void main(String[] args) {
		
		int maxLoginTrials = 3;
		db = new DbUtil();
		
		if (db.connect()) {

			System.out.println("Benvenuto nell'applicativo Library");
			System.out.println("Inserisci le tue credenziali di accesso");
			
			scanner = new Scanner(System.in);	
			int tentativi = 0;
			
			do {
				
				System.out.println("email");
				String email = scanner.nextLine();
				
				System.out.println("password");				
				String password = scanner.nextLine();
				
				if (db.checkLogin(email, password)) {
					System.out.println("Credenziali corrette");
				}
				else {
					System.out.println("Credenziali errate");
				}
			}
			while (++tentativi < maxLoginTrials  && db.getUtente() == null);
			
			
			if (tentativi <= 3) {
				System.out.println("Ciao " + db.getUtente().getPersona().getNome());
				menuPrincipale(db);
			}
			else {
				System.out.println("Hai digitato credenziali errate per tre volte consecutive");
			}
			
		}
		else {
			System.out.println("Applicativo non visualizzabile, verificare connessione al database");
		}
		
		try {
			if (db.getStmt() != null) {
				db.getStmt().close();
			}
			if (db.getConn() != null) {
				db.getConn().close();
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private static void menuPrincipale(DbUtil db) {
		System.out.println("Scegli il numero dell'operazione da eseguire e premi invio");
		
		PreparedStatement stmt = null; 
		ResultSet rs = null;
		
		int scelta;
		do {
			System.out.println("\n1. Elenco libri");
			System.out.println("2. Ricerca libro tramite titolo ed autore");
			System.out.println("3. Ricerca parola chiave");
			System.out.println("4. Seleziona un libro tramite il suo id");
			if (db.getUtente().isAdmin()) {
				System.out.println("5. Admin: Gestisci copie");								  
				System.out.println("6. Admin: Gestisci libri");
			}
			System.out.println("99. Termina il programma");

			scelta = scanner.nextInt();
			String query;
			
			switch(scelta) {
				case 1:
					System.out.println("Elenco libri");
					
					List<Libri> risultati = db.elencoLibri();
					
					for (Libri l: risultati ) {
						System.out.println(l);
						//System.out.println(l.getAutoriSecondari());
						wait(400);
					}
					
					break;
				case 2:
					/*
					System.out.println("TO DO: chiedere le info del libro da cercare");
					
					query = "SELECT titolo, data_prima_pubblicazione FROM libri"
							+ " JOIN autori ON libri.id_autore = autori.id"
							+ " JOIN persone ON autori.id_persona = persone.id"
							+ " WHERE titolo = ? AND persone.nome = ? AND persone.cognome = ? ";
					
					try {
						stmt = db.getConn().prepareStatement(query);
						
						System.out.println("titolo");
						String titolo = scanner.nextLine();
						titolo = scanner.nextLine();
						
						System.out.println("nome");					
						String nome = scanner.nextLine();
						
						System.out.println("cognome");					
						String cognome = scanner.nextLine();
						
						stmt.setString(1, titolo);
						stmt.setString(2, nome);
						stmt.setString(3, cognome);
						
						rs = stmt.executeQuery();
						
						if (rs.next()) {
							titolo = rs.getString(1);
							Date data = rs.getDate(2);
							
							System.out.println("Titolo: " + titolo + "  Data: " + data);
						} 
						else 
							System.out.println("Libro non trovato");
						
					} catch (Exception e) {
						e.printStackTrace();
					}
					*/
					
					break;
				case 3:
					System.out.println("Ricerca libro basandoti su parola chiave");
					scanner.nextLine();
					ricerca();
					break;
				case 4:
					System.out.println("Digita id per accedere alle operazioni sul libro: ");
					break;
				case 5:
					if (!db.getUtente().isAdmin()) {
						break;
					}
					break;
				case 6:
					if (!db.getUtente().isAdmin()) {
						break;
					}
					break;
				case 99:
					break;
				default:
					System.out.println("Per piacere scegli una delle voci disponibili");
			}
			
		} while(scelta != 99);
		
		wait(700);

	}
	
	public static void ricerca() {
		System.out.println("Digita parte del titolo o dell'autore del libro che ti interessa:");
		String testo = scanner.nextLine();
		
		// divido il testo sul carattere spazio
		String[] parole = testo.split(" ");
		
		System.out.println("Elenco dei risultati:");
		
		List<Libri> risultati = db.ricercaParoleChiavi(parole);
		
		if (risultati!=null) {
			for (Libri l: risultati ) {
				System.out.println(l);
				System.out.println(l.getAutoriSecondari());
			}
			
			// to do:
			// mostrare elenco operazioni per il singolo libro:
			/*
			 -dettaglio libro
			 -modifica
			 -cancellazione
			 -prestito
			 
			
			System.out.println("Scegli un libro e scrivi il suo id:");
			String id = scanner.nextLine();
			*/
			
		}
		else {
			System.out.println("Nessun libro corrisponde alla tua ricerca");
		}
		
								
 	}
	
	//small delay to call after operations to allow user to read better
	public static void wait(int ms) {
		try {
			TimeUnit.MILLISECONDS.sleep(ms);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}



