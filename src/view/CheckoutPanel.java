package view;

import javax.swing.JPanel;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.awt.Color;
import java.awt.Label;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

import actions.FinalizarAction;
import estrutura.PilhaToFila;
import model.Carrinho;
import model.CarrinhoProduto;
import model.Cliente;
import model.Produto;

import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JComboBox;

public class CheckoutPanel extends JPanel {

	private static final long serialVersionUID = 1L;
	private List<Cliente> clientes;
	private DefaultComboBoxModel<Cliente> clienteComboBoxModel = new DefaultComboBoxModel<Cliente>();
	private DefaultTableModel checkoutTableModel = new DefaultTableModel(new Object[] { "Produto", "Total" }, 0);
	private JLabel valorLabel;
	private Carrinho carrinho;
	private FinalizarAction listener;

	/**
	 * Create the panel.
	 */
	public CheckoutPanel() {
		setLayout(null);
		
		Panel tituloPanel = new Panel();
		tituloPanel.setBounds(198, 10, 194, 33);
		tituloPanel.setBackground(new Color(234, 255, 215));
		add(tituloPanel);
		
		Label titulo = new Label("Conferência:");
		titulo.setFont(new Font("Dialog", Font.PLAIN, 12));
		tituloPanel.add(titulo);
		
		JLabel totalLabel = new JLabel("Valor Total:");
		totalLabel.setBounds(399, 288, 180, 33);
		totalLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		add(totalLabel);
		
		valorLabel = new JLabel("R$ 599, 97");
		valorLabel.setBounds(417, 288, 180, 33);
		valorLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		valorLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		add(valorLabel);
		
		JButton finalizarBtn = new JButton("Finalizar");
		finalizarBtn.setBounds(417, 335, 180, 23);
		finalizarBtn.setFont(new Font("Tahoma", Font.PLAIN, 12));
		add(finalizarBtn);
		
		finalizarBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				Cliente cliente = (Cliente) clienteComboBoxModel.getSelectedItem();
				
				if (carrinho.getItens().isEmpty()) {
					JOptionPane.showMessageDialog(null, "Adicione um produto", "Adicione um produto", JOptionPane.WARNING_MESSAGE);
					return;
				}
				
				if (cliente == null) {
					JOptionPane.showMessageDialog(null, "Selecione um cliente", "Selecione um cliente", JOptionPane.WARNING_MESSAGE);
					return;
				}
				carrinho.setCliente(cliente);
				listener.actionPerformed();
				JOptionPane.showMessageDialog(null, "Compra finalizada!");
			}
		});
		
		JTable checkoutTable = new JTable(checkoutTableModel);
		JScrollPane scrollCheckout = new JScrollPane(checkoutTable);
		scrollCheckout.setBounds(20, 69, 577, 199);
		add(scrollCheckout);
		
		JComboBox<Cliente> clientesCbx = new JComboBox<Cliente>(clienteComboBoxModel);
		clientesCbx.setBounds(149, 291, 209, 30);
		add(clientesCbx);
		
		JLabel lblNewLabel = new JLabel("ID do cliente:");
		lblNewLabel.setBounds(20, 299, 151, 14);
		add(lblNewLabel);
	}
	
	public void setCarrinho(Carrinho carrinho) {
		this.carrinho = carrinho;
		checkoutTableModel.setRowCount(0);

		for (CarrinhoProduto item : PilhaToFila.transformar(carrinho.getItens())) {
			Produto produto = item.getProduto();
			checkoutTableModel.addRow(new Object[] { produto.getNome(), produto.getValor() * item.getQuantidade() });
		}
		valorLabel.setText("R$"  + carrinho.getTotal());
		
	}
	
	public void setClientes(List<Cliente> clientes) {
		this.clientes = clientes;
		clienteComboBoxModel.removeAllElements();
		clienteComboBoxModel.addElement(null);
		
		for (Cliente cliente : clientes) {
			clienteComboBoxModel.addElement(cliente);
		}
	}
	
	public void addActionListener(FinalizarAction listener) {
		this.listener = listener;
	}

}
