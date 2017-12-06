package com.widera.adventofcode2017.day06;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class InfiniteLoopFinder {
	
	private final MemoryReallocation memoryReallocation;
	
	public InfiniteLoopFinder(MemoryReallocation memoryReallocation) {
		this.memoryReallocation = memoryReallocation;
	}

	public int sizeOfRedistributionCyclesBeforeSeenLoop() {
		int counter = 0;
		
		Set<List<Integer>> seenMemoryBlocks = new HashSet<>();
		
		while (!seenMemoryBlocks.contains(getActualMemoryBlock())) {
			seenMemoryBlocks.add(getActualMemoryBlock());
			memoryReallocation.reallocation();
			counter++;
		}
		return counter;
	}
	
	private List<Integer> getActualMemoryBlock() {
		return Arrays.stream(memoryReallocation.getActualMemoryBlocks()).boxed().collect(Collectors.toList());
	}
}
