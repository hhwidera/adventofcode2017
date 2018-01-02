package com.widera.adventofcode2017.day22;

import java.awt.Point;

public class VirusCarrier2 {
	
	private static final Point UP = new Point(0, -1);
	private static final Point DOWN = new Point(0, 1);
	private static final Point LEFT = new Point(-1, 0);
	private static final Point RIGHT = new Point(1, 0);

	private final Grid grid;
	
	private int positionX;
	private int positionY;
	
	private Point direction;
	
	public VirusCarrier2(final Grid grid, final int positionX, final int positionY) {
		this.grid = grid;
		this.positionX = positionX;
		this.positionY = positionY;
		this.direction = UP;
	}
	
	public void run(final int rounds) {
		for (int r = 0; r < rounds; r++) {
			if (grid.isClean(positionX, positionY)) {
				turnLeft();
			} else if (grid.isInfected(positionX, positionY)) {
				turnRight();
			} else if (grid.isFlagged(positionX, positionY)) {
				reverseDirection();
			} 
			modifyCurrentNode();
			move();
		}
	}

	private void reverseDirection() {
		if (UP.equals(direction)) {
			direction = DOWN;
		} else if (DOWN.equals(direction)) {
			direction = UP;
		} else if (RIGHT.equals(direction)) {
			direction = LEFT;
		} else if (LEFT.equals(direction)) {
			direction = RIGHT;
		}
	}

	private void modifyCurrentNode() {
		if (grid.isClean(positionX, positionY)) {
			grid.weaken(positionX, positionY);
		} else if (grid.isWeakened(positionX, positionY)) {
			grid.infect(positionX, positionY);
		} else if (grid.isInfected(positionX, positionY)) {
			grid.flag(positionX, positionY);
		} else if (grid.isFlagged(positionX, positionY)) {
			grid.clean(positionX, positionY);
		} 
	}

	private void move() {
		positionX += direction.x;
		positionY += direction.y;
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
