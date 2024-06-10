package view;

import javax.swing.JPanel;
import javax.swing.JTextField;

import actions.CriarClienteAction;
import actions.CriarClientePFAction;
import model.Cliente;
import model.PessoaFisica;
import model.PessoaJuridica;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Panel;
import java.awt.Color;
import java.awt.Label;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;

public class AdicionarClientePFPanel extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTextField nomeTxt;
	private JTextField cpfTxt;
	private JTextField enderecoTxt;
	private JTextField numeroTxt;
	private JTextField complementoTxt;
	private JTextField cepTxt;
	private JTextField telefoneTxt;
	private JLabel lblNome;
	private JLabel lblCpf;
	private JLabel lblEndereco;
	private JLabel lblNumero;
	private JLabel lblComplemento;
	private JLabel lblCep;
	private JLabel lblTelefone;
	private CriarClienteAction listener;
	private List<Cliente> clientes;


	/**
	 * Create the panel.
	 */
	public AdicionarClientePFPanel() {
		setLayout(null);
		
		JPanel cadastroClientePF = new JPanel();
		cadastroClientePF.setBounds(0, 0, 616, 363);
		cadastroClientePF.setLayout(null);
		add(cadastroClientePF);
		
		nomeTxt = new JTextField();
		nomeTxt.setColumns(10);
		nomeTxt.setBounds(10, 95, 326, 30);
		cadastroClientePF.add(nomeTxt);
		
		cpfTxt = new JTextField();
		cpfTxt.setColumns(10);
		cpfTxt.setBounds(363, 95, 246, 30);
		cadastroClientePF.add(cpfTxt);
		
		enderecoTxt = new JTextField();
		enderecoTxt.setColumns(10);
		enderecoTxt.setBounds(10, 155, 406, 30);
		cadastroClientePF.add(enderecoTxt);
		
		numeroTxt = new JTextField();
		numeroTxt.setColumns(10);
		numeroTxt.setBounds(442, 155, 167, 30);
		cadastroClientePF.add(numeroTxt);
		
		complementoTxt = new JTextField();
		complementoTxt.setColumns(10);
		complementoTxt.setBounds(10, 213, 159, 30);
		cadastroClientePF.add(complementoTxt);
		
		cepTxt = new JTextField();
		cepTxt.setColumns(10);
		cepTxt.setBounds(197, 213, 219, 30);
		cadastroClientePF.add(cepTxt);
		
		telefoneTxt = new JTextField();
		telefoneTxt.setColumns(10);
		telefoneTxt.setBounds(442, 213, 167, 30);
		cadastroClientePF.add(telefoneTxt);
		
		lblNome = new JLabel("Nome Completo:");
		lblNome.setBounds(10, 78, 109, 14);
		cadastroClientePF.add(lblNome);
		
		lblCpf = new JLabel("CPF:");
		lblCpf.setBounds(363, 78, 46, 14);
		cadastroClientePF.add(lblCpf);
		
		lblEndereco = new JLabel("Endereço:");
		lblEndereco.setBounds(10, 136, 136, 14);
		cadastroClientePF.add(lblEndereco);
		
		lblNumero = new JLabel("N°:");
		lblNumero.setBounds(442, 136, 46, 14);
		cadastroClientePF.add(lblNumero);
		
		lblComplemento = new JLabel("Complemento:");
		lblComplemento.setBounds(10, 196, 109, 14);
		cadastroClientePF.add(lblComplemento);
		
		lblCep = new JLabel("CEP:");
		lblCep.setBounds(197, 196, 46, 14);
		cadastroClientePF.add(lblCep);
		
		lblTelefone = new JLabel("Telefone:");
		lblTelefone.setBounds(442, 196, 72, 14);
		cadastroClientePF.add(lblTelefone);
		
		Panel panel_1_2 = new Panel();
		panel_1_2.setBackground(new Color(234, 255, 215));
		panel_1_2.setBounds(182, 10, 234, 33);
		cadastroClientePF.add(panel_1_2);
		
		Label label_2 = new Label("Cadastro de Pessoa Física");
		label_2.setFont(new Font("Dialog", Font.PLAIN, 12));
		panel_1_2.add(label_2);
		
		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(!validarFormulario()) return;
				if(isCpfExistente(Long.parseLong(cpfTxt.getText()))) {
					return;
				}
				PessoaFisica pf = new PessoaFisica();
				pf.setNome(nomeTxt.getText());
				pf.setCpf(Long.parseLong(cpfTxt.getText()));
				pf.setLogradouro(enderecoTxt.getText());
				pf.setNumero(Integer.parseInt(numeroTxt.getText()));
				if(complementoTxt.getText().trim().isEmpty()) {
					pf.setComplemento("Sem complemento");
				}else {
					pf.setComplemento(complementoTxt.getText());
				}
				pf.setCep(Integer.parseInt(cepTxt.getText()));
				pf.setTelefone(Long.parseLong(telefoneTxt.getText()));
				
				listener.actionPerformed(pf);
				
				limparFormulario();
			}
		});
		btnCadastrar.setBounds(463, 283, 146, 30);
		cadastroClientePF.add(btnCadastrar);

	}
	
	public void addActionsListener(CriarClienteAction listener) {
		this.listener = listener;
	}
	
	public boolean validarFormulario() {
		if (this.nomeTxt.getText().equals("")) {
			this.lblNome.setForeground(Color.RED);
			return false;
		}
		if (this.cpfTxt.getText().equals("")) {
			this.lblCpf.setForeground(Color.RED);
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
		
		return true;
	}
	
	
    public void limparFormulario() {
        cpfTxt.setText("");
        nomeTxt.setText("");
        enderecoTxt.setText("");
        numeroTxt.setText("");
        cepTxt.setText("");
        complementoTxt.setText("");
        telefoneTxt.setText("");
    }
    
    private boolean isCpfExistente(long cpf) {
    	for (Cliente cliente : clientes) {
    		if (cliente.getDocumento() == cpf) {
    			JOptionPane.showMessageDialog(this, "CPF já cadastrado.", "Erro", JOptionPane.WARNING_MESSAGE);
                return true;
    		}
    	}
    	
        return false;
    }
    
    public void setClientes(List<Cliente> clientes) {
    	this.clientes = clientes;
    }
}
