import java.sql.*;
import java.util.Scanner;

//codice insegnante
public class Test {
	
	private static final String CONNECTION_STRING = "jdbc:mariadb://localhost:3306/biblioteca_prof?serverTimezone=UTC";

	public static void main(String[] args) {
		try (Connection con = DriverManager.getConnection(CONNECTION_STRING,
				"root", ""); Statement stmt = con.createStatement();) {
			String query = "insert...";
			Integer id = insertMethod(stmt, query);
			
		} catch (SQLException e) {
			System.out.println("prova");
		}
	}

	private static Integer insertMethod(Statement stmt, String query) throws SQLException {
		int rows = stmt.executeUpdate(query, Statement.RETURN_GENERATED_KEYS);
		if (rows <= 0) {
			throw new SQLException();
		}
		try (ResultSet rs = stmt.getGeneratedKeys();) {
			int lastId = -1;
			if (rs.next()) {
				lastId = rs.getInt(1);
			}
			System.out.println("La riga inserita ha id: " + lastId);
			return lastId;
		}
	}
}