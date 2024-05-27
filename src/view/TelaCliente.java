package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTabbedPane;
import java.awt.Panel;
import java.awt.Color;
import java.awt.Label;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JTable;
import javax.swing.JComboBox;
import javax.swing.JList;
import java.awt.Component;

public class TelaCliente extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTable table;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTable table_produtos;
	private JTable table_carrinho;
	private DefaultTableModel modeloCatalogo;
	private DefaultTableModel modeloCarrinho;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaCliente frame = new TelaCliente();
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
	public TelaCliente() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 640, 480);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(0, 0, 624, 441);
		contentPane.add(tabbedPane);
		
		JPanel produtos = new JPanel();
		tabbedPane.addTab("Produtos", null, produtos, null);
		produtos.setLayout(null);
		
		Panel panel_1_3 = new Panel();
		panel_1_3.setBackground(new Color(234, 255, 215));
		panel_1_3.setBounds(208, 10, 194, 33);
		produtos.add(panel_1_3);
		
		Label label_3 = new Label("Catálogo de Produtos");
		label_3.setFont(new Font("Dialog", Font.PLAIN, 12));
		panel_1_3.add(label_3);
		
		textField_2 = new JTextField();
		textField_2.setToolTipText("ID Compra");
		textField_2.setColumns(10);
		textField_2.setBounds(35, 80, 111, 30);
		produtos.add(textField_2);
		
		JLabel lblNewLabel_8_2 = new JLabel("ID da compra");
		lblNewLabel_8_2.setBounds(35, 66, 142, 14);
		produtos.add(lblNewLabel_8_2);
		
		JLabel lblNewLabel_8_1_1 = new JLabel("Produto");
		lblNewLabel_8_1_1.setBounds(170, 66, 142, 14);
		produtos.add(lblNewLabel_8_1_1);
		
		textField_3 = new JTextField();
		textField_3.setToolTipText("Nome Cliente");
		textField_3.setColumns(10);
		textField_3.setBounds(170, 80, 162, 30);
		produtos.add(textField_3);
		
		JButton btnNewButton_4_1 = new JButton("Buscar");
		btnNewButton_4_1.setBounds(487, 84, 89, 23);
		produtos.add(btnNewButton_4_1);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(350, 80, 127, 30);
		produtos.add(comboBox);
		
		JLabel lblNewLabel_8_1_1_1 = new JLabel("Categoria");
		lblNewLabel_8_1_1_1.setBounds(350, 66, 105, 14);
		produtos.add(lblNewLabel_8_1_1_1);
		modeloCatalogo = new DefaultTableModel(new Object[]{"ID", "Nome", "Tipo"}, 0);
		table_produtos = new JTable(modeloCatalogo);
		JScrollPane scrollCatalogo = new JScrollPane(table_produtos);
		//table_produtos.setBounds(35, 161, 541, 175);
		 scrollCatalogo.setBounds(35, 136, 541, 200);
		produtos.add(scrollCatalogo);
		preencherCatalogo();
		
		JPanel carrinho = new JPanel();
		tabbedPane.addTab("Carrinho de Compras", null, carrinho, null);
		carrinho.setLayout(null);
		
		Panel panel_1 = new Panel();
		panel_1.setBackground(new Color(234, 255, 215));
		panel_1.setBounds(198, 10, 194, 33);
		carrinho.add(panel_1);
		
		Label label = new Label("Itens do Carrinho de Compras:");
		label.setFont(new Font("Dialog", Font.PLAIN, 12));
		panel_1.add(label);
		
		JLabel lblNewLabel_6 = new JLabel("Valor Total:");
		lblNewLabel_6.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_6.setBounds(28, 281, 97, 33);
		carrinho.add(lblNewLabel_6);
		
		JLabel lblNewLabel_6_1 = new JLabel("R$ 599, 97");
		lblNewLabel_6_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_6_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_6_1.setBounds(104, 281, 125, 33);
		carrinho.add(lblNewLabel_6_1);
		
		JButton btnNewButton_3 = new JButton("Ir para o pagamento");
		btnNewButton_3.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnNewButton_3.setBounds(26, 325, 180, 23);
		carrinho.add(btnNewButton_3);
		
		JButton btnNewButton_3_1 = new JButton("Esvaziar o carrinho");
		btnNewButton_3_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_3_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnNewButton_3_1.setBounds(406, 325, 180, 23);
		carrinho.add(btnNewButton_3_1);
		
		JButton btnNewButton = new JButton("Remover");
		btnNewButton.setForeground(new Color(255, 255, 255));
		btnNewButton.setBounds(496, 260, 89, 23);
		carrinho.add(btnNewButton);
		btnNewButton.setBackground(new Color(215, 9, 9));
		
		
		modeloCarrinho = new DefaultTableModel(new Object[]{"ID", "Produto", "Valor", "Quantidade"}, 0);
		table_carrinho = new JTable(modeloCarrinho);
		JScrollPane scrollCarrinho = new JScrollPane(table_carrinho);
		//table_produtos.setBounds(35, 161, 541, 175);
		 scrollCarrinho.setBounds(28, 84, 557, 165);
		carrinho.add(scrollCarrinho);
		preencherCarrinho();
		
		
		
		JPanel checkout = new JPanel();
		tabbedPane.addTab("Checkout", null, checkout, null);
		checkout.setLayout(null);
		
		Panel panel_1_1 = new Panel();
		panel_1_1.setBounds(198, 10, 194, 33);
		panel_1_1.setBackground(new Color(234, 255, 215));
		checkout.add(panel_1_1);
		
		Label label_1 = new Label("Conferência:");
		label_1.setFont(new Font("Dialog", Font.PLAIN, 12));
		panel_1_1.add(label_1);
		
		JLabel lblNewLabel_6_2 = new JLabel("Valor Total:");
		lblNewLabel_6_2.setBounds(20, 289, 180, 33);
		lblNewLabel_6_2.setFont(new Font("Tahoma", Font.BOLD, 14));
		checkout.add(lblNewLabel_6_2);
		
		JLabel lblNewLabel_6_1_1 = new JLabel("R$ 599, 97");
		lblNewLabel_6_1_1.setBounds(20, 289, 180, 33);
		lblNewLabel_6_1_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_6_1_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		checkout.add(lblNewLabel_6_1_1);
		
		JButton btnNewButton_3_1_1 = new JButton("Finalizar");
		btnNewButton_3_1_1.setBounds(417, 295, 180, 23);
		btnNewButton_3_1_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		checkout.add(btnNewButton_3_1_1);
		
		String[] mugiwara = {"Ronronoa Zoro", "Usopp", "Franky / Cutty Flam"};
		
		JList checkoutList = new JList(mugiwara);
		JScrollPane scrollCheckout = new JScrollPane(checkoutList);
		scrollCheckout.setBounds(20, 69, 577, 199);
		checkout.add(scrollCheckout);
		
		
		JPanel historico = new JPanel();
		tabbedPane.addTab("Histórico de compras", null, historico, null);
		historico.setLayout(null);
		
		Panel panel_1_2 = new Panel();
		panel_1_2.setBounds(191, 10, 234, 33);
		panel_1_2.setBackground(new Color(234, 255, 215));
		historico.add(panel_1_2);
		
		Label label_2 = new Label("Histórico de compras");
		label_2.setFont(new Font("Dialog", Font.PLAIN, 12));
		panel_1_2.add(label_2);
		
		textField = new JTextField();
		textField.setBounds(33, 73, 200, 30);
		textField.setToolTipText("ID Compra");
		textField.setColumns(10);
		historico.add(textField);
		
		textField_1 = new JTextField();
		textField_1.setBounds(254, 73, 200, 30);
		textField_1.setToolTipText("Nome Cliente");
		textField_1.setColumns(10);
		historico.add(textField_1);
		
		JButton btnNewButton_4 = new JButton("Buscar");
		btnNewButton_4.setBounds(481, 77, 89, 23);
		historico.add(btnNewButton_4);
		
		table = new JTable();
		table.setBounds(33, 154, 537, 184);
		historico.add(table);
		
		JButton btnNewButton_1_1 = new JButton("Exportar CSV");
		btnNewButton_1_1.setBounds(443, 354, 127, 23);
		historico.add(btnNewButton_1_1);
		
		JLabel lblNewLabel_8 = new JLabel("ID da compra");
		lblNewLabel_8.setBounds(33, 59, 142, 14);
		historico.add(lblNewLabel_8);
		
		JLabel lblNewLabel_8_1 = new JLabel("Nome do Cliente");
		lblNewLabel_8_1.setBounds(254, 59, 142, 14);
		historico.add(lblNewLabel_8_1);
		
	}
    private void preencherCatalogo() {
    	 modeloCatalogo.addRow(new Object[]{1, "Produto A", "Tipo 1"});
         modeloCatalogo.addRow(new Object[]{2, "Produto B", "Tipo 2"});
         modeloCatalogo.addRow(new Object[]{3, "Produto C", "Tipo 3"});
    }
    private void preencherCarrinho() {
	   	modeloCarrinho.addRow(new Object[]{1, "Produto A", "99,99", "1"});
	   	modeloCarrinho.addRow(new Object[]{2, "Produto B", "678,50", "2"});
	   	modeloCarrinho.addRow(new Object[]{3, "Produto C", "2,00", "1" });
   }

}
