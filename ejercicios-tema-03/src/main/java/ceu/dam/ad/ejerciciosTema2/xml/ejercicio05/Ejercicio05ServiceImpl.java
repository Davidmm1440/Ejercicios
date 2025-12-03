package ceu.dam.ad.ejerciciosTema2.xml.ejercicio05;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import ceu.dam.ad.ejerciciosTema2.xml.ejercicio04.modelo.Edicion;
import ceu.dam.ad.ejerciciosTema2.xml.ejercicio04.modelo.Libro;
import ceu.dam.ad.ejerciciosTema2.xml.exceptions.XMLImportException;

public class Ejercicio05ServiceImpl implements Ejercicio05Service{

	@Override
	public List<Libro> importXML(String pathFile) throws XMLImportException {
		
		try {
			// Crear documento
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			DocumentBuilder builder = factory.newDocumentBuilder();
			File file = new File(pathFile);
			Document document = builder.parse(file);
			
			Element librosTag = document.getDocumentElement();
			List<Libro> libros = new ArrayList<Libro>();
			
			NodeList librosTagList = document.getElementsByTagName("libros");
			for (int i = 0; i < librosTagList.getLength(); i++) {
				Element libroTag = (Element) librosTagList.item(i);
				
				Libro libro =new Libro();
				libros.add(libro);
				
				libro.setIsbn(Integer.valueOf(librosTag.getAttribute("isbn")));
				
				Element tituloTag = (Element) libroTag.getElementsByTagName("titulo").item(0);
				libro.setTitulo(tituloTag.getTextContent());
				
				List<String> autores = new ArrayList<>();
				libro.setAutores(autores);
				
				NodeList autoresTagList = document.getElementsByTagName("autores");
				for (int j = 0; j < autoresTagList.getLength(); j++) {
					Element autorTag = (Element) librosTagList.item(j);
					
					libro.getAutores().add(autorTag.getTextContent());
				}
				
				List<Edicion> ediciones = new ArrayList<>();
				libro.setEdiciones(ediciones);
				
				NodeList edicionesTagList = document.getElementsByTagName("ediciones");
				for (int j = 0; j < edicionesTagList.getLength(); j++) {
					Element edicionTag = (Element) librosTagList.item(j);
					
					Edicion edicion = new Edicion();
					libro.getEdiciones().add(edicion);
					
					Element añoTag = (Element) edicionTag.getElementsByTagName("año").item(0);
					edicion.setAño(Integer.valueOf(añoTag.getTextContent()));
					
					Element editorialTag = (Element) edicionTag.getElementsByTagName("editorial").item(0);
					edicion.setEditorial(editorialTag.getTextContent());
					
				}
			}
			
			return libros;
		} catch (Exception e) {
			throw new XMLImportException("Error importando xml", e);
		}
		
	}



}
