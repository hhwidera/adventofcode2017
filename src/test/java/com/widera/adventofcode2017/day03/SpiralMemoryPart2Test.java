package com.widera.adventofcode2017.day03;

import org.junit.Test;

import static org.junit.Assert.*;

public class SpiralMemoryPart2Test {

    @Test
    public void test57() {
        assertEquals(57, new SpiralMemoryPart2().getNextStepValueAfter(55));
    }

    @Test
    public void test11() {
        assertEquals(11, new SpiralMemoryPart2().getNextStepValueAfter(10));
    }

    @Test
    public void test25() {
        assertEquals(25, new SpiralMemoryPart2().getNextStepValueAfter(24));
    }

    @Test
    public void test806() {
        assertEquals(806, new SpiralMemoryPart2().getNextStepValueAfter(800));
    }
}