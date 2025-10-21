package ejercicios.ejercicio04.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import ejercicios.ejercicio04.modelo.PedidoLinea;

public class LineaPedidoDao {

	public void insert(Connection conn, PedidoLinea linea) throws SQLException{
		String sql = "insert into pedidos_lineas (id_pedido, numero_linea, articulo, precio) values (?,?,?,?)";
		PreparedStatement stmt = conn.prepareStatement(sql);
		stmt.setLong(1, linea.getIdPedido());
		stmt.setInt(2, linea.getNumLinea());
		stmt.setString(3, linea.getArticulo());
		stmt.setBigDecimal(4, linea.getPrecio());
		stmt.execute();
	}
}
