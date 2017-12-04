package com.widera.adventofcode2017.day04;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

public class Day04Part1 {

    public static void main(String[] args) throws IOException {
        final List<String> input = Files.lines(Paths.get("input-day04-part1.txt")).collect(Collectors.toList());

        System.out.println(input.stream()
                .filter(passphrase -> new PassphrasesChecker(passphrase).isValid())
                .peek(System.out::println)
                .count());
    }
}
