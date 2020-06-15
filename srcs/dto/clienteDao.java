package dto;

import java.util.List;

import beans.Cliente;

public interface clienteDao {
	public List<Cliente> listar() ;
	public int insert(Cliente cl);
	public int  update(Cliente cl);
	public int delete(Cliente cl);
	public Cliente encontrar(Cliente cl);

}
