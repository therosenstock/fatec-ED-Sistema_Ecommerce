package view;

import javax.swing.JPanel;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Color;
import java.awt.Label;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

import actions.EsvaziarCarrinhoAction;
import actions.IrPagamentoAction;
import actions.RemoverCarrinhoProdutoAction;
import model.Carrinho;
import model.CarrinhoProduto;
import model.Produto;

import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class CarrinhoPanel extends JPanel {

	private static final long serialVersionUID = 1L;
	private DefaultTableModel carrinhoTableModel = new DefaultTableModel(new Object[]{"ID", "Produto", "Valor", "Quantidade"}, 0);
	private Carrinho carrinho;
	private JLabel totalLabel;
	private RemoverCarrinhoProdutoAction removeListener;
	private EsvaziarCarrinhoAction esvaziarListener;
	private IrPagamentoAction pagamentoListener;

	/**
	 * Create the panel.
	 */
	public CarrinhoPanel() {
		setLayout(null);
		
		Panel panel_1 = new Panel();
		panel_1.setBackground(new Color(234, 255, 215));
		panel_1.setBounds(198, 10, 194, 33);
		add(panel_1);
		
		Label label = new Label("Itens do Carrinho de Compras:");
		label.setFont(new Font("Dialog", Font.PLAIN, 12));
		panel_1.add(label);
		
		JLabel lblNewLabel_6 = new JLabel("Valor Total:");
		lblNewLabel_6.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_6.setBounds(28, 281, 97, 33);
		add(lblNewLabel_6);
		
		totalLabel = new JLabel("R$ 599, 97");
		totalLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		totalLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		totalLabel.setBounds(104, 281, 125, 33);
		add(totalLabel);
		
		JTable carrinhoTable = new JTable(carrinhoTableModel);
		
		JButton pagamentoBtn = new JButton("Ir para o pagamento");
		pagamentoBtn.setFont(new Font("Tahoma", Font.PLAIN, 12));
		pagamentoBtn.setBounds(26, 325, 180, 23);
		add(pagamentoBtn);
		
		pagamentoBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pagamentoListener.actionPerformed();
			}
		});
		
		JButton esvaziarBtn = new JButton("Esvaziar o carrinho");
		
		esvaziarBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				esvaziarListener.actionPerformed();
				JOptionPane.showMessageDialog(null, "Carrinho esvaziado");
			}
		});
		
		esvaziarBtn.setFont(new Font("Tahoma", Font.PLAIN, 12));
		esvaziarBtn.setBounds(406, 325, 180, 23);
		add(esvaziarBtn);
		
		JButton removerBtn = new JButton("Remover");
		
		removerBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int linha = carrinhoTable.getSelectedRow();
				if (linha == -1) return;
				long id = Long.parseLong(carrinhoTableModel.getValueAt(linha, 0).toString());
				
				for (CarrinhoProduto item :  carrinho.getItens()) {
					if (item.getId() == id) {
						removeListener.actionPerformed(item);
						JOptionPane.showMessageDialog(null, "Produto excluído");
						return;
					}
				}
			}
		});
		
		removerBtn.setBounds(496, 260, 89, 23);
		add(removerBtn);
		removerBtn.setBackground(new Color(215, 9, 9));
		

		JScrollPane scrollCarrinho = new JScrollPane(carrinhoTable);
		//table_produtos.setBounds(35, 161, 541, 175);
		scrollCarrinho.setBounds(28, 84, 557, 165);
		add(scrollCarrinho);
	}

	
	public void setCarrinho(Carrinho carrinho) {
		this.carrinho = carrinho;
		carrinhoTableModel.setRowCount(0);
		
		double total = 0;
		
		for (CarrinhoProduto item : carrinho.getItens()) {
			Produto produto = item.getProduto();
			int quantidade = item.getQuantidade();
			double valor = produto.getValor();
			carrinhoTableModel.addRow(new Object[] {item.getId(), produto.getNome(), valor, quantidade});
			total += valor * quantidade;
		}
		
		totalLabel.setText("R$ " + total);
	}
	
	public void addRemoverCarrinhoProdutoActionListener(RemoverCarrinhoProdutoAction listener) {
		removeListener = listener;
	}
	
	public void addEsvaziarCarrinhoActionListener(EsvaziarCarrinhoAction listener) {
		esvaziarListener = listener;
	}
	
	public void addIrPagamentoActionListener(IrPagamentoAction listener) {
		pagamentoListener = listener;
	}
}
