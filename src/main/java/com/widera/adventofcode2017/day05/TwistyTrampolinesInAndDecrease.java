package com.widera.adventofcode2017.day05;

import java.util.Arrays;

public class TwistyTrampolinesInAndDecrease {
	
	private final int[] field;
	private int jumpFieldPointer;

	public TwistyTrampolinesInAndDecrease(final int[] startField) {
		this.field = startField;
		this.jumpFieldPointer = 0;
	}

	private int nextJumpSize() {
		int jumpSize = field[jumpFieldPointer];
		return jumpSize;
	}
	
	public void jump() {
		if (canDoNextJump()) {
			int jumpSize = nextJumpSize();
			int oldJumpFieldPointer = jumpFieldPointer;
			jumpFieldPointer += jumpSize;
			if (jumpSize >= 3) {
				field[oldJumpFieldPointer]--;
			} else {
				field[oldJumpFieldPointer]++;
			}
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
