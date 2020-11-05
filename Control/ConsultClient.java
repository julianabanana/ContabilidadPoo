package Control;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ConsultClient extends Conexion {
	//methods that the form will call
	public boolean register(Client client) {
		
		PreparedStatement statement = null;
		Connection conex = getConexion();
		
		String sql = "INSERT  INTO Clientes (nombre,direccion,at) VALUES(?,?,?)";
		
		try {
			statement = conex.prepareStatement(sql);
			statement.setString(1, client.getNombre());
			statement.setString(2, client.getDireccion());
			statement.setString(3, client.getAt());
			statement.execute();
			return true;
		}catch(SQLException e) {
			System.err.println(e);
			return false;
			
		}finally {
                    close(conex);
                }
	}
	
	public boolean modify(Client client) {
		
		PreparedStatement statement = null;
		Connection conex = getConexion();
		
		String sql = "UPDATE Clientes SET nombre=?,direcion=?,at=? WHERE idcliente";
		
		try {
			statement = conex.prepareStatement(sql);
			statement.setInt(1, client.getId());
			statement.setString(2, client.getNombre());
			statement.setString(3, client.getDireccion());
			statement.setString(4, client.getAt());
			statement.execute();
			return true;
		}catch(SQLException e) {
			System.err.println(e);
			return false;
			
		}finally {
			close(conex);
			}
	}

	public boolean delete(Client client) {
		
		PreparedStatement statement = null;
		Connection conex = getConexion();
		
		String sql = "DELETE FROM Clientes WHERE idcliente=?";
		
		try {
			statement = conex.prepareStatement(sql);
			statement.setInt(1, (client.getId()));
			statement.execute();
			return true;
		}catch(SQLException e) {
			System.err.println(e);
			return false;
			
		}finally {
                    close(conex);
		}
	}
	
	public boolean search(Client client) {
		
		PreparedStatement statement = null;
		ResultSet res = null;
		Connection conex = getConexion();
		
		String sql = "SELECT * FROM Clientes WHERE nombre=?";
		
		try {
			statement = conex.prepareStatement(sql);
			statement.setString(1, client.getNombre());
			res = statement.executeQuery();
			
			if(res.next()){
				
				client.setId(Integer.parseInt(res.getString("idcliente")));
				client.setNombre(res.getString("nombre"));
				client.setDireccion(res.getString("direccion"));
				client.setAt(res.getString("at"));
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
        public int getIdcliente(String nombre){
            PreparedStatement statement;
            ResultSet rs;
	    Connection conex = getConexion();
		
            String sql = "SELECT * FROM clientes WHERE nombre=?";
            try {
                statement=conex.prepareStatement(sql);
                statement.setString(1, nombre);
                rs=statement.executeQuery();
                if(rs.next()){
                    
                    return rs.getInt("idcliente");
                    
                }
                
                return -1;
            } catch (SQLException ex) {
                Logger.getLogger(ConsultInventory.class.getName()).log(Level.SEVERE, null, ex);
                
                return -10;
            }finally{
                close(conex);
            }
        }
}
