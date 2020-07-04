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
import prova.dao.DaoEmployeeExtended;
import prova.dao.DaoProjectExtended;
import prova.model.Employee;
import prova.model.Project;

@WebServlet(urlPatterns="/progetti.do")

/**
 * Servlet implementation class ProjectController
 */
public class ProjectController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProjectController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		DbUtil db = new DbUtil();
		Connection conn = null;
		
		if (db.connect()) {
			conn = db.getConnection();
		}
		
		DaoProjectExtended servizio = DaoProjectExtended.getInstance(conn);
		
		List<Project> elencoProject = servizio.getListaProjects(request.getParameter("ordinamento"));
		
		request.setAttribute("lista_project", elencoProject);
		
		request.getRequestDispatcher("/WEB-INF/views/project.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
