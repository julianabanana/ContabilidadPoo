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
                if(sale.getCantidad()>0){
                sale.setIdcliente(frame.getIdcliente());
                sale.setIdproducto(frame.getIdproducto());
                sale.setCosto((new ConsultInventory()).getCosto(sale.getIdproducto())*sale.getCantidad());
                if(query.register(sale)){
                    frame.setTotal(sale.getCosto());
                    frame.anadirATabla(frame.getNameProducto(),sale);
                    JOptionPane.showMessageDialog(null, "Objeto añadido exitosamente.");

                }else {
                    JOptionPane.showMessageDialog(null, "Ha ocurrido un error. Debe registrar una cantidad, cliente y producto válido.");
                }
            }else{
                JOptionPane.showMessageDialog(null, "Ha ocurrido un error. Debe registrar una cantidad válida.");
            }
            frame.cleanLabels();
        }
        if(e.getSource()==frame.getBtnGenerarVenta()){
            frame.newSale();
            JOptionPane.showMessageDialog(null, "Venta realizada correctamente");
        }
    }
    

}
