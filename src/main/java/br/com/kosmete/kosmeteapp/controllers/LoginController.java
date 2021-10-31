package br.com.kosmete.kosmeteapp.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.kosmete.kosmeteapp.AuthenticationComponent;
import br.com.kosmete.kosmeteapp.dto.ObjectMapper;
import br.com.kosmete.kosmeteapp.dto.UsuarioDto;
import br.com.kosmete.kosmeteapp.entitites.UsuarioEntity;
import br.com.kosmete.kosmeteapp.exceptions.UsuarioNaoEncontradoException;
import br.com.kosmete.kosmeteapp.services.UsuarioService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
public class LoginController {

	@Autowired
	UsuarioService usuarioService;
	
	@Autowired
	AuthenticationComponent authenticationComponent;
	
	@ApiOperation(value = "Efetua login do usuário", notes = "Retorna dados do usuário logado", response = UsuarioDto.class)
	@ApiResponses(value = {
	    @ApiResponse(code = 200, message = "Retorna dados do usuário logado", response = UsuarioDto.class),
	    @ApiResponse(code = 404, message = "Usuário não encontrado ou dados de login inválidos"),
	    @ApiResponse(code = 500, message = "Erro interno do servidor")}
	)
	@RequestMapping(value = "/login", method = RequestMethod.GET)
    public UsuarioDto login() throws UsuarioNaoEncontradoException {
		UsuarioEntity usuario = authenticationComponent.getUsuario();
		if (usuario != null) {
			UsuarioDto usuarioDto = ObjectMapper.getUsuarioDto(usuario);
			usuarioDto.setSenha("");
			return usuarioDto;
		} else {
			throw new UsuarioNaoEncontradoException("");
		}
    }

}
