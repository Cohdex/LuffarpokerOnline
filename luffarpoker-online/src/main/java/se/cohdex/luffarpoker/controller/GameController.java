package se.cohdex.luffarpoker.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import lombok.extern.log4j.Log4j2;
import se.cohdex.luffarpoker.model.Game;
import se.cohdex.luffarpoker.repository.GameRepository;

/**
 * Controller for handling /game requests.
 * 
 * @author Jonathan Cohlin
 */
@Controller
@Log4j2
public class GameController {

	@Autowired
	private GameRepository gameRepository;

	@GetMapping("/game")
	public String game(@RequestParam(name = "gameId", required = false) String gameId, Model model) {
		log.info("/game requested with parameters [gameId={}]", gameId);

		Optional<Game> game = gameId != null ? gameRepository.get(gameId) : Optional.empty();

		if (game.isPresent()) {
			log.info("Found game with gameId={}", gameId);
			model.addAttribute("game", game.get());
			return "game";
		} else {
			log.info("Game not found" + (gameId != null ? " with gameId={}" : ""), gameId);
			return "new-game";
		}
	}
}
