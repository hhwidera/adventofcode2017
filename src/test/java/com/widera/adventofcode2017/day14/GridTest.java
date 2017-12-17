package com.widera.adventofcode2017.day14;

import org.junit.Test;

import static org.junit.Assert.*;

public class GridTest {

    @Test
    public void test() {
        Grid grid = new Grid("flqrgnkx");
        assertEquals(8108, grid.usedSquares());
    }

    @Test
    public void testGroups() {
        Grid grid = new Grid("flqrgnkx");
        assertEquals(1242, grid.usedSquareGroups());
    }

}