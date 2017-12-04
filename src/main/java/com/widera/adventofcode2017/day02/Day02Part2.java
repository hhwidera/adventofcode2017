package com.widera.adventofcode2017.day02;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

public class Day02Part2 {

    public static void main(String[] args) throws IOException {
        final List<String> input = Files.lines(Paths.get("input-day02-part2.txt")).collect(Collectors.toList());
        System.out.println(new SpreadSheetCheckSumPart2(input).calculate());
    }
}
