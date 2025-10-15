package ceu.dam.ad;

import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import ceu.dam.ad.model.Perro;
import ceu.dam.ad.service.NotFoundException;
import ceu.dam.ad.service.PerrosService;

@SpringBootApplication
public class DemoSpringPerrosApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(DemoSpringPerrosApplication.class, args);
		
		PerrosService service = context.getBean(PerrosService.class);
		
//		Perro p = new Perro();
//		p.setColor("negro");
//		p.setPerroName("Coquito");
//		p.setRaza("Labrador");
//		
//		Perro perroCreado = service.crearPerro(p);
//		System.out.println(perroCreado);
		
		try {
			Perro p2 = service.consultarPerro(1L);
			System.out.println(p2);
		} catch (NotFoundException e) {
			System.out.println(e.getMessage());
		}
		
		List<Perro> listaPerros = service.getAll();
		listaPerros.forEach(System.out::println);
		
		List<Perro> listaPerrosCoco = service.encontrarPerros("Coco");
		listaPerrosCoco.forEach(System.out::println);
	}

}
