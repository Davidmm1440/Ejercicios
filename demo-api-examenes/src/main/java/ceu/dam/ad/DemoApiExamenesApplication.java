package ceu.dam.ad;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import ceu.dam.ad.apiExamenes.test.Test;

@SpringBootApplication
public class DemoApiExamenesApplication {

	public static void main(String[] args) throws Exception {
		ConfigurableApplicationContext context = SpringApplication.run(DemoApiExamenesApplication.class, args);
		Test test = context.getBean(Test.class);
		test.test();
	}

}
