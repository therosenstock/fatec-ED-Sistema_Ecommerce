package view;

import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Panel;
import java.awt.Color;
import java.awt.Label;
import java.awt.Font;
import javax.swing.JButton;

public class AdicionarClientePJPanel extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTextField nomeFantasiaTxt;
	private JTextField cnpjTxt;
	private JTextField enderecoTxt;
	private JTextField numeroTx6t;
	private JTextField complementoTxt;
	private JTextField cepTxt;
	private JTextField telefoneTxt;
	private JTextField emailTxt;

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
		
		numeroTx6t = new JTextField();
		numeroTx6t.setColumns(10);
		numeroTx6t.setBounds(442, 155, 167, 30);
		cadastroClientePJ.add(numeroTx6t);
		
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
		
		JLabel lblNomeFantasial = new JLabel("Nome Fantasia:");
		lblNomeFantasial.setBounds(10, 78, 109, 14);
		cadastroClientePJ.add(lblNomeFantasial);
		
		JLabel lblNewLabel_1_1 = new JLabel("CNPJ:");
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
		
		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.setBounds(520, 315, 89, 30);
		cadastroClientePJ.add(btnCadastrar);
		
		emailTxt = new JTextField();
		emailTxt.setBounds(10, 273, 599, 30);
		cadastroClientePJ.add(emailTxt);
		emailTxt.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("E-mail:");
		lblNewLabel.setBounds(10, 254, 46, 14);
		cadastroClientePJ.add(lblNewLabel);

	}
}
