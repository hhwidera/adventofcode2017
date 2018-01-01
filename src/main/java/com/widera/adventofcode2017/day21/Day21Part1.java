package com.widera.adventofcode2017.day21;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Day21Part1 {

    public static void main(String[] args) throws IOException {
        final String[] input = Files.lines(Paths.get("input-day21-part1.txt")).toArray(String[]::new);
        List<Rule> rules = Arrays.stream(input).map(Rule::new).collect(Collectors.toList());

        char[][] startImage = new char[3][3];
        startImage[0] = ".#.".toCharArray();
        startImage[1] = "..#".toCharArray();
        startImage[2] = "###".toCharArray();

        Image image = new Image(startImage, rules);

        image.grow(5);

        System.out.println(image.sizeOfOnPixels());
    }
}
