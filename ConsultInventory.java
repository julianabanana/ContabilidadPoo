package Control;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ConsultInventory extends Conexion{
	
	//methods that the form will call
        public static void close(Connection conex){
            try {
		conex.close();
            }catch(SQLException e) {
		System.err.println(e);
            }
	
        }
		public boolean register(Inventory inventory) {
		
		PreparedStatement statement ;
		Connection conex = getConexion();
		
		String sql = "INSERT  INTO Inventario (nombre,cantidad,precio) VALUES(?,?,?)";
			
		try {
			statement = conex.prepareStatement(sql);
			statement.setString(1, inventory.getNombre());
			statement.setInt(2, inventory.getCantidad());
			statement.setInt(3, inventory.getPrecio());
			statement.execute();
			return true;
		}catch(SQLException e) {
			System.out.println("Error anadiendo al inventario");
			System.err.println(e);
			return false;
		}finally {
                    close(conex);
                }
	}
	public boolean search(Inventory inventory) {
		
		PreparedStatement statement = null;
		ResultSet res = null;
		Connection conex = getConexion();
		
		String sql = "SELECT * FROM Inventario WHERE nombre=?";
		
		try {
			statement = conex.prepareStatement(sql);
			statement.setString(1, inventory.getNombre());
			res = statement.executeQuery();
			
			if(res.next()){
				
				inventory.setIdproducto(Integer.parseInt(res.getString("idproducto")));
				inventory.setNombre(res.getString("nombre"));
				inventory.setCantidad(res.getInt("cantidad"));
				return true;
			}
			
			return false;
			
		}catch(SQLException e) {
			System.err.println(e);
			return false;
		}finally {
                    close(conex);
                }
	}
	public boolean delete(Inventory inventory) {
		
		PreparedStatement statement ;
		Connection conex = getConexion();
		
		String sql = "DELETE FROM Inventario WHERE nombre=?";
		
		try {
			statement = conex.prepareStatement(sql);
			statement.setString(1, (inventory.getNombre()));
			statement.execute();
			return true;
		}catch(SQLException e) {
			System.err.println(e);
			return false;
		}finally {
			close(conex);
			}
	}
        public int getIdproducto(String nombre){
            PreparedStatement statement;
            ResultSet rs;
	    Connection conex = getConexion();
		
            String sql = "SELECT * FROM Inventario WHERE nombre=?";
            try {
                statement=conex.prepareStatement(sql);
                statement.setString(1, sql);
                rs=statement.executeQuery();
                if(rs.next()){
                    return rs.getInt("idproducto");
                }
                return -1;
            } catch (SQLException ex) {
                Logger.getLogger(ConsultInventory.class.getName()).log(Level.SEVERE, null, ex);
                return -1;
            }finally{
                close(conex);
            }
        }
	
}
