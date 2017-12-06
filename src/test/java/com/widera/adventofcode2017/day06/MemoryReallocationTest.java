package com.widera.adventofcode2017.day06;

import static org.junit.Assert.*;

import org.junit.Test;

public class MemoryReallocationTest {

	@Test
	public void testOneReallocation() {
		MemoryReallocation mr = new MemoryReallocation(new int[] {0, 2, 7, 0});
		mr.reallocation();
		assertArrayEquals(new int[] {2, 4, 1, 2}, mr.getActualMemoryBlocks());
	}
	
	@Test
	public void testTwoReallocation() {
		MemoryReallocation mr = new MemoryReallocation(new int[] {0, 2, 7, 0});
		mr.reallocation();
		mr.reallocation();
		assertArrayEquals(new int[] {3, 1, 2, 3}, mr.getActualMemoryBlocks());
	}

	@Test
	public void testThreeReallocation() {
		MemoryReallocation mr = new MemoryReallocation(new int[] {0, 2, 7, 0});
		mr.reallocation();
		mr.reallocation();
		mr.reallocation();
		assertArrayEquals(new int[] {0, 2, 3, 4}, mr.getActualMemoryBlocks());
	}

	@Test
	public void testFourReallocation() {
		MemoryReallocation mr = new MemoryReallocation(new int[] {0, 2, 7, 0});
		mr.reallocation();
		mr.reallocation();
		mr.reallocation();
		mr.reallocation();
		assertArrayEquals(new int[] {1, 3, 4, 1}, mr.getActualMemoryBlocks());
	}
	
	@Test
	public void testFiveReallocation() {
		MemoryReallocation mr = new MemoryReallocation(new int[] {0, 2, 7, 0});
		mr.reallocation();
		mr.reallocation();
		mr.reallocation();
		mr.reallocation();
		mr.reallocation();
		assertArrayEquals(new int[] {2, 4, 1, 2}, mr.getActualMemoryBlocks());
	}

}
