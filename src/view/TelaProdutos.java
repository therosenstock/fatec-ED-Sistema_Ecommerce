package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import java.awt.Panel;
import java.awt.Color;
import java.awt.Label;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JComboBox;

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
	private JTextField textField_5;
	private JTextField textField_3;
	private JTextField textField_6;

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
		
		JPanel cadastroProduto = new JPanel();
		tabbedPane.addTab("Cadastro de Produto", null, cadastroProduto, null);
		cadastroProduto.setLayout(null);
		
		Panel panel_1_3_3 = new Panel();
		panel_1_3_3.setBackground(new Color(234, 255, 215));
		panel_1_3_3.setBounds(188, 10, 194, 33);
		cadastroProduto.add(panel_1_3_3);
		
		Label label_3_3 = new Label("Cadastro de Produto");
		label_3_3.setFont(new Font("Dialog", Font.PLAIN, 12));
		panel_1_3_3.add(label_3_3);
		
		textField = new JTextField();
		textField.setBounds(10, 82, 599, 30);
		cadastroProduto.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(10, 140, 261, 30);
		cadastroProduto.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(333, 140, 276, 30);
		cadastroProduto.add(textField_2);
		textField_2.setColumns(10);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(10, 198, 599, 81);
		cadastroProduto.add(textArea);
		
		JLabel lblNewLabel = new JLabel("Descrição:");
		lblNewLabel.setBounds(10, 181, 108, 14);
		cadastroProduto.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Valor:");
		lblNewLabel_1.setBounds(10, 125, 46, 14);
		cadastroProduto.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Quantidade:");
		lblNewLabel_2.setBounds(333, 125, 113, 14);
		cadastroProduto.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Nome:");
		lblNewLabel_3.setBounds(10, 65, 46, 14);
		cadastroProduto.add(lblNewLabel_3);
		
		JButton btnNewButton = new JButton("Adicionar");
		btnNewButton.setBounds(520, 317, 89, 23);
		cadastroProduto.add(btnNewButton);
		
		JPanel consultaProdutos = new JPanel();
		tabbedPane.addTab("Consultar Produtos", null, consultaProdutos, null);
		consultaProdutos.setLayout(null);
		table_produto = new JTable(modeloProduto);
		JScrollPane scrollProduto = new JScrollPane(table_produto );
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
		
		JPanel cadastroTipos = new JPanel();
		tabbedPane.addTab("Cadastro de Tipos", null, cadastroTipos, null);
		cadastroTipos.setLayout(null);
		
		Panel panel_1_3_2 = new Panel();
		panel_1_3_2.setBackground(new Color(234, 255, 215));
		panel_1_3_2.setBounds(196, 10, 194, 33);
		cadastroTipos.add(panel_1_3_2);
		
		Label label_3_2 = new Label("Cadastro de Tipos de Produto");
		label_3_2.setFont(new Font("Dialog", Font.PLAIN, 12));
		panel_1_3_2.add(label_3_2);
		
		JTextArea textArea_1 = new JTextArea();
		textArea_1.setBounds(10, 141, 599, 81);
		cadastroTipos.add(textArea_1);
		
		JLabel lblNewLabel_4 = new JLabel("Descrição:");
		lblNewLabel_4.setBounds(10, 124, 108, 14);
		cadastroTipos.add(lblNewLabel_4);
		
		JLabel lblNewLabel_3_1 = new JLabel("Nome:");
		lblNewLabel_3_1.setBounds(10, 66, 46, 14);
		cadastroTipos.add(lblNewLabel_3_1);
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBounds(10, 83, 599, 30);
		cadastroTipos.add(textField_5);
		
		JButton btnNewButton_1 = new JButton("Adicionar");
		btnNewButton_1.setBounds(520, 250, 89, 23);
		cadastroTipos.add(btnNewButton_1);
		
		JPanel consultaTipos = new JPanel();
		tabbedPane.addTab("Consultar Tipos de Produto", null, consultaTipos, null);
		consultaTipos.setLayout(null);
		
		modeloProduto = new DefaultTableModel(new Object[]{"ID", "Nome", "Valor", "Descrição", "Quantidade"}, 0);
		
		modeloTipos = new DefaultTableModel(new Object[]{"ID", "Tipo", "Descrição"}, 0);
		table_tipos = new JTable(modeloTipos);
		JScrollPane scrollTipos = new JScrollPane(table_tipos);
		//table_produtos.setBounds(35, 161, 541, 175);
		scrollTipos.setBounds(28, 112, 557, 231);
		consultaTipos.add(scrollTipos);
		
		Panel panel_1_3_1 = new Panel();
		panel_1_3_1.setBackground(new Color(234, 255, 215));
		panel_1_3_1.setBounds(194, 10, 194, 33);
		consultaTipos.add(panel_1_3_1);
		
		Label label_3_1 = new Label("Consulta de Tipos de Produto");
		label_3_1.setFont(new Font("Dialog", Font.PLAIN, 12));
		panel_1_3_1.add(label_3_1);
		
		textField_6 = new JTextField();
		textField_6.setColumns(10);
		textField_6.setBounds(28, 71, 464, 30);
		consultaTipos.add(textField_6);
		
		JLabel lblNewLabel_5_1 = new JLabel("Nome:");
		lblNewLabel_5_1.setBounds(28, 53, 46, 14);
		consultaTipos.add(lblNewLabel_5_1);
		
		JButton btnBuscarProduto_1 = new JButton("Buscar");
		btnBuscarProduto_1.setBounds(502, 75, 83, 23);
		consultaTipos.add(btnBuscarProduto_1);
		
		JButton btnNewButton_2 = new JButton("Remover");
		btnNewButton_2.setBounds(496, 353, 89, 23);
		consultaTipos.add(btnNewButton_2);
	}
}
