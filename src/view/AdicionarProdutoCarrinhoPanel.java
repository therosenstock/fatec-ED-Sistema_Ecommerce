package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Label;
import java.awt.Panel;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import actions.AdicionarCarrinhoProdutoAction;

import javax.swing.JOptionPane;

import model.Carrinho;
import model.CarrinhoProduto;
import model.Produto;
import model.TipoProduto;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AdicionarProdutoCarrinhoPanel extends JPanel {

	private static final long serialVersionUID = 1L;
	private List<Produto> produtos;
	private HashMap<Long, List<Produto>> produtoHash = new HashMap<Long, List<Produto>>();
	private DefaultTableModel produtoTableModel = new DefaultTableModel(new Object[]{"ID", "Nome", "Tipo"}, 0);
	private Produto produtoSelecionado;
	private Carrinho carrinho;
	private AdicionarCarrinhoProdutoAction listener;
	private List<TipoProduto> tipos;
	private DefaultComboBoxModel<TipoProduto> tiposComboBoxModel = new DefaultComboBoxModel<TipoProduto>();
	private JTextField produtoTxt;

	/**
	 * Create the panel.
	 */
	public AdicionarProdutoCarrinhoPanel() {
		this.carrinho = carrinho;
		setLayout(null);
		
		Panel tituloPanel = new Panel();
		tituloPanel.setBackground(new Color(234, 255, 215));
		tituloPanel.setBounds(208, 10, 194, 33);
		add(tituloPanel);
		
		Label titulo = new Label("Catálogo de Produtos");
		titulo.setFont(new Font("Dialog", Font.PLAIN, 12));
		tituloPanel.add(titulo);
		
		JLabel produtoLabel = new JLabel("Produto");
		produtoLabel.setBounds(35, 67, 142, 14);
		add(produtoLabel);
		
		produtoTxt = new JTextField();
		produtoTxt.setToolTipText("Digite o nome do produto");
		produtoTxt.setColumns(10);
		produtoTxt.setBounds(35, 81, 162, 30);
		add(produtoTxt);
		
		JButton buscarBtn = new JButton("Buscar");
		buscarBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				buscarProdutos();
			}
		});
		buscarBtn.setBounds(487, 84, 89, 23);
		add(buscarBtn);
		
		JComboBox tiposCbx = new JComboBox<TipoProduto>(tiposComboBoxModel);
		tiposCbx.setBounds(215, 81, 226, 30);
		add(tiposCbx);
		
		JLabel tiposLabel = new JLabel("Categoria");
		tiposLabel.setBounds(215, 67, 105, 14);
		add(tiposLabel);
		
		JTable produtosTable = new JTable(produtoTableModel);
		JScrollPane scrollCatalogo = new JScrollPane(produtosTable);
		//table_produtos.setBounds(35, 161, 541, 175);
		scrollCatalogo.setBounds(35, 136, 541, 200);
		add(scrollCatalogo);
		
		JButton adicionarBtn = new JButton("Adicionar");
		adicionarBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int linha = produtosTable.getSelectedRow();
				if (linha == -1) return;
				long id = Long.parseLong(produtoTableModel.getValueAt(linha, 0).toString());
				Produto produto = produtos.stream().filter(p -> p.getId() == id).findFirst().orElse(null);
				System.out.println(produto);
				if (produto == null) return;
				produtoSelecionado = produto;
				showDialog();
				
			}
		});
		adicionarBtn.setBounds(470, 348, 106, 25);
		add(adicionarBtn);
	}
	
	public void setProdutos(List<Produto> produtos) {
		this.produtos = produtos;
		
		for (Produto produto : produtos) {
			produtoTableModel.addRow(new Object[] { produto.getId(), produto.getNome(), produto.getTipo().getNome() });
			
			long chave = produto.getTipo().getId();
			
			if (!produtoHash.containsKey(chave)) {
				produtoHash.put(chave, new ArrayList<Produto>());
			}
			
			produtoHash.get(chave).add(produto);
		}
	}
	
	public void setTipos(List<TipoProduto> tipos) {
		this.tipos = tipos;
		tiposComboBoxModel.addElement(null);
		
		for (TipoProduto tipo : tipos) {
			tiposComboBoxModel.addElement(tipo);
		}
	}
	
	private void buscarProdutos() {
		produtoTableModel.setRowCount(0);
		
		TipoProduto tipo = (TipoProduto) tiposComboBoxModel.getSelectedItem();
		
		List<Produto> lista;
		
		if (tipo == null) lista = produtos;
		else lista = produtoHash.get(tipo.getId());
		
		for (Produto produto : lista) {
			if (produto.getNome().contains(produtoTxt.getText())) {
				produtoTableModel.addRow(new Object[] { produto.getId(), produto.getNome(), produto.getTipo().getNome() });
			}
		}
	}
	
    private void showDialog() {
    	JOptionPane optionPane = new JOptionPane("Digite a quantidade");

		optionPane.setLayout(new BorderLayout());


        JTextField quantidadeTxt = new JTextField(20);
        optionPane.add(quantidadeTxt, BorderLayout.CENTER);

        JButton okButton = new JButton("OK");
 
        optionPane.add(okButton, BorderLayout.SOUTH);
        
		JDialog dialog = optionPane.createDialog("Digite a quantidade");
        
        okButton.addActionListener(e -> {
            int quantidade = Integer.parseInt(quantidadeTxt.getText());
            JOptionPane.showMessageDialog(dialog, "Produto adicionado");
            CarrinhoProduto item = new CarrinhoProduto();
            item.setProduto(produtoSelecionado);
            item.setQuantidade(quantidade);
            listener.actionPerformed(item);
            dialog.dispose();
        });


        dialog.setVisible(true);
    }
    
    public void addActionListener(AdicionarCarrinhoProdutoAction listener) {
    	this.listener = listener;
    }
}
