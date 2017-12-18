package com.widera.adventofcode2017.day16;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Collectors;

public class Day16Part2 {

	public static void main(String[] args) throws IOException {
		final String input = Files.lines(Paths.get("input-day16-part2.txt")).collect(Collectors.joining());
		final String[] moves = input.split(",");
		Dance dance = new Dance(moves, 16);
		
		String danced = null;
		
		for (int d = 0; d < 1000000000; d++) {
			String result = dance.dance();
			if (danced == null) {
				danced = result;
			} 
			System.out.println((d + 1) + ": " + result);
			if (danced.equals(result) && d > 1) {
				System.out.println("in round " + (d + 1) + " is same result like first dance!");
				d = ( 1000000000 / d ) * d;
			}
		}
	}
}
