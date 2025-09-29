package test.log;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Test {
	
	private static final Logger log = LoggerFactory.getLogger(Test.class);

	public static void main(String[] args) {
		
		log.info("Ejecutando el programa mágico");
		try {
			Integer n = 3/0;
		} catch (Exception e) {
			log.error("Error Error Error", e);
		}
		
	}

}
