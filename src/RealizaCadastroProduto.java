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

@WebServlet("/RealizaCadastroProduto")
public class RealizaCadastroProduto extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nome = request.getParameter("nome");
		String Descricao = request.getParameter("Descricao");
		int preco ;
		preco=Integer.parseInt(request.getParameter("preco"));
		int estoque =0;
		estoque=Integer.parseInt(request.getParameter("estoque")); 
		
		ServletContext ctx = getServletContext();
		response.setContentType("text/html");
		PrintWriter pw = response.getWriter();
		
		if(nome.equals("") && Descricao.equals("")&& preco==0 && estoque==0){
			pw.println("Preencha os campos");
		}else{
			((ArrayList<Produto>) ctx.getAttribute("listaPro")).add(new Produto(preco, nome, Descricao, estoque));
			response.sendRedirect("/Carrinho/ExibirProdutos");
			
		}
	}

}
