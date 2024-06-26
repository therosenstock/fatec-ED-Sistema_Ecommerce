package model;

public class PessoaJuridica extends Cliente{
	
	private String nomeFantasia;
	private long cnpj;
	private String email;
	
	public PessoaJuridica() {
		this.tipo = "PJ";
	}
	
	public String getNomeFantasia() {
		return nomeFantasia;
	}
	
	public void setNomeFantasia(String nomeFantasia) {
		this.nomeFantasia = nomeFantasia;
	}
	
	public long getCnpj() {
		return cnpj;
	}
	
	public void setCnpj(long cnpj) {
		this.cnpj = cnpj;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	@Override
	public String getNome() {
		return nomeFantasia;
	}
	
	public String toString() {
		return nomeFantasia;
	}
	
	@Override
	public long getDocumento() {
		return cnpj;
	}
	
}
