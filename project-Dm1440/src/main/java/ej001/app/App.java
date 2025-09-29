package ej001.app;

import java.util.List;

import ej001.model.Pelicula;
import ej001.services.PeliculaException;
import ej001.services.PeliculasService;

public class App {

	public static void main(String[] args) {
		PeliculasService service = new PeliculasService();
		try {
			List<Pelicula> shortFilms = service.findShortFilms();
			shortFilms.forEach(System.out::println);
		} catch (PeliculaException e) {
			e.printStackTrace();
		}
	}

}
