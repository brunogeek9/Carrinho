

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
@WebServlet("/FinalizaCompra")
public class FinalizaCompra extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		String title = "Finalizando Compra";  
		out.println("<head><title>"+title+"</title><head>"+  
		"<BODY> " +  
		"<H1 ALIGN=CENTER>" + title + "</H1>"+
		"<TABLE BORDER=1 ALIGN=CENTER>"+"<TH>Quantidade Produtos</TH><TH>Valor a Pagar</TH>");  
		out.println("<TR>");
		
		HttpSession s = request.getSession();
		Carrinho c = (Carrinho) s.getAttribute("carrinho");
		ArrayList<Produto> p = c.getProduto();
		int qtd = 0,valorTotal=0;

		for (int i = 0; i < p.size(); i++) {
			qtd += 1;
			valorTotal += p.get(i).getPreco();
		}
		
		out.print("<Td>" + qtd + "</Td>");
		out.print("<Td>" + valorTotal +" R$"+ "</Td>");

		out.println("</TR>");
		out.println("</TABLE>");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
