package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import actions.CriarClienteAction;

import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Panel;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.awt.Color;
import java.awt.Label;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JComboBox;
import model.Cliente;
import model.PessoaFisica;
import model.PessoaJuridica;
import model.TipoProduto;

public class TelaCliente extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	
	private List<PessoaJuridica> clientesPj = new ArrayList<PessoaJuridica>();;
	private List<PessoaFisica> clientesPf = new ArrayList<PessoaFisica>();;
	

	private ConsultarClientesPanel consultarClientesPanel;
	private AdicionarClientePFPanel adicionarClientePF;
	private AdicionarClientePJPanel adicionarClientePJ;
	private File arquivoClientes = new File("clientes.txt");

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
		 clientesPj = new ArrayList<PessoaJuridica>();
		 clientesPf = new ArrayList<PessoaFisica>();
		 
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
		inicializarListas();
		
		

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
		
	}
	
	private void inicializarListas() {
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
					
					clientesPf.add(pf);

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
					
					clientesPj.add(pj);
					
				}
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	

}
