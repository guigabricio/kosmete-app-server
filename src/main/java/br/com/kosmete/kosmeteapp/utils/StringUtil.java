package br.com.kosmete.kosmeteapp.utils;

public class StringUtil {
	
	public static String hide(String text) {
		return text.replaceAll("(?s).", "*");
	}
	
}
