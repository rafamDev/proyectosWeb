package datos;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;
import org.apache.commons.dbcp2.BasicDataSource;


public class Conexion {
   private static final String URL = "jdbc:mysql://localhost:3306/control_clientes?allowPublicKeyRetrieval=true&useSSL=false&serverTimezone=Europe/Madrid";
   private static final String user = "root";
   private static final String password = "abc123";
    
    public static DataSource getDataSource(){
    	BasicDataSource ds = new BasicDataSource();
    	ds.setUrl(URL);
    	ds.setUsername(user);
    	ds.setPassword(password);
    	ds.setInitialSize(50);
	return ds;
    }

    public static Connection getConnection() throws SQLException {
        return getDataSource().getConnection();
    }
   
     
    public static void close(ResultSet rs){
    	try {
	   rs.close();
        } catch (SQLException e) {
	    e.printStackTrace();
	}
    }
    
    
    public static void close(PreparedStatement ps){
    	try {
	   ps.close();
	} catch (SQLException e) {
	   e.printStackTrace();
	}
    }
    
    public static void close(Connection con){
    	try {
	   con.close();
	} catch (SQLException e) {
	   e.printStackTrace();
	}
    }


}