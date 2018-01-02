package com.widera.adventofcode2017.day22;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class GridTest {

	@Test
	public void test() {
        String[] startMap = new String[3];
        startMap[0] = "..#";
        startMap[1] = "#..";
        startMap[2] = "...";
        
        Grid grid = new Grid(startMap, 9);
        
        char[][] expected = new char[9][9];
        expected[0] = ".........".toCharArray();
        expected[1] = ".........".toCharArray();
        expected[2] = ".........".toCharArray();
        expected[3] = ".....#...".toCharArray();
        expected[4] = "...#.....".toCharArray();
        expected[5] = ".........".toCharArray();
        expected[6] = ".........".toCharArray();
        expected[7] = ".........".toCharArray();
        expected[8] = ".........".toCharArray();
        
        assertArrayEquals(expected, grid.field());
	}
	
	@Test
	public void testMiddle() {
        String[] startMap = new String[3];
        startMap[0] = "...";
        startMap[1] = ".#.";
        startMap[2] = "...";
        
        Grid grid = new Grid(startMap, 9);
        
        assertEquals('#', grid.node(4, 4));
	}
	
	@Test
	public void testIsInfected() {
        String[] startMap = new String[3];
        startMap[0] = "...";
        startMap[1] = ".#.";
        startMap[2] = "...";
        
        Grid grid = new Grid(startMap, 9);
        
        assertTrue(grid.isInfected(4, 4));
	}
	
	@Test
	public void testIsNotInfected() {
        String[] startMap = new String[3];
        startMap[0] = "...";
        startMap[1] = ".#.";
        startMap[2] = "...";
        
        Grid grid = new Grid(startMap, 9);
        
        assertFalse(grid.isInfected(2, 2));
	}
	
	@Test
	public void testInfectedNode() {
        String[] startMap = new String[3];
        startMap[0] = "...";
        startMap[1] = "...";
        startMap[2] = "...";
        
        Grid grid = new Grid(startMap, 9);
        assertFalse(grid.isInfected(4, 4));
        grid.infect(4, 4);
        assertTrue(grid.isInfected(4, 4));
	}
	
	@Test
	public void testCleanNode() {
        String[] startMap = new String[3];
        startMap[0] = "...";
        startMap[1] = ".#.";
        startMap[2] = "...";
        
        Grid grid = new Grid(startMap, 9);
        assertTrue(grid.isInfected(4, 4));
        grid.clean(4, 4);
        assertFalse(grid.isInfected(4, 4));
	}

}
