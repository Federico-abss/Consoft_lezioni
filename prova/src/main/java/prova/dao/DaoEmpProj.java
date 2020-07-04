package prova.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import prova.model.EmployeeProject;

public class DaoEmpProj {
	
	private static DaoEmpProj single_instance;
	private Connection conn;
	
	private DaoEmpProj()  {  } 
	
	
	public static DaoEmpProj getInstance(Connection conn) 
    { 
        if (single_instance == null) {
            single_instance = new DaoEmpProj(); 
        	single_instance.conn = conn;
        }
  
        return single_instance; 
    } 
	
	
	public boolean insertEmplProj(int idEmp, int idProj) {

		String query = "INSERT INTO employees_projects (employee_id, project_id) VALUES (?, ?)";
		
		try (PreparedStatement stmt = conn.prepareStatement(query);) {
			
			stmt.setInt(1, idEmp);
			stmt.setInt(2, idProj);
			
			stmt.executeUpdate();
			
			return true;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return false;
	}
	
	
	public EmployeeProject readEmpProj(int idEmp, int idProj) {
		
		String query = "SELECT * FROM employees_projects WHERE employee_id = ?"
				+ " AND project_id = ?";
		
		EmployeeProject empProj = null;
		
		try (PreparedStatement stmt = conn.prepareStatement(query);) {
			
			stmt.setInt(1, idEmp);
			stmt.setInt(2, idProj);
			
			try (ResultSet rs = stmt.executeQuery()) {
				
				if (rs.next()) {
					
					empProj = new EmployeeProject();
					
					empProj.setId_employee(rs.getInt("employee_id"));
					empProj.setId_employee(rs.getInt("project_id"));
				}				
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}		
		
		return empProj;
	}
	
	
	public boolean updateEmpProj(int oldidEmp, int oldidProj, int idEmp, int idProj) {

		String query = "UPDATE employees_projects SET employee_id = ?, project_id = ? "
				+ "WHERE employee_id = ? AND project_id = ?"; 
		
		try (PreparedStatement stmt = conn.prepareStatement(query);) {
			
			stmt.setInt(1, idEmp);
			stmt.setInt(2, idProj);
			stmt.setInt(3, oldidEmp);
			stmt.setInt(4, oldidProj);
			
			stmt.executeUpdate();
			
			return true;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return false;
		
	}
	
	
	public boolean deleteEmpProj(int idEmp, int idProj) {
		
		String query = "DELETE FROM employees_projects WHERE employee_id = ?" + 
				" AND project_id = ?";
		
		try (PreparedStatement stmt = conn.prepareStatement(query);) {
			
			stmt.setInt(1, idEmp);
			stmt.setInt(2, idProj);
			
			stmt.executeUpdate();
			
			return true;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return false;
	}

}
