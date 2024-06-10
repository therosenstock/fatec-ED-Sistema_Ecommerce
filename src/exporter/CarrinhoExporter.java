package exporter;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import model.Carrinho;

public class CarrinhoExporter {
	private List<Carrinho> carrinhos;
	private String nomeArquivo = "historico.csv";
	
	public CarrinhoExporter(List<Carrinho> carrinhos) {
		this.carrinhos = carrinhos;
	}
	
	public void exportar() {
		File arquivo = new File(nomeArquivo);
		
		try (BufferedWriter writer = new BufferedWriter(new FileWriter(arquivo, false))) {
			writer.write("ID Compra;Cliente;Total");
			writer.newLine();
			for (Carrinho carrinho : carrinhos) {
				String linha = getLinha(carrinho);
				writer.write(linha);
				writer.newLine();
			}
			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private String getLinha(Carrinho carrinho) {
		String cliente = "Sem Cliente";
		if (carrinho.getCliente() != null) carrinho.getCliente().getNome();
		
		return carrinho.getId() + ";" + cliente + ";" + carrinho.getTotal();
	}
}
