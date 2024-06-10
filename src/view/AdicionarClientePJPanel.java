package view;

import javax.swing.JPanel;
import javax.swing.JTextField;

import actions.CriarClienteAction;
import actions.CriarTipoProdutoAction;
import model.Cliente;
import model.PessoaFisica;
import model.PessoaJuridica;
import model.Produto;
import model.TipoProduto;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.awt.Color;
import java.awt.Label;
import java.awt.Font;
import javax.swing.JButton;

public class AdicionarClientePJPanel extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTextField nomeFantasiaTxt;
	private JTextField cnpjTxt;
	private JTextField enderecoTxt;
	private JTextField numeroTxt;
	private JTextField complementoTxt;
	private JTextField cepTxt;
	private JTextField telefoneTxt;
	private JTextField emailTxt;
	private JLabel lblNomeFantasia;
	private JLabel lblCnpj;
	private JLabel lblEndereco;
	private JLabel lblNumero;
	private JLabel lblComplemento;
	private JLabel lblCep;
	private JLabel lblTelefone;
	private JLabel lblEmail;
	private CriarClienteAction listener;
	private List<Cliente> clientes;

	/**
	 * Create the panel.
	 */
	public AdicionarClientePJPanel() {
		setLayout(null);
		
		JPanel cadastroClientePJ = new JPanel();
		cadastroClientePJ.setLayout(null);
		cadastroClientePJ.setBounds(0, 0, 619, 413);
		add(cadastroClientePJ);
		
		nomeFantasiaTxt = new JTextField();
		nomeFantasiaTxt.setColumns(10);
		nomeFantasiaTxt.setBounds(10, 95, 326, 30);
		cadastroClientePJ.add(nomeFantasiaTxt);
		
		cnpjTxt = new JTextField();
		cnpjTxt.setColumns(10);
		cnpjTxt.setBounds(363, 95, 246, 30);
		cadastroClientePJ.add(cnpjTxt);
		
		enderecoTxt = new JTextField();
		enderecoTxt.setColumns(10);
		enderecoTxt.setBounds(10, 155, 406, 30);
		cadastroClientePJ.add(enderecoTxt);
		
		numeroTxt = new JTextField();
		numeroTxt.setColumns(10);
		numeroTxt.setBounds(442, 155, 167, 30);
		cadastroClientePJ.add(numeroTxt);
		
		complementoTxt = new JTextField();
		complementoTxt.setColumns(10);
		complementoTxt.setBounds(10, 213, 159, 30);
		cadastroClientePJ.add(complementoTxt);
		
		cepTxt = new JTextField();
		cepTxt.setColumns(10);
		cepTxt.setBounds(197, 213, 219, 30);
		cadastroClientePJ.add(cepTxt);
		
		telefoneTxt = new JTextField();
		telefoneTxt.setColumns(10);
		telefoneTxt.setBounds(442, 213, 167, 30);
		cadastroClientePJ.add(telefoneTxt);
		
		lblNomeFantasia = new JLabel("Nome Fantasia:");
		lblNomeFantasia.setBounds(10, 78, 109, 14);
		cadastroClientePJ.add(lblNomeFantasia);
		
		lblCnpj = new JLabel("CNPJ:");
		lblCnpj.setBounds(363, 78, 46, 14);
		cadastroClientePJ.add(lblCnpj);
		lblEndereco = new JLabel("Endereço:");
		lblEndereco.setBounds(10, 136, 136, 14);
		cadastroClientePJ.add(lblEndereco);
		
		lblNumero = new JLabel("N°:");
		lblNumero.setBounds(442, 136, 46, 14);
		cadastroClientePJ.add(lblNumero);
		
		lblComplemento = new JLabel("Complemento:");
		lblComplemento.setBounds(10, 196, 109, 14);
		cadastroClientePJ.add(lblComplemento);
		
		lblCep = new JLabel("CEP:");
		lblCep.setBounds(197, 196, 46, 14);
		cadastroClientePJ.add(lblCep);
		
		lblTelefone = new JLabel("Telefone:");
		lblTelefone.setBounds(442, 196, 86, 14);
		cadastroClientePJ.add(lblTelefone);
				
		lblEmail = new JLabel("E-mail:");
		lblEmail.setBounds(10, 254, 46, 14);
		cadastroClientePJ.add(lblEmail);
		
		Panel panel_1_2_1 = new Panel();
		panel_1_2_1.setBackground(new Color(234, 255, 215));
		panel_1_2_1.setBounds(182, 10, 234, 33);
		cadastroClientePJ.add(panel_1_2_1);
		
		Label label_2_1 = new Label("Cadastro de Pessoa Jurídica");
		label_2_1.setFont(new Font("Dialog", Font.PLAIN, 12));
		panel_1_2_1.add(label_2_1);
		
		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(!validarFormulario()) return;
				if(isCnpjExistente(Long.parseLong(cnpjTxt.getText()))) {
					return;
				}
				PessoaJuridica pj = new PessoaJuridica();
				pj.setCnpj(Long.parseLong(cnpjTxt.getText()));
				pj.setNomeFantasia(nomeFantasiaTxt.getText());
				pj.setLogradouro(enderecoTxt.getText());
				pj.setNumero(Integer.parseInt(numeroTxt.getText()));
				pj.setCep(Integer.parseInt(cepTxt.getText()));
		
				if(complementoTxt.getText().trim().isEmpty()) {
					pj.setComplemento("Sem complemento");
					System.out.println("sem");
				}else {
					pj.setComplemento(complementoTxt.getText());
					System.out.println("com");
				}
				pj.setTelefone(Long.parseLong(telefoneTxt.getText()));
				pj.setEmail(emailTxt.getText());
				
				
				listener.actionPerformed(pj);
				limparFormulario();
				
			}
		});
		btnCadastrar.setBounds(461, 315, 148, 30);
		cadastroClientePJ.add(btnCadastrar);
		
		emailTxt = new JTextField();
		emailTxt.setBounds(10, 273, 599, 30);
		cadastroClientePJ.add(emailTxt);
		emailTxt.setColumns(10);
		
	}
	
	public boolean validarFormulario() {
		if (this.nomeFantasiaTxt.getText().equals("")) {
			this.lblNomeFantasia.setForeground(Color.RED);
			return false;
		}
		if (this.cnpjTxt.getText().equals("")) {
			this.lblCnpj.setForeground(Color.RED);
			return false;
		}
		if (this.enderecoTxt.getText().equals("")) {
			this.lblEndereco.setForeground(Color.RED);
			return false;
		}
		if (this.numeroTxt.getText().equals("")) {
			this.lblNumero.setForeground(Color.RED);
			return false;
		}
		
		if (this.cepTxt.getText().equals("")) {
			this.lblCep.setForeground(Color.RED);
			return false;
		}
		if (this.telefoneTxt.getText().equals("")) {
			this.lblTelefone.setForeground(Color.RED);
			return false;
		}
		if (this.emailTxt.getText().equals("")) {
			this.lblEmail.setForeground(Color.RED);
			return false;
		}
		
		return true;
	}
	
	public void addActionsListener(CriarClienteAction listener) {
		this.listener = listener;
	}
	
    public void limparFormulario() {
        cnpjTxt.setText("");
        nomeFantasiaTxt.setText("");
        enderecoTxt.setText("");
        numeroTxt.setText("");
        cepTxt.setText("");
        complementoTxt.setText("");
        telefoneTxt.setText("");
        emailTxt.setText("");
    }
    
    private boolean isCnpjExistente(long cnpj) {
    	
    	for (Cliente cliente : clientes) {
    		if (cliente.getDocumento() == cnpj) {
    			JOptionPane.showMessageDialog(this, "CNPJ já cadastrado.", "Erro", JOptionPane.WARNING_MESSAGE);
                return true;
    		}
    	}

        return false;
    }
    
    public void setClientes(List<Cliente> clientes) {
    	this.clientes = clientes;
    }
}
