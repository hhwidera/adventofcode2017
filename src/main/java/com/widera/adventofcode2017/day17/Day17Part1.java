package com.widera.adventofcode2017.day17;

public class Day17Part1 {

	public static void main(String[] args) {
		Spinlock spinlock = new Spinlock(2017, 363);
		System.out.println(spinlock.getValueAfterPosition());
	}
}
