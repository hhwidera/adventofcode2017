package com.widera.adventofcode2017.day10;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Collectors;

public class Day10Part2 {

    public static void main(String[] args) throws IOException {
        final String input = Files.lines(Paths.get("input-day10-part2.txt")).collect(Collectors.joining());
        KnotHash hash = new KnotHash(input);
        System.out.println(hash.denseHashAsHex());
    }

}
