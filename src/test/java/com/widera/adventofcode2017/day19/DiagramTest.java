package com.widera.adventofcode2017.day19;

import org.junit.Test;

import static org.junit.Assert.*;

public class DiagramTest {

    @Test
    public void test() {
        String[] input = new String[] {
                "     |          ",
                "     |  +--+    ",
                "     A  |  C    ",
                " F---|----E|--+ ",
                "     |  |  |  D ",
                "     +B-+  +--+ "
        };

        Diagram diagram = new Diagram(input);
        assertEquals("ABCDEF", diagram.lettersOnPath());
    }

    @Test
    public void testStepCount() {
        String[] input = new String[] {
                "     |          ",
                "     |  +--+    ",
                "     A  |  C    ",
                " F---|----E|--+ ",
                "     |  |  |  D ",
                "     +B-+  +--+ "
        };

        Diagram diagram = new Diagram(input);
        assertEquals(38, diagram.stepsTotal());
    }

}