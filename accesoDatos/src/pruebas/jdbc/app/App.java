package pruebas.jdbc.app;

import java.sql.SQLException;
import java.util.List;

import pruebas.jdbc.model.Country;
import pruebas.jdbc.services.CountryService;

public class App {

	public static void main(String[] args) {
		
		CountryService service = new CountryService();
		Country country;
		try {
			country = service.findById(20);
			System.out.println(country);
			List<Country> lista = service.findAll();
			System.out.println("Todos los paises");
			System.out.println(lista);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
	}

}
