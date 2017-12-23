package com.widera.adventofcode2017.day19;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Day19Part2 {

    public static void main(String[] args) throws IOException {
        final String[] input = Files.lines(Paths.get("input-day19-part2.txt")).toArray(String[]::new);
        Diagram diagram = new Diagram(input);
        System.out.println(diagram.stepsTotal());
    }
}
