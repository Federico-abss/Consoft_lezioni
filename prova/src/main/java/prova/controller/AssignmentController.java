package prova.controller;

import java.io.IOException;
import java.sql.Connection;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import prova.DbUtil;
import prova.dao.DaoEmpProj;
import prova.dao.DaoEmployeeExtended;
import prova.dao.DaoProjectExtended;
import prova.frontend.AssegnazioniFrontend;
import prova.model.Employee;
import prova.model.Project;
import prova.service.AssignmentsService;

@WebServlet(urlPatterns= {"/assegnazioni.do","/nuova_assegnazione.do","/elimina_assegnazione.do"})

/**
 * Servlet implementation class EmployeeProjectController
 */
public class AssignmentController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private DbUtil db;
	private Connection conn;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AssignmentController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 
		db = DbUtil.getInstance();
		conn = db.getConnection();
		
		String paginaJsp = "assignments";
		
		AssignmentsService servizi = new AssignmentsService(conn);
		DaoEmpProj operazioni = DaoEmpProj.getInstance(conn);
		
		
		switch (request.getRequestURI()) {		
		case ("/prova/assegnazioni.do"):
			
			break;
		case ("/prova/elimina_assegnazione.do"):
			String idEmp = request.getParameter("id_employee");
			String idProj = request.getParameter("id_project");
			
			if (idEmp!=null && idProj!=null) {
				operazioni.deleteEmpProj(Integer.valueOf(idEmp), Integer.valueOf(idProj));
			}
			
			break;
		case ("/prova/nuova_assegnazione.do"):
			
			paginaJsp = "create_assignment";
			
			DaoEmployeeExtended daoEmp = DaoEmployeeExtended.getInstance(conn);
			DaoProjectExtended daoProj = DaoProjectExtended.getInstance(conn);
			
			List<Employee> impiegati = daoEmp.getListaEmployees("");
			List<Project> progetti = daoProj.getListaProjects("");
		
			request.setAttribute("impiegati", impiegati);
			request.setAttribute("progetti", progetti);
			
			break;
		}
		
		
		List<AssegnazioniFrontend> assegnazioni = servizi.getElencoAssegnazioni(request.getParameter("ordinamento"));
		
		request.setAttribute("lista_assegnazioni", assegnazioni);
		
		request.getRequestDispatcher("/WEB-INF/views/"+ paginaJsp +".jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		db = DbUtil.getInstance();
		conn = db.getConnection();
		

		DaoEmpProj operazioni = DaoEmpProj.getInstance(conn);
		
		switch (request.getRequestURI()) {		
		case ("/prova/assegnazioni.do"):
			
			break;
		case ("/prova/nuova_assegnazione.do"):
			
			String idEmp = request.getParameter("id_employee");
			String idProj = request.getParameter("id_project");
			
			if (idEmp!=null && idProj!=null) {
				
				boolean inserimento = operazioni.insertEmplProj(Integer.valueOf(idEmp), Integer.valueOf(idProj));
				
				request.setAttribute("is_inserted", inserimento);	
				
				if (inserimento) {
					response.sendRedirect("/prova/assegnazioni.do");
				}
				else {
					doGet(request, response);
				}
			}
			
			break;
		}
		
	}

}
