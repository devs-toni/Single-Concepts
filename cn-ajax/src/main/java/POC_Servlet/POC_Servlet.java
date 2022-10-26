package POC_Servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/POC_Servlet")
public class POC_Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L; 
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("name");
		String state = request.getParameter("state");
		System.out.println(name);
		String error = "Error de acceso";
		request.setAttribute("error", error);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/servlet_init.jsp");
		dispatcher.forward(request, response);
		//response.sendRedirect("servlet_init.jsp");
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
