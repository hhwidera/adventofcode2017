package com.widera.adventofcode2017.day22;

import static org.junit.Assert.*;

import org.junit.Test;

public class VirusCarrier2Test {

	@Test
	public void testAfterStep1() {
		String[] startMap = new String[3];
        startMap[0] = "..#";
        startMap[1] = "#..";
        startMap[2] = "...";
        
        Grid grid = new Grid(startMap, 9);
        
        VirusCarrier2 carrier = new VirusCarrier2(grid, 4, 4);
        carrier.run(1);
        
        assertTrue(carrier.isOnPosition(3, 4));
        assertTrue(grid.isWeakened(4, 4));
	}
	
	@Test
	public void testAfterStep2() {
		String[] startMap = new String[3];
        startMap[0] = "..#";
        startMap[1] = "#..";
        startMap[2] = "...";
        
        Grid grid = new Grid(startMap, 9);
        
        VirusCarrier2 carrier = new VirusCarrier2(grid, 4, 4);
        carrier.run(2);
        
        assertTrue(carrier.isOnPosition(3, 3));
        assertTrue(grid.isFlagged(3, 4));
	}
	
	@Test
	public void testBurstsAfterStep100() {
		String[] startMap = new String[3];
        startMap[0] = "..#";
        startMap[1] = "#..";
        startMap[2] = "...";
        
        Grid grid = new Grid(startMap, 100);
        
        VirusCarrier2 carrier = new VirusCarrier2(grid, 50, 50);
        carrier.run(100);
        
        assertEquals(26, grid.sizeOfBursts());
	}
	
	@Test
	public void testBurstsAfterStep10_000_000() {
		String[] startMap = new String[3];
        startMap[0] = "..#";
        startMap[1] = "#..";
        startMap[2] = "...";
        
        Grid grid = new Grid(startMap, 5_000);
        
        VirusCarrier2 carrier = new VirusCarrier2(grid, 5_000/2, 5_000/2);
        carrier.run(10_000_000);
        
        assertEquals(2511944, grid.sizeOfBursts());
	}

}
