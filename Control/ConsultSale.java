package Control;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
public class ConsultSale extends Conexion{   
    public boolean register(Sale sale){
        
        PreparedStatement statement;
        Connection c=getConexion();
        String sql="INSERT INTO Ventas (idcliente,idproducto,costo,cantidad) VALUES (?,?,?,?)";
        try {
            statement= c.prepareStatement(sql);
            statement.setInt(1,sale.getIdcliente());
            statement.setInt(2,sale.getIdproducto());
            statement.setFloat(3,sale.getCosto());
            statement.setInt(4,sale.getCantidad());
            if(quantity(sale) &&   transaction(sale)){
                statement.execute();
                return true;
            }
            return false;
        } catch (SQLException ex) {
            Logger.getLogger(ConsultSale.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }finally {
            try {
		c.close();
            }catch(SQLException e) {
		System.err.println(e);
            }
	}
        
    }
    public boolean modify(Sale sale, int amount){
        PreparedStatement ps;
        Connection c=getConexion();
        String sql="UPDATE Inventario SET cantidad=? WHERE idproducto=?";
        try {
            ps=c.prepareStatement(sql);
            ps.setInt(1, amount);
            ps.setInt(2,sale.getIdproducto());
            ps.executeUpdate();
            
            return true;
        } catch (SQLException ex) {
            System.err.println(ex);
            return false;
        }finally {
           try {
		c.close();
            }catch(SQLException e) {
		System.err.println(e);
		}
            } 
            
    }
    public boolean quantity(Sale sale){
        
        PreparedStatement statement;
        ResultSet rs;
        Connection c=getConexion();
        int q=sale.getCantidad();
        String sql="SELECT * FROM Inventario WHERE idproducto=?";
        try {
            statement=c.prepareStatement(sql);
            statement.setInt(1,sale.getIdproducto());
            rs=statement.executeQuery();
            if(rs.next() ){
                if(rs.getInt("cantidad")>=q){
                    modify(sale,rs.getInt("cantidad")-q);
                    return true;
                }
            }
            return false;
        } catch (SQLException ex) {
            System.out.println(ex);
                return false;
        }finally{
            try {
        	c.close();

            }catch(SQLException e) {
		System.err.println(e);
		}
            }
        
        
    }
    public boolean transaction(Sale sale){
        Date date=new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("E dd MMM yyyy");  
	String strDate = formatter.format(date);
        PreparedStatement ps;
        Connection c=getConexion();
        String sql="INSERT INTO Contabilidad (tipo, neto, ganancia, fecha) VALUES (?,?,?,?)";
        try {
            
            ps=c.prepareStatement(sql);
            ps.setString(1,"venta");
            ps.setFloat(2,sale.getCosto() );
            ps.setFloat(3,sale.getCosto() );
            ps.setString(4,strDate);
            ps.execute();
            
            return true;
        } catch (SQLException e) {
            System.err.println(e);
            return false;
        }finally{
            try{
                c.close();
            }catch(SQLException e){
                System.err.println(e);
            }
        }
        
    }
}
