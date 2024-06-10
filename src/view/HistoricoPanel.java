package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.Label;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import exporter.CarrinhoExporter;
import model.Carrinho;

public class HistoricoPanel extends JPanel {

	private static final long serialVersionUID = 1L;
	private List<Carrinho> historico;
	private DefaultTableModel historicoTableModel = new DefaultTableModel(new Object[] { "ID", "Cliente", "Total"}, 0);

	/**
	 * Create the panel.
	 */
	public HistoricoPanel() {
		
		setLayout(null);
		
		Panel tituloPanel = new Panel();
		tituloPanel.setBounds(191, 10, 234, 33);
		tituloPanel.setBackground(new Color(234, 255, 215));
		add(tituloPanel);
		
		Label titulo = new Label("Histórico de compras");
		titulo.setFont(new Font("Dialog", Font.PLAIN, 12));
		tituloPanel.add(titulo);
		
		JTextField compraTxt = new JTextField();
		compraTxt.setBounds(33, 73, 200, 30);
		compraTxt.setToolTipText("ID Compra");
		compraTxt.setColumns(10);
		add(compraTxt);
		
		JTextField clienteTxt = new JTextField();
		clienteTxt.setBounds(254, 73, 200, 30);
		clienteTxt.setToolTipText("Nome Cliente");
		clienteTxt.setColumns(10);
		add(clienteTxt);
		
		JButton buscarBtn = new JButton("Buscar");
		buscarBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				historicoTableModel.setRowCount(0);
				String nomeCliente = clienteTxt.getText();
				long id =  0L;
				if (!compraTxt.getText().isBlank()) id = Long.parseLong(compraTxt.getText());
				
				for (Carrinho carrinho : historico) {
					double total = carrinho.getTotal();
					
					String cliente = carrinho.getCliente().getNome();
					
					if (id != 0 ) {
						if (id == carrinho.getId()) {
							historicoTableModel.addRow(new Object[] { carrinho.getId(), cliente, total });
						}
					} else {
						if (cliente.contains(nomeCliente)) {
							historicoTableModel.addRow(new Object[] { carrinho.getId(), cliente, total });
						}
					}

				}
			}
		});
		buscarBtn.setBounds(481, 77, 89, 23);
		add(buscarBtn);
		
		JTable table = new JTable(historicoTableModel);
		JScrollPane scroll = new JScrollPane(table);
		scroll.setBounds(33, 154, 537, 184);
		add(scroll);
		
		
		JButton exportarBtn = new JButton("Exportar CSV");
		exportarBtn.setBounds(443, 354, 127, 23);
		add(exportarBtn);
		
		exportarBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				exportar();
				JOptionPane.showMessageDialog(null, "Arquivo exportado");
			}
		});
		
		JLabel compraLabel = new JLabel("ID da compra");
		compraLabel.setBounds(33, 59, 142, 14);
		add(compraLabel);
		
		JLabel clientLabel = new JLabel("Nome do Cliente");
		clientLabel.setBounds(254, 59, 142, 14);
		add(clientLabel);
	}
	
	public void setHistorico(List<Carrinho> historico) {
		historicoTableModel.setRowCount(0);
		this.historico = historico;
		for (Carrinho carrinho :  historico) {
			long id = carrinho.getId();
			String cliente = carrinho.getCliente().getNome();
			
			double total = carrinho.getTotal();
			
			historicoTableModel.addRow(new Object[] { id, cliente, total });
		}
	}
	
	private void exportar() {
		CarrinhoExporter exporter = new CarrinhoExporter(historico);
		exporter.exportar();
	}

}
