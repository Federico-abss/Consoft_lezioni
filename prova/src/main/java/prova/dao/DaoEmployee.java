package prova.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import prova.model.Employee;
import prova.model.Project;

public class DaoEmployee {

	private static DaoEmployee single_instance;
	private Connection conn;
	
	private DaoEmployee()  {  } 
	
	
	public static DaoEmployee getInstance(Connection conn) 
    { 
        if (single_instance == null) {
            single_instance = new DaoEmployee(); 
        	single_instance.conn = conn;
        }
  
        return single_instance; 
    } 
	
	
	public boolean insertEmployee(String nome, String cognome) {

		String query = "INSERT INTO employees (first_name, last_name) VALUES (?, ?)";
		
		try (PreparedStatement stmt = conn.prepareStatement(query);) {
			
			stmt.setString(1, nome);
			stmt.setString(2, cognome);
			
			stmt.executeUpdate();
			
			return true;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return false;
	}
	
	
	public Employee readEmployee(Integer id) {
		
		String query = "SELECT e.*, ep.project_id, p.title FROM `employees` e"
				+ " LEFT OUTER JOIN employees_projects ep ON ep.employee_id = e.id"
				+ " LEFT OUTER JOIN projects p ON ep.project_id = p.id"
				+ " WHERE e.id = ?";

		
		Employee employee = null;
		Project project = null;
		List<Project> projects = new ArrayList<>();
		
		try (PreparedStatement stmt = conn.prepareStatement(query);) {
			
			stmt.setInt(1, id);
			
			try (ResultSet rs = stmt.executeQuery()) {
				
				if (rs.next()) {
					
					employee = new Employee();
					
					employee.setNome(rs.getString("e.first_name"));
					employee.setCognome(rs.getString("e.last_name"));
					employee.setId(rs.getInt("e.id"));
					
					do {
						project = new Project();
						
						project.setId(rs.getInt("ep.project_id"));
						project.setTitolo(rs.getString("p.title"));
						
						projects.add(project);
						
					} while (rs.next());
					
					employee.setProjects(projects);
				}				
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}		
		
		return employee;
	}
	
	
	public boolean updateEmployee(Integer id, String nome, String cognome) {

		String query = "UPDATE employees SET first_name = ?, last_name = ? WHERE id = ?";
		
		try (PreparedStatement stmt = conn.prepareStatement(query);) {
			
			stmt.setString(1, nome);
			stmt.setString(2, cognome);
			stmt.setInt(3, id);
			
			stmt.executeUpdate();
			
			return true;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return false;
		
	}
	
	
	public boolean deleteEmployee(Integer id) {
		
		String query = "DELETE FROM employees WHERE id = ?";
		
		try (PreparedStatement stmt = conn.prepareStatement(query);) {
			
			stmt.setInt(1, id);
			
			stmt.executeUpdate();
			
			return true;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return false;
	}
}
