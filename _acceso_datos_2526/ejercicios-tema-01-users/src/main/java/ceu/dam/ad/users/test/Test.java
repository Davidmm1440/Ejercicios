package ceu.dam.ad.users.test;

import ceu.dam.ad.users.model.User;
import ceu.dam.ad.users.services.DuplicateUserException;
import ceu.dam.ad.users.services.UserException;
import ceu.dam.ad.users.services.UserNotFoundException;
import ceu.dam.ad.users.services.UserServiceImpl;
import ceu.dam.ad.users.services.UserUnauthorizedException;

public class Test {

	public static void main(String[] args) {
		UserServiceImpl service = new UserServiceImpl();
		User u = new User();
		u.setEmail("usuario4@g.com");
		u.setUsername("user4");
		u.setPassword("4444");
		try {
			u = service.createUser(u);
			System.out.println(u.getId());
		} catch (DuplicateUserException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UserException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		try {
			service.changePassword(u.getId(), "4444", "44441");
		} catch (UserNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UserUnauthorizedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UserException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
