package br.com.kosmete.kosmeteapp.exceptions;

import org.springframework.http.HttpStatus;

public class IdiomaNaoEncontradoFoundException extends KosmeteException {

	private static final long serialVersionUID = 1L;
	private static int errorCode = IndexErrorCodeException.IDIOMA_NAO_ENCONTRADO;
	private static String message = "Idioma não encontrado";
	private static HttpStatus status = HttpStatus.BAD_REQUEST;

	public IdiomaNaoEncontradoFoundException(String path) {
		super(message, errorCode, status, path);
	}

	public IdiomaNaoEncontradoFoundException(Throwable cause, String path) {
		super(message, cause, errorCode, status, path);
	}

}
