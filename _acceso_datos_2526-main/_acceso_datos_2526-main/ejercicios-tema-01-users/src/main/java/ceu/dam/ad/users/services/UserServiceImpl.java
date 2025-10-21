package ceu.dam.ad.users.services;

import ceu.dam.ad.users.model.User;

public class UserServiceImpl  implements UserService {



	@Override
	public User createUser(User user) throws DuplicateUserException, UserException {
		return null;
	}

	@Override
	public void changePassword(Long idUser, String oldPassword, String newPassword)
			throws UserNotFoundException, UserUnauthorizedException, UserException {
	}

	@Override
	public User login(String login, String password)
			throws UserNotFoundException, UserUnauthorizedException, UserException {
		return null;
	
	}

	@Override
	public User getUser(Long idUser) throws UserNotFoundException, UserException {
		return null;
	}

}
