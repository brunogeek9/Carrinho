

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/ListaProdutos")
public class ListaProdutos extends HttpServlet {
	private String conteudoadd = "";
	public void addAoCarrinho(Produto produto,int id){
		if(produto.getEstoque() <= 0){
			conteudoadd = "Sem estoque";
		}else{
			conteudoadd = "<a href='/Carrinho/AdicionaItem?id="+id+"'>"+"Adicionar</a>";
		}
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		PrintWriter out = response.getWriter();
		String title = "Lista Produtos";  
		out.println("<head><title>"+title+"</title><head>"+  
		"<BODY> " +  
		"<H1 ALIGN=CENTER>" + title + "</H1>"+
		"<TABLE BORDER=1 ALIGN=CENTER>"+"<TH>Nome<TH>Descricao<TH>Preco<TH>Estoque<TH>Carrinho");  
		ServletContext ctx = request.getServletContext();
		ArrayList<Produto> lista = ((ArrayList<Produto>) ctx.getAttribute("listaPro"));
		out.println("<TR>");
		for (int i = 0; i < lista.size(); i++) {
			out.print("<Td>" + lista.get(i).getNome() + "</Td>");
			out.print("<Td>" + lista.get(i).getDescricao() + "</Td>");
			out.print("<Td>" + lista.get(i).getPreco() + "</Td>");
			out.print("<Td>" + lista.get(i).getEstoque() + "</Td>");
			addAoCarrinho(lista.get(i),lista.get(i).getId());
			out.print("<TD>" + conteudoadd + "</TR>");
		}
		out.println("</tr>");
		out.println("</TABLE>");
		
		out.println("<a href='/Carrinho/VisualizaCarrinho'>Ver Carrinho</a>");
		
	}
}
