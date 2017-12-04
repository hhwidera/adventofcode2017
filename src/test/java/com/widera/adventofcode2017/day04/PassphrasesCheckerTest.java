package com.widera.adventofcode2017.day04;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

public class PassphrasesCheckerTest {

    @Test
    public void test1() {
        assertTrue(new PassphrasesChecker("aa bb cc dd ee").isValid());
    }

    @Test
    public void test2() {
        assertFalse(new PassphrasesChecker("aa bb cc dd aa").isValid());
    }

    @Test
    public void test3() {
        assertTrue(new PassphrasesChecker("aa bb cc dd aaa").isValid());
    }

}