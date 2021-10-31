package br.com.kosmete.kosmeteapp.exceptions;

import org.springframework.http.HttpStatus;

public class ProdutoExisteException extends KosmeteException {

	private static final long serialVersionUID = 1L;
	private static int errorCode = IndexErrorCodeException.PRODUTO_EXISTE;
	private static String message = "Produto já cadastrada";
	private static HttpStatus status = HttpStatus.BAD_REQUEST;

	public ProdutoExisteException(String path) {
		super(message, errorCode, status, path);
	}

	public ProdutoExisteException(Throwable cause, String path) {
		super(message, cause, errorCode, status, path);
	}

}
