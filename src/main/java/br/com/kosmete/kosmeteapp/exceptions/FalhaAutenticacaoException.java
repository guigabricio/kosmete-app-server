package br.com.kosmete.kosmeteapp.exceptions;

import org.springframework.http.HttpStatus;

public class FalhaAutenticacaoException extends KosmeteException {

	private static final long serialVersionUID = 1L;
	private static int errorCode = IndexErrorCodeException.USUARIO_NAO_ENCONTRADO;
	private static String message = "Usuário não encontrado";
	private static HttpStatus status = HttpStatus.BAD_REQUEST;

	public FalhaAutenticacaoException(String path) {
		super(message, errorCode, status, path);
	}

	public FalhaAutenticacaoException(Throwable cause, String path) {
		super(message, cause, errorCode, status, path);
	}

}
