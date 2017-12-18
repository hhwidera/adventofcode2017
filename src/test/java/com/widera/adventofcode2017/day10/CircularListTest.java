package com.widera.adventofcode2017.day10;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;

import org.junit.Test;

public class CircularListTest {

    @Test
    public void testInitStep() {
        CircularList list = new CircularList(Arrays.asList(0, 1, 2, 3, 4));
        assertEquals("[0] 1 2 3 4", list.toString());
        assertEquals(0, list.skipSize());
    }

    @Test
    public void testFirstStep() {
        CircularList list = new CircularList(Arrays.asList(0, 1, 2, 3, 4));
        list.operation(3);
        assertEquals("2 1 0 [3] 4", list.toString());
        assertEquals(1, list.skipSize());
    }

    @Test
    public void testTwoStep() {
        CircularList list = new CircularList(Arrays.asList(0, 1, 2, 3, 4));
        list.operation(3);
        list.operation(4);
        assertEquals("4 3 0 [1] 2", list.toString());
        assertEquals(2, list.skipSize());
    }

    @Test
    public void testThreeStep() {
        CircularList list = new CircularList(Arrays.asList(0, 1, 2, 3, 4));
        list.operation(3);
        list.operation(4);
        list.operation(1);
        assertEquals("4 [3] 0 1 2", list.toString());
        assertEquals(3, list.skipSize());
    }

    @Test
    public void testFourStep() {
        CircularList list = new CircularList(Arrays.asList(0, 1, 2, 3, 4));
        list.operation(3);
        list.operation(4);
        list.operation(1);
        list.operation(5);
        assertEquals("3 4 2 1 [0]", list.toString());
        assertEquals(4, list.skipSize());
    }

    @Test
    public void testAfterFourStepsMultiplicateFirstAndSecondValue() {
        CircularList list = new CircularList(Arrays.asList(0, 1, 2, 3, 4));
        list.operation(3);
        list.operation(4);
        list.operation(1);
        list.operation(5);
        assertEquals(12, list.multiplyingFirstTwoValuesOfList());
    }
}