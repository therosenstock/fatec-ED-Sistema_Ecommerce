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
		
		JButton btnNewButton = new JButton("Área de Compras");
		btnNewButton.setBounds(131, 135, 168, 50);
		contentPane.add(btnNewButton);
		
		JButton btnGerenciarCliente = new JButton("Gerenciar Cliente");
		btnGerenciarCliente.setBounds(316, 135, 168, 50);
		contentPane.add(btnGerenciarCliente);
		
		JButton btnGerenciarProdutos = new JButton("Gerenciar Produtos");
		btnGerenciarProdutos.setBounds(316, 196, 168, 50);
		contentPane.add(btnGerenciarProdutos);
		
		JButton btnGerenciarTipoDe = new JButton("Gerenciar Categorias");
		btnGerenciarTipoDe.setBounds(131, 197, 168, 50);
		contentPane.add(btnGerenciarTipoDe);
		
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
