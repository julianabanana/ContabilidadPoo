package Graphic;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTable;

import java.sql.*;
import Control.Conexion;
import Control.ConsultClient;
import Control.ConsultInventory;
import Control.Sale;
import java.awt.event.ActionListener;


public class FrameSales extends JFrame {
	public JPanel contentPane;
	private JTextField textFieldCantidad;
	private JTable table; 
        private JComboBox comboBoxCliente;
        private JComboBox comboBoxProducto;
        private JButton btnAnadirProducto;
        private  JButton btnGenerarVenta;
	private JLabel lblResult;
        public Conexion con;
        
	
	public FrameSales() {
		setForeground(Color.WHITE);
		setTitle("Ventas");
		setBackground(Color.DARK_GRAY);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 600);
		contentPane = new JPanel();
		contentPane.setBackground(Color.DARK_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		//table
		table = new JTable();
		
		//labels
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(FrameSales.class.getResource("/Images/sales.png")));
		JLabel lblTotal = new JLabel("Total:");
		lblTotal.setForeground(Color.WHITE);
		JLabel lblCliente = new JLabel("Cliente:");
		lblCliente.setForeground(Color.WHITE);
		JLabel lblProducto = new JLabel("Producto:");
		lblProducto.setForeground(Color.WHITE);
		JLabel lblNewLabel = new JLabel("Cantidad:");
		lblNewLabel.setForeground(Color.WHITE);
		lblResult = new JLabel("");
		lblResult.setForeground(Color.WHITE);
		
		//comboboxes
		con = new Conexion();
		comboBoxCliente = new JComboBox();
		llenarCombo(comboBoxCliente, "Clientes", "nombre", con);
		comboBoxProducto = new JComboBox();
		llenarCombo(comboBoxProducto, "Inventario", "nombre", con);
		
		
		//text field
		textFieldCantidad = new JTextField("");
		textFieldCantidad.setColumns(10);
		
		//buttons
		btnAnadirProducto = new JButton("Añadir producto");
		btnGenerarVenta = new JButton("Generar Venta");
		
		
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
							.addGroup(gl_contentPane.createSequentialGroup()
								.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
									.addGroup(gl_contentPane.createSequentialGroup()
										.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
											.addGroup(gl_contentPane.createSequentialGroup()
												.addGap(15)
												.addComponent(lblCliente))
											.addGroup(gl_contentPane.createSequentialGroup()
												.addContainerGap()
												.addComponent(lblProducto))
											.addGroup(gl_contentPane.createSequentialGroup()
												.addContainerGap()
												.addComponent(lblNewLabel)))
										.addPreferredGap(ComponentPlacement.RELATED)
										.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
											.addComponent(textFieldCantidad, GroupLayout.DEFAULT_SIZE, 185, Short.MAX_VALUE)
											.addComponent(comboBoxCliente, 0, 185, Short.MAX_VALUE)
											.addComponent(comboBoxProducto, 0, 185, Short.MAX_VALUE)))
									.addGroup(gl_contentPane.createSequentialGroup()
										.addContainerGap()
										.addComponent(btnAnadirProducto)))
								.addPreferredGap(ComponentPlacement.UNRELATED)
								.addComponent(label))
							.addGroup(gl_contentPane.createSequentialGroup()
								.addGap(309)
								.addComponent(lblResult)
								.addGap(68)))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(24)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
								.addComponent(btnGenerarVenta)
								.addComponent(table, GroupLayout.PREFERRED_SIZE, 391, GroupLayout.PREFERRED_SIZE))
							.addGap(9)))
					.addContainerGap())
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap(231, Short.MAX_VALUE)
					.addComponent(lblTotal)
					.addGap(164))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(label)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(comboBoxCliente, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblCliente))
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(comboBoxProducto, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblProducto))
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(textFieldCantidad, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblNewLabel))
							.addGap(18)
							.addComponent(btnAnadirProducto)))
					.addGap(35)
					.addComponent(table, GroupLayout.PREFERRED_SIZE, 275, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(lblResult)
						.addComponent(lblTotal))
					.addPreferredGap(ComponentPlacement.RELATED, 21, Short.MAX_VALUE)
					.addComponent(btnGenerarVenta)
					.addGap(21))
		);
		contentPane.setLayout(gl_contentPane);
	}
        //Accesores Botones
        public void addALAnadirProducto(ActionListener al){
            this.btnAnadirProducto.addActionListener(al);
        }
        public void addALGenerarVenta(ActionListener al){
            this.btnGenerarVenta.addActionListener(al);
        }

        public JButton getBtnAnadirProducto() {
            return btnAnadirProducto;
        }

        public JButton getBtnGenerarVenta() {
            return btnGenerarVenta;
        }
        //Limpíadores de labels
        public void newSale(){
            cleanLabels();
            this.lblResult.setText("");
        }
        public void cleanLabels(){
            this.textFieldCantidad.setText("");
            this.comboBoxProducto.setSelectedIndex(0);
        }
        public int getCantidadInput(){
            return Integer.parseInt(textFieldCantidad.getText());
        }  
        public String getNameCliente(){
            
            return String.valueOf(comboBoxCliente.getSelectedItem());
        }
        public String getNameProducto(){
            return String.valueOf(comboBoxProducto.getSelectedItem());
        }
        public int getIdcliente(){
            ConsultClient search=new ConsultClient();
            return search.getIdcliente(getNameCliente());
        }
        public int getIdproducto(){
            ConsultInventory search=new ConsultInventory();
            System.out.println("Id producto"+search.getIdproducto(getNameProducto()));
            return search.getIdproducto(getNameProducto());
        }
        
        //
        public void anadirATabla(Sale s){
            
        }
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrameSales frame = new FrameSales();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public static void llenarCombo(JComboBox cbo, String tabla, String columna, Conexion con){
        
		PreparedStatement ps ;
		ResultSet res ;
		Connection conex = con.getConexion();
		
		try 
        {
            
            String sql = "SELECT * FROM "+tabla;
            ps = conex.prepareStatement(sql);
            res = ps.executeQuery();
            
            while(res.next()) {
            	cbo.addItem(res.getString(columna));
            }
            res.close();
        } 
        catch (SQLException e) 
        {
            System.err.println(e.toString());
        }
    }
}