package se.cohdex.luffarpoker.repository;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.Random;

import org.springframework.stereotype.Component;

import se.cohdex.luffarpoker.model.Game;
import se.cohdex.luffarpoker.model.GameRound;
import se.cohdex.luffarpoker.model.Player;

@Component
public class GameRepository {

	private Map<String, Game> gameCache = new HashMap<>();

	/**
	 * For now just mock some games.
	 */
	public GameRepository() {
		Player jonathan = new Player("Jonathan");
		Player kristin = new Player("Kristin");
		Player lars = new Player("Lars");
		Player christoffer = new Player("Christoffer");

		Game game1 = new Game("1");
		gameCache.put(game1.getGameId(), game1);
		
		game1.getPlayers().add(jonathan);
		game1.getPlayers().add(kristin);
		game1.getPlayers().add(lars);

		game1.getRounds().add(new GameRound(GameRound.RoundType.TWO_THREE_OF_A_KIND));
		game1.getRounds().get(0).getPlayerScores().put(jonathan, 7);
		game1.getRounds().get(0).getPlayerScores().put(kristin, 0);
		game1.getRounds().get(0).getPlayerScores().put(lars, 5);

		game1.getRounds().add(new GameRound(GameRound.RoundType.ONE_THREE_OF_A_KIND_ONE_STRAIGHT_FLUSH));
		game1.getRounds().get(1).getPlayerScores().put(jonathan, 0);
		game1.getRounds().get(1).getPlayerScores().put(kristin, 99);
		game1.getRounds().get(1).getPlayerScores().put(lars, 96);

		Game game2 = new Game("2");
		gameCache.put(game2.getGameId(), game2);
		
		game2.getPlayers().add(jonathan);
		game2.getPlayers().add(kristin);
		game2.getPlayers().add(lars);
		game2.getPlayers().add(christoffer);

		Random rnd = new Random(5247749218062482201L);
		for (GameRound.RoundType roundType : GameRound.RoundType.values()) {
			GameRound round = new GameRound(roundType);
			Player winner = game2.getPlayers().get(rnd.nextInt(game2.getPlayers().size()));
			for (Player player : game2.getPlayers()) {
				int score;
				if (player == winner) {
					score = 0;
				} else {
					score = (int) Math.round(Math.pow(rnd.nextDouble(), 4.0) * 130 + 2.0);
				}
				round.getPlayerScores().put(player, score);
			}
			game2.getRounds().add(round);
		}
	}

	public Optional<Game> get(String gameId) {
		return Optional.ofNullable(gameCache.get(gameId));
	}
}
