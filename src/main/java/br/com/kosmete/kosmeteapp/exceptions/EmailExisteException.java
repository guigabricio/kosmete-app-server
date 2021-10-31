package br.com.kosmete.kosmeteapp.exceptions;

import org.springframework.http.HttpStatus;

public class EmailExisteException extends KosmeteException {

	private static final long serialVersionUID = 1L;
	private static int errorCode = IndexErrorCodeException.EMAIL_EXISTE;
	private static String message = "Email já cadastrado";
	private static HttpStatus status = HttpStatus.BAD_REQUEST;

	public EmailExisteException(String path) {
		super(message, errorCode, status, path);
	}

	public EmailExisteException(Throwable cause, String path) {
		super(message, cause, errorCode, status, path);
	}

}
