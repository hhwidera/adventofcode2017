package com.widera.adventofcode2017.day16;

import java.util.Arrays;

public class Dance {
	
	private char[] floor = new char[16];
	private final String[] moves;

	public Dance(final String[] moves, final int floorSize) {
		floor = new char[floorSize];
		initDanceFloor();
		this.moves = moves;
	}

	private void initDanceFloor() {
		for (int p = 0; p < floor.length; p++) {
			floor[p] = (char) ((byte)'a' + p);
		}
	}
	
	public String dance() {
		for (String move : moves) {
			if (move.startsWith("s")) {
				spin(Integer.valueOf(move.substring(1)));
			} else if (move.startsWith("x")) {
				String[] parts = move.substring(1).split("/");
				exchange(Integer.valueOf(parts[0]), Integer.valueOf(parts[1]));
			} else if (move.startsWith("p")) {
				String[] parts = move.substring(1).split("/");
				partner(parts[0].charAt(0), parts[1].charAt(0));
			}
		}
		return String.valueOf(floor);
	}

	private void partner(final char programA, final char programB) {
		int programAPosition = findPosition(programA);
		int programBPosition = findPosition(programB);
		exchange(programAPosition, programBPosition);
	}

	private int findPosition(char program) {
		for (int f = 0; f < floor.length; f++) {
			if (floor[f] == program) {
				return f;
			}
		}
		return -1;
	}

	private void exchange(final Integer positionA, final Integer positionB) {
		char buffer = floor[positionA];
		floor[positionA] = floor[positionB];
		floor[positionB] = buffer;
	}

	private void spin(final Integer steps) {
		char[] firstPart = Arrays.copyOfRange(floor, 0, floor.length - steps);
		char[] lastPart = Arrays.copyOfRange(floor, floor.length - steps, floor.length);
		for (int f = 0; f < lastPart.length; f++) {
			floor[f] = lastPart[f];
		}
		for (int f = 0; f < firstPart.length; f++) {
			floor[f + lastPart.length] = firstPart[f];
		}
	}
}
