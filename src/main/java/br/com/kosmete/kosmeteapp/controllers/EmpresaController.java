package br.com.kosmete.kosmeteapp.controllers;

import java.net.UnknownHostException;
import java.util.Arrays;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.kosmete.kosmeteapp.dto.EmpresaDto;
import br.com.kosmete.kosmeteapp.dto.EmpresaUsuarioDto;
import br.com.kosmete.kosmeteapp.dto.EnderecoDto;
import br.com.kosmete.kosmeteapp.dto.ObjectMapper;
import br.com.kosmete.kosmeteapp.dto.UsuarioDto;
import br.com.kosmete.kosmeteapp.entitites.UsuarioEntity;
import br.com.kosmete.kosmeteapp.enums.PerfilUsuario;
import br.com.kosmete.kosmeteapp.exceptions.EmailExisteException;
import br.com.kosmete.kosmeteapp.exceptions.UsuarioExisteException;
import br.com.kosmete.kosmeteapp.services.EmpresaService;
import br.com.kosmete.kosmeteapp.services.UsuarioService;

@RestController
public class EmpresaController {

	@Autowired
	EmpresaService empresaService;

	@Autowired
	UsuarioService usuarioService;

	@RequestMapping(value = "/empresa", method = RequestMethod.POST)
	public void salvar(@RequestBody EmpresaUsuarioDto empresaUsuarioDto) throws UsuarioExisteException, EmailExisteException, UnknownHostException {
		UsuarioDto usuarioDto = new UsuarioDto(
				null, 
				null, 
				empresaUsuarioDto.getEmail(), 
				empresaUsuarioDto.getUsuario(), 
				empresaUsuarioDto.getSenha(), 
				empresaUsuarioDto.getNome(), 
				empresaUsuarioDto.getSobrenome(), 
				null, 
				PerfilUsuario.ROLE_USER, 
				empresaUsuarioDto.getTipoDeConta()
				);
		UsuarioEntity usuario = this.usuarioService.salvar(ObjectMapper.getUsuario(usuarioDto));

		EnderecoDto endereco = new EnderecoDto(
				empresaUsuarioDto.getEndereco().getCep(), 
				empresaUsuarioDto.getEndereco().getLogradouro(), 
				empresaUsuarioDto.getEndereco().getNumero(), 
				empresaUsuarioDto.getEndereco().getComplemento(), 
				empresaUsuarioDto.getEndereco().getBairro(), 
				empresaUsuarioDto.getEndereco().getCidade(), 
				empresaUsuarioDto.getEndereco().getUf());

		EmpresaDto empresaDto = new EmpresaDto(
				null, 
				null, 
				empresaUsuarioDto.getNomeEmpresa(), 
				empresaUsuarioDto.getRazaoSocial(), 
				empresaUsuarioDto.getCpfCnpj(), 
				endereco,
				empresaUsuarioDto.getTelefones(), 
				Arrays.asList(usuario.getId().toHexString())
				);
		this.empresaService.salvar(ObjectMapper.getEmpresa(empresaDto ));
	}

}
