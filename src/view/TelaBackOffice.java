package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Panel;
import java.awt.Color;
import java.awt.Label;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JComboBox;

public class TelaBackOffice extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField nome_pf;
	private JTextField cpf_pf;
	private JTextField logradouro_pf;
	private JTextField numero_pf;
	private JTextField complemento_pf;
	private JTextField cep_pf;
	private JTextField telefone_pf;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTable table_cliente;
	private DefaultTableModel modeloCliente;
	private JTextField textField_7;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaBackOffice frame = new TelaBackOffice();
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
	public TelaBackOffice() {
		setTitle("Área de BackOffice");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 640, 480);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(0, 0, 624, 441);
		contentPane.add(tabbedPane);
		
		JPanel consultaCliente = new JPanel();
		tabbedPane.addTab("Consulta Cliente", null, consultaCliente, null);
		consultaCliente.setLayout(null);
		
		modeloCliente = new DefaultTableModel(new Object[]{"Documento", "Nome/Razão Social", "Endereço", "Telefone"}, 0);
		table_cliente = new JTable(modeloCliente);
		JScrollPane scrollCarrinho = new JScrollPane(table_cliente);
		//table_produtos.setBounds(35, 161, 541, 175);
		 scrollCarrinho.setBounds(28, 112, 557, 231);
		consultaCliente.add(scrollCarrinho);
		
		textField_7 = new JTextField();
		textField_7.setToolTipText("ID Compra");
		textField_7.setColumns(10);
		textField_7.setBounds(28, 71, 436, 30);
		consultaCliente.add(textField_7);
		
		JButton btnNewButton_4_1 = new JButton("Buscar");
		btnNewButton_4_1.setBounds(474, 75, 89, 23);
		consultaCliente.add(btnNewButton_4_1);
		
		JLabel lblNewLabel_7 = new JLabel("Documento:");
		lblNewLabel_7.setBounds(28, 53, 89, 14);
		consultaCliente.add(lblNewLabel_7);
		
		Panel panel_1_3 = new Panel();
		panel_1_3.setBackground(new Color(234, 255, 215));
		panel_1_3.setBounds(206, 10, 194, 33);
		consultaCliente.add(panel_1_3);
		
		Label label_3 = new Label("Clientes");
		label_3.setFont(new Font("Dialog", Font.PLAIN, 12));
		panel_1_3.add(label_3);
		
		JButton btnRemover = new JButton("Remover");
		btnRemover.setBounds(496, 354, 89, 23);
		consultaCliente.add(btnRemover);
		preencherCliente();
		
		JPanel cadastroClientePF = new JPanel();
		tabbedPane.addTab("Pessoa Física", null, cadastroClientePF, null);
		cadastroClientePF.setLayout(null);
		
		nome_pf = new JTextField();
		nome_pf.setBounds(10, 95, 326, 30);
		cadastroClientePF.add(nome_pf);
		nome_pf.setColumns(10);
		
		cpf_pf = new JTextField();
		cpf_pf.setBounds(363, 95, 246, 30);
		cadastroClientePF.add(cpf_pf);
		cpf_pf.setColumns(10);
		
		logradouro_pf = new JTextField();
		logradouro_pf.setBounds(10, 155, 406, 30);
		cadastroClientePF.add(logradouro_pf);
		logradouro_pf.setColumns(10);
		
		numero_pf = new JTextField();
		numero_pf.setBounds(442, 155, 167, 30);
		cadastroClientePF.add(numero_pf);
		numero_pf.setColumns(10);
		
		complemento_pf = new JTextField();
		complemento_pf.setBounds(10, 213, 159, 30);
		cadastroClientePF.add(complemento_pf);
		complemento_pf.setColumns(10);
		
		cep_pf = new JTextField();
		cep_pf.setBounds(197, 213, 219, 30);
		cadastroClientePF.add(cep_pf);
		cep_pf.setColumns(10);
		
		telefone_pf = new JTextField();
		telefone_pf.setBounds(442, 213, 167, 30);
		cadastroClientePF.add(telefone_pf);
		telefone_pf.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Nome Completo:");
		lblNewLabel.setBounds(10, 78, 109, 14);
		cadastroClientePF.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("CPF:");
		lblNewLabel_1.setBounds(363, 78, 46, 14);
		cadastroClientePF.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Endereço:");
		lblNewLabel_2.setBounds(10, 136, 136, 14);
		cadastroClientePF.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("N°:");
		lblNewLabel_3.setBounds(442, 136, 46, 14);
		cadastroClientePF.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Complemento:");
		lblNewLabel_4.setBounds(10, 196, 109, 14);
		cadastroClientePF.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("CEP:");
		lblNewLabel_5.setBounds(197, 196, 46, 14);
		cadastroClientePF.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("Telefone:");
		lblNewLabel_6.setBounds(442, 196, 46, 14);
		cadastroClientePF.add(lblNewLabel_6);
		
		Panel panel_1_2 = new Panel();
		panel_1_2.setBackground(new Color(234, 255, 215));
		panel_1_2.setBounds(182, 10, 234, 33);
		cadastroClientePF.add(panel_1_2);
		
		Label label_2 = new Label("Cadastro de Pessoa Física");
		label_2.setFont(new Font("Dialog", Font.PLAIN, 12));
		panel_1_2.add(label_2);
		
		JButton btnNewButton = new JButton("Cadastrar");
		btnNewButton.setBounds(520, 283, 89, 30);
		cadastroClientePF.add(btnNewButton);
		
		JPanel panel = new JPanel();
		tabbedPane.addTab("Pessoa Jurídica", null, panel, null);
		panel.setLayout(null);
		
		JPanel cadastroClientePJ = new JPanel();
		cadastroClientePJ.setLayout(null);
		cadastroClientePJ.setBounds(0, 0, 619, 413);
		panel.add(cadastroClientePJ);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(10, 95, 326, 30);
		cadastroClientePJ.add(textField);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(363, 95, 246, 30);
		cadastroClientePJ.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(10, 155, 406, 30);
		cadastroClientePJ.add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(442, 155, 167, 30);
		cadastroClientePJ.add(textField_3);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(10, 213, 159, 30);
		cadastroClientePJ.add(textField_4);
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBounds(197, 213, 219, 30);
		cadastroClientePJ.add(textField_5);
		
		textField_6 = new JTextField();
		textField_6.setColumns(10);
		textField_6.setBounds(442, 213, 167, 30);
		cadastroClientePJ.add(textField_6);
		
		JLabel lblRazoSocial = new JLabel("Razão Social:");
		lblRazoSocial.setBounds(10, 78, 109, 14);
		cadastroClientePJ.add(lblRazoSocial);
		
		JLabel lblNewLabel_1_1 = new JLabel("CPF:");
		lblNewLabel_1_1.setBounds(363, 78, 46, 14);
		cadastroClientePJ.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_2_1 = new JLabel("Endereço:");
		lblNewLabel_2_1.setBounds(10, 136, 136, 14);
		cadastroClientePJ.add(lblNewLabel_2_1);
		
		JLabel lblNewLabel_3_1 = new JLabel("N°:");
		lblNewLabel_3_1.setBounds(442, 136, 46, 14);
		cadastroClientePJ.add(lblNewLabel_3_1);
		
		JLabel lblNewLabel_4_1 = new JLabel("Complemento:");
		lblNewLabel_4_1.setBounds(10, 196, 109, 14);
		cadastroClientePJ.add(lblNewLabel_4_1);
		
		JLabel lblNewLabel_5_1 = new JLabel("CEP:");
		lblNewLabel_5_1.setBounds(197, 196, 46, 14);
		cadastroClientePJ.add(lblNewLabel_5_1);
		
		JLabel lblNewLabel_6_1 = new JLabel("Telefone:");
		lblNewLabel_6_1.setBounds(442, 196, 46, 14);
		cadastroClientePJ.add(lblNewLabel_6_1);
		
		Panel panel_1_2_1 = new Panel();
		panel_1_2_1.setBackground(new Color(234, 255, 215));
		panel_1_2_1.setBounds(182, 10, 234, 33);
		cadastroClientePJ.add(panel_1_2_1);
		
		Label label_2_1 = new Label("Cadastro de Pessoa Jurídica");
		label_2_1.setFont(new Font("Dialog", Font.PLAIN, 12));
		panel_1_2_1.add(label_2_1);
		
		JButton btnNewButton_1 = new JButton("Cadastrar");
		btnNewButton_1.setBounds(520, 283, 89, 30);
		cadastroClientePJ.add(btnNewButton_1);
	}
	
    private void preencherCliente() {
	   	 modeloCliente.addRow(new Object[]{1, "Produto A", "Tipo 1"});
	   	 modeloCliente.addRow(new Object[]{1, "Produto A", "Tipo 1"});
	   	 modeloCliente.addRow(new Object[]{1, "Produto A", "Tipo 1"});
	   }
}
