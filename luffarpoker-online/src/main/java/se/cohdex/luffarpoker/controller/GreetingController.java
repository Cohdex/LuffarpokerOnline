package se.cohdex.luffarpoker.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import lombok.extern.log4j.Log4j2;
import se.cohdex.luffarpoker.util.MyStringUtil;

/**
 * Controller for handling /greeting requests.
 * 
 * @author Jonathan Cohlin
 */
@Controller
@Log4j2
public class GreetingController {

	/**
	 * Handles /greeting requests. Takes the input name parameter, capitalizes it
	 * and supplies it to the model for presenting in the greeting view. Returns the
	 * greeting view.
	 * 
	 * @param name  name to show in greeting
	 * @param model the MVC model
	 * @return the name of the greeting view
	 */
	@GetMapping("/greeting")
	public String greeting(@RequestParam(name = "name", required = false, defaultValue = "World") String name,
			Model model) {
		log.info("'/greeting' requested with parameters [name='{}']", name);
		name = MyStringUtil.capitalizeWords(name);
		log.info("Name was capitalized: '{}'", name);
		model.addAttribute("name", name);
		return "greeting";
	}
}
