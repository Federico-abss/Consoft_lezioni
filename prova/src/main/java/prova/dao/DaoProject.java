package prova.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import prova.model.Project;

public class DaoProject {
	
	private static DaoProject single_instance;
	private Connection conn;
	
	private DaoProject()  {  } 
	
	
	public static DaoProject getInstance(Connection conn) 
    { 
        if (single_instance == null) {
            single_instance = new DaoProject(); 
            single_instance.conn = conn;
        }
  
        return single_instance; 
    } 
	
	
	public boolean insertProject(String title) {

		String query = "INSERT INTO projects (title) VALUES (?)";
		
		try (PreparedStatement stmt = conn.prepareStatement(query);) {
			
			stmt.setString(1, title);
			
			stmt.executeUpdate();
			
			return true;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return false;
	}
	
	
	public Project readProject(Integer id) {
		
		String query = "SELECT * FROM projects WHERE id = ?";
		
		Project project = null;
		
		try (PreparedStatement stmt = conn.prepareStatement(query);) {
			
			stmt.setInt(1, id);
			
			try (ResultSet rs = stmt.executeQuery()) {
				
				if (rs.next()) {
					
					project = new Project();
					
					project.setTitolo(rs.getString("title"));
					project.setId(rs.getInt("id"));
				}				
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}		
		
		return project;
	}
	
	
	public boolean updateProject(Integer id, String title) {

		String query = "UPDATE projects SET title = ? WHERE id = ?";
		
		try (PreparedStatement stmt = conn.prepareStatement(query);) {
			
			stmt.setString(1, title);
			stmt.setInt(2, id);
			
			stmt.executeUpdate();
			
			return true;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return false;
		
	}
	
	
	public boolean deleteProject(Integer id) {
		
		String query = "DELETE FROM projects WHERE id = ?";
		
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
