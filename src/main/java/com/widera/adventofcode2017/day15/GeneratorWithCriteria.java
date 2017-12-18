package com.widera.adventofcode2017.day15;

import java.util.function.Supplier;

public class GeneratorWithCriteria implements Supplier<Long> {
	
	private final Generator generator;
	private final long criteria;

	public GeneratorWithCriteria(final long factor, final long startValue, final long criteria) {
		this.generator = new Generator(factor, startValue);
		this.criteria = criteria;
	}

	@Override
	public Long get() {
		long nextValue = 0;
		do {
			nextValue = generator.get();
		} while (nextValue % criteria != 0);
		return nextValue;
	}

}
