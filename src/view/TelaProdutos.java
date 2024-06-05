package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import actions.CriarProdutoAction;
import actions.CriarTipoProdutoAction;
import actions.RemoverTipoProdutoAction;
import model.Produto;
import model.TipoProduto;

import javax.swing.JTabbedPane;
import javax.swing.JTable;
import java.awt.Panel;
import java.util.ArrayList;
import java.util.List;
import java.awt.Color;
import java.awt.Label;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JLabel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.awt.event.ActionEvent;

public class TelaProdutos extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private DefaultTableModel modeloProduto;
	private JTable table_tipos;
	private DefaultTableModel modeloTipos;

	
	private List<TipoProduto> tiposProduto;
	private List<Produto> produtos;
	private ConsultarTipoProdutoPanel consultarTipoProdutoPanel;
	private AdicionarProdutoPanel adicionarProdutoPanel;
	private ConsultarProdutoPanel consultarProdutoPanel; 
	private String arquivoTipo = "tipos.txt";
	private String arquivoProduto = "produtos.txt";

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaProdutos frame = new TelaProdutos();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public TelaProdutos() {
		tiposProduto = new ArrayList<TipoProduto>();
		produtos = new ArrayList<Produto>();
		inicializarDados();
		setTitle("Área de Estoque");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 640, 480);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(0, 0, 624, 441);
		contentPane.add(tabbedPane);
		
		adicionarProdutoPanel = new AdicionarProdutoPanel();
		adicionarProdutoPanel.addActionListener(new CriarProdutoAction() {
			
			@Override
			public void actionPerformed(Produto produto) {
				produtos.add(produto);
			}
		});
		tabbedPane.addTab("Cadastro de Produto", null, adicionarProdutoPanel, null);
		

		consultarTipoProdutoPanel = new ConsultarTipoProdutoPanel();
		consultarTipoProdutoPanel.setTiposProduto(tiposProduto);
		consultarTipoProdutoPanel.addActionsListener(new RemoverTipoProdutoAction() {
			
			@Override
			public void actionPerformed(TipoProduto tipo) {
				tiposProduto.remove(tipo);
				//atualizarTiposProdutos();
			}
		});
		
		var adicionarTipoProdutoPanel = new AdicionarTipoProdutoPanel();

		tabbedPane.addTab("Cadastro de Tipos", null, adicionarTipoProdutoPanel, null);
		
		adicionarTipoProdutoPanel.addActionsListener(new CriarTipoProdutoAction() {
			@Override
			public void actionPerformed(TipoProduto tipo) {
				tiposProduto.add(tipo);
				atualizarTiposProdutos(tipo);
			}

		});
		
		adicionarProdutoPanel.addActionListener(new CriarProdutoAction() {
			
			@Override
			public void actionPerformed(Produto produto) {
				produtos.add(produto);
				atualizarProdutos(produto);
			}
		});
		

		tabbedPane.addTab("Consultar Tipos de Produto", null, consultarTipoProdutoPanel, null);
		
		consultarProdutoPanel = new ConsultarProdutoPanel();
		tabbedPane.addTab("Consultar Produto", null, consultarProdutoPanel, null);
		

		modeloProduto = new DefaultTableModel(new Object[]{"ID", "Nome", "Valor", "Descrição", "Quantidade"}, 0);
	}
	
	private void atualizarTiposProdutos(TipoProduto tipo) {
		// Salvar no arquivo
		try(BufferedWriter writer = new BufferedWriter(new FileWriter(arquivoTipo, true))){
			writer.write(tipo.getId()+";"+tipo.getNome()+";"+tipo.getDescricao());
			writer.newLine();
			writer.close();
			System.out.println(tipo.toString());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(tiposProduto + " atualizando");
		
		consultarTipoProdutoPanel.setTiposProduto(tiposProduto);
		adicionarProdutoPanel.setTiposProduto(tiposProduto);
		consultarProdutoPanel.setTiposProduto(tiposProduto);
		
	}
	
	private void atualizarProdutos(Produto produto) {
		// Salvar no arquivo
		try(BufferedWriter writer = new BufferedWriter(new FileWriter(arquivoProduto, true))){
			var dados = produto.getId()+";"+produto.getNome()+";"+produto.getDescricao()+";"+produto.getQuantidade()+";"+produto.getValor()+";"+produto.getTipo().getId()+";"+produto.getTipo().getNome();
			writer.write(dados);
			writer.newLine();
			writer.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(produto + " atualizando");
		
		consultarProdutoPanel.setProduto(produtos);
	}
	
	private void inicializarDados() {
		try(BufferedReader reader = new BufferedReader(new FileReader(arquivoTipo))){
			String line;
			while((line = reader.readLine()) != null) {
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
//		try(BufferedReader reader = new BufferedReader(new FileReader(arquivoProduto))){
//			String line;
//			while((line = reader.readLine()) != null) {
//				var dados = line.split(";");
//				Produto produto = new Produto();
//				produto.setId(Long.parseLong(dados[0]));
//				produto.setNome(dados[1]);
//				produto.setDescricao(dados[2]);
//				produto.setQuantidade(Integer.parseInt(dados[3]));
//				produto.setValor(Double.parseDouble(dados[4]));
//				produto.set
//				
//				
//				
//				produtos.add(produto);
//			}
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
	}
	
	
}
