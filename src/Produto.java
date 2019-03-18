public class Produto {
	private int id;
	private int preco;
	private String nome;
	private String Descricao;
	private int estoque;
	private static int cont = 0;/* quantidade aumentada a cada nova instancia de produto
		cont e um atributo de instancia que pertence a classe e nao ao objeto*/
	public Produto(int preco, String nome, String descricao, int estoque) {
		
		this.preco = preco;
		this.nome = nome;
		this.Descricao = descricao;
		this.estoque = estoque;
		this.id = cont++;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getPreco() {
		return preco;
	}
	public void setPreco(int preco) {
		this.preco = preco;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getDescricao() {
		return Descricao;
	}
	public void setDescricao(String descricao) {
		Descricao = descricao;
	}
	public int getEstoque() {
		return estoque;
	}
	public void setEstoque(int estoque) {
		this.estoque = estoque;
	}
	public void incrementaEstoque(){
		this.estoque++;
	}
	public void diminuiEstoque(){
		this.estoque--;
	}

}
