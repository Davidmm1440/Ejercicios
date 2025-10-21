package ejercicios.ejercicio02.services;

public class ClientesException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5869062092842492997L;

	public ClientesException() {
	}

	public ClientesException(String message) {
		super(message);
	}

	public ClientesException(Throwable cause) {
		super(cause);
	}

	public ClientesException(String message, Throwable cause) {
		super(message, cause);
	}

	public ClientesException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

}
