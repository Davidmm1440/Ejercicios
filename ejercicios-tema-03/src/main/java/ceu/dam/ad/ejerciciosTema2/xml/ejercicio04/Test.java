package ceu.dam.ad.ejerciciosTema2.xml.ejercicio04;

import java.util.ArrayList;
import java.util.List;

import ceu.dam.ad.ejerciciosTema2.xml.ejercicio04.modelo.Edicion;
import ceu.dam.ad.ejerciciosTema2.xml.ejercicio04.modelo.Libro;
import ceu.dam.ad.ejerciciosTema2.xml.exceptions.XMLExportException;

public class Test {

	public static void main(String[] args) {
		System.out.println("Hola");
		List<Libro> libros = createLibros();
		Ejercicio04ServiceImpl service = new Ejercicio04ServiceImpl();
		try {
			service.exportXML(libros, "c:/temporal/libro.xml");
		} catch (XMLExportException e) {
			e.printStackTrace();
		}
	
	}
	
	public static List<Libro> createLibros() {
 
	    List<Libro> libros = new ArrayList<>();
 
	    // ==== LIBRO 1: El Señor de los Anillos ====
	    Libro l1 = new Libro();
	    l1.setIsbn(97802611);
	    l1.setTitulo("El Señor de los Anillos");
 
	    List<String> autores1 = new ArrayList<>();
	    autores1.add("J. R. R. Tolkien");
	    l1.setAutores(autores1);
 
	    List<Edicion> ediciones1 = new ArrayList<>();
 
	    Edicion e1_1 = new Edicion();
	    e1_1.setAño(1954);
	    e1_1.setEditorial("Allen & Unwin");
 
	    Edicion e1_2 = new Edicion();
	    e1_2.setAño(2001);
	    e1_2.setEditorial("HarperCollins");
 
	    ediciones1.add(e1_1);
	    ediciones1.add(e1_2);
	    l1.setEdiciones(ediciones1);
 
	    libros.add(l1);
 
 
	    // ==== LIBRO 2: 1984 ====
	    Libro l2 = new Libro();
	    l2.setIsbn(9780451);
	    l2.setTitulo("1984");
 
	    List<String> autores2 = new ArrayList<>();
	    autores2.add("George Orwell");
	    l2.setAutores(autores2);
 
	    List<Edicion> ediciones2 = new ArrayList<>();
 
	    Edicion e2_1 = new Edicion();
	    e2_1.setAño(1949);
	    e2_1.setEditorial("Secker & Warburg");
 
	    Edicion e2_2 = new Edicion();
	    e2_2.setAño(2003);
	    e2_2.setEditorial("Penguin Books");
 
	    ediciones2.add(e2_1);
	    ediciones2.add(e2_2);
	    l2.setEdiciones(ediciones2);
 
	    libros.add(l2);
 
 
	    // ==== LIBRO 3: Don Quijote de la Mancha ====
	    Libro l3 = new Libro();
	    l3.setIsbn(9788491);
	    l3.setTitulo("Don Quijote de la Mancha");
 
	    List<String> autores3 = new ArrayList<>();
	    autores3.add("Miguel de Cervantes");
	    l3.setAutores(autores3);
 
	    List<Edicion> ediciones3 = new ArrayList<>();
 
	    Edicion e3_1 = new Edicion();
	    e3_1.setAño(1605);
	    e3_1.setEditorial("Juan de la Cuesta");
 
	    Edicion e3_2 = new Edicion();
	    e3_2.setAño(2015);
	    e3_2.setEditorial("Alfaguara");
 
	    ediciones3.add(e3_1);
	    ediciones3.add(e3_2);
	    l3.setEdiciones(ediciones3);
 
	    libros.add(l3);
 
 
	    // ==== LIBRO 4: Harry Potter y la Piedra Filosofal ====
	    Libro l4 = new Libro();
	    l4.setIsbn(9780747);
	    l4.setTitulo("Harry Potter y la Piedra Filosofal");
 
	    List<String> autores4 = new ArrayList<>();
	    autores4.add("J. K. Rowling");
	    l4.setAutores(autores4);
 
	    List<Edicion> ediciones4 = new ArrayList<>();
 
	    Edicion e4_1 = new Edicion();
	    e4_1.setAño(1997);
	    e4_1.setEditorial("Bloomsbury");
 
	    Edicion e4_2 = new Edicion();
	    e4_2.setAño(2003);
	    e4_2.setEditorial("Scholastic");
 
	    ediciones4.add(e4_1);
	    ediciones4.add(e4_2);
	    l4.setEdiciones(ediciones4);
 
	    libros.add(l4);
 
 
	    // ==== LIBRO 5: El Principito ====
	    Libro l5 = new Libro();
	    l5.setIsbn(9780176);
	    l5.setTitulo("El Principito");
 
	    List<String> autores5 = new ArrayList<>();
	    autores5.add("Antoine de Saint-Exupéry");
	    l5.setAutores(autores5);
 
	    List<Edicion> ediciones5 = new ArrayList<>();
 
	    Edicion e5_1 = new Edicion();
	    e5_1.setAño(1943);
	    e5_1.setEditorial("Reynal & Hitchcock");
 
	    Edicion e5_2 = new Edicion();
	    e5_2.setAño(2000);
	    e5_2.setEditorial("Gallimard");
 
	    ediciones5.add(e5_1);
	    ediciones5.add(e5_2);
	    l5.setEdiciones(ediciones5);
 
	    libros.add(l5);
 
	    return libros;
	}

}
