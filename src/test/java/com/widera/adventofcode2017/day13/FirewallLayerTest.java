package com.widera.adventofcode2017.day13;

import org.junit.Test;

import static org.junit.Assert.*;

public class FirewallLayerTest {

    @Test
    public void testRange2() {
        FirewallLayer firewall = new FirewallLayer(2);

        assertFalse(firewall.isOpen(0));
        assertTrue(firewall.isOpen(1));
        assertFalse(firewall.isOpen(2));
    }

    @Test
    public void testRange3() {
        FirewallLayer firewall = new FirewallLayer(3);

        assertFalse(firewall.isOpen(0));
        assertTrue(firewall.isOpen(1));
        assertTrue(firewall.isOpen(2));
        assertTrue(firewall.isOpen(3));
        assertFalse(firewall.isOpen(4));
    }

}