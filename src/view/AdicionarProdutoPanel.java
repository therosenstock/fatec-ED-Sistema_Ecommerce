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
		descricaoTxt.setBounds(10, 198, 599, 81);
		this.add(descricaoTxt);
		
		JLabel descricaoLabel = new JLabel("Descrição:");
		descricaoLabel.setBounds(10, 181, 108, 14);
		this.add(descricaoLabel);
		
		JLabel valorLabel = new JLabel("Valor:");
		valorLabel.setBounds(10, 125, 46, 14);
		this.add(valorLabel);
		
		JLabel quantidadeLabel = new JLabel("Quantidade:");
		quantidadeLabel.setBounds(333, 125, 113, 14);
		this.add(quantidadeLabel);
		
		JLabel nomeLabel = new JLabel("Nome:");
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
		adicionarBtn.setBounds(520, 317, 89, 23);
		this.add(adicionarBtn);

		tipoCbx = new JComboBox();
		tipoCbx.setModel(cbxModelo);
		tipoCbx.setBounds(10, 290, 143, 22);
		this.add(tipoCbx);
	}
	
	public void setTiposProduto(List<TipoProduto> tiposProduto) {
		this.tiposProduto = tiposProduto;
		cbxModelo.removeAllElements();
		for (var tipo : tiposProduto) {
			cbxModelo.addElement(tipo);
		}
	}
	
	private boolean validarFormulario() {
		if (nomeTxt.getText().equals("")) return false;
		if (descricaoTxt.getText().equals("")) return false;
		if (valorTxt.getText().equals("")) return false;
		if (quantidadeTxt.getText().equals("")) return false;
		if (tipoCbx.getSelectedIndex() == -1) return false;
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
