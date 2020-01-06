package se.cohdex.luffarpoker.model;

import java.util.HashMap;
import java.util.Map;

import lombok.Data;

@Data
public class GameRound {

	private final RoundType roundType;
	private final Map<Player, Integer> playerScores = new HashMap<>();

	public enum RoundType {

		TWO_THREE_OF_A_KIND, ONE_THREE_OF_A_KIND_ONE_STRAIGHT_FLUSH, TWO_STRAIGHT_FLUSH,
		TWO_THREE_OF_A_KIND_ONE_STRAIGHT_FLUSH, ONE_THREE_OF_A_KIND_TWO_STRAIGHT_FLUSH, THREE_THREE_OF_A_KIND,
		THREE_STRAIGHT_FLUSH;
	}
}
