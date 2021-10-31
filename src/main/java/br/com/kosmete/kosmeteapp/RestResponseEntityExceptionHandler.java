package br.com.kosmete.kosmeteapp;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import br.com.kosmete.kosmeteapp.exceptions.KosmeteException;

@ControllerAdvice
public class RestResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler(value = { Throwable.class })
	public ResponseEntity<Object> handleAll(Throwable ex, WebRequest request) {
		ApiError apiError = new ApiError(HttpStatus.CONFLICT, ex.getLocalizedMessage(), null);
		return new ResponseEntity<Object>(apiError, new HttpHeaders(), apiError.getStatus());
	}

	@ExceptionHandler(value = { KosmeteException.class })
	public ResponseEntity<Object> handleAllSpecific(KosmeteException ex, WebRequest request) {
		ApiError apiError = new ApiError(ex.getErrorCode(), ex.getStatus(), ex.getLocalizedMessage(), ex.getPath());
		return new ResponseEntity<Object>(apiError, new HttpHeaders(), apiError.getStatus());
	}

}
