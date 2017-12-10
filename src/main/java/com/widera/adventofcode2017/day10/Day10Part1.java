package com.widera.adventofcode2017.day10;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Day10Part1 {

    public static void main(String[] args) throws IOException {
        final String[] input = Files.lines(Paths.get("input-day10-part1.txt")).collect(Collectors.joining()).split(",");
        CircularList list = new CircularList( IntStream.range(0, 256).boxed().collect(Collectors.toList()));
        System.out.println(list);
        for (String value : input) {
            list.operation(Integer.valueOf(value));
            System.out.println(list);
        }
        System.out.println(list.multiplyingFirstTwoValuesOfList());
    }

}
