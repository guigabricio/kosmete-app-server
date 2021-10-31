package br.com.kosmete.kosmeteapp.exceptions;

import org.springframework.http.HttpStatus;

import lombok.Getter;

@Getter
public abstract class KosmeteException extends Exception {

	private static final long serialVersionUID = 1L;

	private int errorCode;
	private HttpStatus status;
	private String path;

	public KosmeteException(String message, Throwable cause, int errorCode, HttpStatus status, String path) {
		super(message, cause);
		this.errorCode = errorCode;
		this.status = status;
		this.path = path;
	}

	public KosmeteException(String message, int errorCode, HttpStatus status, String path) {
		super(message);
		this.errorCode = errorCode;
		this.status = status;
		this.path = path;
	}

	public KosmeteException(Throwable cause, int errorCode, HttpStatus status, String path) {
		super(cause);
		this.errorCode = errorCode;
		this.status = status;
		this.path = path;
	}

	public KosmeteException(String message, HttpStatus status, String path) {
		super(message);
		this.status = status;
		this.path = path;
	}

}
