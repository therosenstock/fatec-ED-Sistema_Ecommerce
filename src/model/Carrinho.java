package model;

import java.util.ArrayList;
import java.util.List;

public class Carrinho {
	private long id = System.currentTimeMillis();
	private List<CarrinhoProduto> itens = new ArrayList<CarrinhoProduto>();
	private Cliente cliente;
	
	public List<CarrinhoProduto> getItens() {
		return itens;
	}
	
	public void addItem(CarrinhoProduto item) {
		itens.add(item);
	}
	
	public void removeItem(CarrinhoProduto item) {
		itens.remove(item);
	}
	
	public void esvaziar() {
		itens.clear();
	}
	
	public long getId() {
		return id;
	}
	
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	
	public Cliente getCliente() {
		return cliente;
	}
	
	public double getTotal() {
		double total = 0;
		for (CarrinhoProduto item : itens) {
			total += item.getProduto().getValor() * item.getQuantidade();
		}
		return total;
	}
}
