package ceu.dam.ad.users.services;

import java.sql.Connection;

import ceu.dam.ad.users.dao.UserDao;
import ceu.dam.ad.users.model.User;

public class UserServiceImpl extends Service implements UserService {

	UserDao uDao = new UserDao();

	@Override
	public User createUser(User user) throws DuplicateUserException, UserException {
		/**
		 * Recibe un usuario que trae indicado su username, email y password (sin
		 * cifrar). El servicio tendrá que: 1. Verificar que no existe usuario con ese
		 * email ni ese username. En caso contrario, lanzar DuplicateUserException 2.
		 * Registrar el usuario en BBDD completando su fecha de alta y cifrando su
		 * password con SHA3-256 3. Devolver el usuario con todos sus datos (incluyendo
		 * el ID) 4. Si hay algún error, lanzará UserException con el origen
		 */
		try (Connection conn = abrirConexionGalleta()) {
			if (uDao.getByEmail(conn, user.getEmail()) != null && uDao.getByUserName(conn, user.getUsername()) != null) {
				
			}
		} catch (Exception e) {
			// TODO: handle exception
		}

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
