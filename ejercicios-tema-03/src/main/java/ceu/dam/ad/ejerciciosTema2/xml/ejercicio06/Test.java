package ceu.dam.ad.ejerciciosTema2.xml.ejercicio06;


import java.util.List;

import ceu.dam.ad.ejerciciosTema2.xml.ejercicio04.modelo.Edicion;
import ceu.dam.ad.ejerciciosTema2.xml.ejercicio04.modelo.Libro;
import ceu.dam.ad.ejerciciosTema2.xml.ejercicio05.Ejercicio05Service;
import ceu.dam.ad.ejerciciosTema2.xml.ejercicio05.Ejercicio05ServiceImpl;

public class Test {

	public static void main(String[] args) {
		Ejercicio05Service service = new Ejercicio05ServiceImpl();
		try {
			List<Libro> listaLibros = service.importXML("c:/temporal/Libros.xml");
			System.out.println("Lista de libros leido de xml con los siguientes datos:");
			for (Libro libro : listaLibros) {
				System.out.println("Isbn: " + libro.getIsbn());
				System.out.println("Titulo: " + libro.getTitulo());
				for (String autor : libro.getAutores()) {
					System.out.println("Autor: " + autor);
				}
				
				for (Edicion edicion : libro.getEdiciones()) {
					System.out.println("Año: " + edicion.getAño());
					System.out.println("Editorial: " + edicion.getEditorial());
				}
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
