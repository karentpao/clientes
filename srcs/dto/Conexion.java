package dto;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.resource.cci.ResultSet;
import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;

public class Conexion {
	private static final String url ="jdbc:mysql://localhost:3306/control_clientes?useSSL=false&serverTimezone=UTC";
	private static final String user= "root";
	private static final String pass ="password";
	
	/**
	 * configurar pool de conexiones
	 * @return
	 * @throws ClassNotFoundException 
	 */
	

	public static Connection conectar() throws SQLException, ClassNotFoundException{
		Class.forName("com.mysql.cj.jdbc.Driver");
		return DriverManager.getConnection(url, user, pass);
		
}
	
	
	public static void close(ResultSet re) {
		try {
			re.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace(System.out);
		}
		
	}
	
	public static void close(PreparedStatement stat) {
		try {
			stat.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace(System.out);
		}
		
	}

	public static void close(Connection cn) {
		try {
			cn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace(System.out);
		}
		
	}
	

}
