package br.com.kosmete.kosmeteapp.dto;

import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;

import br.com.kosmete.kosmeteapp.entitites.UsuarioEntity;

public class UsuarioDetails implements UserDetails {

	private static final long serialVersionUID = 1L;

	private String username;
	private String password;
	private List<GrantedAuthority> grantedAuthorities;

	public UsuarioDetails(UsuarioEntity usuario) {
		super();
		this.username = usuario.getUsuario();
		this.password = usuario.getSenha();
		this.grantedAuthorities = AuthorityUtils.createAuthorityList(usuario.getPerfil());
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return grantedAuthorities;
	}

	@Override
	public String getPassword() {
		return password;
	}

	@Override
	public String getUsername() {
		return username;
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}
}
