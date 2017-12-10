package com.widera.adventofcode2017.day08;

public class Instruction {

    private final String instructionAsString;

    public Instruction(final String instructionAsString) {
        this.instructionAsString = instructionAsString;
    }

    public void run(final Register register) {
        String[] parts = instructionAsString.split(" ");
        String registerFieldToModify = parts[0];
        String modifyType = parts[1];
        Integer modifyValue = Integer.valueOf(parts[2]);
        String conditionFieldName = parts[4];
        String conditionLogic = parts[5];
        Integer conditionValue = Integer.valueOf(parts[6]);

        if (conditionIsTrue(register, conditionFieldName, conditionLogic, conditionValue)) {
            if (modifyType.equals("inc")) {
                register.incValueToRegister(registerFieldToModify, modifyValue);
            } else if (modifyType.equals("dec")) {
                register.decValueToRegister(registerFieldToModify, modifyValue);
            } else {
                throw new IllegalArgumentException("can't parse modify type '" + modifyType + "'!");
            }
        }
    }

    private boolean conditionIsTrue(final Register register, final String conditionFieldName, final String conditionLogic, final int conditionValue) {
        int actualRegisterValue = register.getRegisterValue(conditionFieldName);
        switch (conditionLogic) {
            case "==": return actualRegisterValue == conditionValue;
            case "!=": return actualRegisterValue != conditionValue;
            case "<": return actualRegisterValue < conditionValue;
            case ">": return actualRegisterValue > conditionValue;
            case "<=": return actualRegisterValue <= conditionValue;
            case ">=": return actualRegisterValue >= conditionValue;
            default: throw new IllegalArgumentException("can't parse '" + conditionLogic + "'!");
        }
    }
}
