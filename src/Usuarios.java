import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Usuarios")
public class Usuarios extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ServletContext ctx = request.getServletContext();
		PrintWriter out = response.getWriter();
		ArrayList<Pessoa> lista1 = ((ArrayList<Pessoa>) ctx.getAttribute("listaClientes"));
		ArrayList<Pessoa> lista2 = ((ArrayList<Pessoa>) ctx.getAttribute("listaLojistas"));
		out.println("Clientes");
		for (Pessoa pessoa : lista1) {
			response.getWriter().println(pessoa.toString());
		}
		out.println("Lojistas");
		for (Pessoa pessoa : lista2) {
			response.getWriter().println(pessoa.toString());
		}
		String contextPath = request.getContextPath();
	    out.println(contextPath);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
//		doGet(request, response);
	}

}
