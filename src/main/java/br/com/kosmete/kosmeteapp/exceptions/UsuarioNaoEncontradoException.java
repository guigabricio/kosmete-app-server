package br.com.kosmete.kosmeteapp.exceptions;

import org.springframework.http.HttpStatus;

public class UsuarioNaoEncontradoException extends KosmeteException {

	private static final long serialVersionUID = 1L;
	private static int errorCode = IndexErrorCodeException.USUARIO_NAO_ENCONTRADO;
	private static String message = "Usuário não encontrado";
	private static HttpStatus status = HttpStatus.BAD_REQUEST;

	public UsuarioNaoEncontradoException(String path) {
		super(message, errorCode, status, path);
	}

	public UsuarioNaoEncontradoException(Throwable cause, String path) {
		super(message, cause, errorCode, status, path);
	}

}
