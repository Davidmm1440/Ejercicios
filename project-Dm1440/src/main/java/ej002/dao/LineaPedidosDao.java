package ej002.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import ej002.model.LineaPedido;

public class LineaPedidosDao {

	public LineaPedidosDao() {
	}

	public void añadirLineaPedidos(Connection conn, LineaPedido lP) throws SQLException {

		String sql = "INSERT INTO pedidos_lineas (id_pedido, numero_linea, articulo, precio) VALUES (?, ?, ?, ?)";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setInt(1, lP.getIdPedido());
		ps.setInt(2, lP.getNumeroLinea());
		ps.setString(3, lP.getArticulo());
		ps.setBigDecimal(4, lP.getPrecio());
		ps.execute();

	}
}
