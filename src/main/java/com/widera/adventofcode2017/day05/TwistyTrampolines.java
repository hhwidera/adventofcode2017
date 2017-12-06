package com.widera.adventofcode2017.day05;

import java.util.Arrays;

public class TwistyTrampolines {
	
	private final int[] field;
	private int jumpFieldPointer;

	public TwistyTrampolines(final int[] startField) {
		this.field = startField;
		this.jumpFieldPointer = 0;
	}

	private int nextJumpSize() {
		return field[jumpFieldPointer];
	}
	
	public void jump() {
		if (canDoNextJump()) {
			int jumpSize = nextJumpSize();
			field[jumpFieldPointer]++;
			jumpFieldPointer += jumpSize;
		}
	}

	public int[] getField() {
		return Arrays.copyOf (field, field.length);
	}

	public int actualJumpPointFieldIndex() {
		return jumpFieldPointer;
	}

	public boolean canDoNextJump() {
		return jumpFieldPointer + nextJumpSize() >= 0 
				&& jumpFieldPointer + nextJumpSize() < field.length;
	}

}
