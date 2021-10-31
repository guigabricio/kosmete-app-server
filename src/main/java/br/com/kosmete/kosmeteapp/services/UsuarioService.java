package br.com.kosmete.kosmeteapp.services;

import java.rmi.server.UID;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import br.com.kosmete.kosmeteapp.dto.UsuarioDetails;
import br.com.kosmete.kosmeteapp.entitites.EmpresaEntity;
import br.com.kosmete.kosmeteapp.entitites.UsuarioEntity;
import br.com.kosmete.kosmeteapp.enums.StatusUsuario;
import br.com.kosmete.kosmeteapp.exceptions.EmailExisteException;
import br.com.kosmete.kosmeteapp.exceptions.UsuarioExisteException;
import br.com.kosmete.kosmeteapp.exceptions.UsuarioNaoEncontradoException;
import br.com.kosmete.kosmeteapp.repositories.EmpresaRepository;
import br.com.kosmete.kosmeteapp.repositories.UsuarioRepository;
import br.com.kosmete.kosmeteapp.utils.PasswordUtil;

@Service
public class UsuarioService implements UserDetailsService {
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	@Autowired
	private EmpresaRepository empresaRepository;
	@Autowired
	private EmailService emailService;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		UsuarioEntity usuario = procurarPorUsuario(username);
		if (usuario != null) {
			UsuarioDetails usuarioDetails = new UsuarioDetails(usuario);
			return usuarioDetails;
		}
		throw new UsernameNotFoundException(username);
	}

	public UsuarioEntity salvar(UsuarioEntity usuario) throws UsuarioExisteException, EmailExisteException {
		if (usuarioRepository.findByUsuario(usuario.getUsuario()) != null) {
			throw new UsuarioExisteException("usuario.usuario");
		}
		if (usuarioRepository.findByEmail(usuario.getEmail()) != null) {
			throw new EmailExisteException("usuario.email");
		}
		usuario.setSenha(PasswordUtil.hash(usuario.getSenha()));
		usuario.setDataRegistro(ZonedDateTime.now(ZoneOffset.UTC));
		usuario.setTokenDeConfirmacaoDeEmail(new UID().toString().replace("-", "").replace(":", ""));
		usuario.setStatus(StatusUsuario.NAO_CONFIRMADO.name());
		UsuarioEntity usuarioSalvo = usuarioRepository.save(usuario);
		emailService.sendSimpleMessage(usuarioSalvo.getEmail(), "Kosmete - Confirmação de e-mail", "https://kosmete-app.herokuapp.com/confirmacaoemail/" + usuarioSalvo.getTokenDeConfirmacaoDeEmail());
		return usuarioSalvo;
	}

	public UsuarioEntity editar(UsuarioEntity usuario) throws EmailExisteException {
		UsuarioEntity usuarioComEmail = usuarioRepository.findByEmail(usuario.getEmail());
		if (usuarioComEmail != null && !usuarioComEmail.getUsuario().equals(usuario.getUsuario())) {
			throw new EmailExisteException("usuario.usuario");
		}
		usuario.setSenha(PasswordUtil.hash(usuario.getSenha()));
		return usuarioRepository.save(usuario);
	}

	public UsuarioEntity procurarPorId(String id) throws UsuarioNaoEncontradoException {
		UsuarioEntity usuario = usuarioRepository.findOne(new ObjectId(id));
		if (usuario != null) {
			return usuario;
		} else {
			throw new UsuarioNaoEncontradoException("usuario.id");
		}
	}

	public List<UsuarioEntity> listarTudo() {
		return usuarioRepository.findAll();
	}

	public List<UsuarioEntity> listarTudo(ObjectId idEmpresa) {
		EmpresaEntity empresa = empresaRepository.findOne(idEmpresa);
		List<UsuarioEntity> usuarios = usuarioRepository.findByIdIn(empresa.getUsuarios());
		return usuarios;
	}

	public List<UsuarioEntity> listarPorRegexUsuario(String usuario) {
		return usuarioRepository.findAllByRegexpUsuario(usuario);
	}

	public UsuarioEntity procurarPorUsuario(String usuario) {
		return usuarioRepository.findByUsuario(usuario);
	}

	public void deletarPorId(String id) throws UsuarioNaoEncontradoException {
		procurarPorId(id);
		usuarioRepository.delete(new ObjectId(id));
	}

	public UsuarioEntity procurarPorTokenDeConfirmacaoDeEmail(String tokenDeConfirmacaoDeEmail) {
		return usuarioRepository.findByTokenDeConfirmacaoDeEmail(tokenDeConfirmacaoDeEmail);
	}

}
