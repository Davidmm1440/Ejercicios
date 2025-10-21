package ejercicios.ejercicio03.test;

import java.util.List;

import ejercicios.ejercicio02.services.ClientesException;
import ejercicios.ejercicio03.model.Pago;
import ejercicios.ejercicio03.service.PagosService;

public class Test {

	public static void main(String[] args) {
		PagosService service = new PagosService();
		
		try {
			List<Pago> pagos = service.consultarPagosClientes().get("MARILYN.ROSS@sakilacustomer.org");
			pagos.forEach(System.out::println);
		} catch (ClientesException e) {
			e.printStackTrace();
		}
	
	
	}

}
