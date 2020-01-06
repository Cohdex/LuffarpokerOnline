package se.cohdex.luffarpoker.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import se.cohdex.luffarpoker.util.MyStringUtil;

@Controller
public class GreetingController {

	private static final Logger LOG = LogManager.getLogger();

	public GreetingController() {
		LOG.error("GreetingController created", new Exception("message", new Exception("nested exception")));
	}

	@GetMapping("/greeting")
	public String greeting(@RequestParam(name = "name", required = false, defaultValue = "World") String name,
			Model model) {
		LOG.info("'/greeting' requested with parameters [name='{}']", name);
		name = MyStringUtil.capitalizeWords(name);
		LOG.info("Name was capitalized: '{}'", name);
		model.addAttribute("name", name);
		return "greeting";
	}
}
