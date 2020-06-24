import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;


//esempio di connessione ed operazione sul database con autochiusura
public class JdbcTest2 {

	public static void main(String[] args) {
		
		//mantieni l'indirizzo del db in una stringa immutabile
		final String CONNECTION_STRING = "jdbc:mariadb://localhost:3306/biblioteca_prof?serverTimezone=UTC";
		
		//primo try (), con e stmt si chiudono automaticamente alla fine del try in ordine inverso
		try (Connection con = DriverManager.getConnection(CONNECTION_STRING,
				"root", ""); Statement stmt = con.createStatement();) {
			//registro driver			
			Class.forName("org.mariadb.jdbc.Driver");			
			System.out.println("Driver JDBC registrato correttamente");
			
			//apriamo il resultset in un try diverso nel caso volessimo operare con diversi rs 
			//usando la stessa connessione e statement
			try (ResultSet rs = stmt.executeQuery("SELECT id, nome, cognome FROM persone");) {
				
				if (rs != null) {
					//scorro i risultati della query
					while (rs.next()) {
						int id = rs.getInt(1);
						String nome = rs.getString(2);
						String cognome = rs.getString(3);
						
						//stampo in console ogni risultato
						System.out.println("Id: " + id + "  Nome: " + nome + "  Cognome: " + cognome);
					}
				}				
			}
		}
		//questa parte viene chiamata solo se ci sono problemi nel try
		catch(Exception e) {
			System.out.println(e);
		}
	}
}
