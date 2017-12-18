package com.widera.adventofcode2017.day16;

import static org.junit.Assert.*;

import org.junit.Test;

public class DanceTest {

	@Test
	public void test() {
		String[] moves = new String[] {
				"s1",
				"x3/4",
				"pe/b"
		};
		Dance dance = new Dance(moves , 5);
		
		assertEquals("baedc", dance.dance());
	}
	
	@Test
	public void testSecondRound() {
		String[] moves = new String[] {
				"s1",
				"x3/4",
				"pe/b"
		};
		Dance dance = new Dance(moves , 5);
		dance.dance();
		assertEquals("ceadb", dance.dance());
	}

}
