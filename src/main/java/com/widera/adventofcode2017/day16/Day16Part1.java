package com.widera.adventofcode2017.day16;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Collectors;

public class Day16Part1 {

	public static void main(String[] args) throws IOException {
		final String input = Files.lines(Paths.get("input-day16-part1.txt")).collect(Collectors.joining());
		
		Dance dance = new Dance(input.split(","), 16);
		System.out.println(dance.dance());
	}
}
