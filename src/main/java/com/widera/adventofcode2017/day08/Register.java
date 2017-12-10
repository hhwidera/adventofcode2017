package com.widera.adventofcode2017.day08;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class Register {

    private final Map<String, Integer> register;

    private Integer highestValue = 0;

    public Register() {
        this.register = new HashMap<>();
    }

    private void initRegisterIfNotExists(final String name) {
        if (!register.containsKey(name)) {
            register.put(name, 0);
        }
    }

    public Integer getRegisterValue(final String name) {
        initRegisterIfNotExists(name);
        return register.get(name);
    }

    public void incValueToRegister(final String name, final Integer addValue) {
        initRegisterIfNotExists(name);
        if (highestValue < register.get(name) + addValue) {
            highestValue = register.get(name) + addValue;
        }
        register.put(name, register.get(name) + addValue);
    }

    public void decValueToRegister(final String name, final Integer addValue) {
        initRegisterIfNotExists(name);
        if (highestValue < register.get(name) - addValue) {
            highestValue = register.get(name) - addValue;
        }
        register.put(name, register.get(name) - addValue);
    }

    public int getHighestValueInRegister() {
        return register.values().stream().max(Comparator.naturalOrder()).orElse(Integer.MIN_VALUE).intValue();
    }

    public int getLargestValueInRegisterHeldInAnyRegister() {
        return highestValue;
    }
}
