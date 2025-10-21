package ejercicios.ejercicio02.test;

import ejercicios.ejercicio02.model.Cliente;
import ejercicios.ejercicio02.services.ClientesException;
import ejercicios.ejercicio02.services.ClientesService;

public class Test {

	public static void main(String[] args) {
		ClientesService service = new ClientesService();
		
		try {
			Cliente cliente = service.consultarClientes().get("MARILYN.ROSS@sakilacustomer.org");
			System.out.println(cliente);
		} catch (ClientesException e) {
			e.printStackTrace();
		}
	
	
	}

}
