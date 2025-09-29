package test.log;

import org.apache.commons.codec.digest.DigestUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Test {
	
	private static final Logger log = LoggerFactory.getLogger(Test.class);

	public static void main(String[] args) {
		
		String password = "nachete";
		String contraseñaCifrada = DigestUtils.sha3_512Hex(password);
		System.out.println(contraseñaCifrada);
		
	}

}
