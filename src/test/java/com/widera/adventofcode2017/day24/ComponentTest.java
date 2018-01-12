package com.widera.adventofcode2017.day24;

import org.junit.Test;

import static org.junit.Assert.*;

public class ComponentTest {

    @Test
    public void testCreateComponentByString() {
        Component component = new Component("12/1");
        assertEquals(12, component.getPortA());
        assertEquals(1, component.getPortB());
    }

    @Test
    public void testCloneComponent() {
        Component component = new Component("12/1").clone();

        assertEquals(12, component.getPortA());
        assertEquals(1, component.getPortB());
    }

    @Test
    public void testHasNullPort() {
        assertTrue(new Component("12/0").hasNullPort());
        assertTrue(new Component("0/0").hasNullPort());
        assertTrue(new Component("0/12").hasNullPort());
        assertFalse(new Component("1/1").hasNullPort());
    }

    @Test
    public void testHasPortType() {
        assertTrue(new Component("12/0").hasPortType(12));
        assertTrue(new Component("0/0").hasPortType(0));
        assertTrue(new Component("0/12").hasPortType(12));
        assertFalse(new Component("1/1").hasPortType(12));
    }
}