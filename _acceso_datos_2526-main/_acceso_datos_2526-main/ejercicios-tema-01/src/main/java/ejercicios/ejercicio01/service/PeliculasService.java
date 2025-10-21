package ejercicios.ejercicio01.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import ejercicios.ejercicio01.dao.PeliculasDao;
import ejercicios.ejercicio01.model.Pelicula;

public class PeliculasService extends Service{

	private PeliculasDao dao;
	
	public PeliculasService() {
		dao = new PeliculasDao();
	}

	public List<Pelicula> findShortFilms() throws PeliculaException{
		try(Connection conn = abrirConexionSakila() ){
			return dao.findAll(conn).stream()
					.filter(p -> p.getLongitud()<100)
					.toList();
		}
		catch(SQLException e) {
			throw new PeliculaException("Error consultando películas", e);
		}
	}
	
	
}











