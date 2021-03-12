
package modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import pojo.Cliente;

public class ClienteDAO {

    public ClienteDAO(){}
   
    private static final String SQL_SELECT = "SELECT * FROM cliente";
	
    private static final String SQL_SELECT_BY_ID = "SELECT * FROM cliente WHERE codigo=?";
	
    private static final String SQL_INSERT = "INSERT INTO cliente (nombre,password,apellido,email,telefono,provincia,localidad,direccion)"
			+ "VALUES (?,?,?,?,?,?,?,?)";
			
    private static final String SQL_UPDATE = "UPDATE cliente SET nombre=?, password=?, apellido=?, email=?, telefono=?, provincia=?, localidad=?, direccion=? "
			+ "WHERE codigo=?";
			
    private static final String SQL_DELETE = "DELETE FROM cliente WHERE codigo=?";
   
    public List<Cliente> listar(){
	Connection con = null;
	PreparedStatement ps = null;
	ResultSet rs = null;
	Cliente cliente = null;
	List<Cliente> clientes = new ArrayList<Cliente>();
	    try {
		con = Conexion.getConnection();
		ps =  con.prepareStatement(SQL_SELECT);
		rs = ps.executeQuery();
		while(rs.next()){
                    int codigo = rs.getInt("codigo");
		    String nombre = rs.getString("nombre");
	            String password = rs.getString("password");
                    String apellido = rs.getString("apellido");
		    String email = rs.getString("email");
		    String telefono = rs.getString("telefono");
		    String provincia = rs.getString("provincia");
		    String localidad = rs.getString("localidad");
                    String direccion = rs.getString("direccion");
                    cliente = new Cliente(codigo,nombre,password,apellido,email,telefono,provincia,localidad,direccion);
		    clientes.add(cliente);
                }
		} catch (SQLException e) {
	    	e.printStackTrace();
		} finally {
			Conexion.close(rs);
			Conexion.close(ps);
			Conexion.close(con);
		}
	   return clientes;
	}
	
    public Cliente encontrar(Cliente cliente){
	Connection con = null;
	PreparedStatement ps = null;
	ResultSet rs = null;
	    try {
		con = Conexion.getConnection();
		ps = con.prepareStatement(SQL_SELECT_BY_ID);
		ps.setInt(1, cliente.getCodigo());
		rs = ps.executeQuery();
		rs.absolute(1);
                String nombre = rs.getString("nombre");
                String password = rs.getString("password");
	        String apellido = rs.getString("apellido");
		String email = rs.getString("email");
		String telefono = rs.getString("telefono");
		String provincia = rs.getString("provincia");
	        String localidad = rs.getString("localidad");
                String direccion = rs.getString("direccion");
		cliente.setNombre(nombre);
                cliente.setPassword(password);
		cliente.setApellido(apellido);
		cliente.setEmail(email);
		cliente.setTelefono(telefono);
		cliente.setProvincia(provincia);
                cliente.setLocalidad(localidad);
                cliente.setDireccion(direccion);
		} catch (SQLException e) {
		  e.printStackTrace();
		} finally {
		Conexion.close(rs);
                Conexion.close(ps);
		Conexion.close(con);
		}
	return cliente;
    }
	
	public int insertar(Cliente cliente){
          Connection con = null;
	  PreparedStatement ps = null;
	  int rows = 0;
	     try {
		con = Conexion.getConnection();
		ps = con.prepareStatement(SQL_INSERT);
		ps.setString(1, cliente.getNombre());
                ps.setString(2, cliente.getPassword());
		ps.setString(3, cliente.getApellido());
		ps.setString(4, cliente.getEmail());
		ps.setString(5, cliente.getTelefono());
                ps.setString(6, cliente.getProvincia());
                ps.setString(7, cliente.getLocalidad());
                ps.setString(8, cliente.getDireccion());
		rows = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
		   Conexion.close(ps);
		   Conexion.close(con);
		}
	   return rows;     
	}
	
	public int actualizar(Cliente cliente){
	  Connection con = null;
	  PreparedStatement ps = null;
	  int rows = 0;
	   try {
	    con = Conexion.getConnection();
	    ps = con.prepareStatement(SQL_UPDATE);
	    ps.setString(1, cliente.getNombre());
            ps.setString(2, cliente.getPassword());
	    ps.setString(3, cliente.getApellido());
	    ps.setString(4, cliente.getEmail());
	    ps.setString(5, cliente.getTelefono());
	    ps.setString(6, cliente.getProvincia());
	    ps.setString(7, cliente.getLocalidad());
            ps.setString(8, cliente.getDireccion());
            ps.setInt(9, cliente.getCodigo());
	    rows = ps.executeUpdate();
		} catch (SQLException e) {
			 e.printStackTrace();
		} finally {
			Conexion.close(ps);
			Conexion.close(con);
		}
	 return rows;     
	}
        
    public int eliminar(Cliente cliente){
	Connection con = null;
	PreparedStatement ps = null;
	int rows = 0;
		try {
	        con = Conexion.getConnection();
		ps = con.prepareStatement(SQL_DELETE);
		ps.setInt(1, cliente.getCodigo());
		rows = ps.executeUpdate();
		} catch (SQLException e) {
		e.printStackTrace();
		} finally {
		Conexion.close(ps);
		Conexion.close(con);
	        }
	 return rows;     
	}    

    public boolean verficarCliente(String nombre, String password){
     Connection con = null;
     ResultSet rs = null; 
     PreparedStatement ps = null;
     String query = "SELECT * FROM cliente WHERE nombre=? && password=?";
        try {  
            con = Conexion.getConnection();
            ps = con.prepareStatement(query);
            ps.setString(1,nombre);
            ps.setString(2,password);
            rs = ps.executeQuery();
              while(rs.next()){
                 if(rs.getString("nombre").equalsIgnoreCase(nombre) && rs.getString("password").equalsIgnoreCase(password)){
                    return true;
                 }
              }
        } catch (SQLException ex) {
           Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
     return false; 
   }      

}
