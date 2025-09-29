package ej001.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import ej001.model.Cliente;

public class ClientesDao {

	public List<Cliente> obtenerCLientes(Connection conn) throws SQLException {
		String sql = "Select * from customer";
		PreparedStatement ps = conn.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();

		List<Cliente> listaClientes = new ArrayList<>();

		while (rs.next()) {
			Cliente c = new Cliente();
			c.setId(rs.getInt("customer_id"));
			c.setFirstName(rs.getString("first_name"));
			c.setLastName(rs.getString("last_name"));
			c.setEmail(rs.getString("email"));
			c.setActivo(rs.getBoolean("active"));
			listaClientes.add(c);
		}
		return listaClientes;
	}
}
