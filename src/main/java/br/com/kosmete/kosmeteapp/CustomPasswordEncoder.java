package br.com.kosmete.kosmeteapp;

import org.springframework.security.crypto.password.PasswordEncoder;

import br.com.kosmete.kosmeteapp.utils.PasswordUtil;

public class CustomPasswordEncoder implements PasswordEncoder {
	@Override
	public String encode(CharSequence rawPassword) {
		String hashed = PasswordUtil.hash(rawPassword.toString());
		return hashed;
	}

	@Override
	public boolean matches(CharSequence rawPassword, String encodedPassword) {
		return PasswordUtil.verify(encodedPassword, rawPassword.toString());
	}
}