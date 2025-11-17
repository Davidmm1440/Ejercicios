package ceu.dam.ad.users.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.CONFLICT)
public class DuplicateUserException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7556828337494466017L;

	public DuplicateUserException() {
	}

	public DuplicateUserException(String message) {
		super(message);
	}

	public DuplicateUserException(Throwable cause) {
		super(cause);
	}

	public DuplicateUserException(String message, Throwable cause) {
		super(message, cause);
	}

	public DuplicateUserException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

}
