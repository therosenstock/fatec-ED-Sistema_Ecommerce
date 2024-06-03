package view;

import javax.swing.JPanel;
import java.awt.Panel;
import java.awt.Color;
import java.awt.Label;
import java.awt.Font;
import javax.swing.JTextArea;
import javax.swing.JLabel;
import javax.swing.JTextField;

import actions.CriarTipoProdutoAction;
import model.TipoProduto;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AdicionarTipoProdutoPanel extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTextField nomeTxt;
	private CriarTipoProdutoAction listener;
	private JLabel nomeLabel;
	private JTextArea descricaoTxt;

	/**
	 * Create the panel.
	 */
	public AdicionarTipoProdutoPanel() {
		this.setLayout(null);
		
		Panel titlePanel = new Panel();
		titlePanel.setBackground(new Color(234, 255, 215));
		titlePanel.setBounds(196, 10, 194, 33);
		this.add(titlePanel);
		
		Label title = new Label("Cadastro de Tipos de Produto");
		title.setFont(new Font("Dialog", Font.PLAIN, 12));
		titlePanel.add(title);
		
		descricaoTxt = new JTextArea();
		descricaoTxt.setBounds(10, 141, 599, 81);
		this.add(descricaoTxt);
		
		JLabel descricaoLabel = new JLabel("Descrição:");
		descricaoLabel.setBounds(10, 124, 108, 14);
		this.add(descricaoLabel);
		
		nomeLabel = new JLabel("Nome:");
		nomeLabel.setBounds(10, 66, 46, 14);
		this.add(nomeLabel);
		
		nomeTxt = new JTextField();
		nomeTxt.setColumns(10);
		nomeTxt.setBounds(10, 83, 599, 30);
		this.add(nomeTxt);
		
		JButton adicionarBtn = new JButton("Adicionar");
		adicionarBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (!validarFormulario()) return;
				
				TipoProduto tipo = new TipoProduto();
				tipo.setId(System.currentTimeMillis());
				tipo.setNome(nomeTxt.getText());
				tipo.setDescricao(descricaoTxt.getText());
				limparFormulario();
				listener.actionPerformed(tipo);
			}
		});
		adicionarBtn.setBounds(520, 250, 89, 23);
		this.add(adicionarBtn);
	}
	
	private boolean validarFormulario() {
		if (this.nomeTxt.getText().equals("")) {
			this.nomeLabel.setForeground(Color.RED);
			return false;
		}
		
		this.nomeLabel.setForeground(Color.BLACK);
		return true;
	}
	
	private void limparFormulario() {
		this.nomeTxt.setText("");
		this.descricaoTxt.setText("");
	}
	
	
	public void addActionsListener(CriarTipoProdutoAction listener) {
		this.listener = listener;
	}
}
