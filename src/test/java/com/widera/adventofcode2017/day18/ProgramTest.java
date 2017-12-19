package com.widera.adventofcode2017.day18;

import static org.junit.Assert.*;

import org.junit.Test;

public class ProgramTest {

	@Test
	public void test() {
		String[] input = new String[] {
				"set a 1",
				"add a 2",
				"mul a a",
				"mod a 5",
				"snd a",
				"set a 0",
				"rcv a",
				"jgz a -1",
				"set a 1",
				"jgz a -2"
		};
		Program program = new Program(input);
		program.run();
		assertEquals(4, program.lastRecoveredPlayedFrequency());
	}

}
