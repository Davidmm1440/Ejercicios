package ceu.dam.ad.tema3.ejercicios;
import ceu.dam.ad.tema3.ejercicios.ejercicio01.test.TestEj1;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;


@SpringBootApplication
public class App {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(App.class, args);
		TestEj1 test = context.getBean(TestEj1.class);
		test.test();
		
	}

}
