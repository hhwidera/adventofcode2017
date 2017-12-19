package com.widera.adventofcode2017.day17;

import static org.junit.Assert.*;

import org.junit.Test;

public class SpinlockTest {

	@Test
	public void testForSize1() {
		Spinlock spinlock = new Spinlock(1, 3);
		assertEquals(0, spinlock.getValueAfterPosition());
	}
	
	@Test
	public void testForSize2() {
		Spinlock spinlock = new Spinlock(2, 3);
		assertEquals(1, spinlock.getValueAfterPosition());
	}

	@Test
	public void testForSize3() {
		Spinlock spinlock = new Spinlock(3, 3);
		assertEquals(1, spinlock.getValueAfterPosition());
	}
	
	@Test
	public void testForSize4() {
		Spinlock spinlock = new Spinlock(4, 3);
		assertEquals(3, spinlock.getValueAfterPosition());
	}
	
	@Test
	public void testForSize9() {
		Spinlock spinlock = new Spinlock(9, 3);
		assertEquals(5, spinlock.getValueAfterPosition());
	}
	
	@Test
	public void testForSize2017() {
		Spinlock spinlock = new Spinlock(2017, 3);
		assertEquals(638, spinlock.getValueAfterPosition());
	}
}
