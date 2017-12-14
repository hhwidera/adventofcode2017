package com.widera.adventofcode2017.day12;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Day12Part2 {

    public static void main(String[] args) throws IOException {
        final String[] input = Files.lines(Paths.get("input-day12-part2.txt")).toArray(String[]::new);
        GroupCounter counter = new GroupCounter(input);
        System.out.println(counter.counter());
    }
}
