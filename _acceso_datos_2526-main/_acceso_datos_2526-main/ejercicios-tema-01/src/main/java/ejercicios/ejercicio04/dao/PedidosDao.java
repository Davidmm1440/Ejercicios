package ejercicios.ejercicio04.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import ejercicios.ejercicio04.modelo.Pedido;

public class PedidosDao {

	public Long insert(Connection conn, Pedido pedido) throws SQLException{
		String sql = "insert into pedidos (fecha_pedido, fecha_entrega, cliente) values (?,?,?)";
		PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
		stmt.setDate(1, Date.valueOf(pedido.getFechaPedido()));
		stmt.setDate(2, Date.valueOf(pedido.getFechaEntrega()));
		stmt.setString(3, pedido.getCliente());
		stmt.execute();
		ResultSet rs = stmt.getGeneratedKeys();
		rs.next();
		return rs.getLong(1);
		
		
	}
}
