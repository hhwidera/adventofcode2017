package com.widera.adventofcode2017.day05;

import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.Test;

public class TwistyTrampolinesInAndDecreaseTest {

	@Test
	public void testStep10() {
		TwistyTrampolinesInAndDecrease tt = new TwistyTrampolinesInAndDecrease(new int[] { 0, 3, 0, 1, -3 });
		System.out.println(Arrays.toString(tt.getField()) + " p:" + tt.actualJumpPointFieldIndex() + ", next:" + tt.canDoNextJump());
		tt.jump();
		System.out.println(Arrays.toString(tt.getField()) + " p:" + tt.actualJumpPointFieldIndex() + ", next:" + tt.canDoNextJump());
		tt.jump();
		System.out.println(Arrays.toString(tt.getField()) + " p:" + tt.actualJumpPointFieldIndex() + ", next:" + tt.canDoNextJump());
		tt.jump();
		System.out.println(Arrays.toString(tt.getField()) + " p:" + tt.actualJumpPointFieldIndex() + ", next:" + tt.canDoNextJump());
		tt.jump();
		System.out.println(Arrays.toString(tt.getField()) + " p:" + tt.actualJumpPointFieldIndex() + ", next:" + tt.canDoNextJump());
		tt.jump();
		System.out.println(Arrays.toString(tt.getField()) + " p:" + tt.actualJumpPointFieldIndex() + ", next:" + tt.canDoNextJump());
		tt.jump();
		System.out.println(Arrays.toString(tt.getField()) + " p:" + tt.actualJumpPointFieldIndex() + ", next:" + tt.canDoNextJump());
		tt.jump();
		System.out.println(Arrays.toString(tt.getField()) + " p:" + tt.actualJumpPointFieldIndex() + ", next:" + tt.canDoNextJump());
		tt.jump();
		System.out.println(Arrays.toString(tt.getField()) + " p:" + tt.actualJumpPointFieldIndex() + ", next:" + tt.canDoNextJump());
		tt.jump();
		System.out.println(Arrays.toString(tt.getField()) + " p:" + tt.actualJumpPointFieldIndex() + ", next:" + tt.canDoNextJump());
		assertArrayEquals(new int[] { 2, 3, 2, 2, -1 }, tt.getField());
		assertFalse(tt.canDoNextJump());
	}

}
