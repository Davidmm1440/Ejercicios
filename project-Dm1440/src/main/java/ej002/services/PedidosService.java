package ej002.services;

import java.sql.Connection;
import java.sql.SQLException;

import ej002.dao.LineaPedidosDao;
import ej002.dao.PedidosDao;
import ej002.model.LineaPedido;
import ej002.model.Pedido;

public class PedidosService extends Service {

	private PedidosDao daoP;
	private LineaPedidosDao daoLP;

	public PedidosService() {
		daoP = new PedidosDao();
		daoLP = new LineaPedidosDao();
	}

	public void registrarPedidos(Pedido p) throws PedidosServiceException {
		try (Connection conn = abrirConexionPedidos()) {

			conn.setAutoCommit(false);
			try {
				Integer idPedido = daoP.añadirPedido(conn, p);
				Integer contador = 1;
				for (LineaPedido lineaPedido : p.getListaLineaPedidos()) {
					lineaPedido.setIdPedido(idPedido);
					lineaPedido.setNumeroLinea(contador);
					daoLP.añadirLineaPedidos(conn, lineaPedido);
					contador++;
				}
				conn.commit();
			} catch (SQLException e) {
				conn.rollback();
				throw e;
			}

		} catch (Exception e) {
			e.printStackTrace();
			throw new PedidosServiceException("Error Insertando en la base de datos", e);
		}
	}

}
