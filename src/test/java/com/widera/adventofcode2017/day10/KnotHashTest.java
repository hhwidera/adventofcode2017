package com.widera.adventofcode2017.day10;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

public class KnotHashTest {

    @Test
    public void testInputConverting() {
        KnotHash kh = new KnotHash("1,2,3");
        assertEquals(Arrays.asList(49, 44, 50, 44, 51, 17, 31, 73, 47, 23), kh.getIntegerInputs());
    }

    @Test
    public void testEmptyString() {
        KnotHash kh = new KnotHash("");
        assertEquals("a2582a3a0e66e6e86e3812dcb672a272", kh.denseHashAsHex());
    }

    @Test
    public void testAoC2017() {
        KnotHash kh = new KnotHash("AoC 2017");
        assertEquals("33efeb34ea91902bb2f59c9920caa6cd", kh.denseHashAsHex());
    }

    @Test
    public void test123() {
        KnotHash kh = new KnotHash("1,2,3");
        assertEquals("3efbe78a8d82f29979031a4aa0b16a9d", kh.denseHashAsHex());
    }

    @Test
    public void test124() {
        KnotHash kh = new KnotHash("1,2,4");
        assertEquals("63960835bcdc130f0b66d7ff4f6a5a8e", kh.denseHashAsHex());
    }
}