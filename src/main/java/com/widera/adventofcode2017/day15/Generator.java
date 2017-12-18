package com.widera.adventofcode2017.day15;

import java.util.function.Supplier;

public class Generator implements Supplier<Long> {
	
	private static final long remainderValue = 2147483647;
	private final long factor;
	private long lastValue = 1;

	public Generator(final long factor, final long startValue) {
		this.factor = factor;
		this.lastValue = startValue;
	}

	@Override
	public Long get() {
		return generateNextValue();
	}

	private Long generateNextValue() {
		Long nextValue = (factor * lastValue) % remainderValue;
		lastValue = nextValue;
		return nextValue;
	}
}
