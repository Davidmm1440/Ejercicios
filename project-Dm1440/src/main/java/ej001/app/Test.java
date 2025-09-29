package ej001.app;

import java.util.Map;

import ej001.model.Cliente;
import ej001.services.ClienteException;
import ej001.services.ClientesService;

public class Test {

	public static void main(String[] args) {
		ClientesService service = new ClientesService();
		try {
			Map<String, Cliente> mapaClientes = service.obtenerMapa();
			System.out.println(mapaClientes.get("MARILYN.ROSS@sakilacustomer.org"));
		} catch (ClienteException e) {
			e.printStackTrace();
		}

	}

}
