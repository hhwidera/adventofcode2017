package com.widera.adventofcode2017.day13;

public class Firewall {

    private FirewallLayer[] layers = new FirewallLayer[100];

    public Firewall(final String[] input) {
        buildLayers(input);
    }

    private void buildLayers(String[] input) {
        for (String inputLayer : input) {
            String[] parts = inputLayer.split(": ");
            Integer position = Integer.valueOf(parts[0]);
            Integer range = Integer.valueOf(parts[1]);
            layers[position] = new FirewallLayer(range);
        }
    }

    public int trip() {
        return trip(0);
    }

    public int trip(final int delay) {
        int severity = 0;
        for (int m = 0; m < layers.length; m++) {
            if (layers[m] != null && !layers[m].isOpen(m + delay)) {
                severity += layers[m].getRange() * m;
            }
        }
        return severity;
    }

    public boolean isOpen(final int delay) {
        for (int m = 0; m < layers.length; m++) {
            if (layers[m] != null && !layers[m].isOpen(m + delay)) {
                return false;
            }
        }
        return true;
    }

    public int severity() {
        return trip();
    }

}
