package dto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import beans.Cliente;

public class clienteDaoImpl  implements clienteDao{
	
	private static final String SQL_SELECT = "SELECT idclientes,nombre, apellido,email,telefono,saldo FROM clientes";
	private static final String SQL_SELECT_ID  = "SELECT idclientes,nombre, apellido,email,telefono,saldo FROM clientes where idclientes = ?";
	private static final String SQL_INSERT = "INSERT INTO clientes (nombre, apellido,email,telefono,saldo) VALUES(?,?,?,?,?)";
	private static final String SQL_UPDATE = "UPDATE clientes SET nombre = ?, apellido = ?,email=?,telefono = ?,saldo= ? where idclientes = ? ";
	private static final String SQL_DELETE = "DELETE from  clientes WHERE idclientes = ?";
	
	
	@Override
	public List<Cliente> listar() {
		Connection cn = null;
		PreparedStatement st = null;
		ResultSet rs = null;
		List<Cliente> cliente = new ArrayList();
		
		try {
			cn = Conexion.conectar();
		    st = cn.prepareStatement(SQL_SELECT);
		    rs = st.executeQuery();
		    while(rs.next()) {
		    	
		    	
		    	
		    Cliente cl = new Cliente();
		    cl.setIdcliente(rs.getInt("idclientes"));
		    cl.setNombre(rs.getString("nombre"));
		    cl.setApellido(rs.getString("apellido"));
		    cl.setEmail(rs.getString("email"));
		    cl.setTelefono(rs.getString("telefono"));
		    cl.setSaldo(rs.getDouble("saldo"));
		    
		    cliente.add(cl);
		   
		    }
		    
			
		} catch (SQLException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace(System.out);
		}finally {
			Conexion.close(cn);
			Conexion.close(st);
			
		}
		return cliente;
		
	}
	
	
	@Override
	public Cliente encontrar(Cliente cl) {
		Connection cn = null;
		PreparedStatement st = null;
		ResultSet rs = null;
		 Cliente cls = new Cliente();
		
		try {
			cn = Conexion.conectar();
		    st = cn.prepareStatement(SQL_SELECT_ID);
		    st.setInt(1,cl.getIdcliente());
		    rs = st.executeQuery();
		    while (rs.next())
		    {
		    	 int id = rs.getInt("idclientes");
		    	 String nombre = rs.getString("nombre");
		    	 String apellido = rs.getString("apellido");
		    	 String email = rs.getString("email");
		    	 String tel   = rs.getString("telefono");
		    	 Double saldo =  rs.getDouble("saldo");
		    	 cls.setIdcliente(id);
		    	 cls.setNombre(nombre);
		    	 cls.setApellido(apellido);
		    	 cls.setEmail(email);
		    	 cls.setTelefono(tel);
		    	 cls.setSaldo(saldo);
				
		    }
		   
		    
		} catch (SQLException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("no se encontro datos");
		}finally {
			Conexion.close(cn);
			Conexion.close(st);
		}
		
		return cls;
		
		
	}
	

	
	
	@Override
	public int insert(Cliente cl) {
		Connection cn = null;
		PreparedStatement st = null;
		int row = 0;
		try {
			cn = Conexion.conectar();
			st = cn.prepareStatement(SQL_INSERT);
			st.setString(1, cl.getNombre());
			st.setString(2,cl.getApellido());
			st.setString(3, cl.getEmail());
			st.setString(4, cl.getTelefono());
			st.setDouble(5, cl.getSaldo());
	
			 row = st.executeUpdate();
			
		} catch (SQLException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			Conexion.close(cn);
			Conexion.close(st);
		}
		
		return row;
		
	}
	
	
	@Override
	public int update(Cliente cl) {
		Connection cn = null;
		PreparedStatement st = null;
		int row = 0;
		
	    try {
			cn = Conexion.conectar();
			st = cn.prepareStatement(SQL_UPDATE);
			st.setString(1, cl.getNombre());
			st.setString(2, cl.getApellido());
			st.setString(3, cl.getEmail());
			st.setString(4, cl.getTelefono());
			st.setDouble(5, cl.getSaldo());
			st.setInt(6, cl.getIdcliente());
			row = st.executeUpdate();
			System.out.println("actualizado");
		} catch (SQLException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			Conexion.close(cn);
			Conexion.close(st);
		}
		
		
		return row;
		
	}


	@Override
	public int delete(Cliente cl) {
		
		Connection cn = null;
		PreparedStatement st = null;
		int row = 0;
		
		try {
			cn = Conexion.conectar();
			st  = cn.prepareStatement(SQL_DELETE);
			st.setInt(1, cl.getIdcliente());
			row = st.executeUpdate();
			
		} catch (SQLException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			Conexion.close(cn);
			Conexion.close(st);
		}
		
	return row;	
	}
		
	
	

}
