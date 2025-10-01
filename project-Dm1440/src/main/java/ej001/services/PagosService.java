package ej001.services;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import ej001.dao.ClientesDao;
import ej001.dao.PagosDao;
import ej001.model.Cliente;
import ej001.model.Pago;

public class PagosService extends Service {
	private ClientesDao daoC;
	private PagosDao daoP;

	public PagosService() {
		daoC = new ClientesDao();
		daoP = new PagosDao();
	}

	public Map<String, List<Pago>> obtenerMapa() throws PagosServiceException {
		Map<String, List<Pago>> mapaPagos = new HashMap<String, List<Pago>>();
		try (Connection conn = abrirConexionSakila()) {
			List<Cliente> listaClientes = daoC.obtenerCLientes(conn);
			for (Cliente cliente : listaClientes) {
				List<Pago> listaPagos = daoP.pagosCliente(conn, cliente.getId());
				mapaPagos.put(cliente.getEmail(), listaPagos);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new PagosServiceException("Error consultando clientes", e);
		}
		return mapaPagos;
	}

}
