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
import java.io.File;
import java.util.List;
import java.awt.Color;
import java.awt.Label;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JComboBox;
import model.Cliente;
import model.PessoaFisica;
import model.PessoaJuridica;

public class TelaCliente extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	
	private List<Cliente> clientes;

	private ConsultarClientesPanel consultarClientesPanel;
	private AdicionarClientePFPanel adicionarClientePF;
	private AdicionarClientePJPanel adicionarClientePJ;
	private File arquivoClientes = new File("clientes.txt");
	

	private DefaultTableModel modeloCliente;

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
		setTitle("Área de Clientes");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 640, 480);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(0, 0, 624, 441);
		contentPane.add(tabbedPane);
		
		consultarClientesPanel = new ConsultarClientesPanel();
		adicionarClientePF = new AdicionarClientePFPanel();
		adicionarClientePJ = new AdicionarClientePJPanel();
		
		//funçoes de set
		tabbedPane.addTab("Consultar Clientes", null, consultarClientesPanel, null);
		tabbedPane.addTab("Cadastro de Pessoa Física", null, adicionarClientePF, null);
		tabbedPane.addTab("Cadastro de Pessoa Jurídica", null, adicionarClientePJ, null);
		

	}
	

}
