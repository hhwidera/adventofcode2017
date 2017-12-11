package com.widera.adventofcode2017.day11;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Collectors;

public class Day11Part1 {

	public static void main(String[] args) throws IOException {
		final String input = Files.lines(Paths.get("input-day11-part1.txt")).collect(Collectors.joining());
		Path path = new Path(input);
		path.go();
		System.out.println(path.stepsAwayFromStart());
	}
}
