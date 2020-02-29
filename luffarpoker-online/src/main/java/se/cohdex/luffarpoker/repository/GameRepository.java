package se.cohdex.luffarpoker.repository;

import java.awt.Color;
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
		{
			Game game1 = new Game("1");
			gameCache.put(game1.getGameId(), game1);

			Player player1 = new Player("Player1", Color.getHSBColor(0.0f / 3.0f, 1.0f, 1.0f), Color.getHSBColor(0.0f / 3.0f + 0.5f, 1.0f, 1.0f));
			Player player2 = new Player("Player2", Color.getHSBColor(1.0f / 3.0f, 1.0f, 1.0f), Color.getHSBColor(1.0f / 3.0f + 0.5f, 1.0f, 1.0f));
			Player player3 = new Player("Player3", Color.getHSBColor(2.0f / 3.0f, 1.0f, 1.0f), Color.getHSBColor(2.0f / 3.0f + 0.5f, 1.0f, 1.0f));

			game1.getPlayers().add(player1);
			game1.getPlayers().add(player2);
			game1.getPlayers().add(player3);

			GameRound round1 = new GameRound(GameRound.RoundType.TWO_THREE_OF_A_KIND);
			game1.getRounds().add(round1);
			round1.getPlayerScores().put(player1, 7);
			round1.getPlayerScores().put(player2, 0);
			round1.getPlayerScores().put(player3, 5);

			GameRound round2 = new GameRound(GameRound.RoundType.ONE_THREE_OF_A_KIND_ONE_STRAIGHT_FLUSH);
			game1.getRounds().add(round2);
			round2.getPlayerScores().put(player1, 0);
			round2.getPlayerScores().put(player2, 99);
			round2.getPlayerScores().put(player3, 96);
		}

		{
			Game game2 = new Game("2");
			gameCache.put(game2.getGameId(), game2);

			Player player1 = new Player("Player1", Color.getHSBColor(0.0f / 4.0f, 1.0f, 1.0f), Color.getHSBColor(0.0f / 4.0f + 0.5f, 1.0f, 1.0f));
			Player player2 = new Player("Player2", Color.getHSBColor(1.0f / 4.0f, 1.0f, 1.0f), Color.getHSBColor(1.0f / 4.0f + 0.5f, 1.0f, 1.0f));
			Player player3 = new Player("Player3", Color.getHSBColor(2.0f / 4.0f, 1.0f, 1.0f), Color.getHSBColor(2.0f / 4.0f + 0.5f, 1.0f, 1.0f));
			Player player4 = new Player("Player4", Color.getHSBColor(3.0f / 4.0f, 1.0f, 1.0f), Color.getHSBColor(3.0f / 4.0f + 0.5f, 1.0f, 1.0f));
			
			game2.getPlayers().add(player1);
			game2.getPlayers().add(player2);
			game2.getPlayers().add(player3);
			game2.getPlayers().add(player4);

			Random rnd = new Random(5247749218062482201L);
			for (GameRound.RoundType roundType : GameRound.RoundType.values()) {
				GameRound round = new GameRound(roundType);
				game2.getRounds().add(round);
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
			}
		}
	}

	public Optional<Game> get(String gameId) {
		return Optional.ofNullable(gameCache.get(gameId));
	}
}
