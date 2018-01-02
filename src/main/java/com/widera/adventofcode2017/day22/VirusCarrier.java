package com.widera.adventofcode2017.day22;

import java.awt.Point;

public class VirusCarrier {
	
	private static final Point UP = new Point(0, -1);
	private static final Point DOWN = new Point(0, 1);
	private static final Point LEFT = new Point(-1, 0);
	private static final Point RIGHT = new Point(1, 0);

	private final Grid grid;
	
	private int positionX;
	private int positionY;
	
	private Point direction;
	
	public VirusCarrier(final Grid grid, final int positionX, final int positionY) {
		this.grid = grid;
		this.positionX = positionX;
		this.positionY = positionY;
		this.direction = UP;
	}
	
	public void run(final int rounds) {
		for (int r = 0; r < rounds; r++) {
			if (grid.isInfected(positionX, positionY)) {
				turnRight();
				cleanCurrectNode();
			} else {
				turnLeft();
				infectCurrentNode();
			}
			move();
		}
	}

	private void move() {
		positionX += direction.x;
		positionY += direction.y;
	}
	
	private void cleanCurrectNode() {
		grid.clean(positionX, positionY);
	}

	private void infectCurrentNode() {
		grid.infect(positionX, positionY);
	}

	private void turnLeft() {
		if (UP.equals(direction)) {
			direction = LEFT;
		} else if (DOWN.equals(direction)) {
			direction = RIGHT;
		} else if (RIGHT.equals(direction)) {
			direction = UP;
		} else if (LEFT.equals(direction)) {
			direction = DOWN;
		}
	}

	private void turnRight() {
		if (UP.equals(direction)) {
			direction = RIGHT;
		} else if (DOWN.equals(direction)) {
			direction = LEFT;
		} else if (RIGHT.equals(direction)) {
			direction = DOWN;
		} else if (LEFT.equals(direction)) {
			direction = UP;
		}
	}

	public boolean isOnPosition(int x, int y) {
		return positionX == x && positionY == y;
	}
	
}
