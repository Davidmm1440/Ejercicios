package ceu.dam.ad.users.services;

import java.nio.ReadOnlyBufferException;
import java.sql.Connection;
import java.sql.SQLException;
import java.time.LocalDate;

import org.apache.commons.codec.digest.DigestUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import ceu.dam.ad.users.dao.UserDao;
import ceu.dam.ad.users.model.User;

public class UserServiceImpl extends Service implements UserService {

	private static final Logger log = LoggerFactory.getLogger(UserServiceImpl.class);

	private UserDao dao;

	public UserServiceImpl() {
		dao = new UserDao();
	}

	@Override
	public User createUser(User user) throws DuplicateUserException, UserException {
		log.debug("Creando nuevo usuario: " + user);
		try(Connection conn = abrirConexionGalleta()){
			User u = dao.getByEmail(conn, user.getEmail());
			if (u != null) {
				log.debug("Ya existe usuario con ese email");
				throw new DuplicateUserException("Ya existe usuario con ese email");
			}
			u = dao.getByUserName(conn, user.getUsername());
			if (u != null) {
				log.debug("Ya existe usuario con ese username");
				throw new DuplicateUserException("Ya existe usuario con ese username");
			}
			String passwordCifrada = DigestUtils.sha3_256Hex(user.getPassword());
			user.setPassword(passwordCifrada);
			user.setCreatedDate(LocalDate.now());
			Long id = dao.insert(conn, user);
			user.setId(id);
			return user;
		}
		catch(SQLException e) {
			log.error("Error registrando usuario", e);
			throw new UserException("Error registrando usuario", e);
		}
	}

	@Override
	public void changePassword(Long idUser, String oldPassword, String newPassword)
			throws UserNotFoundException, UserUnauthorizedException, UserException {
		log.debug("Actualizacion password de usuario con id: " + idUser);
		try(Connection conn = abrirConexionGalleta()){
			User user = dao.getById(conn, idUser);
			if (user == null) {
				log.warn("No existe usuario con el ID indicado");
				throw new UserNotFoundException("No existe usuario con el ID indicado");
			}
			
			if (oldPassword.equals(newPassword)) {
				log.debug("La password nueva no puede ser igual a la vieja");
				throw new UserUnauthorizedException("La password nueva no puede ser igual a la vieja");
			}
			
			String passwordCifrada = DigestUtils.sha3_256Hex(oldPassword);
			if (!user.getPassword().equals(passwordCifrada)) {
				log.debug("La password antigua no es correcta");
				throw new UserUnauthorizedException("La password antigua no es correcta");
			}
			
			String passwordNewCifrada = DigestUtils.sha3_256Hex(newPassword);
			user.setPassword(passwordNewCifrada);
			dao.update(conn, user);
		
		}
		catch(SQLException e) {
			log.error("Error cambiando password", e);
			throw new UserException("Error cambiando password", e);
		}
		
		
		
		
	}

	@Override
	public User login(String login, String password)
			throws UserNotFoundException, UserUnauthorizedException, UserException {
		log.debug("Realizando login con usuario " + login);
		try(Connection conn = abrirConexionGalleta()){
			User user = dao.getByUserName(conn, login);
			if (user == null) {
				user = dao.getByEmail(conn, login);
				if (user == null) {
					throw new UserNotFoundException("No existe el usuario indicado");
				}
			}
			String passwordCifrada = DigestUtils.sha3_256Hex(password);
			if (!passwordCifrada.equals(user.getPassword())) {
				throw new UserUnauthorizedException("Password incorrecta");
			}
			try {
				user.setLastLoginDate(LocalDate.now());
				Integer updates = dao.update(conn, user);
				if (updates == 0) {
					log.error("Error actualizando fecha último login");
				}
			}
			catch(Exception e) {
				log.error("Error actualizando fecha último login", e);
			}
			return user;
			
		}
		catch(SQLException e) {
			log.error("Error haciendo login", e);
			throw new UserException("Error haciendo login", e);
		}

	}

	@Override
	public User getUser(Long idUser) throws UserNotFoundException, UserException {
		log.debug("Consultando usuario con id " + idUser);
		try(Connection conn = abrirConexionGalleta()){
			User user = dao.getById(conn, idUser);
			if (user == null) {
				log.warn("No existe usuario con el ID indicado");
				throw new UserNotFoundException("No existe usuario con el ID indicado");
			}
			return user;
			
		}
		catch(SQLException e) {
			log.error("Error consultando usuario", e);
			throw new UserException("Error consultando usuario", e);
		}
	}

}
