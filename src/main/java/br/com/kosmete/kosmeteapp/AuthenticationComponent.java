package br.com.kosmete.kosmeteapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import br.com.kosmete.kosmeteapp.entitites.EmpresaEntity;
import br.com.kosmete.kosmeteapp.entitites.UsuarioEntity;
import br.com.kosmete.kosmeteapp.services.EmpresaService;
import br.com.kosmete.kosmeteapp.services.UsuarioService;

@Component
public class AuthenticationComponent {

	@Autowired
	UsuarioService usuarioService;
	@Autowired
	EmpresaService empresaService;

	public EmpresaEntity getEmpresa() {
		if (SecurityContextHolder.getContext() != null && SecurityContextHolder.getContext().getAuthentication() != null) {
			UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
			UsuarioEntity usuario = usuarioService.procurarPorUsuario(userDetails.getUsername());
			EmpresaEntity empresa = empresaService.findByUsuarios(usuario.getId());
			return empresa;
		}
		return null;
	}

	public UsuarioEntity getUsuario() {
		if (SecurityContextHolder.getContext() != null && SecurityContextHolder.getContext().getAuthentication() != null) {
			UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
			UsuarioEntity usuario = usuarioService.procurarPorUsuario(userDetails.getUsername());
			return usuario;
		}
		return null;
	}

}
