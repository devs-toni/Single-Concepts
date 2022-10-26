package POC_Ajax_Form;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

@WebServlet("/POC_Form_Ajax")
public class POC_Form_Ajax extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String name = request.getParameter("name");
		String surname = request.getParameter("surname");
		String dni = request.getParameter("dni");
		String email = request.getParameter("email");
		System.out.println(name + " " + surname + "\n" + dni + " " + email);
		
		String json = new Gson().toJson((name + " " + surname + "\n" + dni + " " + email));
		response.getWriter().write(json);
	}

}
