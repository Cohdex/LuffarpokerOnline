package se.cohdex.luffarpoker.model;

import java.util.ArrayList;
import java.util.List;

import lombok.Data;

@Data
public class Game {

	private final String gameId;
	private final List<Player> players = new ArrayList<>();
	private final List<GameRound> rounds = new ArrayList<>();

	public int getPlayerTotalScore(Player player) {
		int totalScore = 0;
		for (GameRound round : rounds) {
			totalScore += round.getPlayerScores().getOrDefault(player, 0);
		}
		return totalScore;
	}
}
