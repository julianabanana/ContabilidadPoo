package Control;

import java.awt.event.*;
import javax.swing.*;
import Graphic.FrameClient;

//for detecting a button being press,send the text boxes content

public class ConClient implements ActionListener{
	
	private Client client;
	private ConsultClient query;
	private FrameClient frame;
	
	
	//constructor
	public ConClient(Client client, ConsultClient query, FrameClient frame) {
		
		this.client = client;
		this.query = query;
		this.frame = frame;
		this.frame.btnModificar.addActionListener(this);
		this.frame.btnBuscar.addActionListener(this);
		this.frame.btnAnadir.addActionListener(this);
		this.frame.btnEliminar.addActionListener(this);
		
	}
	//method for initializing the view (title and location)
	public void start() {
		frame.setTitle("Cientes");
		frame.setLocationRelativeTo(null);
	}
	
	//methods that listen to the clicks (events)
	public void actionPerformed(ActionEvent e){
		//Adding button
		if(e.getSource() == frame.btnAnadir){
			client.setNombre(frame.txtNombre.getText());
			client.setDireccion(frame.txtDireccion.getText());
			client.setAt(frame.txtAt.getText());
			clean();
			if(query.register(client)){
				JOptionPane.showMessageDialog(null, "Nuevo cliente guardado");
			}else {
				JOptionPane.showMessageDialog(null, "Ha ocurrido un error. Debe anadir nombre, direccion y una cuenta de correo o red social.");

			}
		}
		//Modify button
		if(e.getSource() == frame.btnModificar){
			client.setId(Integer.parseInt(frame.txtIdCliente.getText()));
			client.setNombre(frame.txtNombre.getText());
			client.setDireccion(frame.txtDireccion.getText());
			client.setAt(frame.txtAt.getText());
			clean();
			if(query.register(client)){
				JOptionPane.showMessageDialog(null, "Nueva informacion guardada");
			}else {
				JOptionPane.showMessageDialog(null, "Ha ocurrido un error. Debe anadir id, nombre, direccion y una cuenta de correo o red social.");
			}
		}
		//Delete button
		if(e.getSource() == frame.btnEliminar){
			client.setId(Integer.parseInt(frame.txtIdCliente.getText()));
			clean();
			if(query.delete(client)){					
				JOptionPane.showMessageDialog(null, "Cliente eliminado");
			}else {
				JOptionPane.showMessageDialog(null, "Ha ocurrido un error. Debe anadir id.");
			}
		}
		//Search button
		if(e.getSource() == frame.btnBuscar){
			client.setNombre(frame.txtNombre.getText());
			if(query.search(client)){
				
				frame.txtIdCliente.setText(String.valueOf(client.getId()));
				frame.txtNombre.setText(client.getNombre());
				frame.txtDireccion.setText(client.getDireccion());
				frame.txtAt.setText(client.getAt());
				
			}else {
				JOptionPane.showMessageDialog(null, "Cliente no registrado");
			}
		}

	}
	
	//method for cleaning the boxes
	public void clean(){
		frame.txtIdCliente.setText(null);
		frame.txtNombre.setText(null);
		frame.txtDireccion.setText(null);
		frame.txtAt.setText(null);
	}
	
}
