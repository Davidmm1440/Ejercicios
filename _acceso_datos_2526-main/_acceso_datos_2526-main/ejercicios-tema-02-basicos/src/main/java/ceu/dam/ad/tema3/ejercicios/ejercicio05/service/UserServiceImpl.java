package ceu.dam.ad.tema3.ejercicios.ejercicio05.service;


import java.time.LocalDate;
import java.util.Optional;

import org.apache.commons.codec.digest.DigestUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import ceu.dam.ad.tema3.ejercicios.ejercicio05.model.User;
import ceu.dam.ad.tema3.ejercicios.ejercicio05.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository repo;

	private static final Logger log = LoggerFactory.getLogger(UserServiceImpl.class);



	public User createUser(User user) throws DuplicateUserException, UserException {
		try {
			log.debug("Creando nuevo usuario: " + user);
			if (repo.findByEmail(user.getEmail()).isPresent()) {
				log.debug("Usuario con email repetido");
				throw new DuplicateUserException("Ya existe usuario con el email indicado");
			}

			if (repo.findByUsername(user.getUsername()).isPresent()) {
				log.debug("Usuario con username repetido");
				throw new DuplicateUserException("Ya existe usuario con el username indicado");
			}

			String passwordCifrada = DigestUtils.sha256Hex(user.getPassword());
			user.setPassword(passwordCifrada);
			user.setFechaAlta(LocalDate.now());
			repo.save(user);
			return repo.findByEmail(user.getEmail()).get();
		} catch (DataAccessException e) {
			throw new UserException("Error creando el usuario");
		}

	}

	public void changePassword(Long idUser, String oldPassword, String newPassword)
			throws UserUnauthorizedException, UserNotFoundException, UserException {
		try {
			log.debug("Actualizacion password de usuario con id: " + idUser);
			if (newPassword.equals(oldPassword)) {
				log.debug("Pass antigua igual a la nueva, no se hará el cambio ");
				throw new UserUnauthorizedException("La password nueva no puede ser igual a la antigua");
			}
			if (repo.findById(idUser).isEmpty()) {
				log.warn("El usuario indicado no existe. ID " + idUser);
				throw new UserNotFoundException("No existe usuario con id " + idUser);
			}
			String passwordCipherOld = DigestUtils.sha256Hex(oldPassword);
			if (!repo.findById(idUser).get().getPassword().equals(passwordCipherOld)) {
				log.debug("Pass indicada para cambio incorrecta ");
				throw new UserUnauthorizedException("El password no es correcto");
			}
			String passwordCipherNew = DigestUtils.sha256Hex(newPassword);
			User userActualizado = repo.findById(idUser).get();
			userActualizado.setPassword(passwordCipherNew);
			repo.save(userActualizado);
			log.debug("Password cambiada con exito");
		} catch (DataAccessException e) {
			log.error("Error actualizando pass de usuario ", e);
			throw new UserException("Error actualizando usuario");
		}

	}

	public User login(String login, String password) throws UserNotFoundException, UserUnauthorizedException {
		log.debug("Realizando login con usuario " + login);
		log.debug("Intentando login por email...");
		Optional<User> user = repo.findByEmail(login);
		if (user.isEmpty()) {
			log.debug("Intentando login por username...");
			user = repo.findByUsername(login);
		}
		if (user.isEmpty()) {
			log.debug("No existe usuario (email o username)");
			throw new UserNotFoundException("No existe usuario con el login indicado");
		}

		String passwordCipher = DigestUtils.sha256Hex(password);
		if (!user.get().getPassword().equals(passwordCipher)) {
			log.debug("Password incorrecta");
			throw new UserUnauthorizedException("Password de usuario incorrecta");
		}

		try {
			log.debug("Actualizando fecha de último login");
			user.get().setFechaUltLogin(LocalDate.now());
			repo.save(user.get());
		} catch (DataAccessException e) {
			log.error("Error actualizando fecha último login del usuario ", e);
		}
		log.debug("Login correcto");
		return user.get();

	}

	public User getUser(Long idUser) throws UserNotFoundException, UserException {
		try {
			log.debug("Consultando usuario con id " + idUser);
			if (repo.findById(idUser).isEmpty()) {
				throw new UserNotFoundException("No existe usuario con el id indicado");
			}
			return repo.findById(idUser).get();
		} catch (DataAccessException e) {
			log.error("Error actualizando pass de usuario ", e);
			throw new UserException("Error actualizando usuario");
		}

	}

}
