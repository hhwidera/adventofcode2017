package com.widera.adventofcode2017.day15;

public class Day15Part1 {

	public static void main(String[] args) {
		Generator generatorA = new Generator(16807, 699);
		Generator generatorB = new Generator(48271, 124);
		
		Judge judge = new Judge(generatorA, generatorB);
		System.out.println(judge.matchingCountOfLowest16Bits(40_000_000));
	}
}
