package com.widera.adventofcode2017.day15;

import java.util.function.Supplier;
import java.util.stream.Stream;

public class Judge {

	private final Supplier<Long> generatorA;
	private final Supplier<Long> generatorB;
	
	public Judge(final Supplier<Long> generatorA, final Supplier<Long> generatorB) {
		this.generatorA = generatorA;
		this.generatorB = generatorB;
	}
	
	public long matchingCountOfLowest16Bits(final int pairs) {
		return Stream.generate(() -> new Long[] {generatorA.get(), generatorB.get()})
				.limit(pairs)
				.map(pair -> new String[] {
						Long.toBinaryString(pair[0]), 
						Long.toBinaryString(pair[1])})
				.map(pair -> new String[] {
						String.format("%32s", pair[0]).replace(" ", "0"), 
						String.format("%32s", pair[1]).replace(" ", "0")})
//				.peek(pair -> System.out.println("\n" + pair[0] + " " + pair[1]))
				.filter(pair -> pair[0].substring(pair[0].length()-16).equals(pair[1].substring(pair[1].length()-16)))
				.peek(pair -> System.out.println("X"))
				.count();
	}
	
}
