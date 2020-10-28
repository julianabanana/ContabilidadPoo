package Graphic;

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

public class FrameClient extends JFrame {

	public JPanel contentPane;
	public JTextField txtNombre;
	public JTextField txtIdCliente;
	public JTextField txtAt;
	public JTextField txtDireccion;
	
	public JButton btnModificar;
	public JButton btnAnadir;
	public JButton btnBuscar;
	public JButton btnEliminar ;
	private JLabel label_1;

	/**
	 * Create the frame.
	 */
	public FrameClient() {
		setForeground(Color.WHITE);
		setTitle("Cliente");
		setBackground(Color.DARK_GRAY);
		initComponents();
		createEvents();
		
	}

	private void createEvents() {
		// TODO Auto-generated method stub
		
	}

	private void initComponents() {
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 225);
		contentPane = new JPanel();
		contentPane.setBackground(Color.DARK_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		//labels
		JLabel lblNombre = new JLabel("Nombre: ");
		lblNombre.setForeground(Color.WHITE);
		JLabel lblNumeroDelCliente = new JLabel("Numero del cliente:  ");
		lblNumeroDelCliente.setForeground(Color.WHITE);
		JLabel label = new JLabel("@: ");
		label.setForeground(Color.WHITE);
		JLabel lblNewLabel = new JLabel("Direccion: ");
		lblNewLabel.setForeground(Color.WHITE);
		
		//text fields
		txtNombre = new JTextField();
		txtNombre.setColumns(10);
		txtIdCliente = new JTextField();
		txtIdCliente.setColumns(10);
		txtAt = new JTextField();
		txtAt.setColumns(10);
		txtDireccion = new JTextField();
		txtDireccion.setColumns(10);
		
		//buttons
		btnModificar = new JButton("Modificar");
		btnAnadir = new JButton("Añadir");
		btnBuscar = new JButton("Buscar");
		btnEliminar = new JButton("Eliminar");
		
		label_1 = new JLabel("");
		label_1.setIcon(new ImageIcon(FrameClient.class.getResource("/Images/client.png")));
		
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(lblNewLabel)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(txtDireccion))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(label)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(txtAt))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(lblNumeroDelCliente)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(txtIdCliente))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(lblNombre)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(txtNombre, GroupLayout.PREFERRED_SIZE, 233, GroupLayout.PREFERRED_SIZE)))
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(label_1, GroupLayout.DEFAULT_SIZE, 129, Short.MAX_VALUE))
						.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
							.addComponent(btnModificar)
							.addGap(18)
							.addComponent(btnAnadir, GroupLayout.PREFERRED_SIZE, 99, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(btnBuscar, GroupLayout.PREFERRED_SIZE, 99, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED, 24, Short.MAX_VALUE)
							.addComponent(btnEliminar, GroupLayout.PREFERRED_SIZE, 99, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap())
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addContainerGap()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblNombre)
								.addComponent(txtNombre, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblNumeroDelCliente)
								.addComponent(txtIdCliente, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(label)
								.addComponent(txtAt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
								.addComponent(lblNewLabel)
								.addComponent(txtDireccion, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
						.addComponent(label_1, GroupLayout.PREFERRED_SIZE, 128, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnModificar)
						.addComponent(btnAnadir)
						.addComponent(btnBuscar)
						.addComponent(btnEliminar))
					.addContainerGap(75, Short.MAX_VALUE))
		);
		contentPane.setLayout(gl_contentPane);
		
	}
}	
