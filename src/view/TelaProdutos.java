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
	private JTable table_produto;
	private DefaultTableModel modeloProduto;
	private JTable table_tipos;
	private DefaultTableModel modeloTipos;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField tipoProdutoNomeTxt;
	private JTextField textField_3;
	private JTextField textField_6;
	
	private List<TipoProduto> tiposProduto;
	private List<Produto> produtos;
	private ConsultarTipoProdutoPanel consultarTipoProdutoPanel;
	private AdicionarProdutoPanel adicionarProdutoPanel;
	private String arquivoTipo = "tipos.txt";

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
		
		JPanel consultaProdutos = new JPanel();
		tabbedPane.addTab("Consultar Produtos", null, consultaProdutos, null);
		consultaProdutos.setLayout(null);
		table_produto = new JTable(modeloProduto);
		JScrollPane scrollProduto = new JScrollPane(table_produto);
		//table_produtos.setBounds(35, 161, 541, 175);
		scrollProduto.setBounds(28, 123, 557, 231);
		consultaProdutos.add(scrollProduto);
		
		Panel panel_1_3 = new Panel();
		panel_1_3.setBackground(new Color(234, 255, 215));
		panel_1_3.setBounds(195, 10, 194, 33);
		consultaProdutos.add(panel_1_3);
		
		Label label_3 = new Label("Consulta de Produtos");
		label_3.setFont(new Font("Dialog", Font.PLAIN, 12));
		panel_1_3.add(label_3);
		
		textField_3 = new JTextField();
		textField_3.setBounds(28, 71, 228, 30);
		consultaProdutos.add(textField_3);
		textField_3.setColumns(10);
		
		JButton btnBuscarProduto = new JButton("Buscar");
		btnBuscarProduto.setBounds(260, 75, 70, 23);
		consultaProdutos.add(btnBuscarProduto);
		
		JLabel lblNewLabel_5 = new JLabel("Nome:");
		lblNewLabel_5.setBounds(28, 53, 46, 14);
		consultaProdutos.add(lblNewLabel_5);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(332, 71, 163, 30);
		consultaProdutos.add(comboBox);
		
		JLabel lblNewLabel_6 = new JLabel("Escolha o Tipo:");
		lblNewLabel_6.setBounds(332, 53, 78, 14);
		consultaProdutos.add(lblNewLabel_6);
		
		JButton btnFiltrarProduto = new JButton("Filtrar");
		btnFiltrarProduto.setBounds(505, 75, 89, 23);
		consultaProdutos.add(btnFiltrarProduto);
		
		JButton btnRemoverProduto = new JButton("Remover");
		btnRemoverProduto.setBounds(494, 366, 89, 23);
		consultaProdutos.add(btnRemoverProduto);
		
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
		

		tabbedPane.addTab("Consultar Tipos de Produto", null, consultarTipoProdutoPanel, null);

		modeloProduto = new DefaultTableModel(new Object[]{"ID", "Nome", "Valor", "Descrição", "Quantidade"}, 0);
	}
	
	private void atualizarTiposProdutos(TipoProduto tipo) {
		// Salvar no arquivo
		try(BufferedWriter writer = new BufferedWriter(new FileWriter(arquivoTipo))){
			writer.write(tipo.toString());
			writer.newLine();
			writer.close();
			System.out.println(tipo.toString());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		consultarTipoProdutoPanel.setTiposProduto(tiposProduto);
		adicionarProdutoPanel.setTiposProduto(tiposProduto);
	}
	
	private void atualizarProdutos() {
		// Salvar no arquivo
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
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
