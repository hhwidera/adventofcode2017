package com.widera.adventofcode2017.day15;

public class Day15Part2 {

	public static void main(String[] args) {
		GeneratorWithCriteria generatorA = new GeneratorWithCriteria(16807, 699, 4);
		GeneratorWithCriteria generatorB = new GeneratorWithCriteria(48271, 124, 8);
		
		Judge judge = new Judge(generatorA, generatorB);
		System.out.println(judge.matchingCountOfLowest16Bits(5_000_000));
	}
}
