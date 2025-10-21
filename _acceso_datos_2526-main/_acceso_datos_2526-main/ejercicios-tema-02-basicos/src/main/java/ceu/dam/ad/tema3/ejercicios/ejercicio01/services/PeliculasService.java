package ceu.dam.ad.tema3.ejercicios.ejercicio01.services;

import java.util.List;

//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import ceu.dam.ad.tema3.ejercicios.ejercicio01.model.Pelicula;
import ceu.dam.ad.tema3.ejercicios.ejercicio01.repository.PeliculasRepository;

@Service
public class PeliculasService {

	@Autowired
	private PeliculasRepository repo;

//	private static final Logger log = LoggerFactory.getLogger(PeliculasService.class);

	public List<Pelicula> consultarPeliculas() throws PeliculasException {
		return consultarPeliculas(100);
	}

	public List<Pelicula> consultarPeliculas(Integer longitud) throws PeliculasException {
		try {
			return repo.findAll().stream().filter(p -> p.getLongitud() < longitud).toList();
		} catch (DataAccessException e) {
			throw new PeliculasException("Error al consultar peliculas en BBDD", e);
		}
	}

}
