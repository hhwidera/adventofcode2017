package com.widera.adventofcode2017.day15;

import static org.junit.Assert.*;

import java.util.stream.Stream;

import org.junit.Test;

public class GeneratorTest {

	@Test
	public void testGeneratorA() {
		Stream<Long> expected = Stream.of(1092455L, 1181022009L, 245556042L, 1744312007L, 1352636452L);
		Generator generator = new Generator(16807, 65);
		expected.forEach(exp -> assertEquals(exp, generator.get()));
	}

	@Test
	public void testGeneratorB() {
		Stream<Long> expected = Stream.of(430625591L, 1233683848L, 1431495498L, 137874439L, 285222916L);
		Generator generator = new Generator(48271, 8921);
		expected.forEach(exp -> assertEquals(exp, generator.get()));
	}
	
}
