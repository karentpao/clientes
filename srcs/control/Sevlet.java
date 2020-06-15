package control;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import beans.Cliente;
import dto.Conexion;
import dto.clienteDaoImpl;


@WebServlet("/servlet")
public class Sevlet extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       
		String accion = request.getParameter("accion");
		if(accion != null) {	
			switch(accion){
			
			case "editar":
				this.encontrarUno(request, response);
				break;
			case "eliminar":
				 String id = request.getParameter("idcliente");
				 this.eliminar(request, response, id);
				
				break;
			default:
				
				this.listardfault(request, response);
			}
		}else {
		
			this.listardfault(request, response);
		}
		

	}
	

	private void listardfault(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		 clienteDaoImpl cli = new clienteDaoImpl();
		  List<Cliente> list = cli.listar();
		  double valor = 0;
		  HttpSession sesion = request.getSession();
			sesion.setAttribute("lis", list);
			sesion.setAttribute("totalClientes", list.size());
			for(Cliente c : list) {
			 valor = valor + c.getSaldo();
			}
			
			sesion.setAttribute("saldoTotal", valor);
			response.sendRedirect("listar.jsp");
					
		
	}
	
	
	@Override
	 protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
		HttpSession sesion = req.getSession();
		String accion = req.getParameter("accion"); 
		String idcli = req.getParameter("idCliente");
	
		int row = 0;
		if(accion != null) {	
			switch(accion){
			
			case "insertar":
				 row = this.insertarClientes(req, resp);
				 this.listardfault(req, resp);
				
				break;
		    
			case "actualizar":
				row = this.editarClientes(req, resp,idcli);
				if(row > 0) {
				this.listardfault(req, resp);
				}
				break;
			
			default:
				
				this.listardfault(req, resp);
			}
		}else {
		
			this.listardfault(req, resp);
		}
		
    
      
		
		}
	
	
	private int  insertarClientes(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String nombre = req.getParameter("nombre");
		String apellido = req.getParameter("apellido");
		String email = req.getParameter("email");
		String tele = req.getParameter("telefono");
		String saldo = req.getParameter("saldo");
		double sal = 0;
		clienteDaoImpl cl = new clienteDaoImpl();
	
			sal = Double.parseDouble(saldo);
		
		Cliente cn = new Cliente(nombre,apellido,email,tele,sal);
		
		int result = cl.insert(cn);
	
		return result;
		
		}
	
	
	private void encontrarUno(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int id = Integer.parseInt(req.getParameter("idcliente"));
		
		Cliente  cliente = new clienteDaoImpl().encontrar( new Cliente(id));
		
		req.setAttribute("Cliente", cliente);
		req.getRequestDispatcher("editar.jsp").forward(req, resp);
		
		
	}
	
private int editarClientes(HttpServletRequest req, HttpServletResponse resp,String idcli) throws ServletException, IOException {
        int id = Integer.parseInt(idcli);
       
		String nombre = req.getParameter("nombre");
		String apellido = req.getParameter("apellido");
		String email = req.getParameter("email");
		String tele = req.getParameter("telefono");
		String saldo = req.getParameter("saldo");
		double sal = 0 ;
		clienteDaoImpl cl = new clienteDaoImpl();
	       
		if(saldo != null) {
			sal = Double.parseDouble(saldo);
		}
		
		Cliente cn = new Cliente(id,nombre,apellido,email,tele,sal);
		System.out.println(idcli +nombre);
		
		int result = cl.update(cn);

		
		return result;
		}
	
	private void eliminar(HttpServletRequest req, HttpServletResponse resp,String idcli) throws IOException, ServletException {
		
		 int id = Integer.parseInt(idcli);
		 int cn = new clienteDaoImpl().delete(new Cliente(id));
		 
		 try {
			try {
				if(cn > 0)
				 {
					this.listardfault(req, resp);
					 System.out.println("fila eliminada");
				 }else {
					System.out.println("error");
				 }
			} catch (ServletException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 
	}
	
	
	
		
	

}
