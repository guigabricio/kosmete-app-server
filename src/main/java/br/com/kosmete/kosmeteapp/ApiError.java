package br.com.kosmete.kosmeteapp;

import org.springframework.http.HttpStatus;

import lombok.Getter;

@Getter
public class ApiError {

	private int errorCode;
	private HttpStatus status;
	private String message;
	private String path;

	public ApiError(int errorCode, HttpStatus status, String message, String path) {
		super();
		this.errorCode = errorCode;
		this.status = status;
		this.message = message;
		this.path = path;
	}

	public ApiError(HttpStatus status, String message, String path) {
		super();
		this.status = status;
		this.message = message;
		this.path = path;
	}

}
