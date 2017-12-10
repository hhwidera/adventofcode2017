package com.widera.adventofcode2017.day09;

import org.junit.Test;

import static org.junit.Assert.*;

public class GroupTest {

    @Test
    public void testGroups() {

        assertEquals(1, new Group("{}", 1).groupCount());
        assertEquals(3, new Group("{{{}}}", 1).groupCount());
        assertEquals(3, new Group("{{},{}}", 1).groupCount());
        assertEquals(6, new Group("{{{},{},{{}}}}", 1).groupCount());
        assertEquals(1, new Group("{<{},{},{{}}>}", 1).groupCount());
        assertEquals(1, new Group("{<a>,<a>,<a>,<a>}", 1).groupCount());
        assertEquals(5, new Group("{{<a>},{<a>},{<a>},{<a>}}", 1).groupCount());
        assertEquals(2, new Group("{{<!>},{<!>},{<!>},{<a>}}", 1).groupCount());

    }

    @Test
    public void testScore() {

        assertEquals(1, new Group("{}", 1).score());
        assertEquals(6, new Group("{{{}}}", 1).score());
        assertEquals(5, new Group("{{},{}}", 1).score());
        assertEquals(16, new Group("{{{},{},{{}}}}", 1).score());
        assertEquals(1, new Group("{<a>,<a>,<a>,<a>}", 1).score());
        assertEquals(9, new Group("{{<ab>},{<ab>},{<ab>},{<ab>}}", 1).score());
        assertEquals(9, new Group("{{<!!>},{<!!>},{<!!>},{<!!>}}", 1).score());
        assertEquals(3, new Group("{{<a!>},{<a!>},{<a!>},{<ab>}}", 1).score());

    }

    @Test
    public void testCanceledGarbage() {
        assertEquals(0, new Group("{<>}", 1).canceledGarbageChars());
        assertEquals(17, new Group("{<random characters>}", 1).canceledGarbageChars());
        assertEquals(3, new Group("{<<<<>}", 1).canceledGarbageChars());
        assertEquals(2, new Group("{<{!>}>}", 1).canceledGarbageChars());
        assertEquals(0, new Group("{<!!>}", 1).canceledGarbageChars());
        assertEquals(0, new Group("{<!!!>>}", 1).canceledGarbageChars());
        assertEquals(10, new Group("{<{o\"i!a,<{i<a>}", 1).canceledGarbageChars());
    }
}