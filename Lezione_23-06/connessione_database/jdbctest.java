import java.sql.*;
import java.util.Scanner;
/**
 * 
 * @author feder
 *
 */
public class jdbctest {

	public static void main(String[] args) {
		Connection connection = null;
		Statement statement = null;
		ResultSet rs = null;
		
		try {
			//registro driver			
			Class.forName("org.mariadb.jdbc.Driver");			
			System.out.println("Driver JDBC registrato correttamente");
			
			//effettuo connessione database
			connection = DriverManager.getConnection("jdbc:mariadb://localhost:3306/"
					+ "biblioteca_prof?serverTimezone=UTC","root","");
			System.out.println("Connessione effettuata con successo!");
			
			//ottengo statemente per eseguire la query
			statement = connection.createStatement();
			
			//eseguo query ed ottengo resultset
			rs = statement.executeQuery("SELECT id, nome, cognome FROM persone");
					
			//scorro i risultati della query
			while (rs.next()) {
				int id = rs.getInt(1);
				String nome = rs.getString(2);
				String cognome = rs.getString(3);
				
				System.out.println("Id: " + id + "  Nome: " + nome + "  Cognome: " + cognome);
			}
			
			//ricevo istruzioni per la query da console
			Scanner scanner = new Scanner(System.in);
			System.out.println("nome");
			String newName = scanner.nextLine();
			
			System.out.println("cognome");
			String newSurname = scanner.nextLine();
			
			System.out.println("data nascita aaaa-mm-gg");
			String newBdate = scanner.nextLine();
			
			System.out.println("Inserisci la tua email:");
			String newEmail = scanner.nextLine();
			
			System.out.println("Inserisci la tua password:");
			String newPassword = scanner.nextLine();
					
			/* Istruzione di INSERT nel database persone */
			
			String query = "INSERT INTO persone (nome, cognome, data_nascita) VALUES ('" + newName + "', '" +newSurname+"', '" + newBdate + "')";
			
			System.out.println("Eseguo query: " + query);
			
			//eseguo INSERT ed ottengo le chiavi AUTO_INCREMENT generate oltre al normale valore di ritorno
			int result = statement.executeUpdate(query, Statement.RETURN_GENERATED_KEYS);
			
			//recupero id della riga inserita
			rs = statement.getGeneratedKeys();
			
			int lastId = -1;
			if (rs.next()) {
				lastId = rs.getInt(1);
			}
			
			System.out.println(lastId);
			
			rs = statement.executeQuery("SELECT id, nome, cognome FROM persone");
			
			//scorro i risultati della query
			while (rs.next()) {
				int id = rs.getInt(1);
				String nome = rs.getString(2);
				String cognome = rs.getString(3);
				
				System.out.println("Id: " + id + "  Nome: " + nome + "  Cognome: " + cognome);
			}
			
			/* INSERIMENTO UTENTE  */
			
			query = "INSERT INTO utenti (email, password_hash, id_persona, tessera, attivo) VALUES ('" + newEmail + "', MD5('" + newPassword + "'), " + lastId + ", '" + lastId+ "', 1)";
			
			System.out.println("Eseguo la query:\n" + query);

			// eseguo la insert e ottengo oltre al valore di ritorno anche la memorizzazione delle chiavi autoincrement generate
			result = statement.executeUpdate(query, Statement.RETURN_GENERATED_KEYS);
			
			// recupero l'id della riga appena inserita
			rs = statement.getGeneratedKeys();
			
			lastId = -1;
			if (rs.next()) {
				lastId = rs.getInt(1);
			}

			
		}
		catch(Exception e) {
			System.out.println(e);
		}
		finally {
			// maniera corretta di chiudere le connessioni
			try {
				if (rs != null) {
					rs.close();
				}
				if (statement != null) {
					statement.close();
				}
				if (connection != null) {
					connection.close();
				}
			}
			catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

}
