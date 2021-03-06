package com.widera.adventofcode2017.day09;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Collectors;

public class Day09Part1 {

    public static void main(String[] args) throws IOException {
        final String input = Files.lines(Paths.get("input-day09-part1.txt")).collect(Collectors.joining());
        Group group = new Group(input, 1);
        System.out.println(group.score());
    }
}
