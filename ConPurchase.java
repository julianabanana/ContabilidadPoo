package Control;

import java.awt.event.*;

import javax.swing.JOptionPane;
import Graphic.FramePurchase;

public class ConPurchase implements ActionListener{
	
	private Purchase purchase;
	private ConsultPurchase query;
	private FramePurchase frame;
	
	
	//constructor
	public ConPurchase(Purchase purchase, ConsultPurchase query, FramePurchase frame) {
		
		this.purchase = purchase;
		this.query = query;
		this.frame = frame;
		this.frame.btnBuscar.addActionListener(this);
		this.frame.btnAnadir.addActionListener(this);
		
	}
	//method for initializing the view (title and location)
	public void start() {
		frame.setTitle("Purchase");
		frame.setLocationRelativeTo(null);
	}
	
	//methods that listen to the clicks (events)
	public void actionPerformed(ActionEvent e){
		//Adding button
		if(e.getSource() == frame.btnAnadir){
			purchase.setIdproducto(Integer.parseInt(frame.txtIdProducto.getText()));
			purchase.setIdcompra(Integer.parseInt(frame.txtIdCompra.getText()));
			purchase.setProveedor(Integer.parseInt(frame.txtProveedor.getText()));
			purchase.setCantidad(Integer.parseInt(frame.txtCantidad.getText()));
			purchase.setCostoIndividual(Integer.parseInt(frame.txtCostoIndividual.getText()));
			purchase.setCostoTotal();
			clean();
			if(query.register(purchase)){
				JOptionPane.showMessageDialog(null, "Compra guardado");
			}else {
				JOptionPane.showMessageDialog(null, "Ha ocurrido un error. Debe anadir numero del producto, proveedor, cantidad y costo individual.");

			}
		}
		//Search button
		if(e.getSource() == frame.btnBuscar){
			purchase.setIdcompra(Integer.parseInt(frame.txtIdCompra.getText()));
			if(query.search(purchase)){
				
				frame.txtIdCompra.setText(String.valueOf(purchase.getIdcompra()));
				frame.txtIdProducto.setText(purchase.getIdproducto()+"");
				frame.txtProveedor.setText(purchase.getProveedor()+"");
				frame.txtCantidad.setText(String.valueOf(purchase.getCantidad()));
				frame.txtCostoIndividual.setText(String.valueOf(purchase.getCostoIndividual()));
				frame.txtCostoTotal.setText(String.valueOf(purchase.getCostoTotal()));
				
			}else {
				JOptionPane.showMessageDialog(null, "Compra no existente");
			}
		}

	}
	
	//method for cleaning the boxes
	public void clean(){
		frame.txtIdCompra.setText(null);
		frame.txtIdProducto.setText(null);
		frame.txtProveedor.setText(null);
		frame.txtCantidad.setText(null);
		frame.txtCostoIndividual.setText(null);
		frame.txtCostoTotal.setText(null);
	}
	
}
