package POC_Ajax;


import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;


@WebServlet("/ServletAjax")
public class ServletAjax extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse resp) throws ServletException, IOException {
		int ent = Integer.parseInt(request.getParameter("num"));
		System.out.println("Esta pasando algo?? - " + ent);
		
		String sumar = String.valueOf(ent+10);
		String json = new Gson().toJson(sumar);

	    resp.setContentType("application/json");
	    resp.setCharacterEncoding("UTF-8");
	    resp.getWriter().write(json);

	}
}
