package ej001.services;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import ej001.dao.PeliculasDao;
import ej001.model.Pelicula;

public class PeliculasService extends Service {

	private PeliculasDao dao;

	public PeliculasService() {
		dao = new PeliculasDao();
	}

	public List<Pelicula> findShortFilms() throws PeliculaException {

		try (Connection conn = abrirConexionSakila()) {
			return dao.findAll(conn).stream().filter(p -> p.getLongitud() < 100).toList();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new PeliculaException("Error consultando películas", e);
		}
	}

}
