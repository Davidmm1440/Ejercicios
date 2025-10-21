package ejercicios.ejercicio02.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import ejercicios.ejercicio02.model.Cliente;

public class ClienteDao {

	public List<Cliente> selectAll(Connection conn) throws SQLException{
		List<Cliente> clientes = new ArrayList<Cliente>();
		String sql = "select * from customer";
		PreparedStatement stmt = conn.prepareStatement(sql);
		ResultSet rs = stmt.executeQuery();
		while(rs.next()) {
			Cliente c = new Cliente();
			c.setId(rs.getInt("customer_id"));
			c.setFirstName(rs.getString("first_name"));
			c.setLastName(rs.getString("last_name"));
			c.setEmail(rs.getString("email"));
			c.setActivo(rs.getBoolean("active"));
			clientes.add(c);
		}
		return clientes;
		
		
	}
	
}
