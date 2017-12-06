package com.widera.adventofcode2017.day06;

import static org.junit.Assert.*;

import org.junit.Test;

public class InfiniteLoopFinderTest {

	@Test
	public void test() {
		MemoryReallocation mr = new MemoryReallocation(new int[] {0, 2, 7, 0});
		assertEquals(5, new InfiniteLoopFinder(mr).sizeOfRedistributionCyclesBeforeSeenLoop());
	}
	
	@Test
	public void testSeenSameLoopAgain() {
		MemoryReallocation mr = new MemoryReallocation(new int[] {0, 2, 7, 0});
		InfiniteLoopFinder finder = new InfiniteLoopFinder(mr);
		finder.sizeOfRedistributionCyclesBeforeSeenLoop();
		assertEquals(4, finder.sizeOfRedistributionCyclesBeforeSeenLoop());
		
	}

}
