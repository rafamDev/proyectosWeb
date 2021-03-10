package datos;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dominio.Cliente;
import java.sql.ResultSet;


public class ClienteDaoJDBC {
	
	public ClienteDaoJDBC(){}

	private static final String SQL_SELECT = "SELECT * FROM cliente";
	
	private static final String SQL_SELECT_BY_ID = "SELECT * FROM cliente WHERE id_cliente=?";
	
	private static final String SQL_INSERT = "INSERT INTO cliente (nombre,apellido,email,telefono,saldo)"
			+ "VALUES (?,?,?,?,?)";
			
	private static final String SQL_UPDATE = "UPDATE cliente SET nombre=?, apellido=?, email=?, telefono=?, saldo=?"
			+ "WHERE id_cliente=?";
			
	private static final String SQL_DELETE = "DELETE FROM cliente WHERE id_cliente=?";
	
	
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
                    int id_cliente = rs.getInt("id_cliente");
		    String nombre = rs.getString("nombre");
	            String apellido = rs.getString("apellido");
		    String email = rs.getString("email");
		    String telefono = rs.getString("telefono");
		    double saldo = rs.getDouble("saldo");
                    cliente = new Cliente(id_cliente,nombre,apellido,email,telefono,saldo);
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
	   java.sql.ResultSet rs = null;
	      try {
		con = Conexion.getConnection();
		ps = con.prepareStatement(SQL_SELECT_BY_ID);
		ps.setInt(1, cliente.getId_cliente());
		rs = ps.executeQuery();
		rs.absolute(1);
                String nombre = rs.getString("nombre");
		String apellido = rs.getString("apellido");
		String email = rs.getString("email");
		String telefono = rs.getString("telefono");
		double saldo = rs.getDouble("saldo");
		cliente.setNombre(nombre);
		cliente.setApellido(apellido);
		cliente.setEmail(email);
		cliente.setTelefono(telefono);
		cliente.setSaldo(saldo);
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
		ps.setString(2, cliente.getApellido());
		ps.setString(3, cliente.getEmail());
		ps.setString(4, cliente.getTelefono());
		ps.setDouble(5, cliente.getSaldo());
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
	    ps.setString(2, cliente.getApellido());
	    ps.setString(3, cliente.getEmail());
	    ps.setString(4, cliente.getTelefono());
	    ps.setDouble(5, cliente.getSaldo());
	    ps.setInt(6, cliente.getId_cliente());
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
		ps.setInt(1, cliente.getId_cliente());
		rows = ps.executeUpdate();
		} catch (SQLException e) {
		e.printStackTrace();
		} finally {
		Conexion.close(ps);
		Conexion.close(con);
	        }
	 return rows;     
	}
	
	
}

