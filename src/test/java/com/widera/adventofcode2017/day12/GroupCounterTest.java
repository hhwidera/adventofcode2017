package com.widera.adventofcode2017.day12;

import org.junit.Test;

import static org.junit.Assert.*;

public class GroupCounterTest {

    @Test
    public void test() {
        String[] input = new String[] {
                "0 <-> 2",
                "1 <-> 1",
                "2 <-> 0, 3, 4",
                "3 <-> 2, 4",
                "4 <-> 2, 3, 6",
                "5 <-> 6",
                "6 <-> 4, 5"
        };
        GroupCounter counter = new GroupCounter(input);
        assertEquals(2, counter.counter());
    }

}