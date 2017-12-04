package com.widera.adventofcode2017.day01;

import org.junit.Test;

import static org.junit.Assert.*;

public class SequenceSumHalfRoundTest {

    @Test
    public void test1() {
        assertEquals(6, new SequenceSumHalfRound("1212").calculate());
    }

    @Test
    public void test2() {
        assertEquals(0, new SequenceSumHalfRound("1221").calculate());
    }

    @Test
    public void test3() {
        assertEquals(4, new SequenceSumHalfRound("123425").calculate());
    }

    @Test
    public void test4() {
        assertEquals(12, new SequenceSumHalfRound("123123").calculate());
    }

    @Test
    public void test5() {
        assertEquals(4, new SequenceSumHalfRound("12131415").calculate());
    }

}