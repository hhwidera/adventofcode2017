package com.widera.adventofcode2017.day15;

import static org.junit.Assert.*;

import java.util.stream.Stream;

import org.junit.Test;

public class GeneratorWithCriteriaTest {

	@Test
	public void testGeneratorA() {
		Stream<Long> expected = Stream.of(1352636452L, 1992081072L, 530830436L, 1980017072L, 740335192L);
		GeneratorWithCriteria generator = new GeneratorWithCriteria(16807, 65, 4);
		expected.forEach(exp -> assertEquals(exp, generator.get()));
	}

	@Test
	public void testGeneratorB() {
		Stream<Long> expected = Stream.of(1233683848L, 862516352L, 1159784568L, 1616057672L, 412269392L);
		GeneratorWithCriteria generator = new GeneratorWithCriteria(48271, 8921, 8);
		expected.forEach(exp -> assertEquals(exp, generator.get()));
	}

}
