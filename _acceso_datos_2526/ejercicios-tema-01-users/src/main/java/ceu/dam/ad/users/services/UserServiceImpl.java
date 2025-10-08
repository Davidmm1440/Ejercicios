package ceu.dam.ad.users.services;

import java.sql.Connection;
import java.sql.SQLException;
import java.time.LocalDate;

import org.apache.commons.codec.digest.DigestUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import ceu.dam.ad.users.dao.UserDao;
import ceu.dam.ad.users.model.User;

public class UserServiceImpl extends Service implements UserService {

	private static final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);
	UserDao uDao = new UserDao();

	@Override
	public User createUser(User user) throws DuplicateUserException, UserException {

		try (Connection conn = abrirConexionGalleta()) {
			if (uDao.getByEmail(conn, user.getEmail()) == null
					&& uDao.getByUserName(conn, user.getUsername()) == null) {
				user.setCreatedDate(LocalDate.now());
				user.setPassword(DigestUtils.sha3_256Hex(user.getPassword()));
				user.setId(uDao.insert(conn, user));
				return user;
			}
			throw new DuplicateUserException();
		} catch (DuplicateUserException e) {
			throw e;
		} catch (Exception e) {
			throw new UserException(e);
		}
	}

	@Override
	public void changePassword(Long idUser, String oldPassword, String newPassword)
			throws UserNotFoundException, UserUnauthorizedException, UserException {

		try (Connection conn = abrirConexionGalleta()) {
			if (uDao.getById(conn, idUser) == null) {
				throw new UserNotFoundException();
			}
			if (oldPassword.equals(newPassword)) {
				throw new UserUnauthorizedException();
			}
			User usuario = uDao.getById(conn, idUser);
			if (!usuario.getPassword().equals(oldPassword)) {
				throw new UserUnauthorizedException();
			}
			usuario.setPassword(DigestUtils.sha3_256Hex(newPassword));
			uDao.update(conn, usuario);
			logger.info("Contraseña cambiada");
		} catch (Exception e) {
			throw new UserException(e);
		}
	}

	@Override
	public User login(String login, String password)
			throws UserNotFoundException, UserUnauthorizedException, UserException {

		try (Connection conn = abrirConexionGalleta()) {
			User u = uDao.getByEmail(conn, login);
			if (u == null) {
				u = uDao.getByUserName(conn, login);
				if (u == null) {
					throw new UserNotFoundException();
				}
			}
			if (!u.getPassword().equals(DigestUtils.sha3_256Hex(password))) {
				throw new UserUnauthorizedException();
			}
			try {
				u.setLastLoginDate(LocalDate.now());
				uDao.update(conn, u);
			} catch (Exception e) {
				logger.error("Error actualizando la fecha de ultima conexión");
			}
			return u;
		} catch (SQLException e) {
			throw new UserException(e);
		}

	}

	@Override
	public User getUser(Long idUser) throws UserNotFoundException, UserException {

		try (Connection conn = abrirConexionGalleta()) {
			User u = uDao.getById(conn, idUser);
			if (u == null) {
				throw new UserNotFoundException();
			}
			return u;
		} catch (SQLException e) {
			throw new UserException(e);
		}
		
	}

}
