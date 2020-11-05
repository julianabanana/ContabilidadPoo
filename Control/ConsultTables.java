
package Control;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ConsultTables extends Conexion{
    public ResultSet getRow(String table){
        Connection conex=getConexion();
        try {
            PreparedStatement statement;
            ResultSet rs; 
            String sql="SELECT * FROM "+table;
            statement=conex.prepareStatement(sql);
            rs=statement.executeQuery();
            
            
            return rs;
            
        } catch (SQLException ex) {
            Logger.getLogger(ConsultInventory.class.getName()).log(Level.SEVERE, null, ex);        
            return null;
        }finally{
            close(conex);
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
        Connection conex=getConexion();
        try {
            PreparedStatement statement;
            
            ResultSet rs;
            statement=conex.prepareStatement("SELECT SUM(costo) as ingresostotales FROM ventas");
            rs=statement.executeQuery();
            if(rs.next()){
                return rs.getDouble("ingresostotales");
            }
        } catch (SQLException ex) {
            Logger.getLogger(ConsultInventory.class.getName()).log(Level.SEVERE, null, ex);        
        }finally{
            close(conex);
        }
        return 0;
    }
    public int getUnidadesVendidas(int id){
        Connection conex=getConexion();
        try {
            PreparedStatement statement;
            
            ResultSet rs;
            statement=conex.prepareStatement("SELECT SUM(cantidad) as unidadesvendidas FROM ventas WHERE idproducto="+id);
            rs=statement.executeQuery();
            if(rs.next()){
                return rs.getInt("unidadesvendidas");
            }
        } catch (SQLException ex) {
            java.util.logging.Logger.getLogger(ConsultTables.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        finally{
            close(conex);
        }
        return 0;
    } 
    public double getGastoTotal(){
        Connection conex=getConexion();
        try {
            PreparedStatement statement;
            ResultSet rs;
            statement=conex.prepareStatement("SELECT SUM(costo) as gastototal FROM compras");
            rs=statement.executeQuery();
            if(rs.next()){
                return rs.getDouble("gastototal");
            }
        } catch (SQLException ex) {
            java.util.logging.Logger.getLogger(ConsultTables.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }finally{
            close(conex);
        }
        return 0;
    }
    public double getIngresoTotal(int id){
        Connection conex=getConexion();
        try {
            PreparedStatement statement;
            ResultSet rs;
            statement=conex.prepareStatement("SELECT SUM(costo) as ingresostotales FROM ventas WHERE idproducto="+id);
            rs=statement.executeQuery();
            if(rs.next()){
                return rs.getDouble("ingresostotales");
            }
        } catch (SQLException ex) {
            java.util.logging.Logger.getLogger(ConsultTables.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }finally{
            close(conex);
        }
        return 0;
    }
    public double getGastoTotal(int id){
        Connection conex=getConexion();
        try {
            PreparedStatement statement;
            
            ResultSet rs;
            statement=conex.prepareStatement("SELECT SUM(costo) as gastototal FROM compras WHERE idproducto="+id);
            rs=statement.executeQuery();
            if(rs.next()){
                return rs.getDouble("gastototal");
            }
        } catch (SQLException ex) {
            java.util.logging.Logger.getLogger(ConsultTables.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }finally{
            close(conex);
        }
        return 0;
    }
       
}


