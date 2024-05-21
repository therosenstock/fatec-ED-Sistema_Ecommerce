package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTabbedPane;
import java.awt.Panel;
import java.awt.Color;
import java.awt.Label;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class TelaHistorico extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtIdCompra;
	private JTextField txtNomeCliente;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaHistorico frame = new TelaHistorico();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public TelaHistorico() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 640, 480);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(0, 0, 624, 441);
		contentPane.add(tabbedPane);
		
		JPanel panel = new JPanel();
		tabbedPane.addTab("Histórico de compras", null, panel, null);
		panel.setLayout(null);
		
		Panel panel_1 = new Panel();
		panel_1.setBounds(191, 10, 234, 33);
		panel_1.setBackground(new Color(234, 255, 215));
		panel.add(panel_1);
		
		Label label = new Label("Histórico de compras");
		label.setFont(new Font("Dialog", Font.PLAIN, 12));
		panel_1.add(label);
		
		txtIdCompra = new JTextField();
		txtIdCompra.setText("ID Compra");
		txtIdCompra.setToolTipText("ID Compra");
		txtIdCompra.setBounds(33, 73, 200, 30);
		panel.add(txtIdCompra);
		txtIdCompra.setColumns(10);
		
		txtNomeCliente = new JTextField();
		txtNomeCliente.setToolTipText("Nome Cliente");
		txtNomeCliente.setText("Nome Cliente");
		txtNomeCliente.setColumns(10);
		txtNomeCliente.setBounds(254, 73, 200, 30);
		panel.add(txtNomeCliente);
		
		JButton btnNewButton = new JButton("Buscar");
		btnNewButton.setBounds(481, 77, 89, 23);
		panel.add(btnNewButton);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
			},
			new String[] {
				"ID", "Cliente", "Valor"
			}
		));
		table.getColumnModel().getColumn(0).setPreferredWidth(187);
		table.getColumnModel().getColumn(1).setPreferredWidth(229);
		table.getColumnModel().getColumn(2).setPreferredWidth(203);
		table.setBounds(33, 154, 537, 184);
		panel.add(table);
		
		JButton btnNewButton_1 = new JButton("Exportar CSV");
		btnNewButton_1.setBounds(443, 354, 127, 23);
		panel.add(btnNewButton_1);
	}
}
