package com.widera.adventofcode2017.day06;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.stream.Collectors;

public class Day06Part2 {

	public static void main(String[] args) throws IOException {
		final String inputAsString = Files.lines(Paths.get("input-day06-part2.txt")).collect(Collectors.joining());
		int[] memoryBlockInput = Arrays.stream(inputAsString.split("\t")).map(String::trim).mapToInt(Integer::parseInt).toArray();
		
		InfiniteLoopFinder finder = new InfiniteLoopFinder(new MemoryReallocation(memoryBlockInput));
		System.out.println("seen first loop:" + finder.sizeOfRedistributionCyclesBeforeSeenLoop());
		System.out.println("seen this loop again:" + finder.sizeOfRedistributionCyclesBeforeSeenLoop());
	}
}
