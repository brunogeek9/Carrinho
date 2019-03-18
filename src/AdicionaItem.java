

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/AdicionaItem")
public class AdicionaItem extends HttpServlet {
	
	public int indice(int id,ArrayList<Produto> lista){
		for (int i = 0; i < lista.size(); i++) {
			if(lista.get(i).getId() == id){
				return i;
			}
		}
		return -1;
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {	
		HttpSession session = request.getSession(true);
		ServletContext ctx = request.getServletContext();
		ArrayList<Produto> lista1 = ((ArrayList<Produto>) ctx.getAttribute("listaPro"));
		ArrayList<Produto> vazia = new ArrayList<>();
		Carrinho c = new Carrinho(vazia);		
		
		int id = Integer.parseInt(request.getParameter("id"));
		int indice = indice(id,lista1);
		if(session.getAttribute("carrinho") == null){
			session.setAttribute("carrinho", c);
			((Carrinho) session.getAttribute("carrinho")).addProduto(lista1.get(indice));
			lista1.get(indice).diminuiEstoque();
			response.sendRedirect("/Carrinho/VisualizaCarrinho");
		}else{
			((Carrinho) session.getAttribute("carrinho")).addProduto(lista1.get(indice));
			lista1.get(indice).diminuiEstoque();
			response.sendRedirect("/Carrinho/VisualizaCarrinho");
		}
		
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
