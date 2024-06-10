package view;

import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Panel;
import java.awt.Color;
import java.awt.Label;
import java.awt.Font;
import javax.swing.JButton;

public class AdicionarClientePFPanel extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTextField nomeTxt;
	private JTextField cpfTxt;
	private JTextField enderecoTxt;
	private JTextField numeroTxt;
	private JTextField complementoTxt;
	private JTextField cepTxt;
	private JTextField telefoneTxt;

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
		
		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.setBounds(520, 283, 89, 30);
		cadastroClientePF.add(btnCadastrar);

	}

}
