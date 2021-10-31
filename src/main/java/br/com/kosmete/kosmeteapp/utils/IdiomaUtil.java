package br.com.kosmete.kosmeteapp.utils;

import java.util.Arrays;
import java.util.Locale;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

public class IdiomaUtil {
	
	public static boolean isISOLanguage(String language) {
		Set<String> languages = Arrays.stream(Locale.getAvailableLocales())
	            .map(Locale::toString)
	            .collect(Collectors.toCollection(TreeSet::new));
		return languages.contains(language);
	}
	
}
