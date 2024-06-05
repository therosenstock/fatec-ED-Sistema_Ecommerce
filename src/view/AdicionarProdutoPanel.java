package view;

import javax.swing.JPanel;
import java.awt.Panel;
import java.util.List;
import java.awt.Color;
import java.awt.Label;
import java.awt.Font;
import javax.swing.JTextField;

import actions.CriarProdutoAction;
import model.Produto;
import model.TipoProduto;

import javax.swing.JTextArea;
import javax.swing.JLabel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AdicionarProdutoPanel extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTextField nomeTxt;
	private JTextArea descricaoTxt;
	private JTextField valorTxt;
	private JTextField quantidadeTxt;
	private List<TipoProduto> tiposProduto;
	private DefaultComboBoxModel<TipoProduto> cbxModelo;
	private JComboBox<TipoProduto> tipoCbx;
	private CriarProdutoAction listener;
	private JLabel descricaoLabel;
	private JLabel valorLabel;
	private JLabel quantidadeLabel;
	private JLabel nomeLabel;
	private JLabel tipoLabel;

	/**
	 * Create the panel.
	 */
	public AdicionarProdutoPanel() {
		this.setLayout(null);
		
		cbxModelo = new DefaultComboBoxModel<TipoProduto>();
		
		Panel tituloPanel = new Panel();
		tituloPanel.setBackground(new Color(234, 255, 215));
		tituloPanel.setBounds(188, 10, 194, 33);

		Label titulo = new Label("Cadastro de Produto");
		titulo.setFont(new Font("Dialog", Font.PLAIN, 12));
		tituloPanel.add(titulo);
		this.add(tituloPanel);
		
		nomeTxt = new JTextField();
		nomeTxt.setColumns(10);
		nomeTxt.setBounds(10, 82, 599, 30);
		this.add(nomeTxt);
		
		valorTxt = new JTextField();
		valorTxt.setColumns(10);
		valorTxt.setBounds(10, 140, 261, 30);
		this.add(valorTxt);
		
		quantidadeTxt = new JTextField();
		quantidadeTxt.setColumns(10);
		quantidadeTxt.setBounds(333, 140, 276, 30);
		this.add(quantidadeTxt);
		
		descricaoTxt = new JTextArea();
		descricaoTxt.setBounds(10, 198, 599, 47);
		this.add(descricaoTxt);
		
		descricaoLabel = new JLabel("Descrição:");
		descricaoLabel.setBounds(10, 181, 108, 14);
		this.add(descricaoLabel);
		
		valorLabel = new JLabel("Valor:");
		valorLabel.setBounds(10, 125, 46, 14);
		this.add(valorLabel);
		
		quantidadeLabel = new JLabel("Quantidade:");
		quantidadeLabel.setBounds(333, 125, 113, 14);
		this.add(quantidadeLabel);
		
		nomeLabel = new JLabel("Nome:");
		nomeLabel.setBounds(10, 65, 46, 14);
		this.add(nomeLabel);
		
		JButton adicionarBtn = new JButton("Adicionar");
		adicionarBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (!validarFormulario()) return;
				
				Produto produto = new Produto();
				produto.setId(System.currentTimeMillis());
				produto.setNome(nomeTxt.getText());
				produto.setDescricao(descricaoTxt.getText());
				produto.setQuantidade(Integer.parseInt(quantidadeTxt.getText()));
				produto.setValor(Double.parseDouble(valorTxt.getText()));
				TipoProduto tipo = (TipoProduto) tipoCbx.getSelectedItem();
				produto.setTipo(tipo);
				limparFormulario();
				listener.actionPerformed(produto);
			}
		});
		adicionarBtn.setBounds(520, 322, 89, 23);
		this.add(adicionarBtn);

		tipoCbx = new JComboBox();
		tipoCbx.setModel(cbxModelo);
		tipoCbx.setBounds(10, 274, 599, 30);
		this.add(tipoCbx);
		
		tipoLabel = new JLabel("Tipo do Produto:");
		tipoLabel.setBounds(10, 256, 108, 14);
		add(tipoLabel);
	}
	
	public void setTiposProduto(List<TipoProduto> tiposProduto) {
		this.tiposProduto = tiposProduto;
		cbxModelo.removeAllElements();
		for (var tipo : tiposProduto) {
			System.out.println(tipo);
			cbxModelo.addElement(tipo);
		}
	}
	
	private boolean validarFormulario() {
		if (nomeTxt.getText().equals("")) {
			this.nomeLabel.setForeground(Color.RED);
			return false;
		}
		if (descricaoTxt.getText().equals("")) {
			this.descricaoTxt.setForeground(Color.RED);
			return false;
		}
		if (valorTxt.getText().equals("")) {
			this.valorLabel.setForeground(Color.RED);
			return false;
		}
		if (quantidadeTxt.getText().equals("")) {
			this.quantidadeLabel.setForeground(Color.RED);
			return false;
		}
		if (tipoCbx.getSelectedIndex() == -1) {
			this.tipoLabel.setForeground(Color.RED);
			return false;
		}
		return true;
	}
	
	private void limparFormulario() {
		nomeTxt.setText("");
		descricaoTxt.setText("");
		valorTxt.setText("");
		quantidadeTxt.setText("");
		tipoCbx.setSelectedIndex(-1);
	}
	
	public void addActionListener(CriarProdutoAction listener) {
		this.listener = listener;
	}
}


