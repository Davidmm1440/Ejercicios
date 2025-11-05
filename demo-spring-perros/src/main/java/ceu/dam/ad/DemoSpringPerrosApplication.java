package ceu.dam.ad;

import java.util.ArrayList;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import ceu.dam.ad.model.Domicilio;
import ceu.dam.ad.model.Perro;
import ceu.dam.ad.model.Persona;
import ceu.dam.ad.repository.perros.PersonaRepository;
import ceu.dam.ad.service.PerrosService;

@SpringBootApplication
public class DemoSpringPerrosApplication {

    private final PersonaRepository personaRepository;

    DemoSpringPerrosApplication(PersonaRepository personaRepository) {
        this.personaRepository = personaRepository;
    }

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(DemoSpringPerrosApplication.class, args);

		PerrosService service = context.getBean(PerrosService.class);

		try {
			Persona persona = new Persona();
			persona.setDni("12345678B");
			persona.setNombre("Blas de los Montes");
			persona.setPerros(new ArrayList<Perro>());
//			persona.setDomicilio(new Domicilio(null, "Calle Jandula", 2));
			for (int i = 1; i <= 3; i++) {
				Perro p = new Perro();
				p.setPerroName("Perro" + i);
				p.setNumChip(i+10000+"A");
				p.setRaza("Chucho");
				p.setVacunado(true);
				persona.getPerros().add(p);
			}
			
			service.crearPersona(persona);
			
			Persona personaCreada = service.consultarPersona(persona.getIdPersona());
			System.out.println(personaCreada);
			System.out.println("Imprimo los perros aparte");
			personaCreada.getPerros().forEach(System.out::println);
			
			
		} catch (Exception e) {
			System.out.println("Petardazo gordo");
			e.printStackTrace();
		}



	}

}
