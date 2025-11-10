package ceu.dam.ad.users.controller;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ceu.dam.ad.users.dto.request.UserChangePasswordRequestDTO;
import ceu.dam.ad.users.dto.request.UserLoginRequestDTO;
import ceu.dam.ad.users.dto.request.UserRequestDTO;
import ceu.dam.ad.users.dto.response.UserGetByIdResponseDTO;
import ceu.dam.ad.users.dto.response.UserLoginResponseDTO;
import ceu.dam.ad.users.dto.response.UserResponseDTO;
import ceu.dam.ad.users.exception.DuplicateUserException;
import ceu.dam.ad.users.exception.UserException;
import ceu.dam.ad.users.exception.UserNotFoundException;
import ceu.dam.ad.users.exception.UserUnauthorizedException;
import ceu.dam.ad.users.model.User;
import ceu.dam.ad.users.service.UserService;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/usuarios")
public class UserController {

	@Autowired
	private UserService service;

	@PostMapping()
	public UserResponseDTO create(@RequestBody UserRequestDTO userDTO) throws DuplicateUserException, UserException {
		User userEntity = new ModelMapper().map(userDTO, User.class);
		userEntity = service.createUser(userEntity);
		return new ModelMapper().map(userEntity, UserResponseDTO.class);
	}

	@PutMapping("/{idUser}/password")
	public void updatePassword(@PathVariable Long idUser, @Valid @RequestBody UserChangePasswordRequestDTO userDTO)
			throws UserNotFoundException, UserUnauthorizedException, UserException {
		service.changePassword(idUser, userDTO.getOldPassword(), userDTO.getNewPassword());
	}

	@PostMapping("/login")
	public UserLoginResponseDTO login(@RequestBody UserLoginRequestDTO request)
			throws UserNotFoundException, UserUnauthorizedException, UserException {
		User user = service.login(request.getLogin(), request.getPassword());
		return new ModelMapper().map(user, UserLoginResponseDTO.class);
	}
	
	@GetMapping("/{id}")
	public UserGetByIdResponseDTO getById(@PathVariable Long id) throws UserNotFoundException, UserException {
		User user = service.getUser(id);
		return new ModelMapper().map(user, UserGetByIdResponseDTO.class);
	}

}
