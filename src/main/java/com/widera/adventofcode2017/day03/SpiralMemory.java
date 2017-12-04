package com.widera.adventofcode2017.day03;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class SpiralMemory {
    public int carriedStepsFor(final int square) {
        if (square == 1) {
            return 0;
        }

        int round = getRoundOfSquare(square);
        System.out.println("square " + square + " is in round " + round);
        int sw = calculateRoundEnd(round);
        System.out.println("sw: " + sw);
        int s = sw - round;
        System.out.println("s: " + s);
        int se = s - round;
        System.out.println("se: " + se);
        int e = se - round;
        System.out.println("e: " + e);
        int ne = e - round;
        System.out.println("ne: " + ne);
        int n = ne - round;
        System.out.println("n: " + n);
        int nw = n - round;
        System.out.println("nw: " + nw);
        int w = nw - round;
        System.out.println("w: " + w);
        List<Integer> roundElements = Arrays.asList(s, e, n, w);
        int directSquareElement = roundElements.stream().map(roundElement -> Math.abs(square - roundElement)).sorted(Comparator.naturalOrder()).findFirst().get();

        System.out.println("directSquareElement " + directSquareElement);

        return round + directSquareElement;
    }

    private int calculateRoundEnd(int round) {
        int lastRoundendPoint = 1;
        for (int r = 1; r <= round; r++) {
            lastRoundendPoint += r * 8;
        }
        return lastRoundendPoint;
    }

    private int getRoundOfSquare(int square) {
        int round = 0;

        while (calculateRoundEnd(round) <= square) {
            round++;
        }

        return round;
    }
}
