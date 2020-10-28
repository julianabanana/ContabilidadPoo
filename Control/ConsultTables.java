
package Control;
import java.lang.System.Logger;
import java.lang.System.Logger.Level;
import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
        /**
 *
 * @author jczam
 */
public class ConsultTables extends Conexion{
    public ResultSet getRow(String table){
        try {
            PreparedStatement statement;
            Connection conex=getConexion();
            ResultSet rs; 
            String sql="SELECT * FROM "+table;
            statement=conex.prepareStatement(sql);
            rs=statement.executeQuery();
            return rs;
        } catch (SQLException ex) {
            java.util.logging.Logger.getLogger(ConsultTables.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
            return null;
        }
    } 
    public ResultSet getRowsInventory(){
        return getRow("inventario");  
    }
    public ResultSet getRowsInventoryByPrecio(){
        return getRow("Inventario ORDER BY precio DESC;");
    }
    public double getIngresoTotal(){
        try {
            PreparedStatement statement;
            Connection conex=getConexion();
            ResultSet rs;
            statement=conex.prepareStatement("SELECT SUM(costo) as ingresostotales FROM ventas");
            rs=statement.executeQuery();
            if(rs.next()){
                return rs.getDouble("ingresostotales");
            }
        } catch (SQLException ex) {
            java.util.logging.Logger.getLogger(ConsultTables.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        return 0;
    }
    public int getUnidadesVendidas(int id){
        try {
            PreparedStatement statement;
            Connection conex=getConexion();
            ResultSet rs;
            statement=conex.prepareStatement("SELECT SUM(cantidad) as unidadesvendidas FROM ventas WHERE idproducto="+id);
            rs=statement.executeQuery();
            if(rs.next()){
                return rs.getInt("unidadesvendidas");
            }
        } catch (SQLException ex) {
            java.util.logging.Logger.getLogger(ConsultTables.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        return 0;
    } 
    public double getGastoTotal(){
        try {
            PreparedStatement statement;
            Connection conex=getConexion();
            ResultSet rs;
            statement=conex.prepareStatement("SELECT SUM(costo) as gastototal FROM compras");
            rs=statement.executeQuery();
            if(rs.next()){
                return rs.getDouble("gastototal");
            }
        } catch (SQLException ex) {
            java.util.logging.Logger.getLogger(ConsultTables.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        return 0;
    }
    public double getIngresoTotal(int id){
        try {
            PreparedStatement statement;
            Connection conex=getConexion();
            ResultSet rs;
            statement=conex.prepareStatement("SELECT SUM(costo) as ingresostotales FROM ventas WHERE idproducto="+id);
            rs=statement.executeQuery();
            if(rs.next()){
                return rs.getDouble("ingresostotales");
            }
        } catch (SQLException ex) {
            java.util.logging.Logger.getLogger(ConsultTables.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        return 0;
    }
    public double getGastoTotal(int id){
        try {
            PreparedStatement statement;
            Connection conex=getConexion();
            ResultSet rs;
            statement=conex.prepareStatement("SELECT SUM(costo) as gastototal FROM compras WHERE idproducto="+id);
            rs=statement.executeQuery();
            if(rs.next()){
                return rs.getDouble("gastototal");
            }
        } catch (SQLException ex) {
            java.util.logging.Logger.getLogger(ConsultTables.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        return 0;
    }
       
}


