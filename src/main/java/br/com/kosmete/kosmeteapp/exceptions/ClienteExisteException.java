package br.com.kosmete.kosmeteapp.exceptions;

import org.springframework.http.HttpStatus;

public class ClienteExisteException extends KosmeteException {

	private static final long serialVersionUID = 1L;
	private static int errorCode = IndexErrorCodeException.CLIENTE_EXISTE;
	private static String message = "Cliente já cadastrado";
	private static HttpStatus status = HttpStatus.BAD_REQUEST;

	public ClienteExisteException(String path) {
		super(message, errorCode, status, path);
	}

	public ClienteExisteException(Throwable cause, String path) {
		super(message, cause, errorCode, status, path);
	}

}
