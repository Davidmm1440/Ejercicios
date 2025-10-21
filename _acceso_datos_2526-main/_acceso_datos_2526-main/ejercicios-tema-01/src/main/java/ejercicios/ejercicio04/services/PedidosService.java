package ejercicios.ejercicio04.services;

import java.sql.Connection;
import java.sql.SQLException;

import ejercicios.ejercicio01.service.Service;
import ejercicios.ejercicio04.dao.LineaPedidoDao;
import ejercicios.ejercicio04.dao.PedidosDao;
import ejercicios.ejercicio04.modelo.Pedido;
import ejercicios.ejercicio04.modelo.PedidoLinea;

public class PedidosService extends Service{

	private LineaPedidoDao daoLinea;
	private PedidosDao daoPedido;
	
	public PedidosService() {
		daoLinea = new LineaPedidoDao();
		daoPedido = new PedidosDao();
	}
	
	public void registrarPedido(Pedido pedido) throws PedidoException {
		try(Connection conn = abrirConexionPedidos()){
			conn.setAutoCommit(false);
			try {
				Long id = daoPedido.insert(conn, pedido);
				Integer numLinea = 1;
				for (PedidoLinea linea : pedido.getLineas()) {
					linea.setIdPedido(id);
					linea.setNumLinea(numLinea);
					numLinea++;
					daoLinea.insert(conn, linea);
				}
				conn.commit();
			}
			catch(SQLException e) {
				conn.rollback();
				throw e;
			}
			
			
		}
		catch(SQLException e) {
			throw new PedidoException("Error creando pedido", e);
		}
		
		
		
	}
	
	
	
	
	
	
	
	
	
}
