package ej001.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import ej001.model.Pelicula;

public class PeliculasDao {
	public List<Pelicula> findAll(Connection conn) throws SQLException {
		String sql = "Select * from film";
		PreparedStatement ps = conn.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();

		List<Pelicula> listaPeliculas = new ArrayList<>();

		while (rs.next()) {
			Pelicula p = new Pelicula();
			p.setId(rs.getInt("film_id"));
			p.setTitulo(rs.getString("title"));
			p.setLongitud(rs.getInt("length"));
			listaPeliculas.add(p);
		}
		return listaPeliculas;
	}
}
