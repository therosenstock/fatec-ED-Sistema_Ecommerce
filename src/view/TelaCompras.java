package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import actions.AdicionarCarrinhoProdutoAction;
import actions.EsvaziarCarrinhoAction;
import actions.FinalizarAction;
import actions.IrPagamentoAction;
import actions.RemoverCarrinhoProdutoAction;
import app.App;
import model.CarrinhoProduto;

import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.JTable;

public class TelaCompras extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private AdicionarProdutoCarrinhoPanel produtosPanel;
	private CarrinhoPanel carrinhoPanel;
	private CheckoutPanel checkout;
	private HistoricoPanel historicoPanel;
	private App app = App.getApp();
	private static int CLOSE_OPERATION = JFrame.DISPOSE_ON_CLOSE;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				CLOSE_OPERATION = JFrame.EXIT_ON_CLOSE;
				try {
					TelaCompras frame = new TelaCompras();
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
	public TelaCompras() {
		app.inicializar();
		setDefaultCloseOperation(CLOSE_OPERATION);
		setBounds(100, 100, 640, 480);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(0, 0, 624, 441);
		contentPane.add(tabbedPane);
		
		produtosPanel = new AdicionarProdutoCarrinhoPanel();
		produtosPanel.addActionListener(new AdicionarCarrinhoProdutoAction() {
			
			@Override
			public void actionPerformed(CarrinhoProduto item) {
				app.getCarrinho().addItem(item);
				atualizarCarrinho();
			}
		});
		
		produtosPanel.setProdutos(app.getProdutos());
		produtosPanel.setTipos(app.getTiposProduto());
		tabbedPane.addTab("Produtos", null, produtosPanel, null);
		
		carrinhoPanel = new CarrinhoPanel();
		carrinhoPanel.setCarrinho(app.getCarrinho());
		
		carrinhoPanel.addEsvaziarCarrinhoActionListener(new EsvaziarCarrinhoAction() {
			
			@Override
			public void actionPerformed() {
				app.getCarrinho().esvaziar();
				atualizarCarrinho();
			}
		});
		
		carrinhoPanel.addRemoverCarrinhoProdutoActionListener(new RemoverCarrinhoProdutoAction() {
			
			@Override
			public void actionPerformed(CarrinhoProduto item) {
				app.getCarrinho().removeItem(item);
				atualizarCarrinho();
			}
		});
		
		carrinhoPanel.addIrPagamentoActionListener(new IrPagamentoAction() {
			
			@Override
			public void actionPerformed() {
				System.out.println("Ir para pagamento");
				tabbedPane.setSelectedIndex(2);
			}
		});
		
		tabbedPane.addTab("Carrinho de Compras", null, carrinhoPanel, null);
		
		checkout = new CheckoutPanel();
		checkout.setCarrinho(app.getCarrinho());
		checkout.setClientes(app.getClientes());
		
		checkout.addActionListener(new FinalizarAction() {
			
			@Override
			public void actionPerformed() {
				app.finalizar();
				atualizarCarrinho();
				atualizarHistorico();
			}
		});
		
		tabbedPane.addTab("Checkout", null, checkout, null);
		
		historicoPanel = new HistoricoPanel();
		historicoPanel.setHistorico(app.getHistorico());
		
		tabbedPane.addTab("Histórico de compras", null, historicoPanel, null);
		
	}
	
	private void atualizarCarrinho() {
		carrinhoPanel.setCarrinho(app.getCarrinho());
		checkout.setCarrinho(app.getCarrinho());
	}
	
	private void atualizarHistorico() {
		historicoPanel.setHistorico(app.getHistorico());
	}
}
