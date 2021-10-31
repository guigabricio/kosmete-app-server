package br.com.kosmete.kosmeteapp.utils;

import de.mkammerer.argon2.Argon2;
import de.mkammerer.argon2.Argon2Factory;

public class PasswordUtil {

	public static String hash(String passwd) {
		Argon2 argon2 = Argon2Factory.create();
		int N = 65536;
		int r = 2;
		int p = 1;
		return argon2.hash(r, N, p, passwd);
	}

	public static boolean verify(String hash, String passwd) {
		Argon2 argon2 = Argon2Factory.create();
		return argon2.verify(hash, passwd);
	}

}
