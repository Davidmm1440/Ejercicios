package ejercicios.ejercicio02.services;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import ejercicios.ejercicio01.service.Service;
import ejercicios.ejercicio02.dao.ClienteDao;
import ejercicios.ejercicio02.model.Cliente;

public class ClientesService extends Service {

	private ClienteDao dao;
	
	public ClientesService() {
		dao = new ClienteDao();
	}
	
	public Map<String, Cliente> consultarClientes() throws ClientesException{
		try(Connection conn = abrirConexionSakila()){
			List<Cliente> lista = dao.selectAll(conn);
			return lista.stream().collect(Collectors.toMap(c -> c.getEmail(), c -> c));
		}
		catch(SQLException e) {
			throw new ClientesException("Error consultando clientes", e);
		}
	}
	
}
