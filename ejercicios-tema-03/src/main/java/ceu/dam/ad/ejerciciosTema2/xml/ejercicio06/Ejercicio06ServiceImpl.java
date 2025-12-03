package ceu.dam.ad.ejerciciosTema2.xml.ejercicio06;

import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import ceu.dam.ad.ejerciciosTema2.xml.ejercicio06.modelo.Largometraje;
import ceu.dam.ad.ejerciciosTema2.xml.ejercicio06.modelo.Persona;
import ceu.dam.ad.ejerciciosTema2.xml.exceptions.XMLExportException;

public class Ejercicio06ServiceImpl implements Ejercicio06Service{

	@Override
	public void exportarXML(List<Largometraje> peliculas, String fichero) throws XMLExportException {
		try {
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			DocumentBuilder builder = factory.newDocumentBuilder();
			Document document = builder.newDocument();
			
			Element peliculasTag = document.createElement("peliculas");
			document.appendChild(peliculasTag);
			
			
			for (Largometraje pelicula : peliculas) {
				Element peliculaTag = document.createElement("pelicula");
				peliculasTag.appendChild(peliculaTag);
				
				Element tituloTag = document.createElement("titulo");
				peliculaTag.appendChild(tituloTag);
				tituloTag.setTextContent(pelicula.getTitulo());
				
				Element duracionTag = document.createElement("duracion");
				peliculaTag.appendChild(duracionTag);
				duracionTag.setTextContent(pelicula.getDuracion().toString());
				
				Element añoTag = document.createElement("año");
				peliculaTag.appendChild(añoTag);
				añoTag.setTextContent(pelicula.getAño().toString());
				
				Element artistasTag = document.createElement("artistas");
				peliculaTag.appendChild(artistasTag);
				
				// meter el director
				Persona direccion = pelicula.getDireccion();
				Element artistaTag = document.createElement("artista");
				artistasTag.appendChild(artistaTag);
				artistaTag.setAttribute("tipo", Persona.DIRECCION);
				
				
//				// meter el director
//				Persona direccion = pelicula.getDireccion();
//				Element artistaTag = document.createElement("artista");
//				artistasTag.appendChild(artistaTag);
//				artistaTag.setAttribute("tipo", "dirección");
//				
//				
//				for (Persona artista : pelicula.getActores()) {
//					Element artistaTag = document.createElement("artista");
//					artistasTag.appendChild(artistaTag);
//					
//					
//					artistaTag.setAttribute("tipo", "");
//				}
			}
			
			
			
			
			
		} catch (Exception e) {
			// TODO: handle exception
		}
	}


}
