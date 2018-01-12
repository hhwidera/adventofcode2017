package com.widera.adventofcode2017.day24;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;

public class BridgeBuilderTest {


    @Test
    public void testOneComponents() {
        BridgeBuilder builder = new BridgeBuilder(new Component("0/0"), 0, Arrays.asList(
                new Component("0/4")
        ));
        builder.buildBridges();
        assertEquals(4, builder.strengthOfStrongestBridge());
    }

    @Test
    public void testTwoComponents() {
        BridgeBuilder builder = new BridgeBuilder(new Component("0/0"), 0, Arrays.asList(
                new Component("0/4"),
                new Component("0/3")
        ));
        builder.buildBridges();
        assertEquals(4, builder.strengthOfStrongestBridge());
    }

    @Test
    public void testStrengthComponents() {
        BridgeBuilder builder = new BridgeBuilder(new Component("0/0"), 0, Arrays.asList(
                new Component("0/4"),
                new Component("4/3"),
                new Component("4/12")
        ));
        builder.buildBridges();
        assertEquals(20, builder.strengthOfStrongestBridge());
    }

    @Test
    public void strengthOfLongestStrongestBridge1() throws Exception {
        BridgeBuilder builder = new BridgeBuilder(new Component("0/0"), 0, Arrays.asList(
                new Component("0/4"),
                new Component("4/3"),
                new Component("3/3"),
                new Component("4/12")
        ));
        builder.buildBridges();
        assertEquals(17, builder.strengthOfLongestStrongestBridge(builder.longestBridge()));
    }

    @Test
    public void testExample() {
        BridgeBuilder builder = new BridgeBuilder(new Component("0/0"), 0, Arrays.asList(
                new Component("0/2"),
                new Component("2/2"),
                new Component("2/3"),
                new Component("3/4"),
                new Component("3/5"),
                new Component("0/1"),
                new Component("10/1"),
                new Component("9/10")
        ));
        builder.buildBridges();
        assertEquals(31, builder.strengthOfStrongestBridge());
    }

    @Test
    public void testLongestPathExample() {
        BridgeBuilder builder = new BridgeBuilder(new Component("0/0"), 0, Arrays.asList(
                new Component("0/2"),
                new Component("2/2"),
                new Component("2/3"),
                new Component("3/4"),
                new Component("3/5"),
                new Component("0/1"),
                new Component("10/1"),
                new Component("9/10")
        ));
        builder.buildBridges();
        assertEquals(4, builder.longestBridge() - 1);
    }
}