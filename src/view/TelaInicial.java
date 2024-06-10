package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.Panel;
import java.awt.Color;
import java.awt.Label;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TelaInicial extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaInicial frame = new TelaInicial();
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
	public TelaInicial() {
		setTitle("Tela inicial");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 640, 480);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnCompras = new JButton("Área de Compras");
		var self = this;
		
		btnCompras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaCompras telaCompras = new TelaCompras();
				telaCompras.setVisible(true);
			}
		});
		
		btnCompras.setBounds(219, 135, 168, 50);
		contentPane.add(btnCompras);
		
		JButton btnGerenciarCliente = new JButton("Gerenciar Cliente");
		
		btnGerenciarCliente.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				TelaCliente telaCliente = new TelaCliente();
				telaCliente.setVisible(true);
			}
		});
		
		btnGerenciarCliente.setBounds(219, 196, 168, 50);
		contentPane.add(btnGerenciarCliente);
		
		JButton btnGerenciarProdutos = new JButton("Gerenciar Produtos");
		btnGerenciarProdutos.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				TelaProdutos telaProodutos = new TelaProdutos();
				telaProodutos.setVisible(true);
			}
		});
		
		
		btnGerenciarProdutos.setBounds(219, 255, 168, 50);
		contentPane.add(btnGerenciarProdutos);
		
		Panel panel_1_2 = new Panel();
		panel_1_2.setBackground(new Color(234, 255, 215));
		panel_1_2.setBounds(173, 50, 253, 33);
		contentPane.add(panel_1_2);
		panel_1_2.setLayout(null);
		
		Label label_2 = new Label("Bem-vindo! Escolha a opção desejada:");
		label_2.setBounds(17, 4, 222, 23);
		label_2.setFont(new Font("Dialog", Font.PLAIN, 12));
		panel_1_2.add(label_2);
	}
}
