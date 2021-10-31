package br.com.kosmete.kosmeteapp.exceptions;

import org.springframework.http.HttpStatus;

public class ProfissionalExisteException extends KosmeteException {

	private static final long serialVersionUID = 1L;
	private static int errorCode = IndexErrorCodeException.PROFISSIONAL_EXISTE;
	private static String message = "Profissional já cadastrada";
	private static HttpStatus status = HttpStatus.BAD_REQUEST;

	public ProfissionalExisteException(String path) {
		super(message, errorCode, status, path);
	}

	public ProfissionalExisteException(Throwable cause, String path) {
		super(message, cause, errorCode, status, path);
	}

}
