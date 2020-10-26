package Control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import Graphic.FrameInventory;
import Graphic.FramePurchase;

public class ConInventory implements ActionListener{
	
	private Inventory inventory;
	private ConsultInventory query;
	private FrameInventory frame;
	
	
	//constructor
	public ConInventory(Inventory inventory, ConsultInventory query2, FrameInventory frame2) {
		
		this.inventory = inventory;
		this.query = query2;
		this.frame = frame2;
		this.frame.btnBuscar.addActionListener(this);
		this.frame.btnAnadir.addActionListener(this);
		this.frame.btnEliminar.addActionListener(this);
		
	}
	//method for initializing the view (title and location)
	public void start() {
		frame.setTitle("Inventory");
		frame.setLocationRelativeTo(null);
	}
	
	//methods that listen to the clicks (events)
	public void actionPerformed(ActionEvent e){
		//Adding button
		if(e.getSource() == frame.btnAnadir){
			inventory.setNombre(frame.txtNombre.getText());
			inventory.setCantidad(Integer.parseInt(frame.txtCantidad.getText()));
			inventory.setPrecio(Integer.parseInt(frame.txtPrecio.getText()));
			clean();
			if(query.register(inventory)){
				JOptionPane.showMessageDialog(null, "Nuevo Producto guardado");
			}else {
				JOptionPane.showMessageDialog(null, "Ha ocurrido un error. Debe anadir nombre y cantidad.");

			}
		}
		//Delete button
		if(e.getSource() == frame.btnEliminar){
			inventory.setNombre(frame.txtNombre.getText());
			clean();
			if(query.delete(inventory)){					
				JOptionPane.showMessageDialog(null, "Producto eliminado");
			}else {
				JOptionPane.showMessageDialog(null, "Ha ocurrido un error. Debe anadir el numero del producto.");
			}
		}
		//Search button
		if(e.getSource() == frame.btnBuscar){
			inventory.setNombre(frame.txtNombre.getText());
			if(query.search(inventory)){
				
				frame.txtNombre.setText(inventory.getNombre());
				frame.txtIdProducto.setText(String.valueOf(inventory.getIdproducto()));
				frame.txtCantidad.setText(String.valueOf(inventory.getCantidad()));
				
			}else {
				JOptionPane.showMessageDialog(null, "Producto no registrado");
			}
		}

	}
	
	//method for cleaning the boxes
	public void clean(){
		frame.txtIdProducto.setText(null);
		frame.txtNombre.setText(null);
		frame.txtCantidad.setText(null);
		frame.txtPrecio.setText(null);
	}
}
