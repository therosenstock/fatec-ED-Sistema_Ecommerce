package model;

public class Cliente {
	
	private String logradouro;
	private int numero;
	private String complemento;
	private int cep;
	private long telefone;

	public String getLogradouro() {
		return logradouro;
	}

	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	public int getCep() {
		return cep;
	}

	public void setCep(int cep) {
		this.cep = cep;
	}

	public long getTelefone() {
		return telefone;
	}

	public void setTelefone(long l) {
		this.telefone = l;
	}

}
