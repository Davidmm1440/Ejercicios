package ceu.dam.ad.ejerciciosTema2.xml.ejercicio04;

import java.io.File;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import ceu.dam.ad.ejerciciosTema2.xml.ejercicio04.modelo.Edicion;
import ceu.dam.ad.ejerciciosTema2.xml.ejercicio04.modelo.Libro;
import ceu.dam.ad.ejerciciosTema2.xml.exceptions.XMLExportException;

public class Ejercicio04ServiceImpl implements Ejercicio04Service{

	@Override
	public void exportXML(List<Libro> libros, String pathFile) throws XMLExportException {
		try {
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			DocumentBuilder builder = factory.newDocumentBuilder();
			Document document = builder.newDocument();
			
			Element librosTag = document.createElement("libros");
			document.appendChild(librosTag);
			
			for (Libro libro : libros) {
				Element libroTag = document.createElement("libro");
				librosTag.appendChild(libroTag);
				
				libroTag.setAttribute("isbn", libro.getIsbn().toString());
				
				Element tituloTag = document.createElement("titulo");
				libroTag.appendChild(tituloTag);
				tituloTag.setTextContent(libro.getTitulo());
				
				Element autoresTag = document.createElement("autores");
				libroTag.appendChild(autoresTag);
				
				for (String autor : libro.getAutores()) {
					Element autorTag = document.createElement("autor");
					autoresTag.appendChild(autorTag);
					autorTag.setTextContent(autor);
					
				}
				
				Element edicionesTag = document.createElement("ediciones");
				libroTag.appendChild(edicionesTag);
				
				for (Edicion edicion : libro.getEdiciones()) {
					Element edicionTag = document.createElement("edicion");
					edicionesTag.appendChild(edicionTag);
					
					Element añoTag = document.createElement("año");
					edicionTag.appendChild(añoTag);
					añoTag.setTextContent(edicion.getAño().toString());
					
					Element editorialTag = document.createElement("editorial");
					edicionTag.appendChild(editorialTag);
					editorialTag.setTextContent(edicion.getEditorial());
				}
				
				TransformerFactory transformerFactory = TransformerFactory.newInstance();
				Transformer transformer = transformerFactory.newTransformer();
				DOMSource source = new DOMSource(document);
				File file = new File(pathFile);
				StreamResult result = new StreamResult(file);
				transformer.transform(source, result);
			}
			
		} catch (Exception e) {
			throw new XMLExportException("Error generando XML", e);
		}
	}


}
