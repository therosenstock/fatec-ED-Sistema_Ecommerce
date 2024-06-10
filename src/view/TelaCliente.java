package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import actions.CriarClienteAction;
import actions.RemoverClienteAction;
import app.App;

import javax.swing.JTabbedPane;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import model.Cliente;
import model.PessoaFisica;
import model.PessoaJuridica;

public class TelaCliente extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	
	private List<PessoaJuridica> clientesPj = new ArrayList<PessoaJuridica>();
	private List<PessoaFisica> clientesPf = new ArrayList<PessoaFisica>();
	

	private ConsultarClientesPanel consultarClientesPanel;
	private AdicionarClientePFPanel adicionarClientePF;
	private AdicionarClientePJPanel adicionarClientePJ;
	private File arquivoClientes = new File("clientes.txt");
	private App app = App.getApp();
	private static int CLOSE_OPERATION = JFrame.DISPOSE_ON_CLOSE;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				CLOSE_OPERATION = JFrame.EXIT_ON_CLOSE;
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
		setDefaultCloseOperation(CLOSE_OPERATION);
		setBounds(100, 100, 640, 480);
		setResizable(false);
		app.inicializar();

		 
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
		
		adicionarClientePF.setClientes(app.getClientes());
		adicionarClientePJ.setClientes(app.getClientes());
		consultarClientesPanel.setClientes(app.getClientes());
		//funçoes de set
		tabbedPane.addTab("Consultar Clientes", null, consultarClientesPanel, null);
		tabbedPane.addTab("Cadastro de Pessoa Física", null, adicionarClientePF, null);
		tabbedPane.addTab("Cadastro de Pessoa Jurídica", null, adicionarClientePJ, null);
		
		
		consultarClientesPanel.addActionsListener(new RemoverClienteAction() {
			
			@Override
			public void actionPerformed(Cliente cliente) {
				app.getClientes().remove(cliente);
				atualizarClientes();
			}
		});
		
		adicionarClientePJ.addActionsListener(new CriarClienteAction() {
			
			@Override
			public void actionPerformed(PessoaJuridica cliente) {
				clientesPj.add(cliente);
				atualizarClientePj(cliente);
			}

			@Override
			public void actionPerformed(PessoaFisica cliente) {}

		});
		
		adicionarClientePF.addActionsListener(new CriarClienteAction() {
			
			@Override
			public void actionPerformed(PessoaJuridica cliente) {}

			@Override
			public void actionPerformed(PessoaFisica cliente) {
				// TODO Auto-generated method stub
				clientesPf.add(cliente);
				System.out.println("adicionou");
				atualizarClientePf(cliente);
			}

		});
	}
	
	private void atualizarClientes() {
		consultarClientesPanel.setClientes(app.getClientes());
		adicionarClientePF.setClientes(app.getClientes());
	}
	
	private void atualizarClientePj(PessoaJuridica cliente) {
		try (BufferedWriter writer = new BufferedWriter(new FileWriter(arquivoClientes, true))){
			writer.write(cliente.getCnpj() + ";" + cliente.getNomeFantasia() 
			+ ";" + cliente.getLogradouro() + ";" + cliente.getNumero() 
			+ ";" + cliente.getComplemento() + ";" + cliente.getCep() 
			+ ";" + cliente.getTelefone() + ";" + cliente.getEmail());
			writer.newLine();
			writer.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		adicionarClientePF.setClientes(app.getClientes());
		adicionarClientePJ.setClientes(app.getClientes());
		consultarClientesPanel.setClientes(app.getClientes());
	}

	private void atualizarClientePf(PessoaFisica cliente) {
		try (BufferedWriter writer = new BufferedWriter(new FileWriter(arquivoClientes, true))){
			writer.write(cliente.getCpf() + ";" + cliente.getNome() 
			+ ";" + cliente.getLogradouro() + ";" + cliente.getNumero() 
			+ ";" + cliente.getComplemento() + ";" + cliente.getCep() 
			+ ";" + cliente.getTelefone());
			writer.newLine();
			writer.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		adicionarClientePF.setClientes(app.getClientes());
		adicionarClientePJ.setClientes(app.getClientes());
		consultarClientesPanel.setClientes(app.getClientes());
	}
}
