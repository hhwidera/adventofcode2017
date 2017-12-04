package com.widera.adventofcode2017.day04;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

public class Day04Part2 {

    public static void main(String[] args) throws IOException {
        final List<String> input = Files.lines(Paths.get("input-day04-part2.txt")).collect(Collectors.toList());

        System.out.println(input.stream()
                .filter(passphrase -> new PassphrasesRearrangedChecker(passphrase).isValid())
                .peek(System.out::println)
                .count());
    }
}
