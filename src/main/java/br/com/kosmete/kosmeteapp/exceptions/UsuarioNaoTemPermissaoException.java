package br.com.kosmete.kosmeteapp.exceptions;

import org.springframework.http.HttpStatus;

public class UsuarioNaoTemPermissaoException extends KosmeteException {

	private static final long serialVersionUID = 1L;
	private static int errorCode = IndexErrorCodeException.USUARIO_NAO_TEM_PERMISSAO;
	private static String message = "Usuário não tem permissão para executar o serviço";
	private static HttpStatus status = HttpStatus.BAD_REQUEST;

	public UsuarioNaoTemPermissaoException(String path) {
		super(message, errorCode, status, path);
	}

	public UsuarioNaoTemPermissaoException(Throwable cause, String path) {
		super(message, cause, errorCode, status, path);
	}

}
