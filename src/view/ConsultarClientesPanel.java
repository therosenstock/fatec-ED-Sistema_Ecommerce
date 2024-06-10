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
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import actions.RemoverClienteAction;
import actions.RemoverTipoProdutoAction;
import model.PessoaFisica;
import model.PessoaJuridica;
import model.TipoProduto;

public class ConsultarClientesPanel extends JPanel {

	private static final long serialVersionUID = 1L;

	private JTextField buscaTxt;
	private List<PessoaFisica> clientePF;
	private List<PessoaJuridica> clientePJ;
	private RemoverClienteAction listener;
	private DefaultTableModel modeloCliente;
	private JTable tabelaCliente;
	/**
	 * Create the panel.
	 */
	public ConsultarClientesPanel() {
		this.setLayout(null);
		modeloCliente = new DefaultTableModel(new Object[]{"Documento", "Nome/Razão Social", "Endereço", "Telefone"}, 0);
		
		tabelaCliente = new JTable(modeloCliente);
		JScrollPane scrollTipos = new JScrollPane(tabelaCliente);
		scrollTipos.setBounds(28, 112, 557, 231);
		this.add(scrollTipos);

		
		Panel tituloPanel = new Panel();
		tituloPanel.setBackground(new Color(234, 255, 215));
		tituloPanel.setBounds(194, 10, 194, 33);
		this.add(tituloPanel);
		
		Label titulo = new Label("Consulta de Clientes");
		titulo.setFont(new Font("Dialog", Font.PLAIN, 12));
		tituloPanel.add(titulo);
		
		buscaTxt = new JTextField();
		buscaTxt.setColumns(10);
		buscaTxt.setBounds(28, 71, 464, 30);
		this.add(buscaTxt);
		
		JLabel nomeLabel = new JLabel("Nome:");
		nomeLabel.setBounds(28, 53, 46, 14);
		this.add(nomeLabel);
		
		JButton buscarBtn = new JButton("Buscar");
		buscarBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				modeloCliente.setRowCount(0);
				
			}
		});
		
		buscarBtn.setBounds(502, 75, 83, 23);
		this.add(buscarBtn);
		
		JButton removerBtn = new JButton("Remover");
		removerBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int linha = tabelaCliente.getSelectedRow();
				long id = Long.parseLong(modeloCliente.getValueAt(linha, 0).toString());
				modeloCliente.removeRow(linha);
				
			}
		});
		removerBtn.setBounds(496, 353, 89, 23);
		this.add(removerBtn);
		

	}

}
