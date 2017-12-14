package com.widera.adventofcode2017.day12;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Day12Part1 {

    public static void main(String[] args) throws IOException {
        final String[] input = Files.lines(Paths.get("input-day12-part1.txt")).toArray(String[]::new);
        Group nullGroup = new Group(0, input);
        System.out.println(nullGroup.memberSize());
    }
}
