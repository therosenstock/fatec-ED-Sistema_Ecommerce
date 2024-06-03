package model;

public class Produto {

	private long id;
	private String nome;
	private double valor;
	private String descricao;
	private int quantidade;
	private TipoProduto tipo;
	
	public int getQuantidade() {
		return quantidade;
	}
	
	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}
	
	public String getDescricao() {
		return descricao;
	}
	
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	public double getValor() {
		return valor;
	}
	
	public void setValor(double valor) {
		this.valor = valor;
	}
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public long getId() {
		return id;
	}
	
	public void setId(long id) {
		this.id = id;
	}
	
	public TipoProduto getTipo() {
		return tipo;
	}
	
	public void setTipo(TipoProduto tipo) {
		this.tipo = tipo;
	}
}
