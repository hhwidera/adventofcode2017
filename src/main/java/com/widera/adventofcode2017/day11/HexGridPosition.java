package com.widera.adventofcode2017.day11;

public class HexGridPosition {

	private int x;
	private int y;
	private int z;
	
	public HexGridPosition(int x, int y , int z) {
		this.x = x;
		this.y = y;
		this.z = z;
	}
	
	public HexGridPosition add(HexGridPosition other) {
		return new HexGridPosition(
				x + other.x, 
				y + other.y, 
				z + other.z);
	}
	
	public HexGridPosition sub(HexGridPosition other) {
		return new HexGridPosition(
				x - other.x, 
				y - other.y, 
				z - other.z);
	}
	
	public int x() {
		return x;
	}
	
	public int y() {
		return y;
	}
	
	public int z() {
		return z;
	}
}
