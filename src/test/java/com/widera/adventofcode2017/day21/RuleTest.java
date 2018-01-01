package com.widera.adventofcode2017.day21;

import org.junit.Test;

import static org.junit.Assert.*;

public class RuleTest {

    @Test
    public void test2x2RuleReplaceTo3x3() {
        Rule rule = new Rule("../.# => ##./#../...");
        char[][] replace = new char[3][3];
        replace[0] = "##.".toCharArray();
        replace[1] = "#..".toCharArray();
        replace[2] = "...".toCharArray();
        assertArrayEquals(replace, rule.getReplace());
    }

    @Test
    public void test3x3RuleReplaceTo4x4() {
        Rule rule = new Rule(".#./..#/### => #..#/..../..../#..#");
        char[][] replace = new char[4][4];
        replace[0] = "#..#".toCharArray();
        replace[1] = "....".toCharArray();
        replace[2] = "....".toCharArray();
        replace[3] = "#..#".toCharArray();
        assertArrayEquals(replace, rule.getReplace());
    }

    @Test
    public void test2x2RuleMatch() {
        Rule rule = new Rule("../.# => ##./#../...");
        char[][] matching = new char[2][2];
        matching[0] = "..".toCharArray();
        matching[1] = ".#".toCharArray();
        assertTrue(rule.match(matching));
    }

    @Test
    public void test2x2RuleMatchRotate() {
        Rule rule = new Rule("../.# => ##./#../...");
        char[][] matching = new char[2][2];
        matching[0] = ".#".toCharArray();
        matching[1] = "..".toCharArray();
        assertTrue(rule.match(matching));

        matching[0] = "..".toCharArray();
        matching[1] = "#.".toCharArray();
        assertTrue(rule.match(matching));

        matching[0] = "#.".toCharArray();
        matching[1] = "..".toCharArray();
        assertTrue(rule.match(matching));
    }

    @Test
    public void test3x3RuleMatchRotate() {
        Rule rule = new Rule(".#./..#/### => #..#/..../..../#..#");
        char[][] matching = new char[3][3];
        matching[0] = ".#.".toCharArray();
        matching[1] = "..#".toCharArray();
        matching[2] = "###".toCharArray();
        assertTrue(rule.match(matching));

        matching[0] = ".#.".toCharArray();
        matching[1] = "#..".toCharArray();
        matching[2] = "###".toCharArray();
        assertTrue(rule.match(matching));

        matching[0] = "#..".toCharArray();
        matching[1] = "#.#".toCharArray();
        matching[2] = "##.".toCharArray();
        assertTrue(rule.match(matching));

        matching[0] = "###".toCharArray();
        matching[1] = "..#".toCharArray();
        matching[2] = ".#.".toCharArray();
        assertTrue(rule.match(matching));

    }

    @Test
    public void test2x2RuleNotMatch() {
        Rule rule = new Rule("../.# => ##./#../...");
        char[][] matching = new char[2][2];
        matching[0] = ".#".toCharArray();
        matching[1] = ".#".toCharArray();
        assertFalse(rule.match(matching));
    }

    @Test
    public void test2x2RuleNotMatchBy3x3() {
        Rule rule = new Rule("../.# => ##./#../...");
        char[][] matching = new char[3][3];
        matching[0] = "##.".toCharArray();
        matching[1] = "#..".toCharArray();
        matching[2] = "...".toCharArray();
        assertFalse(rule.match(matching));
    }

    @Test
    public void test2x2RuleNotMatchByEmpty() {
        Rule rule = new Rule("../.# => ##./#../...");
        assertFalse(rule.match(new char[0][0]));
    }
}