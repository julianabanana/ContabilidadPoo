/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
        String sql="INSERT INTO ventas (idcliente,idproducto,costo,cantidad) VALUES (?,?,?,?)";
        try {
            statement= c.prepareStatement(sql);
            statement.setInt(1,sale.getIdcliente());
            statement.setInt(2,sale.getIdproducto());
            statement.setFloat(3,sale.getCosto());
            statement.setInt(4,sale.getCantidad());
            quantity(sale);
            transaction(sale);
            statement.execute();
            return true;
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
    public boolean search(Sale sale){
        PreparedStatement statement;
        ResultSet rs;
        Connection c= getConexion();
        String sql="SELECT * FROM venta WHERE idventa=?";
        try {
            statement =c.prepareStatement(sql);
            statement.setInt(1, sale.getIdventa());
            rs=statement.executeQuery();
            if(rs.next()){
                sale.setCantidad(rs.getInt("cantidad"));
                sale.setCosto(rs.getFloat("costo"));
                sale.setIdproducto(rs.getInt("idproducto"));
                sale.setIdcliente(rs.getInt("idcliente"));
                return true;
            }
            return false;
        } catch (SQLException ex) {
            Logger.getLogger(ConsultSale.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }finally{
            try{
                c.close();
            }catch(SQLException e){
                System.out.println(e);
            }
        }
        
    }
    public boolean modify(Sale sale, int amount){
        PreparedStatement ps;
        Connection c=getConexion();
        String sql="UPDATE inventario SET cantidad=? WHERE idproducto=?";
        try {
            ps=c.prepareStatement(sql);
            ps.setInt(1, amount);
            ps.execute();

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
        String sql="SELECT * FROM inventario WHERE idproducto=?";
        try {
            statement=c.prepareStatement(sql);
            statement.setInt(1,sale.getIdproducto());
            rs=statement.executeQuery();
            if(rs.next() ){
                modify(sale,rs.getInt("cantidad")-q);
                return true;
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
        String sql="INSTER INTO contabilidad (tipo, neto, ganancia, fecha) VALUES";
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
