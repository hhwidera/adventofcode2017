package com.widera.adventofcode2017.day08;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Day08Part2 {

    public static void main(String[] args) throws IOException {
        final String[] input = Files.lines(Paths.get("input-day08-part2.txt")).toArray(String[]::new);
        InstructionInterpreter interpreter = new InstructionInterpreter(input);
        Register register = new Register();
        interpreter.runOnRegister(register);
        System.out.println(register.getLargestValueInRegisterHeldInAnyRegister());
    }
}
