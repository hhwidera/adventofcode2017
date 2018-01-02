package com.widera.adventofcode2017.day22;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Day22Part1 {

    public static void main(String[] args) throws IOException {
        final String[] input = Files.lines(Paths.get("input-day22-part1.txt")).toArray(String[]::new);
        
        Grid grid = new Grid(input, 10_000);
        
        VirusCarrier carrier = new VirusCarrier(grid, 5_000, 5_000);
        carrier.run(10_000);
        
        System.out.println(grid.sizeOfBursts());
    }
}
