package br.com.kosmete.kosmeteapp.exceptions;

import org.springframework.http.HttpStatus;

public class UsuarioExisteException extends KosmeteException {

	private static final long serialVersionUID = 1L;
	private static int errorCode = IndexErrorCodeException.USUARIO_EXISTE;
	private static String message = "Usuário já cadastrado";
	private static HttpStatus status = HttpStatus.BAD_REQUEST;

	public UsuarioExisteException(String path) {
		super(message, errorCode, status, path);
	}

	public UsuarioExisteException(Throwable cause, String path) {
		super(message, cause, errorCode, status, path);
	}

}
