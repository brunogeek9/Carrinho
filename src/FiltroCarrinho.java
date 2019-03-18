import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/*sempre que um cliente entrar em nas urls dentro do grupo especificado,uma verificação sera feita
e so conseguira ir ao conteudo da pagina se estiver dentro de uma das condiçoes de ser cliente */
//"/RealizaCadastroProduto""/VisualizaCarrinho"
@WebFilter(urlPatterns={})
public class FiltroCarrinho implements Filter {
	public void destroy() {		}
	
	
	public void init(FilterConfig fConfig) throws ServletException {	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain arg2)
			throws IOException, ServletException {
		HttpSession sessao = ((HttpServletRequest) request).getSession(false);
		/*Pessoa p = null;
		if( ((Pessoa) sessao.getAttribute("Pessoa")) == null){
			((HttpServletResponse) response).sendRedirect("/Carrinho/login.html");
		}else{
			p = new Pessoa(((Pessoa)sessao.getAttribute("Pessoa")).getEmail(),((Pessoa)sessao.getAttribute("Pessoa")).getSenha());
//			((HttpServletResponse) response).sendRedirect("/Carrinho/cliente.html");
			((HttpServletResponse) response).sendRedirect("/Carrinho/VisualizaCarrinho");
		}
		
		if(( (Carrinho) (sessao.getAttribute("carrinho"))) == null){
			((HttpServletResponse) response).sendRedirect("/Carrinho/ListaProdutos");
		}
		
		
		ServletContext ctx = ((HttpServletRequest) request).getServletContext();
		ArrayList<Pessoa> lista1 = (ArrayList<Pessoa>) ctx.getAttribute("listaClientes");
		ArrayList<Pessoa> lista2 = (ArrayList<Pessoa>) ctx.getAttribute("listaLojistas");
		boolean lojista = false ,cliente = false;
		*/
		/*
		for (Pessoa pessoa : lista1) {
			if(pessoa.getEmail().equals(p.getEmail()) && pessoa.getSenha().equals(p.getSenha())){
				cliente = true;
			}
		}
		for (Pessoa pessoa : lista2) {
			if(pessoa.getEmail().equals(p.getEmail()) && pessoa.getSenha().equals(p.getSenha())){
				lojista = true;
			}
		}
		if(lojista){
			((HttpServletResponse) response).sendRedirect("http://localhost:8080/carrinho/lojista.html");
		}else if(cliente){
			((HttpServletResponse) response).sendRedirect("http://localhost:8080/carrinho/cliente.html");
		}else{
			
		}*/
	}


}
