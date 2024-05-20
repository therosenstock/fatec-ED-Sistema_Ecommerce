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

public class TelaCheckout extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaCheckout frame = new TelaCheckout();
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
	public TelaCheckout() {
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
		panel.setLayout(null);
		tabbedPane.addTab("Checkout", null, panel, null);
		
		Panel panel_1 = new Panel();
		panel_1.setBackground(new Color(234, 255, 215));
		panel_1.setBounds(198, 10, 194, 33);
		panel.add(panel_1);
		
		Label label = new Label("Conferência:");
		label.setFont(new Font("Dialog", Font.PLAIN, 12));
		panel_1.add(label);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(245, 250, 241));
		panel_2.setBounds(10, 76, 599, 42);
		panel.add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Item blablabla");
		lblNewLabel.setBounds(45, 12, 118, 14);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 12));
		panel_2.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("1o");
		lblNewLabel_1.setBounds(10, 12, 46, 14);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		panel_2.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("R$");
		lblNewLabel_2.setBounds(464, 12, 46, 14);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 12));
		panel_2.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("199,99");
		lblNewLabel_3.setBounds(507, 12, 46, 14);
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 12));
		panel_2.add(lblNewLabel_3);
		
		JPanel panel_2_1 = new JPanel();
		panel_2_1.setBackground(new Color(245, 250, 241));
		panel_2_1.setBounds(10, 117, 599, 42);
		panel.add(panel_2_1);
		panel_2_1.setLayout(null);
		
		JLabel lblNewLabel_4 = new JLabel("Item blablabla");
		lblNewLabel_4.setBounds(45, 12, 118, 14);
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 12));
		panel_2_1.add(lblNewLabel_4);
		
		JLabel lblNewLabel_1_1 = new JLabel("2o");
		lblNewLabel_1_1.setBounds(10, 12, 46, 14);
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		panel_2_1.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_2_1 = new JLabel("R$");
		lblNewLabel_2_1.setBounds(464, 12, 46, 14);
		lblNewLabel_2_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		panel_2_1.add(lblNewLabel_2_1);
		
		JLabel lblNewLabel_3_1 = new JLabel("199,99");
		lblNewLabel_3_1.setBounds(507, 12, 46, 14);
		lblNewLabel_3_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		panel_2_1.add(lblNewLabel_3_1);
		
		JPanel panel_2_2 = new JPanel();
		panel_2_2.setBackground(new Color(245, 250, 241));
		panel_2_2.setBounds(10, 158, 599, 42);
		panel.add(panel_2_2);
		panel_2_2.setLayout(null);
		
		JLabel lblNewLabel_5 = new JLabel("Item blablabla");
		lblNewLabel_5.setBounds(45, 12, 118, 14);
		lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 12));
		panel_2_2.add(lblNewLabel_5);
		
		JLabel lblNewLabel_1_2 = new JLabel("3o");
		lblNewLabel_1_2.setBounds(10, 12, 46, 14);
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.BOLD, 12));
		panel_2_2.add(lblNewLabel_1_2);
		
		JLabel lblNewLabel_2_2 = new JLabel("R$");
		lblNewLabel_2_2.setBounds(464, 12, 46, 14);
		lblNewLabel_2_2.setFont(new Font("Tahoma", Font.BOLD, 12));
		panel_2_2.add(lblNewLabel_2_2);
		
		JLabel lblNewLabel_3_2 = new JLabel("199,99");
		lblNewLabel_3_2.setBounds(507, 12, 46, 14);
		lblNewLabel_3_2.setFont(new Font("Tahoma", Font.PLAIN, 12));
		panel_2_2.add(lblNewLabel_3_2);
		
		JLabel lblNewLabel_6 = new JLabel("Valor Total:");
		lblNewLabel_6.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_6.setBounds(10, 227, 180, 33);
		panel.add(lblNewLabel_6);
		
		JLabel lblNewLabel_6_1 = new JLabel("R$ 599, 97");
		lblNewLabel_6_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_6_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_6_1.setBounds(429, 227, 180, 33);
		panel.add(lblNewLabel_6_1);
		
		JButton btnNewButton_3_1 = new JButton("Finalizar");
		btnNewButton_3_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnNewButton_3_1.setBounds(212, 364, 180, 23);
		panel.add(btnNewButton_3_1);
	}

}
