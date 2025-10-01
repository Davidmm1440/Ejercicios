package ej002.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import ej002.model.Pedido;

public class PedidosDao {

	public Integer añadirPedido(Connection conn, Pedido p) throws SQLException {

		String sql = "INSERT INTO pedidos (fecha_pedido, fecha_entrega, cliente) VALUES (?, ?, ?)";
		PreparedStatement ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

		ps.setDate(1, Date.valueOf(p.getFechaPedido()));
		ps.setDate(2, Date.valueOf(p.getFechaEntrega()));
		ps.setString(3, p.getCliente());
		ps.execute();
		ResultSet rs = ps.getGeneratedKeys();
		rs.next();
		return rs.getInt(1);

	}
}
