package com.widera.adventofcode2017.day08;

import java.util.ArrayList;
import java.util.List;

public class InstructionInterpreter {

    private final List<Instruction> instructions;

    public InstructionInterpreter(String[] instructionsAsString) {
        this.instructions = new ArrayList<>();
        for (String instructionAsString : instructionsAsString) {
            instructions.add(new Instruction(instructionAsString));
        }
    }

    public void runOnRegister(final Register register) {
        for (Instruction instruction : instructions) {
            instruction.run(register);
        }
    }

}
