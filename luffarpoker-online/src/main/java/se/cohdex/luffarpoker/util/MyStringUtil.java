package se.cohdex.luffarpoker.util;

import java.util.StringTokenizer;

public class MyStringUtil {

	private MyStringUtil() {
		// Utility class
	}

	public static String capitalizeWords(String str) {
		StringTokenizer tokenizer = new StringTokenizer(str, " \t\n\r\f", true);
		StringBuilder result = new StringBuilder();
		while (tokenizer.hasMoreTokens()) {
			String word = tokenizer.nextToken();
			String capitalized = Character.toUpperCase(word.charAt(0)) + word.substring(1).toLowerCase();
			result.append(capitalized);
		}
		return result.toString();
	}
}
