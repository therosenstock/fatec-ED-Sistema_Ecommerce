package view;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import java.awt.Component;
import java.awt.Panel;
import java.util.ArrayList;
import java.util.List;
import java.awt.Color;
import java.awt.Label;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import actions.CriarTipoProdutoAction;
import actions.RemoverTipoProdutoAction;
import model.TipoProduto;

import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ConsultarTipoProdutoPanel extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTextField buscaTxt;
	private List<TipoProduto> tiposProduto;
	private RemoverTipoProdutoAction listener;
	private DefaultTableModel modeloTipos;
	private JTable tabelaTipos;

	/**
	 * Create the panel.
	 */
	public ConsultarTipoProdutoPanel() {
		
		this.setLayout(null);
		modeloTipos = new DefaultTableModel(new Object[]{"ID", "Tipo", "Descrição"}, 0);
		tabelaTipos = new JTable(modeloTipos);
		JScrollPane scrollTipos = new JScrollPane(tabelaTipos);
		scrollTipos.setBounds(28, 112, 557, 231);
		this.add(scrollTipos);

		
		Panel tituloPanel = new Panel();
		tituloPanel.setBackground(new Color(234, 255, 215));
		tituloPanel.setBounds(194, 10, 194, 33);
		this.add(tituloPanel);
		
		Label titulo = new Label("Consulta de Tipos de Produto");
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
				modeloTipos.setRowCount(0);
				for (TipoProduto tipo : tiposProduto) {
					if (tipo.getNome().contains(buscaTxt.getText())) {
						modeloTipos.addRow(new Object[]{tipo.getId(), tipo.getNome(), tipo.getDescricao()});
					}
				}
			}
		});
		
		buscarBtn.setBounds(502, 75, 83, 23);
		this.add(buscarBtn);
		
		JButton removerBtn = new JButton("Remover");
		removerBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int linha = tabelaTipos.getSelectedRow();
				long id = Long.parseLong(modeloTipos.getValueAt(linha, 0).toString());
				modeloTipos.removeRow(linha);
				for (TipoProduto tipo : tiposProduto) {
					if (tipo.getId() == id) {
						listener.actionPerformed(tipo);
						break;
					}
				}
			}
		});
		removerBtn.setBounds(496, 353, 89, 23);
		this.add(removerBtn);
		
		this.inicializarTabela();
	}
	
	public void setTiposProduto(List<TipoProduto> tiposProduto) {
		this.tiposProduto = tiposProduto;
	}
	
	public void addActionsListener(RemoverTipoProdutoAction listener) {
		this.listener = listener;
	}
	
	public void inicializarTabela() {
		modeloTipos.setRowCount(0);
		if(tiposProduto != null) {
		for (TipoProduto tipo : tiposProduto) {
			modeloTipos.addRow(new Object[]{tipo.getId(), tipo.getNome(), tipo.getDescricao()});
		}
		}
	}
}
