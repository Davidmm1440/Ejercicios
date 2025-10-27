package ceu.dam.ad.tema3.ejercicios.ejercicio05.test;

import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ceu.dam.ad.tema3.ejercicios.ejercicio05.model.User;
import ceu.dam.ad.tema3.ejercicios.ejercicio05.service.DuplicateUserException;
import ceu.dam.ad.tema3.ejercicios.ejercicio05.service.UserException;
import ceu.dam.ad.tema3.ejercicios.ejercicio05.service.UserNotFoundException;
import ceu.dam.ad.tema3.ejercicios.ejercicio05.service.UserServiceImpl;
import ceu.dam.ad.tema3.ejercicios.ejercicio05.service.UserUnauthorizedException;

@Component
public class TestEj5 {

	@Autowired
	UserServiceImpl service;

	public void test() {
		Scanner sc = new Scanner(System.in);
		Integer opcion = -1;

		do {
			System.out.println("\n===== MENÚ DE USUARIOS =====");
			System.out.println("1. Crear usuario");
			System.out.println("2. Cambiar contraseña");
			System.out.println("3. Iniciar sesión");
			System.out.println("4. Consultar usuario por ID");
			System.out.println("0. Salir");
			System.out.print("Seleccione una opción: ");
			opcion = sc.nextInt();
			sc.nextLine(); 
			
			switch (opcion) {
			case 1 -> {
				System.out.print("Nombre de usuario: ");
				String username = sc.nextLine();
				System.out.print("Email: ");
				String email = sc.nextLine();
				System.out.print("Contraseña: ");
				String password = sc.nextLine();

				User user = new User();
				user.setUsername(username);
				user.setEmail(email);
				user.setPassword(password);

				User creado;
				try {
					creado = service.createUser(user);
					System.out.println("✅ Usuario creado: " + creado);
				} catch (DuplicateUserException e) {
					e.printStackTrace();
				} catch (UserException e) {
					e.printStackTrace();
				}
				
			}

			case 2 -> {
				System.out.print("ID del usuario: ");
				Long id = sc.nextLong();
				sc.nextLine();
				System.out.print("Contraseña actual: ");
				String oldPass = sc.nextLine();
				System.out.print("Nueva contraseña: ");
				String newPass = sc.nextLine();

				try {
					service.changePassword(id, oldPass, newPass);
					System.out.println("✅ Contraseña cambiada correctamente.");
				} catch (UserUnauthorizedException e) {
					e.printStackTrace();
				} catch (UserNotFoundException e) {
					e.printStackTrace();
				} catch (UserException e) {
					e.printStackTrace();
				}
				
			}

			case 3 -> {
				System.out.print("Usuario o email: ");
				String login = sc.nextLine();
				System.out.print("Contraseña: ");
				String password = sc.nextLine();

				User u;
				try {
					u = service.login(login, password);
					System.out.println("✅ Login correcto. Bienvenido " + u.getUsername());
				} catch (UserNotFoundException e) {
					e.printStackTrace();
				} catch (UserUnauthorizedException e) {
					e.printStackTrace();
				}
				
			}

			case 4 -> {
				System.out.print("ID del usuario: ");
				Long id = sc.nextLong();
				sc.nextLine();

				User u;
				try {
					u = service.getUser(id);
					System.out.println("👤 Usuario encontrado: " + u);
				} catch (UserNotFoundException e) {
					e.printStackTrace();
				} catch (UserException e) {
					e.printStackTrace();
				}
				
			}

			case 0 -> System.out.println("👋 Saliendo del programa...");
			default -> System.out.println("❌ Opción no válida.");
			}

		} while (opcion != 0);

		sc.close();
	}

}
