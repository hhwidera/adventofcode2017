package com.widera.adventofcode2017.day05;

import static org.junit.Assert.*;

import org.junit.Test;

public class TwistyTrampolinesTest {

	@Test
	public void testStep1() {
		TwistyTrampolines tt = new TwistyTrampolines(new int[] {0, 3, 0, 1, -3});
		tt.jump();
		assertArrayEquals(new int[] {1, 3, 0, 1, -3}, tt.getField());
		assertEquals(0, tt.actualJumpPointFieldIndex());
		assertTrue(tt.canDoNextJump());
	}
	
	@Test
	public void testStep2() {
		TwistyTrampolines tt = new TwistyTrampolines(new int[] {0, 3, 0, 1, -3});
		tt.jump();
		tt.jump();
		assertArrayEquals(new int[] {2, 3, 0, 1, -3}, tt.getField());
		assertEquals(1, tt.actualJumpPointFieldIndex());
		assertTrue(tt.canDoNextJump());
	}
	
	@Test
	public void testStep3() {
		TwistyTrampolines tt = new TwistyTrampolines(new int[] {0, 3, 0, 1, -3});
		tt.jump();
		tt.jump();
		tt.jump();
		assertArrayEquals(new int[] {2, 4, 0, 1, -3}, tt.getField());
		assertEquals(4, tt.actualJumpPointFieldIndex());
		assertTrue(tt.canDoNextJump());
	}
	
	@Test
	public void testStep4() {
		TwistyTrampolines tt = new TwistyTrampolines(new int[] {0, 3, 0, 1, -3});
		tt.jump();
		tt.jump();
		tt.jump();
		tt.jump();
		assertArrayEquals(new int[] {2, 4, 0, 1, -2}, tt.getField());
		assertEquals(1, tt.actualJumpPointFieldIndex());
		assertFalse(tt.canDoNextJump());
	}

}
