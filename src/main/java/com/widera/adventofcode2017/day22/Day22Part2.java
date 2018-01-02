package com.widera.adventofcode2017.day22;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Day22Part2 {

    public static void main(String[] args) throws IOException {
        final String[] input = Files.lines(Paths.get("input-day22-part2.txt")).toArray(String[]::new);
        
        Grid grid = new Grid(input, 10_000);
        
        VirusCarrier2 carrier = new VirusCarrier2(grid, 5_000, 5_000);
        carrier.run(10_000_000);
        
        System.out.println(grid.sizeOfBursts());
    }
}
