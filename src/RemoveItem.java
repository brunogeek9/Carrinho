

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
@WebServlet("/RemoveItem")
public class RemoveItem extends HttpServlet {
	
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
		ArrayList<Produto> lista = ((ArrayList<Produto>) ctx.getAttribute("listaPro"));
		int id = Integer.parseInt(request.getParameter("id"));
		int index = indice(id, lista);
		if(session.getAttribute("carrinho") == null){
			((Carrinho) session.getAttribute("carrinho")).removeProduto(index);
			lista.get(index).incrementaEstoque();
			response.sendRedirect("/Carrinho/VisualizaCarrinho");
		}else{
			((Carrinho) session.getAttribute("carrinho")).removeProduto(index);
			lista.get(index).incrementaEstoque();
			response.sendRedirect("/Carrinho/VisualizaCarrinho");
		}
	}

}
