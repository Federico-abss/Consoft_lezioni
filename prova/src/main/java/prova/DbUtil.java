package prova;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class DbUtil {
	
	private static DbUtil single_instance;
	
	private String host = "localhost";
	private String username = "root";
	private String password = "";
	private String database = "compagnia";
	private boolean connected;
	private PreparedStatement stmt;
	private Connection conn;


	public DbUtil() {
		
	}
	
	public DbUtil(String host, String username, String password, String database) {

		this.host = host;
		this.username = username;
		this.password = password;
		this.database = database;
				
	}
	
	public static DbUtil getInstance() {
		if (single_instance == null) {
			single_instance = new DbUtil();
			single_instance.connected = single_instance.connect();
		}
		
		return single_instance;
	}
	
	public boolean connect() {
		try  {
			Class.forName("org.mariadb.jdbc.Driver");
			//System.out.println("Driver JDBC registrato correttamente");
			
			String url = "jdbc:mariadb://" + this.host + ":3306/" + this.database + "?serverTimezone=UTC"; 
			// effettuo la connessione al database
			conn = DriverManager.getConnection(url, this.username, this.password);
			//System.out.println("Connessione effettuata con successo");					
			
			return true;
			
		}
		catch( Exception e ) {
			System.out.println("Errore: " + e);
			return false;
		}		
	}	
	
	
	public Connection getConnection() {
		return conn;
	}
	
	public PreparedStatement getStatement() {
		return stmt;
	}
}
