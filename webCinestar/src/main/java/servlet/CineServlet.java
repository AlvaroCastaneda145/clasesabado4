package servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import dao.CinestarDAO;


public class CineServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	CinestarDAO cinestarDAO = new CinestarDAO() ;
    public CineServlet() {
    	
    	
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		ProcessRequest(request, response);
	}
	
	

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		ProcessRequest(request, response);
	}
	
	protected void ProcessRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Object data =  CinestarDAO.getCines();
		request.getSession().setAttribute("cines", data);
		request.setAttribute("cines.jsp", data);
		request.setAttribute("id", "cine");	
		
		new request.getRequestDispacher("index.jsp").forward(request, response);
		
	}

}
