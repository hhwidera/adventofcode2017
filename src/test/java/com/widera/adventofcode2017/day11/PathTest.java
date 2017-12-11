package com.widera.adventofcode2017.day11;

import static org.junit.Assert.*;

import org.junit.Test;

public class PathTest {

	@Test
	public void test1() {
		Path p = new Path("ne,ne,ne");
		p.go();
		assertEquals(3, p.stepsAwayFromStart());
	}

	@Test
	public void test2() {
		Path p = new Path("ne,ne,sw,sw");
		p.go();
		assertEquals(0, p.stepsAwayFromStart());
	}
	
	@Test
	public void test3() {
		Path p = new Path("ne,ne,s,s");
		p.go();
		assertEquals(2, p.stepsAwayFromStart());
	}
	
	@Test
	public void test4() {
		Path p = new Path("se,sw,se,sw,sw");
		p.go();
		assertEquals(3, p.stepsAwayFromStart());
	}
}
