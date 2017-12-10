package com.widera.adventofcode2017.day07;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Day07Part1 {

    public static void main(String[] args) throws IOException {
        final String[] input = Files.lines(Paths.get("input-day07-part1.txt")).toArray(String[]::new);
        ProgramTree tree = new ProgramTree();
        tree.addProgramsAsString(input);
        System.out.println(tree.rootProgramName());
    }
}
