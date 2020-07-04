package prova.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import prova.model.EmployeeProject;

public class DaoEmpProjExtended {
	
	private static DaoEmpProjExtended single_instance;
	private Connection conn;
	
	private DaoEmpProjExtended()  {  } 
	
	
	public static DaoEmpProjExtended getInstance(Connection conn) 
    { 
        if (single_instance == null) {
            single_instance = new DaoEmpProjExtended(); 
            single_instance.conn = conn;
        }
  
        return single_instance; 
    } 
	
	
	public List<EmployeeProject> getListaAssignments(String ordinamento) {
		
		String query = "SELECT * FROM employees_projects ORDER BY ?";
		
		List<EmployeeProject> result = new ArrayList<>();
		EmployeeProject empProj = null;		
		
		try (PreparedStatement stmt = conn.prepareStatement(query);) {
			
			stmt.setString(1, ordinamento);
			
			try (ResultSet rs = stmt.executeQuery();) {
				
				while (rs.next()) {
					
					empProj = new EmployeeProject();
					
					empProj.setId_employee(rs.getInt("employee_id"));
					empProj.setId_project(rs.getInt("project_id"));
					
					result.add(empProj);
				}
				
			}	
				
		} catch (Exception e) {
			e.printStackTrace();
		}		
		
		return result;
	}

}
