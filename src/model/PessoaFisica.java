package model;

public class PessoaFisica extends Cliente {
	
	private String nome;
	private long cpf;
	
	public PessoaFisica() {
		this.tipo = "PF";
	}
	
	@Override
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public long getCpf() {
		return cpf;
	}
	
	public void setCpf(long cpf) {
		this.cpf = cpf;
	}
	
	public String toString() {
		return nome;
	}
	
	@Override
	public long getDocumento() {
		return cpf;
	}

}
