package com.widera.adventofcode2017.day11;

public enum HexGridMove {

	N(0,1,0),
	S(0,-1,0),
	NW(-1, 0, 0),
	SE(1, 0, 0),
	NE(0, 0, -1),
	SW(0, 0, 1);
	
	private final HexGridPosition move;
	
	HexGridMove(int x, int y, int z) {
		move = new HexGridPosition(x, y ,z);
	}
	
	public HexGridPosition move() {
		return move;
	}
	
	public static HexGridMove get(final String asString) {
		return HexGridMove.valueOf(asString.toUpperCase());
	}
}
