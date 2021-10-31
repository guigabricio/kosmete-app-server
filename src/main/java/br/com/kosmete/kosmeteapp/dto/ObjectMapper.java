package br.com.kosmete.kosmeteapp.dto;

import java.util.ArrayList;
import java.util.List;

import org.bson.types.ObjectId;

import br.com.kosmete.kosmeteapp.entitites.EmpresaEntity;
import br.com.kosmete.kosmeteapp.entitites.EnderecoEntity;
import br.com.kosmete.kosmeteapp.entitites.TelefoneEntity;
import br.com.kosmete.kosmeteapp.entitites.UsuarioEntity;
import br.com.kosmete.kosmeteapp.enums.PerfilUsuario;
import br.com.kosmete.kosmeteapp.enums.StatusUsuario;
import br.com.kosmete.kosmeteapp.enums.TipoDeConta;

public final class ObjectMapper {

	public static UsuarioDto getUsuarioDto(UsuarioEntity usuario) {
		UsuarioDto usuarioDto = new UsuarioDto();
		usuarioDto.setIdUsuario(usuario.getId().toHexString());
		usuarioDto.setDataRegistro(usuario.getDataRegistro());
		usuarioDto.setUsuario(usuario.getUsuario());
		usuarioDto.setSenha(usuario.getSenha());
		usuarioDto.setNome(usuario.getNome());
		usuarioDto.setSobrenome(usuario.getSobrenome());
		usuarioDto.setEmail(usuario.getEmail());
		usuarioDto.setStatus(StatusUsuario.valueOf(usuario.getStatus()));
		usuarioDto.setPerfil(PerfilUsuario.valueOf(usuario.getPerfil()));
		usuarioDto.setTipoDeConta(TipoDeConta.valueOf(usuario.getTipoDeConta()));
		return usuarioDto;
	}

	public static ListarUsuarioDto getListarUsuarioDto(UsuarioEntity usuario) {
		ListarUsuarioDto usuarioDto = new ListarUsuarioDto();
		usuarioDto.setIdUsuario(usuario.getId().toHexString());
		usuarioDto.setUsuario(usuario.getUsuario());
		usuarioDto.setNome(usuario.getNome());
		usuarioDto.setSobrenome(usuario.getSobrenome());
		usuarioDto.setEmail(usuario.getEmail());
		usuarioDto.setStatus(StatusUsuario.valueOf(usuario.getStatus()));
		usuarioDto.setPerfil(PerfilUsuario.valueOf(usuario.getPerfil()));
		usuarioDto.setTipoDeConta(TipoDeConta.valueOf(usuario.getTipoDeConta()));
		return usuarioDto;
	}

	public static UsuarioEntity getUsuario(UsuarioDto usuarioDto) {
		UsuarioEntity usuario = new UsuarioEntity();
		usuario.setId(usuarioDto.getIdUsuario() == null || usuarioDto.getIdUsuario().trim().equals("") ? null : new ObjectId(usuarioDto.getIdUsuario()));
		usuario.setDataRegistro(usuarioDto.getDataRegistro());
		usuario.setUsuario(usuarioDto.getUsuario());
		usuario.setSenha(usuarioDto.getSenha());
		usuario.setNome(usuarioDto.getNome());
		usuario.setSobrenome(usuarioDto.getSobrenome());
		usuario.setEmail(usuarioDto.getEmail());
		usuario.setStatus(usuarioDto.getStatus() == null ? null : usuarioDto.getStatus().name());
		usuario.setPerfil(usuarioDto.getPerfil() == null ? null : usuarioDto.getPerfil().name());
		usuario.setTipoDeConta(usuarioDto.getTipoDeConta() == null ? null : usuarioDto.getTipoDeConta().name());
		return usuario;
	}

	public static EmpresaEntity getEmpresa(EmpresaDto empresaDto) {
		List<TelefoneEntity> telefones;
		if (empresaDto.getTelefones() == null) {
			telefones = null;
		} else {
			telefones = new ArrayList<TelefoneEntity>();
			empresaDto.getTelefones().forEach(t -> {
				telefones.add(getTelefoneEntity(t));
			});
		}
		List<ObjectId> usuarios;
		if (empresaDto.getUsuarios() == null) {
			usuarios = null;
		} else {
			usuarios = new ArrayList<ObjectId>();
			empresaDto.getUsuarios().forEach(u -> {
				usuarios.add(new ObjectId(u));
			});
		}
		EmpresaEntity empresa = new EmpresaEntity(
				empresaDto.getId() == null || empresaDto.getId().trim().equals("") ? null : new ObjectId(empresaDto.getId()), 
						empresaDto.getDataRegistro(), 
						empresaDto.getNomeEmpresa(), 
						empresaDto.getRazaoSocial(), 
						empresaDto.getCpfCnpj(), 
						new EnderecoEntity(
								empresaDto.getEndereco().getCep(), 
								empresaDto.getEndereco().getLogradouro(), 
								empresaDto.getEndereco().getNumero(), 
								empresaDto.getEndereco().getComplemento(), 
								empresaDto.getEndereco().getBairro(), 
								empresaDto.getEndereco().getCidade(), 
								empresaDto.getEndereco().getUf()),
						telefones, 
						usuarios 
				);
		return empresa;
	}

	public static TelefoneEntity getTelefoneEntity(TelefoneDto telefoneDto) {
		TelefoneEntity telefone = new TelefoneEntity();
		telefone.setTipo(telefoneDto.getTipo());
		telefone.setDdd(telefoneDto.getDdd());
		telefone.setNumero(telefoneDto.getNumero());
		return telefone;
	}

	public static TelefoneDto getTelefoneDto(TelefoneEntity telefoneEntity) {
		TelefoneDto telefone = new TelefoneDto();
		telefone.setTipo(telefoneEntity.getTipo());
		telefone.setDdd(telefoneEntity.getDdd());
		telefone.setNumero(telefoneEntity.getNumero());
		return telefone;
	}

}
