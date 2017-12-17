package com.widera.adventofcode2017.day13;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Day13Part2 {

    public static void main(String[] args) throws IOException {
        final String[] input = Files.lines(Paths.get("input-day13-part2.txt")).toArray(String[]::new);

        int delay = 0;

        Firewall firewall = new Firewall(input);

        while(!firewall.isOpen(delay)) {
           delay++;
        }

        System.out.println(delay);
    }
}
