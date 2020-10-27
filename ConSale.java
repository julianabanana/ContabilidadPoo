package Control;

import Graphic.FrameSales;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
public class ConSale implements ActionListener {
    private Sale sale;
    private ConsultSale query;
    private FrameSales frame;

    public ConSale(Sale sale, ConsultSale query, FrameSales frame) {
        this.sale = sale;
        this.query = query;
        this.frame = frame;
        this.frame.addALAnadirProducto(this);
        this.frame.addALGenerarVenta(this);
        
    }
    public void start(){
        frame.setTitle("Ventas");
        frame.setLocationRelativeTo(null);
    }
    public void actionPerformed(ActionEvent e){
        if(e.getSource()==frame.getBtnAnadirProducto()){
            sale.setCantidad(frame.getCantidadInput());
            
            sale.setIdcliente(frame.getIdcliente());
            sale.setIdproducto(frame.getIdproducto());
            sale.setCosto((new ConsultInventory()).getCosto(sale.getIdproducto())*sale.getCantidad());
            clean();
            if(query.register(sale)){
                frame.anadirATabla(sale);
                JOptionPane.showMessageDialog(null, "Objeto añadido exitosamente.");
                
            }else {
		JOptionPane.showMessageDialog(null, "Ha ocurrido un error. Debe registrar una cantidad, cliente y producto válido.");
		}
        }
        if(e.getSource()==frame.getBtnGenerarVenta()){
            cleanAll();
        }
    }
    public void clean(){
        frame.cleanLabels();
    }
    public void cleanAll(){
        frame.newSale();
    }

}
