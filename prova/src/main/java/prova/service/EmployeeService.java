package prova.service;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import prova.dao.DaoEmployeeExtended;
import prova.model.Employee;

public class EmployeeService {
	
	private DaoEmployeeExtended dao;
	
	public EmployeeService(Connection conn) {
		this.dao = DaoEmployeeExtended.getInstance(conn);
	}
	
	public List<ArrayList<String>> getElencoAutori(String ordinamento) {
		
		List<Employee> employees = dao.getListaEmployees(ordinamento);
		
		List<ArrayList<String>> result = new ArrayList<>();
		ArrayList<String> emp = null;
				
		for (Employee e:employees) {
			
			emp = new ArrayList<>();
			
			emp.add(e.getNome());
			emp.add(e.getCognome());
			
			result.add(emp);
		}
		
		return result;
	}
}
