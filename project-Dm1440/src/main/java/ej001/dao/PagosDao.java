package ej001.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.sql.Date;
import java.util.List;

import ej001.model.Pago;

public class PagosDao {
	
	public List<Pago> pagosCliente(Connection conn, Integer id) throws SQLException{
		String sql = "Select * from payment where customer_id = ?";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setInt(1, id);
		ResultSet rs = ps.executeQuery();
		List<Pago> resultado = new ArrayList<Pago>();
		while(rs.next()) {
			Pago p = new Pago();
			Date date = rs.getDate("payment_date");
			p.setFecha(date.toLocalDate());
			p.setImporte(rs.getBigDecimal("amount"));
			resultado.add(p);
		}
		return resultado;
	

	}
}
