package com.widera.adventofcode2017.day10;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class KnotHash {

    private final List<Integer> integerInputs;

    private final CircularList circularList;

    public KnotHash(final String input) {
        this.integerInputs = convertInputToAsciiIntegers(input);
        this.circularList = new CircularList(IntStream.range(0, 256).boxed().collect(Collectors.toList()));
        addFixSequenceToInput();
        run64Rounds();
    }

    private void addFixSequenceToInput() {
        integerInputs.addAll(Arrays.asList(17, 31, 73, 47, 23));
    }

    private List<Integer> convertInputToAsciiIntegers(final String input) {
        List<Integer> result = new ArrayList<>();
        for (char inputChar : input.toCharArray()) {
            result.add(Integer.valueOf((int) inputChar));
        }
        return result;
    }

    public List<Integer> getIntegerInputs() {
        return Collections.unmodifiableList(integerInputs);
    }

    private void run64Rounds() {
        for (int r = 0; r < 64; r++) {
            for (Integer value : integerInputs) {
                circularList.operation(value);
            }
        }
    }

    private List<Integer> spareHash() {
        return circularList.spareHash();
    }

    private List<Integer> denseHash() {
        List<Integer> spareHash = spareHash();
        List<Integer> denseHash = new ArrayList<>();
        for (int p = 0; p < 16; p++) {
            int part = spareHash.get(p * 16);
            for (int n = 1; n < 16; n++) {
                part ^= spareHash.get(p * 16 + n);
            }
            denseHash.add(part);
        }
        return denseHash;
    }

    public String denseHashAsHex() {
        return denseHash().stream()
                .map(Integer::toHexString)
                .map(hex -> hex.length() == 1 ? "0" + hex : hex)
                .collect(Collectors.joining());
    }
}
