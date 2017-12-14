package com.widera.adventofcode2017.day12;

import org.junit.Test;

import static org.junit.Assert.*;

public class GroupTest {

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
        Group g = new Group(0, input);
        assertEquals(6, g.memberSize());
    }

}