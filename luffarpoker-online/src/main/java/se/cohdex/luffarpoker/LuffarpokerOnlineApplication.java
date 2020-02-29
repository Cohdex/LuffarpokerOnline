package se.cohdex.luffarpoker;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * Main starting point for the Luffarpoker Online application.
 * 
 * @author Jonathan Cohlin
 */
@SpringBootApplication
public class LuffarpokerOnlineApplication implements WebMvcConfigurer {

	public static void main(String[] args) {
		SpringApplication.run(LuffarpokerOnlineApplication.class, args);
	}

	@Bean
	public MessageSource messageSource(@Value("${messages.basename}") String messagesBasename) {
		ReloadableResourceBundleMessageSource messageSource = new ReloadableResourceBundleMessageSource();
		messageSource.setFallbackToSystemLocale(false);
		messageSource.setBasename(messagesBasename);
		return messageSource;
	}
}
