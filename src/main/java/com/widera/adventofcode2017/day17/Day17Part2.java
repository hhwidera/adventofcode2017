package com.widera.adventofcode2017.day17;

public class Day17Part2 {

	public static void main(String[] args) {
		Spinlock spinlock = new Spinlock(50_000_000, 363);
		System.out.println(spinlock.getValueAfterValueZero()); // 1080289, need ~5min
	}
}
