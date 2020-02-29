package se.cohdex.luffarpoker.formatter;

import java.awt.Color;
import java.text.ParseException;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.format.Formatter;
import org.springframework.stereotype.Component;

@Component
public class ColorFormatter implements Formatter<Color> {

	/* Matches "rgb(r, g, b)" with support for varying whitespace. */
	private static final Pattern RGB_PATTERN = Pattern.compile(
			"^\\s*[rR][gG][bB]\\s*\\(\\s*(?<red>\\d*)\\s*,\\s*(?<green>\\d*)\\s*,\\s*(?<blue>\\d*)\\s*\\)\\s*$");

	@Override
	public String print(Color color, Locale locale) {
		return String.format("rgb(%d, %d, %d)", color.getRed(), color.getGreen(), color.getBlue());
	}

	@Override
	public Color parse(String text, Locale locale) throws ParseException {
		Matcher matcher = RGB_PATTERN.matcher(text);
		if (matcher.matches()) {
			int red = Integer.parseInt(matcher.group("red"));
			int green = Integer.parseInt(matcher.group("green"));
			int blue = Integer.parseInt(matcher.group("blue"));
			return new Color(red, green, blue);
		} else {
			throw new ParseException("Input did not match the color pattern", 0);
		}
	}
}
