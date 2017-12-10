package com.widera.adventofcode2017.day08;

import org.junit.Test;

import static org.junit.Assert.*;

public class InstructionInterpreterTest {

    @Test
    public void testHighestValueInRegister() {
     String[] instructions = new String[] {
             "b inc 5 if a > 1",
             "a inc 1 if b < 5",
             "c dec -10 if a >= 1",
             "c inc -20 if c == 10"
        };
        InstructionInterpreter interpreter = new InstructionInterpreter(instructions);
        Register register = new Register();
        interpreter.runOnRegister(register);
        assertEquals(1, register.getHighestValueInRegister());
    }

    @Test
    public void testHighestValueHeld() {
        String[] instructions = new String[] {
                "b inc 5 if a > 1",
                "a inc 1 if b < 5",
                "c dec -10 if a >= 1",
                "c inc -20 if c == 10"
        };
        InstructionInterpreter interpreter = new InstructionInterpreter(instructions);
        Register register = new Register();
        interpreter.runOnRegister(register);
        assertEquals(10, register.getLargestValueInRegisterHeldInAnyRegister());
    }

}