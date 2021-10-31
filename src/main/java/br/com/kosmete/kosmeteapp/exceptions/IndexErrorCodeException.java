package br.com.kosmete.kosmeteapp.exceptions;

public interface IndexErrorCodeException {

	int CLIENTE_EXISTE = 1;
	int EMAIL_EXISTE = 2;
	int EMPRESA_EXISTE = 3;
	int PRODUTO_EXISTE = 4;
	int USUARIO_EXISTE = 5;
	int USUARIO_NAO_ENCONTRADO = 6;
	int IDIOMA_NAO_ENCONTRADO = 7;
	int PROFISSIONAL_EXISTE = 8;
	int EMPRESA_NAO_ENCONTRADA = 9;
	int CLIENTE_NAO_ENCONTRADA = 10;
	int USUARIO_NAO_PERTENCE_A_EMPRESA = 11;
	int USUARIO_NAO_TEM_PERMISSAO = 12;

}
