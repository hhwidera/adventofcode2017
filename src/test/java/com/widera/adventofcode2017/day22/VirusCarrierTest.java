package com.widera.adventofcode2017.day22;

import static org.junit.Assert.*;

import org.junit.Test;

public class VirusCarrierTest {

	@Test
	public void testPositionStartPosition() {
		String[] startMap = new String[3];
        startMap[0] = "..#";
        startMap[1] = "#..";
        startMap[2] = "...";
        
        Grid grid = new Grid(startMap, 9);
        
        VirusCarrier carrier = new VirusCarrier(grid, 4, 4);
        
        assertTrue(carrier.isOnPosition(4, 4));
	}
	
	@Test
	public void testPositionAfterRound1() {
		String[] startMap = new String[3];
        startMap[0] = "..#";
        startMap[1] = "#..";
        startMap[2] = "...";
        
        Grid grid = new Grid(startMap, 9);
        
        VirusCarrier carrier = new VirusCarrier(grid, 4, 4);
        carrier.run(1);
        
        assertTrue(carrier.isOnPosition(3, 4));
	}
	
	@Test
	public void testPositionAfterRound2() {
		String[] startMap = new String[3];
        startMap[0] = "..#";
        startMap[1] = "#..";
        startMap[2] = "...";
        
        Grid grid = new Grid(startMap, 9);
        
        VirusCarrier carrier = new VirusCarrier(grid, 4, 4);
        carrier.run(2);
        
        assertTrue(carrier.isOnPosition(3, 3));
	}
	
	@Test
	public void testPositionAfterRound70() {
		String[] startMap = new String[3];
        startMap[0] = "..#";
        startMap[1] = "#..";
        startMap[2] = "...";
        
        Grid grid = new Grid(startMap, 9);
        
        VirusCarrier carrier = new VirusCarrier(grid, 4, 4);
        carrier.run(70);
        
        assertTrue(carrier.isOnPosition(5, 3));
	}
	
	@Test
	public void testGridBursts() {
		String[] startMap = new String[3];
        startMap[0] = "..#";
        startMap[1] = "#..";
        startMap[2] = "...";
        
        Grid grid = new Grid(startMap, 10_000);
        
        VirusCarrier carrier = new VirusCarrier(grid, 10_000 / 2, 10_000 / 2);
        carrier.run(10_000);
        
        assertEquals(5587, grid.sizeOfBursts());
	}

}
