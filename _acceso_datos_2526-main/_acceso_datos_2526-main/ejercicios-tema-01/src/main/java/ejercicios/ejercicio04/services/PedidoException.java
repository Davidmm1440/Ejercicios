package ejercicios.ejercicio04.services;

public class PedidoException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7331214697554859400L;

	public PedidoException() {
	}

	public PedidoException(String message) {
		super(message);
	}

	public PedidoException(Throwable cause) {
		super(cause);
	}

	public PedidoException(String message, Throwable cause) {
		super(message, cause);
	}

	public PedidoException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

}
