package com.widera.adventofcode2017.day18;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Day18Part1 {
	
	public static void main(String[] args) throws IOException {
		final String[] input = Files.lines(Paths.get("input-day18-part1.txt")).toArray(String[]::new);
		
		Program program = new Program(input);
		program.run();
		System.out.println(program.lastRecoveredPlayedFrequency());
	}

}
