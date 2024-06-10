package view;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import java.awt.Component;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.awt.Color;
import java.awt.Label;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import actions.RemoverProdutoAction;
import model.Produto;
import model.TipoProduto;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JComboBox;

public class ConsultarProdutoPanel extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTextField nomeTxt;
	private List<Produto> produtos;
	private List<TipoProduto> tiposProduto;
	private RemoverProdutoAction listener;
	private DefaultTableModel modeloProdutos;
	private JTable tabelaProdutos;
	private DefaultComboBoxModel<TipoProduto> cbxModelo;
	private JComboBox<TipoProduto> tipoCbx;

	/**
	 * Create the panel.
	 */
	public ConsultarProdutoPanel() {
		setLayout(null);
		
		JPanel consultaProdutos = new JPanel();
		consultaProdutos.setLayout(null);
		consultaProdutos.setBounds(0, 0, 645, 413);
		add(consultaProdutos);
		
		modeloProdutos = new DefaultTableModel(new Object[]{"ID", "Nome", "Descrição", "Quantidade", "Valor", "Tipo"}, 0);
		tabelaProdutos = new JTable(modeloProdutos);
		JScrollPane scrollProduto = new JScrollPane(tabelaProdutos);
		scrollProduto.setBounds(28, 123, 557, 231);
		consultaProdutos.add(scrollProduto);
		
		Panel tituloPanel = new Panel();
		tituloPanel.setBackground(new Color(234, 255, 215));
		tituloPanel.setBounds(195, 10, 194, 33);
		consultaProdutos.add(tituloPanel);
		
		Label titulo = new Label("Consulta de Produtos");
		titulo.setFont(new Font("Dialog", Font.PLAIN, 12));
		tituloPanel.add(titulo);
		
		nomeTxt = new JTextField();
		nomeTxt.setColumns(10);
		nomeTxt.setBounds(28, 71, 202, 30);
		consultaProdutos.add(nomeTxt);
		
		JButton btnBuscarProduto = new JButton("Buscar");
		btnBuscarProduto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				modeloProdutos.setRowCount(0);
				for (Produto produto : produtos) {
					if (produto.getNome().contains(nomeTxt.getText())) {
						modeloProdutos.addRow(new Object[]{produto.getId(), produto.getNome(), produto.getDescricao(), produto.getQuantidade(), produto.getValor(), produto.getTipo().getNome()});
					}
				}
			}
		});
		btnBuscarProduto.setBounds(232, 75, 90, 23);
		consultaProdutos.add(btnBuscarProduto);
		
		JLabel lblNewLabel_5 = new JLabel("Nome:");
		lblNewLabel_5.setBounds(28, 53, 46, 14);
		consultaProdutos.add(lblNewLabel_5);
		
		cbxModelo = new DefaultComboBoxModel<TipoProduto>();
		
		JLabel lblNewLabel_6 = new JLabel("Escolha o Tipo:");
		lblNewLabel_6.setBounds(332, 53, 78, 14);
		consultaProdutos.add(lblNewLabel_6);
		
		JButton btnFiltrarProduto = new JButton("Filtrar");
		btnFiltrarProduto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				modeloProdutos.setRowCount(0);
				String texto = tipoCbx.getSelectedItem().toString();
				System.out.println(texto+ "texto da cbx");
				for (Produto produto : produtos) {
					if (produto.getTipo().getNome().contains(texto)) {
						modeloProdutos.addRow(new Object[]{produto.getId(), produto.getNome(), produto.getDescricao(), produto.getQuantidade(), produto.getValor(), produto.getTipo().getNome()});
					}
				}
			}
		});
		btnFiltrarProduto.setBounds(507, 75, 78, 23);
		consultaProdutos.add(btnFiltrarProduto);
		
		JButton btnRemoverProduto = new JButton("Remover");
		btnRemoverProduto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int linha = tabelaProdutos.getSelectedRow();
				long id = Long.parseLong(modeloProdutos.getValueAt(linha, 0).toString());
				modeloProdutos.removeRow(linha);
				for (Produto prod : produtos) {
					if (prod.getId() == id) {
						listener.actionPerformed(prod);
						break;
					}
				}
			}
		});
		btnRemoverProduto.setBounds(494, 366, 89, 23);
		consultaProdutos.add(btnRemoverProduto);
		
		tipoCbx = new JComboBox();
		tipoCbx.setBounds(332, 71, 163, 30);
		consultaProdutos.add(tipoCbx);
		tipoCbx.setModel(cbxModelo);
		
		inicializarTabela();

	}
	
	public void setProduto(List<Produto> produto) {
		this.produtos = produto;
	}
	
	public void addActionsListener(RemoverProdutoAction listener) {
		this.listener = listener;
	}
	
	public void inicializarTabela() {
		modeloProdutos.setRowCount(0);
		System.out.println("inicializei produto" + produtos);
		if(produtos != null) {
			for (Produto produto : produtos) {
				System.out.println(produto.getNome());
				modeloProdutos.addRow(new Object[]{produto.getId(), produto.getNome(), produto.getDescricao(), produto.getQuantidade(), produto.getValor(), produto.getTipo().getNome()});
			}
		}

	}
	
	public void setTiposProduto(List<TipoProduto> tiposProduto) {
		this.tiposProduto = tiposProduto;
		cbxModelo.removeAllElements();
		for (var tipo : tiposProduto) {
			cbxModelo.addElement(tipo);
		}
	}

}
