package ejercicios.ejercicio03.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import ejercicios.ejercicio03.model.Pago;

public class PagosDao {

	public List<Pago> selectByCustomer(Connection conn, Integer idCustomer) throws SQLException{
		List<Pago> pagos = new ArrayList<Pago>();
		String sql = "select * from payment where customer_id = ?";
		PreparedStatement stmt = conn.prepareStatement(sql);
		stmt.setInt(1, idCustomer);
		ResultSet rs = stmt.executeQuery();
		while (rs.next()) {
			Pago p = new Pago();
			p.setId(rs.getInt("payment_id"));
			p.setCantidad(rs.getBigDecimal("amount"));
			p.setFecha(rs.getDate("payment_date").toLocalDate());
			pagos.add(p);
		}
		return pagos;
		
		
	}
}
