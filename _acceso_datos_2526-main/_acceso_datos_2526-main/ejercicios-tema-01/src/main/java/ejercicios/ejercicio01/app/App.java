package ejercicios.ejercicio01.app;

import java.util.List;

import ejercicios.ejercicio01.model.Pelicula;
import ejercicios.ejercicio01.service.PeliculaException;
import ejercicios.ejercicio01.service.PeliculasService;

public class App {

	public static void main(String[] args) {
		PeliculasService service = new PeliculasService();
		try {
			List<Pelicula> peliculas = service.findShortFilms();
			peliculas.forEach(System.out::println);
		} catch (PeliculaException e) {
			e.printStackTrace();
		}
	}

}
