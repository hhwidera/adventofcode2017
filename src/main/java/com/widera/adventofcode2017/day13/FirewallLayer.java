package com.widera.adventofcode2017.day13;

public class FirewallLayer {

    private final int range;

    public FirewallLayer(final int range) {
        this.range = range;
    }

    public boolean isOpen(final int time) {
        return !(time % ((range - 1) * 2) == 0);
    }

    public int getRange() {
        return range;
    }

}
