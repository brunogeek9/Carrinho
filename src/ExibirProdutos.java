

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/ExibirProdutos")
public class ExibirProdutos extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		
		ServletContext ctx = getServletContext();
		
	
		String title = "Lista de Produtos";
		PrintWriter pw = response.getWriter();
		
		out.println("<head><title>"+title+"</title><head>"+  
				"<BODY> " +  
				"<H1 ALIGN=CENTER>" + title + "</H1>"+
				"<TABLE BORDER=1 ALIGN=CENTER>"+"<TH>Nome<TH>Descricao<TH>Quantidade<TH>Preco");  
				out.println("<TR>");
		ArrayList<Produto> listaPro = (ArrayList<Produto>)ctx.getAttribute("listaPro");
		for (Produto p : listaPro) {
			pw.println("<Td>"+p.getNome()+"</Td>");
			pw.println("<Td>"+p.getDescricao()+"</Td>");
			pw.println("<Td>"+p.getEstoque()+"</Td>");
			pw.println("<Td>"+p.getPreco()+"</Td>");
			out.print("</TR>");
		}
		//out.println("</TR>");
		out.println("</TABLE>");	
			
			
		out.println("<a href='/Carrinho/lojista.html'>Menu Principal</a>");
		out.println("<br><br>");
		out.println("<a href='/Carrinho/CadastraProduto.html'>Cadastrar Produto</a>");
		out.println("<br><br>");
		out.println("<a href='/Carrinho//Logout'>Sair</a>");
		
		
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
