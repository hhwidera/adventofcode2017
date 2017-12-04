package com.widera.adventofcode2017.day01;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Collectors;

public class Day01Part1 {

    public static void main(String[] args) throws IOException {
        final String input = Files.lines(Paths.get("input-day01-part1.txt")).collect(Collectors.joining());
        System.out.println(new SequenceSum(input).calculate());
    }

}
