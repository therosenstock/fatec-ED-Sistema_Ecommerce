package model;


import java.util.ArrayList;
import java.util.List;

import estrutura.Pilha;

public class Carrinho {
	private long id = System.currentTimeMillis();
	private Pilha<CarrinhoProduto> itens = new Pilha<CarrinhoProduto>();
	private Cliente cliente;
	
	public Pilha<CarrinhoProduto> getItens() {
		return itens;
	}
	
	public void addItem(CarrinhoProduto item) {
		itens.push(item);
	}
	
	public void removeItem(CarrinhoProduto item) {
		List<CarrinhoProduto> lista = new ArrayList<CarrinhoProduto>();
		

		
		while (!itens.isEmpty()) {
			try {
				CarrinhoProduto i = itens.pop();
				if (!i.equals(item)) {
					lista.add(i);
				} else {
					Produto produto = item.getProduto();
					produto.setQuantidade(produto.getQuantidade() + item.getQuantidade());
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		Pilha<CarrinhoProduto> pilha = new Pilha<CarrinhoProduto>();
		
		for (CarrinhoProduto i : lista.reversed()) {
			pilha.push(i);
		}
		
		itens = pilha;
	}
	
	public void esvaziar() {
		while (!itens.isEmpty()) {
			try {
				CarrinhoProduto item = itens.pop();
				Produto produto = item.getProduto();
				produto.setQuantidade(produto.getQuantidade() + item.getQuantidade());
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
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
