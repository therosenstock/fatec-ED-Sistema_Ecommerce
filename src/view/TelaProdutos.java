package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import actions.CriarProdutoAction;
import actions.CriarTipoProdutoAction;
import actions.RemoverProdutoAction;
import actions.RemoverTipoProdutoAction;
import app.App;
import model.Produto;
import model.TipoProduto;

import javax.swing.JTabbedPane;
import javax.swing.JTable;
import java.awt.Panel;
import java.util.ArrayList;
import java.util.Iterator;
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
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.awt.event.ActionEvent;

public class TelaProdutos extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	private ConsultarTipoProdutoPanel consultarTipoProdutoPanel;
	private AdicionarProdutoPanel adicionarProdutoPanel;
	private ConsultarProdutoPanel consultarProdutoPanel;
	private AdicionarTipoProdutoPanel adicionarTipoProdutoPanel;
	private File arquivoTipo = new File("tipos.txt");
	private File arquivoProduto = new File("produtos.txt");
	private App app = App.getApp();

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
		consultarTipoProdutoPanel = new ConsultarTipoProdutoPanel();
		adicionarTipoProdutoPanel = new AdicionarTipoProdutoPanel();
		consultarProdutoPanel = new ConsultarProdutoPanel();

		consultarTipoProdutoPanel.setTiposProduto(app.getTiposProduto());
		adicionarProdutoPanel.setTiposProduto(app.getTiposProduto());
		consultarProdutoPanel.setTiposProduto(app.getTiposProduto());
		consultarProdutoPanel.setProduto(app.getProdutos());

		tabbedPane.addTab("Cadastro de Produto", null, adicionarProdutoPanel, null);
		tabbedPane.addTab("Cadastro de Tipos", null, adicionarTipoProdutoPanel, null);
		tabbedPane.addTab("Consultar Tipos de Produto", null, consultarTipoProdutoPanel, null);
		tabbedPane.addTab("Consultar Produto", null, consultarProdutoPanel, null);

		consultarTipoProdutoPanel.addActionsListener(new RemoverTipoProdutoAction() {
			@Override
			public void actionPerformed(TipoProduto tipo) {
				app.getTiposProduto().remove(tipo);
				removerTipoProduto();
				removerProdutosPorTipo(tipo);

				consultarTipoProdutoPanel.setTiposProduto(app.getTiposProduto());
				adicionarProdutoPanel.setTiposProduto(app.getTiposProduto());
				consultarProdutoPanel.setTiposProduto(app.getTiposProduto());
			}
		});

		adicionarTipoProdutoPanel.addActionsListener(new CriarTipoProdutoAction() {
			@Override
			public void actionPerformed(TipoProduto tipo) {
				app.getTiposProduto().add(tipo);
				atualizarTiposProdutos(tipo);

				consultarTipoProdutoPanel.setTiposProduto(app.getTiposProduto());
				adicionarProdutoPanel.setTiposProduto(app.getTiposProduto());
				consultarProdutoPanel.setTiposProduto(app.getTiposProduto());
			}
		});

		adicionarProdutoPanel.addActionListener(new CriarProdutoAction() {
			@Override
			public void actionPerformed(Produto produto) {
				app.getProdutos().add(produto);
				atualizarProdutos(produto);

				consultarProdutoPanel.setProduto(app.getProdutos());
			}
		});

		consultarProdutoPanel.addActionsListener(new RemoverProdutoAction() {

			@Override
			public void actionPerformed(Produto produto) {
				// TODO Auto-generated method stub
				app.getProdutos().remove(produto);
				removerProduto();
			}
		});

	}

	private void atualizarTiposProdutos(TipoProduto tipo) {
		// Salvar no arquivo
		try (BufferedWriter writer = new BufferedWriter(new FileWriter(arquivoTipo, true))) {
			writer.write(tipo.getId() + ";" + tipo.getNome() + ";" + tipo.getDescricao());
			writer.newLine();
			writer.close();
			System.out.println(tipo.toString());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(app.getTiposProduto() + " atualizando");
	}

	private void atualizarProdutos(Produto produto) {
		app.addProduto(produto);
		System.out.println(produto + " atualizando");
		consultarProdutoPanel.setProduto(app.getProdutos());
	}

	private void inicializarDados() {
		app.inicializar();
	}



	private void removerTipoProduto() {
		File arquivoTemp = new File("novoarquivo.txt");
		try (BufferedWriter writer = new BufferedWriter(new FileWriter(arquivoTemp, true))) {
			for (TipoProduto tipo : app.getTiposProduto()) {
				writer.write(tipo.getId() + ";" + tipo.getNome() + ";" + tipo.getDescricao());
				writer.newLine();

				System.out.println(tipo.toString());
			}
			writer.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		arquivoTipo.delete();
		arquivoTemp.renameTo(arquivoTipo);

		consultarTipoProdutoPanel.setTiposProduto(app.getTiposProduto());
		adicionarProdutoPanel.setTiposProduto(app.getTiposProduto());
		consultarProdutoPanel.setTiposProduto(app.getTiposProduto());

	}

	private void removerProduto() {
		File arquivoTemp = new File("novoarquivo.txt");
		try (BufferedWriter writer = new BufferedWriter(new FileWriter(arquivoTemp, true))) {
			for (Produto produto : app.getProdutos()) {
				var dados = produto.getId() + ";" + produto.getNome() + ";" + produto.getDescricao() + ";"
						+ produto.getQuantidade() + ";" + produto.getValor() + ";" + produto.getTipo().getId() + ";"
						+ produto.getTipo().getNome() + ";" + produto.getTipo().getDescricao();
				writer.write(dados);
				writer.newLine();
			}
			writer.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		arquivoProduto.delete();
		arquivoTemp.renameTo(arquivoProduto);
	}

	private void removerProdutosPorTipo(TipoProduto tipo) {
        Iterator<Produto> iterator = app.getProdutos().iterator();
        while (iterator.hasNext()) {
            Produto produto = iterator.next();
			if (produto.getTipo().getId() == tipo.getId()) {
				iterator.remove();
			}
		}

		try (BufferedWriter writer = new BufferedWriter(new FileWriter(arquivoProduto, false))) {
			for (Produto produto : app.getProdutos()) {
				var dados = produto.getId() + ";" + produto.getNome() + ";" + produto.getDescricao() + ";"
						+ produto.getQuantidade() + ";" + produto.getValor() + ";" + produto.getTipo().getId() + ";"
						+ produto.getTipo().getNome() + ";" + produto.getTipo().getDescricao();
				writer.write(dados);
				writer.newLine();
			}
			writer.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		consultarProdutoPanel.setProduto(app.getProdutos());

	}
}
