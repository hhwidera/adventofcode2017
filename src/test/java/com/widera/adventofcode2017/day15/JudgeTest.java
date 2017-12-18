package com.widera.adventofcode2017.day15;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class JudgeTest {

	@Test
	public void test() {
		Generator generatorA = new Generator(16807, 65);
		Generator generatorB = new Generator(48271, 8921);
		
		Judge judge = new Judge(generatorA, generatorB);
		assertEquals(1L, judge.matchingCountOfLowest16Bits(5));
	}
	
	@Test
	public void test40Mill() {
		Generator generatorA = new Generator(16807, 65);
		Generator generatorB = new Generator(48271, 8921);
		
		Judge judge = new Judge(generatorA, generatorB);
		assertEquals(588L, judge.matchingCountOfLowest16Bits(40_000_000));
	}

	@Test
	public void test5MillWithGeneratorWithCritica() {
		GeneratorWithCriteria generatorA = new GeneratorWithCriteria(16807, 65, 4);
		GeneratorWithCriteria generatorB = new GeneratorWithCriteria(48271, 8921, 8);
		
		Judge judge = new Judge(generatorA, generatorB);
		assertEquals(309L, judge.matchingCountOfLowest16Bits(5_000_000));
	}
}
