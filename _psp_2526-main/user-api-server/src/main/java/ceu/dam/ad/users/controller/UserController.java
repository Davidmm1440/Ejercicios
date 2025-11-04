package ceu.dam.ad.users.controller;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ceu.dam.ad.users.dto.request.UserChangePasswordRequestDTO;
import ceu.dam.ad.users.dto.request.UserRequestDTO;
import ceu.dam.ad.users.dto.response.UserResponseDTO;
import ceu.dam.ad.users.exception.DuplicateUserException;
import ceu.dam.ad.users.exception.UserException;
import ceu.dam.ad.users.exception.UserNotFoundException;
import ceu.dam.ad.users.exception.UserUnauthorizedException;
import ceu.dam.ad.users.model.User;
import ceu.dam.ad.users.service.UserService;



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

@PutMapping()
public void update(@RequestBody UserChangePasswordRequestDTO userDTO) throws UserNotFoundException, UserUnauthorizedException, UserException {
	service.changePassword(userDTO.getIdUser(), userDTO.getOldPassword(), userDTO.getNewPassword());
	
}

}
