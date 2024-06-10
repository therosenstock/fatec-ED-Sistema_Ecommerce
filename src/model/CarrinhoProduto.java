package model;

public class CarrinhoProduto {
	private long id = System.currentTimeMillis();
	private Produto produto;
	private int quantidade;
	
	public Produto getProduto() {
		return produto;
	}
	public void setProduto(Produto produto) {
		this.produto = produto;
	}
	
	public int getQuantidade() {
		return quantidade;
	}
	
	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}
	
	public long getId() {
		return id;
	}
}
