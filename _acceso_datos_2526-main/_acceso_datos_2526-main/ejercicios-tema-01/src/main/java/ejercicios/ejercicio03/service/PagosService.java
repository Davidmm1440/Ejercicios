package ejercicios.ejercicio03.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import ejercicios.ejercicio01.service.Service;
import ejercicios.ejercicio02.dao.ClienteDao;
import ejercicios.ejercicio02.model.Cliente;
import ejercicios.ejercicio02.services.ClientesException;
import ejercicios.ejercicio03.dao.PagosDao;
import ejercicios.ejercicio03.model.Pago;

public class PagosService extends Service{

	private PagosDao daoPagos;
	private ClienteDao daoClientes;
	
	public PagosService() {
		daoPagos = new PagosDao();
		daoClientes = new ClienteDao();
	}

	public Map<String, List<Pago>> consultarPagosClientes() throws ClientesException{
		Map<String, List<Pago>> mapa = new HashMap<>();
		
		try(Connection conn = abrirConexionSakila()){
			
			List<Cliente> clientes = daoClientes.selectAll(conn);
			
			for (Cliente cliente : clientes) {
				List<Pago> pagosCliente = daoPagos.selectByCustomer(conn, cliente.getId());
				
				mapa.put(cliente.getEmail(), pagosCliente);
			}
			return mapa;
		}
		catch(SQLException e) {
			throw new ClientesException("Error consultando pagos cliente", e);
		}
		
		
	}
	
	
	
	
}
