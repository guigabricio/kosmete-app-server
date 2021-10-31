package br.com.kosmete.kosmeteapp.exceptions;

import org.springframework.http.HttpStatus;

public class ClienteNaoEncontradaException extends KosmeteException {

	private static final long serialVersionUID = 1L;
	private static int errorCode = IndexErrorCodeException.CLIENTE_NAO_ENCONTRADA;
	private static String message = "Cliente não cadastrado.";
	private static HttpStatus status = HttpStatus.BAD_REQUEST;

	public ClienteNaoEncontradaException(String path) {
		super(message, errorCode, status, path);
	}

	public ClienteNaoEncontradaException(Throwable cause, String path) {
		super(message, cause, errorCode, status, path);
	}

}
