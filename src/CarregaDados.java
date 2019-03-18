
import java.util.ArrayList;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener()
public class CarregaDados implements ServletContextListener {

	public void contextInitialized(ServletContextEvent ctx) {
		//inicializando produtos na aplicação
		ArrayList<Produto> listaProduto = new ArrayList<Produto>();
		
		Produto p1 = new Produto(500, "Mesa", " Uma mesa de computador", 10);
		Produto p2 = new Produto( 2, "Lapis", "Lapis B2 grafite", 50);
		Produto p3 = new Produto(1500, "Computador", "Computador I5 16Gb de RAM.",2);
		
		listaProduto.add(p1);
		listaProduto.add(p2);
		listaProduto.add(p3);
		
		//Inicializando clientes na aplicação
		ArrayList<Pessoa> listaClientes = new ArrayList<>();
		
		Pessoa c1 = new Pessoa("João Pedro","jp2017@uol.com.br","12345jaum");
		Pessoa c2 = new Pessoa("Amara Silva","amarasil@bol.com.br","amara82");
		Pessoa c3 = new Pessoa("Maria Pereira","mariape@terra.com.br","145aektm");
		Pessoa c4 = new Pessoa("Maria Pereira","a","a");
		
		listaClientes.add(c1);
		listaClientes.add(c2);
		listaClientes.add(c3);
		listaClientes.add(c4);
		//Inicializando vendedores na aplicação
		ArrayList<Pessoa> listaLojistas = new ArrayList<>();
		Pessoa l1 = new Pessoa("Bruno Jamelli","bruno@gmail.com","123");
		Pessoa l2 = new Pessoa("tutu","tutu@gmail.com","123");
		listaLojistas.add(l1);
		listaLojistas.add(l2);
		
		//colocando as listas no contexto da aplicação
		ctx.getServletContext().setAttribute("listaPro", listaProduto);
		ctx.getServletContext().setAttribute("listaClientes", listaClientes);
		ctx.getServletContext().setAttribute("listaLojistas", listaLojistas);
	}

	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
		

	}

}
