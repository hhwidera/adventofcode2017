package com.widera.adventofcode2017.day05;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Day05Part2 {
	
	public static void main(String[] args) throws IOException {
		final int[] fieldInput = Files.lines(Paths.get("input-day05-part2.txt")).map(Integer::valueOf).mapToInt(i->i).toArray();
		TwistyTrampolinesInAndDecrease twistyTrampolines = new TwistyTrampolinesInAndDecrease(fieldInput);
		
		int rounds = 1;
		while(twistyTrampolines.canDoNextJump()) {
			rounds++;
			twistyTrampolines.jump();
		}
		System.out.println(rounds);
	}
	
}
