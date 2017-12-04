package com.widera.adventofcode2017.day03;

import org.junit.Test;

import static org.junit.Assert.*;

public class SpiralMemoryTest {

    @Test
    public void test1() {
        assertEquals(0, new SpiralMemory().carriedStepsFor(1));
    }

    @Test
    public void test12() {
        assertEquals(3, new SpiralMemory().carriedStepsFor(12));
    }

    @Test
    public void test23() {
        assertEquals(2, new SpiralMemory().carriedStepsFor(23));
    }

    @Test
    public void test1024() {
        assertEquals(31, new SpiralMemory().carriedStepsFor(1024));
    }
}