package ej001.services;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Map;
import java.util.stream.Collectors;

import ej001.dao.ClientesDao;
import ej001.model.Cliente;

public class ClientesService extends Service {

	private ClientesDao dao;

	public ClientesService() {
		dao = new ClientesDao();
	}

	public Map<String, Cliente> obtenerMapa() throws ClienteException {
		try (Connection conn = abrirConexionSakila()) {
			return dao.obtenerCLientes(conn).stream().collect(Collectors.toMap(c -> c.getEmail(), c -> c));
		} catch (SQLException e) {
			e.printStackTrace();
			throw new ClienteException("Error consultando clientes", e);
		}
	}
}
