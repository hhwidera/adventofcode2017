package com.widera.adventofcode2017.day25;

public class Day25Part1 {

    public static void main(String[] args) {
        TuringMachine machine = new TuringMachine();
        machine.run();
        System.out.println(machine.checksum());
    }
}
