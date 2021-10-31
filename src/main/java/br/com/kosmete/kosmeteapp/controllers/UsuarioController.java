package br.com.kosmete.kosmeteapp.controllers;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;

import java.util.ArrayList;
import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Link;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.kosmete.kosmeteapp.AuthenticationComponent;
import br.com.kosmete.kosmeteapp.dto.ListarUsuarioDto;
import br.com.kosmete.kosmeteapp.dto.ObjectMapper;
import br.com.kosmete.kosmeteapp.dto.UsuarioDto;
import br.com.kosmete.kosmeteapp.entitites.UsuarioEntity;
import br.com.kosmete.kosmeteapp.exceptions.EmailExisteException;
import br.com.kosmete.kosmeteapp.exceptions.UsuarioExisteException;
import br.com.kosmete.kosmeteapp.exceptions.UsuarioNaoEncontradoException;
import br.com.kosmete.kosmeteapp.exceptions.UsuarioNaoPertenceAEmpresaException;
import br.com.kosmete.kosmeteapp.exceptions.UsuarioNaoTemPermissaoException;
import br.com.kosmete.kosmeteapp.services.UsuarioService;
import br.com.kosmete.kosmeteapp.utils.StringUtil;

@RestController
public class UsuarioController {

	@Autowired
	UsuarioService usuarioService;
	
	@Autowired
	AuthenticationComponent authenticationComponent;

	@RequestMapping(value = "/usuario", method = { RequestMethod.GET })
	public List<ListarUsuarioDto> listar() throws UsuarioNaoPertenceAEmpresaException, UsuarioNaoTemPermissaoException {
		ArrayList<ListarUsuarioDto> lista = new ArrayList<ListarUsuarioDto>();
		this.usuarioService.listarTudo(new ObjectId(authenticationComponent.getEmpresa().getId().toHexString())).forEach(u -> {
			ListarUsuarioDto usuario = ObjectMapper.getListarUsuarioDto(u);
			Link selfLink = linkTo(UsuarioController.class).slash("/usuario/" + usuario.getIdUsuario()).withSelfRel();
			usuario.add(selfLink);
			lista.add(usuario);
		});
		return lista;
	}

	@RequestMapping(value = "/usuario", params = { "usuario" }, method = { RequestMethod.GET })
	public List<ListarUsuarioDto> listarRegex(@RequestParam("usuario") String usuario) {
		ArrayList<ListarUsuarioDto> lista = new ArrayList<ListarUsuarioDto>();
		this.usuarioService.listarPorRegexUsuario(usuario).forEach(u -> {
			ListarUsuarioDto usu = ObjectMapper.getListarUsuarioDto(u);
			Link selfLink = linkTo(UsuarioController.class).slash(usu.getIdUsuario()).withSelfRel();
			usu.add(selfLink);
			lista.add(usu);
		});
		return lista;
	}

    @RequestMapping(value = "/usuario", method = RequestMethod.POST)
    public UsuarioDto salvar(@RequestBody UsuarioDto usuarioDto) throws UsuarioExisteException, EmailExisteException {
    	UsuarioEntity usuario = this.usuarioService.salvar(ObjectMapper.getUsuario(usuarioDto));
    	usuario.setSenha(StringUtil.hide("senha"));
    	usuarioDto = ObjectMapper.getUsuarioDto(usuario);
    	Link selfLink = linkTo(UsuarioController.class).slash(usuarioDto.getIdUsuario()).withSelfRel();
    	usuarioDto.add(selfLink);
        return usuarioDto;
    }

    @RequestMapping(value = "/usuario", method = RequestMethod.PUT)
    public UsuarioDto editar(@RequestBody UsuarioDto usuarioDto) throws EmailExisteException {
    	UsuarioEntity usuario = this.usuarioService.editar(ObjectMapper.getUsuario(usuarioDto));
    	usuario.setSenha(StringUtil.hide("senha"));
    	usuarioDto = ObjectMapper.getUsuarioDto(usuario);
    	Link selfLink = linkTo(UsuarioController.class).slash(usuarioDto.getIdUsuario()).withSelfRel();
    	usuarioDto.add(selfLink);
        return usuarioDto;
    }
	
	@RequestMapping(value = "/usuario/{id}", method = RequestMethod.GET)
    public UsuarioDto procurarPorId(@PathVariable String id) throws UsuarioNaoEncontradoException {
		UsuarioEntity usuario = this.usuarioService.procurarPorId(id);
		usuario.setSenha(StringUtil.hide("senha"));
		UsuarioDto usuarioDto = ObjectMapper.getUsuarioDto(usuario);
    	Link selfLink = linkTo(UsuarioController.class).slash(usuarioDto.getIdUsuario()).withSelfRel();
    	usuarioDto.add(selfLink);
        return usuarioDto;
    }

    @RequestMapping(value = "/usuario/{id}", method = RequestMethod.DELETE)
    public void deletarPorId(@PathVariable String id) throws UsuarioNaoEncontradoException {
        this.usuarioService.deletarPorId(id);
    }

}
