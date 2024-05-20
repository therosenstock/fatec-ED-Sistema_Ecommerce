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
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TelaCarrinho extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaCarrinho frame = new TelaCarrinho();
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
	public TelaCarrinho() {
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
		tabbedPane.addTab("Carrinho de Compras", null, panel, null);
		panel.setLayout(null);
		
		Panel panel_1 = new Panel();
		panel_1.setBackground(new Color(234, 255, 215));
		panel_1.setBounds(198, 10, 194, 33);
		panel.add(panel_1);
		
		Label label = new Label("Itens do Carrinho de Compras:");
		label.setFont(new Font("Dialog", Font.PLAIN, 12));
		panel_1.add(label);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(245, 250, 241));
		panel_2.setBounds(10, 76, 599, 42);
		panel.add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Item blablabla");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel.setBounds(45, 12, 118, 14);
		panel_2.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("1o");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_1.setBounds(10, 12, 46, 14);
		panel_2.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("R$");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_2.setBounds(236, 12, 46, 14);
		panel_2.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("199,99");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_3.setBounds(279, 12, 46, 14);
		panel_2.add(lblNewLabel_3);
		
		JButton btnNewButton = new JButton("Remover");
		btnNewButton.setBackground(new Color(215, 9, 9));
		btnNewButton.setBounds(500, 9, 89, 23);
		panel_2.add(btnNewButton);
		
		JPanel panel_2_1 = new JPanel();
		panel_2_1.setLayout(null);
		panel_2_1.setBackground(new Color(245, 250, 241));
		panel_2_1.setBounds(10, 117, 599, 42);
		panel.add(panel_2_1);
		
		JLabel lblNewLabel_4 = new JLabel("Item blablabla");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_4.setBounds(45, 12, 118, 14);
		panel_2_1.add(lblNewLabel_4);
		
		JLabel lblNewLabel_1_1 = new JLabel("2o");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_1_1.setBounds(10, 12, 46, 14);
		panel_2_1.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_2_1 = new JLabel("R$");
		lblNewLabel_2_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_2_1.setBounds(236, 12, 46, 14);
		panel_2_1.add(lblNewLabel_2_1);
		
		JLabel lblNewLabel_3_1 = new JLabel("199,99");
		lblNewLabel_3_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_3_1.setBounds(279, 12, 46, 14);
		panel_2_1.add(lblNewLabel_3_1);
		
		JButton btnNewButton_1 = new JButton("Remover");
		btnNewButton_1.setBackground(new Color(215, 9, 9));
		btnNewButton_1.setBounds(500, 9, 89, 23);
		panel_2_1.add(btnNewButton_1);
		
		JPanel panel_2_2 = new JPanel();
		panel_2_2.setLayout(null);
		panel_2_2.setBackground(new Color(245, 250, 241));
		panel_2_2.setBounds(10, 158, 599, 42);
		panel.add(panel_2_2);
		
		JLabel lblNewLabel_5 = new JLabel("Item blablabla");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_5.setBounds(45, 12, 118, 14);
		panel_2_2.add(lblNewLabel_5);
		
		JLabel lblNewLabel_1_2 = new JLabel("3o");
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_1_2.setBounds(10, 12, 46, 14);
		panel_2_2.add(lblNewLabel_1_2);
		
		JLabel lblNewLabel_2_2 = new JLabel("R$");
		lblNewLabel_2_2.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_2_2.setBounds(236, 12, 46, 14);
		panel_2_2.add(lblNewLabel_2_2);
		
		JLabel lblNewLabel_3_2 = new JLabel("199,99");
		lblNewLabel_3_2.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_3_2.setBounds(279, 12, 46, 14);
		panel_2_2.add(lblNewLabel_3_2);
		
		JButton btnNewButton_2 = new JButton("Remover");
		btnNewButton_2.setBackground(new Color(215, 9, 9));
		btnNewButton_2.setBounds(500, 9, 89, 23);
		panel_2_2.add(btnNewButton_2);
		
		JLabel lblNewLabel_6 = new JLabel("Valor Total:");
		lblNewLabel_6.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_6.setBounds(10, 281, 180, 33);
		panel.add(lblNewLabel_6);
		
		JLabel lblNewLabel_6_1 = new JLabel("R$ 599, 97");
		lblNewLabel_6_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_6_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_6_1.setBounds(429, 281, 180, 33);
		panel.add(lblNewLabel_6_1);
		
		JButton btnNewButton_3 = new JButton("Ir para o pagamento");
		btnNewButton_3.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnNewButton_3.setBounds(10, 325, 180, 23);
		panel.add(btnNewButton_3);
		
		JButton btnNewButton_3_1 = new JButton("Esvaziar o carrinho");
		btnNewButton_3_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_3_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnNewButton_3_1.setBounds(429, 326, 180, 23);
		panel.add(btnNewButton_3_1);
	}
}
