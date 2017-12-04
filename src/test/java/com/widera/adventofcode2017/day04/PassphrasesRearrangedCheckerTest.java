package com.widera.adventofcode2017.day04;

import org.junit.Test;

import static org.junit.Assert.*;

public class PassphrasesRearrangedCheckerTest {

    @Test
    public void test1() {
        assertTrue(new PassphrasesRearrangedChecker("abcde fghij").isValid());
    }

    @Test
    public void test2() {
        assertFalse(new PassphrasesRearrangedChecker("abcde xyz ecdab").isValid());
    }

    @Test
    public void test3() {
        assertTrue(new PassphrasesRearrangedChecker("a ab abc abd abf abj").isValid());
    }

    @Test
    public void test4() {
        assertTrue(new PassphrasesRearrangedChecker("iiii oiii ooii oooi oooo").isValid());
    }

    @Test
    public void test5() {
        assertFalse(new PassphrasesRearrangedChecker("oiii ioii iioi iiio").isValid());
    }

}