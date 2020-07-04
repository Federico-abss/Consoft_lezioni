package prova.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import prova.model.Employee;

public class DaoEmployeeExtended {
	
	private static DaoEmployeeExtended single_instance;
	private Connection conn;
	
	private DaoEmployeeExtended()  {  } 
	
	
	public static DaoEmployeeExtended getInstance(Connection conn) 
    { 
        if (single_instance == null) {
            single_instance = new DaoEmployeeExtended(); 
            single_instance.conn = conn;
        }
  
        return single_instance; 
    } 
	
	
	public List<Employee> getListaEmployees(String ordinamento) {
		
		String query = "SELECT * FROM employees ORDER BY ?";
		
		List<Employee> result = new ArrayList<>();
		Employee employee = null;		
		
		try (PreparedStatement stmt = conn.prepareStatement(query);) {
			
			stmt.setString(1, ordinamento);
			
			try (ResultSet rs = stmt.executeQuery();) {
				
				while (rs.next()) {
					
					employee = new Employee();
					
					employee.setNome(rs.getString("first_name"));
					employee.setCognome(rs.getString("last_name"));
					employee.setId(rs.getInt("id"));
					
					result.add(employee);
				}
				
			}	
				
		} catch (Exception e) {
			e.printStackTrace();
		}		
		
		return result;
	}
	
}
