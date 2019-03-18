

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
import javax.servlet.http.HttpSession;

@WebServlet("/VisualizaCarrinho")
public class VisualizaCarrinho extends HttpServlet {
	private String conteudorm = null;

	public void removeItem(Produto produto,int id){
    	conteudorm = "<a href='/Carrinho/RemoveItem?id="+id+"'>"+"Remover</a>";
    }   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession s = request.getSession(false);
		Carrinho car = (Carrinho) s.getAttribute("carrinho");
		int qtd = 1;
		ArrayList<Produto> p = car.getProduto();
		PrintWriter out = response.getWriter();
		
		if(request.getSession(false) == null){
			out.println("ainda nao ha produtos no carrinho");
		}
		String title = "Lista Carrinho";  
		out.println("<head><title>"+title+"</title><head>"+  
		"<BODY> " +  
		"<H1 ALIGN=CENTER>" + title + "</H1>"+
		"<TABLE BORDER=1 ALIGN=CENTER>"+"<TH>Nome<TH>Descricao<TH>Preco<TH>Quantidade<TH>Carrinho");  
		out.println("<TR>");
		for (int i = 0; i < p.size(); i++) {
			out.print("<Td>" + p.get(i).getNome() + "</Td>");
			out.print("<Td>" + p.get(i).getDescricao() + "</Td>");
			out.print("<Td>" + p.get(i).getPreco() + "</Td>");
			out.print("<Td>" + qtd + "</Td>");
			removeItem(p.get(i),p.get(i).getId());
			out.print("<TD>" + conteudorm + "</TR>");
		}
		
		out.println("</TR>");
		out.println("</TABLE>");
		
		out.println("<a href='/Carrinho/ListaProdutos'>Ver Produtos</a>");
		out.println("<br><br>");
		out.println("<a href='/Carrinho/FinalizaCompra'>FinalizaCompra</a>");
		
	}

}
