package prova.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import prova.model.Employee;
import prova.model.Project;

public class DaoProjectExtended {

	private static DaoProjectExtended single_instance;
	private Connection conn;
	
	private DaoProjectExtended()  {  } 
	
	
	public static DaoProjectExtended getInstance(Connection conn) 
    { 
        if (single_instance == null) {
            single_instance = new DaoProjectExtended(); 
            single_instance.conn = conn;
        }
  
        return single_instance; 
    } 
	
	
	public List<Project> getListaProjects(String ordinamento) {
		
		String query = "SELECT * FROM projects ORDER BY ?";
		
		List<Project> result = new ArrayList<>();
		Project project = null;		
		
		try (PreparedStatement stmt = conn.prepareStatement(query);) {
			
			stmt.setString(1, ordinamento);
			
			try (ResultSet rs = stmt.executeQuery();) {
				
				while (rs.next()) {
					
					project = new Project();
					
					project.setTitolo(rs.getString("title"));
					project.setId(rs.getInt("id"));
					
					result.add(project);
				}
				
			}	
				
		} catch (Exception e) {
			e.printStackTrace();
		}		
		
		return result;
	}
}
