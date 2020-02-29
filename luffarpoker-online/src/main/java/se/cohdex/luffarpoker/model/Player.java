package se.cohdex.luffarpoker.model;

import java.awt.Color;

import lombok.Data;

@Data
public class Player {

	private final String name;
	private final Color color;
	private final Color backgroundColor;
}
