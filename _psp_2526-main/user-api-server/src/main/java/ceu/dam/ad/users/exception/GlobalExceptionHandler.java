package ceu.dam.ad.users.exception;


import java.util.stream.Collectors;

import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import lombok.extern.log4j.Log4j2;

@RestControllerAdvice
@Log4j2
public class GlobalExceptionHandler {

	@ExceptionHandler(UserNotFoundException.class)
	public ResponseEntity<String> handle(UserNotFoundException e) {
		return ResponseEntity.status(HttpStatus.NOT_FOUND.value()).body(e.getMessage());
	}

//	@ExceptionHandler(MethodArgumentNotValidException.class)
//	public ResponseEntity<String> handle(MethodArgumentNotValidException e) {
//		return ResponseEntity.badRequest().body("Error causado por " + e.getFieldError().getField() + ": " + e.getFieldError().getDefaultMessage());
//	}
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<String> handle(MethodArgumentNotValidException e) {
		return ResponseEntity.badRequest().body(e.getFieldErrors().stream().map(i -> i.getDefaultMessage()).collect(Collectors.joining("\n")));
	}
	

	@ExceptionHandler(UserUnauthorizedException.class)
	public ResponseEntity<String> handle(UserUnauthorizedException e) {
		return ResponseEntity.status(HttpStatus.UNAUTHORIZED.value()).body("Login no autorizado. Causa: " + e.getMessage());
	}

	@ExceptionHandler(DuplicateUserException.class)
	public ResponseEntity<String> handle(DuplicateUserException e) {
		return ResponseEntity.status(HttpStatus.CONFLICT.value()).body(e.getMessage());
	}

	@ExceptionHandler(Exception.class)
	public ResponseEntity<String> handle(Exception e) {
		log.error("Error inesperado del servidor. Consulte el log si tiene acceso", e);
		return ResponseEntity.internalServerError().body("Error inesperado del servidor. Consulte el log si tiene acceso" + e.getMessage());
	}
	
	@ExceptionHandler(DataAccessException.class)
	public ResponseEntity<String> handle(DataAccessException e) {
		return ResponseEntity.internalServerError().body("Error inesperado del servidor. Consulte el log si tiene acceso" + e.getMessage());
	}
	
	
}
