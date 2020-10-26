package Control;

import java.sql.*;
//for getting date as a string
import java.text.ParseException;  
import java.text.SimpleDateFormat;  
import java.util.Date;  
import java.util.Locale;  


public class ConsultPurchase extends Conexion {
	
	//methods that the form will call
	public boolean register(Purchase purchase) {
		
		PreparedStatement statement = null;
		Connection conex = getConexion();
		
		String sql = "INSERT  INTO Compras (idproducto,cantidad,costo,proveedor) VALUES(?,?,?,?)";
		
		
		try {
			statement = conex.prepareStatement(sql);
			statement.setString(1, purchase.getIdproducto());
			statement.setInt(2, purchase.getCantidad());
			statement.setInt(3, purchase.getCostoTotal());
			statement.setString(4, purchase.getProveedor());
			quantity(purchase);
			transaction(purchase,purchase.getCostoTotal());
			statement.execute();
			return true;
		}catch(SQLException e) {
			System.err.println(e);
			return false;
			
		}finally {
			try {
				conex.close();
			}catch(SQLException e) {
				System.err.println(e);
				}
			}
	}
	
	

	
	public boolean search(Purchase purchase) {
		
		PreparedStatement statement = null;
		ResultSet res = null;
		Connection conex = getConexion();
		
		String sql = "SELECT * FROM Purchase WHERE idcompra=?";
		
		try {
			statement = conex.prepareStatement(sql);
			statement.setInt(1, purchase.getIdcompra());
			res = statement.executeQuery();
			
			if(res.next()){
				
				purchase.setIdcompra(res.getInt("idcompra"));
				purchase.setIdproducto(res.getString("idproducto"));
				purchase.setIdproducto(res.getString("nombre"));
				purchase.setCantidad(Integer.parseInt(res.getString("cantidad")));
				purchase.setCostoTotal2(Integer.parseInt(res.getString("costo")));
				purchase.setIdproducto(res.getString("proveedor"));
				return true;
			}
			
			return false;
			
		}catch(SQLException e) {
			System.err.println(e);
			return false;
			
		}finally {
			try {
				conex.close();
			}catch(SQLException e) {
				System.err.println(e);
				}
			}
	}
	public boolean quantity(Purchase purchase) {
		
		PreparedStatement statement = null;
		ResultSet res = null;
		Connection conex = getConexion();
		int purQuantity = purchase.getCantidad();
		
		String sql = "SELECT * FROM Inventario WHERE idproducto=?";
		
		try {
			statement = conex.prepareStatement(sql);
			statement.setString(1, purchase.getIdproducto());
			res = statement.executeQuery();
			System.out.println("producto encontrado");
			
			if(res.next()){
				
				modify(purchase, purQuantity+res.getInt("cantidad"));
				purchase.setIdproducto(res.getString("idproducto"));
				
				return true;
			}
			
			return false;
			
		}catch(SQLException e) {
			System.err.println(e);
			return false;
			
		}finally {
			try {
				conex.close();
			}catch(SQLException e) {
				System.err.println(e);
				}
			}
	}
	public boolean modify(Purchase purchase, int amount) {
		
		PreparedStatement statement = null;
		Connection conex = getConexion();
		String sql = "UPDATE Inventario SET cantidad=? WHERE idproducto";
		
		try {
			statement = conex.prepareStatement(sql);
			statement.setInt(1, amount);
			statement.execute();
			return true;
		}catch(SQLException e) {
			System.err.println(e);
			return false;
			
		}finally {
			try {
				conex.close();
			}catch(SQLException e) {
				System.err.println(e);
				}
			}
	}
	public boolean transaction(Purchase purchase, int amount) {
		
		Date date = new Date();
		SimpleDateFormat formatter = new SimpleDateFormat("E dd MMM yyyy");  
	    String strDate = formatter.format(date);
	    
		
		PreparedStatement statement = null;
		Connection conex = getConexion();
		
		String sql = "INSERT  INTO Contabilidad (tipo,neto,inversion,fecha) VALUES(?,?,?,?)";
		
		try {
			statement = conex.prepareStatement(sql);
			statement.setString(1, "compra");
			statement.setInt(2, purchase.getCostoTotal());
			statement.setInt(3, purchase.getCostoTotal());
			statement.setString(4, strDate);
			statement.execute();
			return true;
		}catch(SQLException e) {
			System.err.println(e);
			return false;
			
		}finally {
			try {
				conex.close();
			}catch(SQLException e) {
				System.err.println(e);
				}
			}
	}
}
