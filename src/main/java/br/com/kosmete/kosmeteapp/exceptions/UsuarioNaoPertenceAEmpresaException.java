package br.com.kosmete.kosmeteapp.exceptions;

import org.springframework.http.HttpStatus;

public class UsuarioNaoPertenceAEmpresaException extends KosmeteException {

	private static final long serialVersionUID = 1L;
	private static int errorCode = IndexErrorCodeException.USUARIO_NAO_PERTENCE_A_EMPRESA;
	private static String message = "Usuário não pertence à empresa";
	private static HttpStatus status = HttpStatus.BAD_REQUEST;

	public UsuarioNaoPertenceAEmpresaException(String path) {
		super(message, errorCode, status, path);
	}

	public UsuarioNaoPertenceAEmpresaException(Throwable cause, String path) {
		super(message, cause, errorCode, status, path);
	}

}
