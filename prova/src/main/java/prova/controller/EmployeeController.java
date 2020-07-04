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
import prova.dao.DaoEmployee;
import prova.dao.DaoEmployeeExtended;
import prova.model.Employee;

@WebServlet(urlPatterns= {"/impiegati.do","/nuovo_impiegato.do","/elimina_impiegato.do",
						  "/dettaglio_impiegato.do","/modifica_impiegato.do"})

/**
 * Servlet implementation class EmployeeController
 */
public class EmployeeController extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	private DbUtil db;
	private Connection conn;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EmployeeController() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		db = DbUtil.getInstance();
		conn = db.getConnection();
		
		DaoEmployee operazioni = DaoEmployee.getInstance(conn);
		DaoEmployeeExtended servizio = DaoEmployeeExtended.getInstance(conn);
		
		Employee employee = null;
		
		String id = request.getParameter("id");
		String paginaJsp = "employees"; 
		
		
		switch (request.getRequestURI()) {		
		case ("/impiegati.do"):
			
			break;
		case ("/prova/modifica_impiegato.do"):
			
			paginaJsp = "update_employee";
		
			employee = operazioni.readEmployee(Integer.valueOf(id));
			request.setAttribute("employee", employee);
		
			break;		
		case ("/prova/elimina_impiegato.do"):
			
			String delId = request.getParameter("id");
			
			if (delId != null) {
				
				boolean delete = operazioni.deleteEmployee(Integer.valueOf(delId));
				
				request.setAttribute("is_deleted", delete);
			}
			
		case ("/prova/dettaglio_impiegato.do"):
			
			paginaJsp = "details_employee";
		
			employee = operazioni.readEmployee(Integer.valueOf(id));
			request.setAttribute("employee", employee);
			
			break;
		}
		
		
		List<Employee> elencoEmployee = servizio.getListaEmployees(request.getParameter("ordinamento"));
		
		request.setAttribute("lista_employee", elencoEmployee);
		request.setAttribute("title", "Elenco Dipendenti");
		
		request.getRequestDispatcher("/WEB-INF/views/"+ paginaJsp +".jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		db = DbUtil.getInstance();
		conn = db.getConnection();
		
		DaoEmployee operazioni = DaoEmployee.getInstance(conn);
		
		String fname = request.getParameter("fname");
		String lname = request.getParameter("lname");
		String id = request.getParameter("id");
		
		switch (request.getRequestURI()) {		
		case ("/prova/modifica_impiegato.do"):
			if (fname!=null && lname!=null) {
				
				boolean update = operazioni.updateEmployee(Integer.valueOf(id), fname, lname);
				
				request.setAttribute("is_updated", update);	
				
				if (update) {
					response.sendRedirect("/prova/impiegati.do");
				}
				else {
					doGet(request, response);
				}
			}
			
			break;
		case ("/prova/nuovo_impiegato.do"):
			
			if (fname!=null && lname!=null) {
				
				boolean inserimento = operazioni.insertEmployee(fname, lname);
				
				request.setAttribute("is_inserted", inserimento);	
				
				if (inserimento) {
					response.sendRedirect("/prova/impiegati.do");
				}
				else {
					doGet(request, response);
				}
			}
			
			break;
		}
		
	}

}
