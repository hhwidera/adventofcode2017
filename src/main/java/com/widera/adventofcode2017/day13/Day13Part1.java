package com.widera.adventofcode2017.day13;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Day13Part1 {

    public static void main(String[] args) throws IOException {
        final String[] input = Files.lines(Paths.get("input-day13-part1.txt")).toArray(String[]::new);
        Firewall firewall = new Firewall(input);
        System.out.println(firewall.severity());
    }
}
