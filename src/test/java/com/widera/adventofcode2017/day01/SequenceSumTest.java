package com.widera.adventofcode2017.day01;

import org.junit.Test;

import static org.junit.Assert.*;

public class SequenceSumTest {

    @Test
    public void testCase1() {
        assertEquals(3, new SequenceSum("1122").calculate());
    }

    @Test
    public void testCase2() {
        assertEquals(4, new SequenceSum("1111").calculate());
    }

    @Test
    public void testCase3() {
        assertEquals(0, new SequenceSum("1234").calculate());
    }

    @Test
    public void testCase4() {
        assertEquals(9, new SequenceSum("91212129").calculate());
    }

}