package com.widera.adventofcode2017.day22;

import java.util.Arrays;

public class Grid {
	
	private final char[][] field;
	
	private int infects = 0;

	public Grid(final String[] startMap, final int gridSize) {
		field = new char[gridSize][gridSize];
		Arrays.stream(field).forEach(row -> Arrays.fill(row, '.'));
		int middle = gridSize/2;
		int startMapStartSize = middle - startMap.length/2;
		
		for (int r = 0; r < startMap.length; r++) {
			for (int c = 0; c < startMap[r].length(); c++) {
				field[startMapStartSize + r][startMapStartSize + c] = startMap[r].toCharArray()[c];
			}
		}
	}
	
	private char[][] clone(final char[][] array) {
        return Arrays.stream(array).map(row -> row.clone()).toArray($ -> array.clone());
    }
	
	public char[][] field() {
		return clone(field);
	}

	public char node(int x, int y) {
		return field[y][x];
	}

	public boolean isInfected(int x, int y) {
		return '#' == node(x, y);
	}

	public void clean(int x, int y) {
		field[y][x] = '.';
	}

	public void infect(int x, int y) {
		field[y][x] = '#';
		infects++;
	}

	public int sizeOfBursts() {
		return infects;
	}
}
