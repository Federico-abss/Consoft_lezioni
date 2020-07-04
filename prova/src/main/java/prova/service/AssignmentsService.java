package prova.service;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import prova.dao.DaoEmpProjExtended;
import prova.dao.DaoEmployee;
import prova.dao.DaoProject;
import prova.frontend.AssegnazioniFrontend;
import prova.model.Employee;
import prova.model.EmployeeProject;
import prova.model.Project;

public class AssignmentsService {
	
	private DaoEmpProjExtended daoAssignments;
	private DaoEmployee daoEmployees;
	private DaoProject daoProjects;
	
	public AssignmentsService(Connection conn) {
		this.daoAssignments = DaoEmpProjExtended.getInstance(conn);
		this.daoEmployees = DaoEmployee.getInstance(conn);
		this.daoProjects = DaoProject.getInstance(conn);
	}
	
	public List<AssegnazioniFrontend> getElencoAssegnazioni(String ordinamento) {
		
		List<EmployeeProject> assegnazioni = daoAssignments.getListaAssignments(ordinamento);
				
		Employee employee = null;
		Project project = null;
		
		List<AssegnazioniFrontend> result = new ArrayList<>();	
		
		AssegnazioniFrontend assegnazioneFront = null;
		
		for (EmployeeProject a:assegnazioni) {
			
			employee = daoEmployees.readEmployee(a.getId_employee());
			project = daoProjects.readProject(a.getId_project());
			
			assegnazioneFront = new AssegnazioniFrontend();
			
			assegnazioneFront.setId_employee(a.getId_employee());
			assegnazioneFront.setId_project(a.getId_project());
			assegnazioneFront.setNome(employee.getNome());
			assegnazioneFront.setCognome(employee.getCognome());
			assegnazioneFront.setTitolo(project.getTitolo());
			
			result.add(assegnazioneFront);
		}
		
		return result;
	}
}
