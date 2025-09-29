package pruebas.jdbc.services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import pruebas.jdbc.model.Country;

public class CountryService extends Service {

	public Country findById(Integer id) throws SQLException {

		try (Connection conn = abrirConexionSakilaCentral()) {

			String sql = "SELECT * from country where country_id = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				Country c = new Country();
				c.setId(rs.getInt("country_id"));
				c.setName(rs.getString("country"));
				c.setLastUpdate(rs.getDate("last_update").toLocalDate());
				return c;
			}
			return null;
		}

	}

	public List<Country> findAll() throws SQLException {
		
		try (Connection conn = abrirConexionSakilaCentral()) {
			//String sql="SELECT *"
				return null;
		}
	}

}
