package ceu.dam.psp.videojuegos.test;

import ceu.dam.psp.videojuegos.client.VideojuegoApiClient;
import ceu.dam.psp.videojuegos.client.VideojuegoApiClientImpl;
import ceu.dam.psp.videojuegos.exceptions.ApiException;
import ceu.dam.psp.videojuegos.exceptions.NotFoundException;
import ceu.dam.psp.videojuegos.model.Videojuego;

public class Test {

	public static void main(String[] args) {
		VideojuegoApiClient cliente = new VideojuegoApiClientImpl("f04977178abb4cb5b394577e1a92a329");
		try {
			// TEST FindByID
			System.out.println("Test By ID");
			Videojuego videojuego = cliente.findById("68f67c497037b603e8a5ab59");
			System.out.println(videojuego);

			// TEST Borrar
			System.out.println("Test borrar");
			cliente.delete("68f67c497037b603e8a5ab59");
			try {
				videojuego = cliente.findById("68f67c497037b603e8a5ab59");
				System.out.println("No se ha borrado :(");
			}
			catch(NotFoundException e) {
				System.out.println("Borrado!!");
			}
			
			
//			// TEST Actualizar
//			System.out.println("Test actualizar");
//			videojuego.setAñoPublicacion(videojuego.getAñoPublicacion()+1);
//			cliente.update(videojuego);
//			System.out.println("Actualizado!!");
//			videojuego = cliente.findById("68f67c497037b603e8a5ab59");
//			System.out.println(videojuego);

			
			
			
//			// TEST FindByAño
//			System.out.println("Test By Año");
//			List<Videojuego> lista = cliente.findByAñoPublicacion(1998);
//			lista.forEach(System.out::println);
			
//			// TEST Crear
//			System.out.println("Test CREAR");
//			Videojuego nuevo = new Videojuego();
//			nuevo.setAñoPublicacion(2005);
//			nuevo.setNombre("BlasCar");
//			nuevo.setPaisOrigen("Kazajastan");
//			nuevo.setValoracion(3.0);
//			String id = cliente.create(nuevo);
//			System.out.println("Creado con id: " + id);
			
			
			
			
		} catch (NotFoundException e) {
			System.out.println(e.getMessage());
		} catch (ApiException e) {
			e.printStackTrace();
		}
	}

}
