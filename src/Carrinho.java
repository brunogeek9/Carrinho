import java.util.ArrayList;

public class Carrinho {
	private ArrayList <Produto> produto ;

	public Carrinho(ArrayList<Produto> produto) {
		super();
		this.produto = produto;
	}

	public ArrayList<Produto> getProduto() {
		return produto;
	}

	public void setProduto(ArrayList<Produto> produto) {
		this.produto = produto;
	}
	
	public Produto getProduto(int id){
		Produto mp = null;
		for (Produto p : produto) {
			if(p.getId()==id){
				return p;
			}
			
		}
		return mp;
	}
	public void removeProduto(int id){
		Produto p = getProduto(id);
		produto.remove(p);
	}
	public void addProduto(Produto p){
		produto.add(p);
	}
}
