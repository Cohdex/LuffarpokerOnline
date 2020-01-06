package se.cohdex.luffarpoker.util;

import java.util.StringTokenizer;

/**
 * Provides utility methods for string operations.
 * 
 * @author Jonathan Cohlin
 */
public class MyStringUtil {

	private MyStringUtil() {
		// Utility class
	}

	/**
	 * Takes a string of words. Each word is capitalized. Whitespaces are preserved.
	 * <p />
	 * Example: input = 'hello world' output = 'Hello World'
	 * 
	 * @param str the string to capitalize
	 * @return the capitalized string
	 */
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
