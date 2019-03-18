import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/RealizaCadastro")
public class RealizaCadastro extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nome = request.getParameter("nome");
		String email = request.getParameter("email");
		String senha = request.getParameter("senha");
		ServletContext ctx = getServletContext();
		RequestDispatcher r = null;
		PrintWriter out = response.getWriter();
		String msg = "";
		//verifica se os campos estão em branco
		if(!nome.equals("") && !email.equals("") && !senha.equals("")){
			//e colocado no objeto de lista de clientes um novo cliente
			((ArrayList<Pessoa>) ctx.getAttribute("listaClientes")).add(new Pessoa(nome,email,senha));
			msg += "cadastro realizado com sucesso";
		}
		else{
			r = request.getRequestDispatcher("/Carrinho/cadastro.html");  
		}
		out.println(msg);
	}

}
