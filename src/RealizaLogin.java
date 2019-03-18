

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
import javax.servlet.http.HttpSession;

@WebServlet("/realizaLogin")
public class RealizaLogin extends HttpServlet {
	public void iniciaSessao(HttpServletRequest request,String email,String senha){
		HttpSession sessao = request.getSession();
		sessao.setMaxInactiveInterval(30*60);
		sessao.setAttribute("Pessoa", new Pessoa(email,senha));
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email = request.getParameter("email");
		String senha = request.getParameter("senha");
		RequestDispatcher r = null;
		ServletContext ctx = request.getServletContext();
		PrintWriter out = response.getWriter();
		ArrayList<Pessoa> lista1 = ((ArrayList<Pessoa>) ctx.getAttribute("listaClientes"));
		ArrayList<Pessoa> lista2 = ((ArrayList<Pessoa>) ctx.getAttribute("listaLojistas"));
		boolean lojista = false,cliente = false;
		if(!email.equals("") && !senha.equals("")){
			for (Pessoa pessoa : lista1) {
				if(email.equals(pessoa.getEmail()) && senha.equals(pessoa.getSenha())){
					iniciaSessao((HttpServletRequest) request, email, senha);
					cliente = true;
				}
			}
			
			if(!cliente){
				for (Pessoa pessoa : lista2) {
					if(email.equals(pessoa.getEmail()) && senha.equals(pessoa.getSenha())){
						iniciaSessao((HttpServletRequest) request, email, senha);
						lojista = true;						
					}
				}
			}
			if(lojista == false && cliente == false){
				//r = request.getRequestDispatcher("/login.html");
				response.getWriter().println("Usuario ou senha invalidos");
				//response.sendRedirect("/Carrinho/login.html");
				
			}else if(cliente){
				response.sendRedirect("/Carrinho/cliente.html");
			}else if(lojista){
				response.sendRedirect("/Carrinho/lojista.html");
			}
		}else{
			response.getWriter().println("Prencha todos os campos");
		} 
			
	}

}
