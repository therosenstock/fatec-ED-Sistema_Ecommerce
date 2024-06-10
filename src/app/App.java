package app;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import model.Carrinho;
import model.Cliente;
import model.PessoaFisica;
import model.PessoaJuridica;
import model.Produto;
import model.TipoProduto;

public class App {
	private List<Produto> produtos = new ArrayList<Produto>();
	private List<TipoProduto> tiposProduto = new ArrayList<TipoProduto>();
	private Carrinho carrinho = new Carrinho();
	private List<Carrinho> historico = new ArrayList<Carrinho>();
	private List<Cliente> clientes = new ArrayList<Cliente>();
	
	
	private static App app;
	
	private App() {
	}
	
	public static App getApp() {
		if (app == null) {
			app = new App();
		}
		
		return app;
	}
	
	public void inicializar() {
		inicializarProdutos();
		inicializarTipos();
		inicializarClientes();
	}
	
	public void finalizar() {
		historico.add(carrinho);
		carrinho = new Carrinho();
	}
	
	public List<Produto> getProdutos() {
		return produtos;
	}
	
	
	public List<TipoProduto> getTiposProduto() {
		return tiposProduto;
	}
	
	public List<Carrinho> getHistorico() {
		return historico;
	}
	
	public List<Cliente> getClientes() {
		return clientes;
	}
	
	public void addProduto(Produto produto) {
		// Salvar no arquivo
		File arquivoProduto = new File("produtos.txt");
		
		try (BufferedWriter writer = new BufferedWriter(new FileWriter(arquivoProduto, true))) {
			var dados = produto.getId() + ";" + produto.getNome() + ";" + produto.getDescricao() + ";"
					+ produto.getQuantidade() + ";" + produto.getValor() + ";" + produto.getTipo().getId() + ";"
					+ produto.getTipo().getNome() + ";" + produto.getTipo().getDescricao();
			writer.write(dados);
			writer.newLine();
			writer.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		produtos.add(produto);
	}
	
	
	public Carrinho getCarrinho() {
		return this.carrinho;
	}
	
	private void inicializarProdutos() {
		File arquivoProduto = new File("produtos.txt");
		
		try (BufferedReader reader = new BufferedReader(new FileReader(arquivoProduto))) {
			String line;
			while ((line = reader.readLine()) != null) {
				var dados = line.split(";");
				Produto produto = new Produto();
				produto.setId(Long.parseLong(dados[0]));
				produto.setNome(dados[1]);
				produto.setDescricao(dados[2]);
				produto.setQuantidade(Integer.parseInt(dados[3]));
				produto.setValor(Double.parseDouble(dados[4]));
				TipoProduto tipo = new TipoProduto();
				tipo.setId(Long.parseLong(dados[5]));
				tipo.setNome(dados[6]);
				tipo.setDescricao(dados[7]);
				produto.setTipo(tipo);

				produtos.add(produto);
				System.out.println(produto.getNome());
			}

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private void inicializarTipos() {
		File arquivoTipo = new File("tipos.txt");
		try (BufferedReader reader = new BufferedReader(new FileReader(arquivoTipo))) {
			String line;
			while ((line = reader.readLine()) != null) {
				var dados = line.split(";");
				TipoProduto tipo = new TipoProduto();
				tipo.setId(Long.parseLong(dados[0]));
				tipo.setNome(dados[1]);
				tipo.setDescricao(dados[2]);

				tiposProduto.add(tipo);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private void inicializarClientes() {
		File arquivoClientes = new File("clientes.txt");
		
		try (BufferedReader reader = new BufferedReader(new FileReader(arquivoClientes))) {
			String line;
			while ((line = reader.readLine()) != null) {
				var dados = line.split(";");
				int tamanho = dados.length;
				
				if(tamanho == 7) {
					PessoaFisica pf = new PessoaFisica();
					pf.setCpf(Long.parseLong(dados[0]));
					pf.setNome(dados[1]);
					pf.setLogradouro(dados[2]);
					pf.setNumero(Integer.parseInt(dados[3]));
					pf.setComplemento(dados[4]);
					pf.setCep(Integer.parseInt(dados[5]));
					pf.setTelefone(Long.parseLong(dados[6]));
					System.out.println(pf.getNome() + " pf");
					clientes.add(pf);
				} else {
					PessoaJuridica pj = new PessoaJuridica();
					pj.setCnpj(Long.parseLong(dados[0]));
					pj.setNomeFantasia(dados[1]);
					pj.setLogradouro(dados[2]);
					pj.setNumero(Integer.parseInt(dados[3]));
					pj.setComplemento(dados[4]);
					pj.setCep(Integer.parseInt(dados[5]));
					pj.setTelefone(Long.parseLong(dados[6]));
					pj.setEmail(dados[7]);
					System.out.println(pj.getNomeFantasia());
					clientes.add(pj);
				}
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
