package com.widera.adventofcode2017.day13;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class FirewallTest {

    @Test
    public void test() {
        String[] input = new String[] {
                "0: 3",
                "1: 2",
                "4: 4",
                "6: 4"
        };

        Firewall firewall = new Firewall(input);

        assertEquals(24, firewall.severity());
    }


    @Test
    public void testNullSeverity() {
        String[] input = new String[] {
                "0: 3",
                "1: 2",
                "4: 4",
                "6: 4"
        };

        int delay = 0;

        Firewall firewall = new Firewall(input);

        while(!firewall.isOpen(delay)) {
            delay++;
        }

        assertEquals(10, delay);
    }

}