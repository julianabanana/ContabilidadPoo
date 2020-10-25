package Graphic;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.WindowConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.ImageIcon;

public class FramePurchase extends JFrame {

	public JPanel JPanel;
	public JTextField txtIdProducto;
	public JTextField txtIdCompra;
	public JTextField txtProveedor;
	public JTextField txtCantidad;
	public JTextField txtCostoIndividual;
	public JTextField txtCostoTotal;
	public JButton btnAnadir;
	public JButton btnBuscar;
	private JLabel image;
	

	/**
	 * Create the frame.
	 */
	public FramePurchase() {
		setForeground(Color.WHITE);
		setTitle("Compra");
		setBackground(Color.DARK_GRAY);
		initComponents();
		
	}

	private void initComponents() {
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 300);
		JPanel = new JPanel();
		JPanel.setBackground(Color.DARK_GRAY);
		JPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(JPanel);
		
		//labels
		JLabel lbIdproducto = new JLabel("Numero del producto: ");
		lbIdproducto.setForeground(Color.WHITE);
		JLabel lblNumeroDelCliente = new JLabel("Numero de la compra:  ");
		lblNumeroDelCliente.setForeground(Color.WHITE);
		JLabel lblProveedor = new JLabel("Proveedor: ");
		lblProveedor.setForeground(Color.WHITE);
		JLabel lblNewLabel = new JLabel("Cantidad: ");
		lblNewLabel.setForeground(Color.WHITE);
		JLabel lblCostoIndividual = new JLabel("Costo individual: ");
		lblCostoIndividual.setForeground(Color.WHITE);
		JLabel lblCostoTotal = new JLabel("Costo total: ");
		lblCostoTotal.setForeground(Color.WHITE);
		
		//text fields
		txtIdProducto = new JTextField();
		txtIdProducto.setColumns(10);
		txtIdCompra = new JTextField();
		txtIdCompra.setColumns(10);
		txtProveedor = new JTextField();
		txtProveedor.setColumns(10);
		txtCantidad = new JTextField();
		txtCantidad.setColumns(10);
		txtCostoIndividual = new JTextField();
		txtCostoIndividual.setColumns(10);
		txtCostoTotal = new JTextField();
		txtCostoTotal.setColumns(10);
		
		//buttons
		btnAnadir = new JButton("Añadir");
		btnBuscar = new JButton("Buscar");
		
		//image
		image = new JLabel("");
		image.setIcon(new ImageIcon(FramePurchase.class.getResource("/Images/purchase.png")));
		
		
		
		GroupLayout gl_JPanel = new GroupLayout(JPanel);
		gl_JPanel.setHorizontalGroup(
			gl_JPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_JPanel.createSequentialGroup()
					.addGroup(gl_JPanel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_JPanel.createSequentialGroup()
							.addGap(53)
							.addComponent(btnAnadir, GroupLayout.PREFERRED_SIZE, 99, GroupLayout.PREFERRED_SIZE)
							.addGap(60)
							.addComponent(btnBuscar, GroupLayout.PREFERRED_SIZE, 99, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_JPanel.createSequentialGroup()
							.addGap(18)
							.addGroup(gl_JPanel.createParallelGroup(Alignment.TRAILING)
								.addGroup(gl_JPanel.createSequentialGroup()
									.addComponent(lblCostoTotal, GroupLayout.PREFERRED_SIZE, 122, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(txtCostoTotal, GroupLayout.DEFAULT_SIZE, 192, Short.MAX_VALUE))
								.addGroup(gl_JPanel.createSequentialGroup()
									.addComponent(lblCostoIndividual)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(txtCostoIndividual, GroupLayout.DEFAULT_SIZE, 192, Short.MAX_VALUE))
								.addGroup(gl_JPanel.createSequentialGroup()
									.addComponent(lblNewLabel)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(txtCantidad, GroupLayout.DEFAULT_SIZE, 241, Short.MAX_VALUE))
								.addGroup(gl_JPanel.createSequentialGroup()
									.addComponent(lblProveedor)
									.addGap(16)
									.addComponent(txtProveedor, GroupLayout.DEFAULT_SIZE, 228, Short.MAX_VALUE))
								.addGroup(Alignment.LEADING, gl_JPanel.createSequentialGroup()
									.addGroup(gl_JPanel.createParallelGroup(Alignment.LEADING)
										.addComponent(lblNumeroDelCliente)
										.addComponent(lbIdproducto))
									.addPreferredGap(ComponentPlacement.RELATED)
									.addGroup(gl_JPanel.createParallelGroup(Alignment.LEADING)
										.addComponent(txtIdProducto, GroupLayout.DEFAULT_SIZE, 151, Short.MAX_VALUE)
										.addComponent(txtIdCompra, GroupLayout.DEFAULT_SIZE, 151, Short.MAX_VALUE))))
							.addGap(12)
							.addComponent(image, GroupLayout.PREFERRED_SIZE, 118, Short.MAX_VALUE)))
					.addContainerGap())
		);
		gl_JPanel.setVerticalGroup(
			gl_JPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_JPanel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_JPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lbIdproducto)
						.addComponent(txtIdProducto, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_JPanel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_JPanel.createSequentialGroup()
							.addComponent(image)
							.addContainerGap())
						.addGroup(gl_JPanel.createSequentialGroup()
							.addGroup(gl_JPanel.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblNumeroDelCliente)
								.addComponent(txtIdCompra, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(gl_JPanel.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblProveedor)
								.addComponent(txtProveedor, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(gl_JPanel.createParallelGroup(Alignment.TRAILING)
								.addComponent(lblNewLabel)
								.addComponent(txtCantidad, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(gl_JPanel.createParallelGroup(Alignment.TRAILING)
								.addComponent(lblCostoIndividual)
								.addComponent(txtCostoIndividual, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(gl_JPanel.createParallelGroup(Alignment.TRAILING)
								.addComponent(lblCostoTotal)
								.addComponent(txtCostoTotal, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.RELATED, 20, Short.MAX_VALUE)
							.addGroup(gl_JPanel.createParallelGroup(Alignment.BASELINE)
								.addComponent(btnAnadir)
								.addComponent(btnBuscar))
							.addGap(25))))
		);
		JPanel.setLayout(gl_JPanel);
		
	}
}