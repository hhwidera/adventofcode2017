package com.widera.adventofcode2017.day25;

public class TuringMachine {

    private static int STEPS = 12_459_852;

    private State state;

    private int[] tape;

    private int cursor;

    public TuringMachine() {
        state = new State.A();
        tape = new int[STEPS];
        cursor = STEPS / 2;
    }

    public void run() {
        for (int s = 0; s < STEPS; s++) {
            int value = tape[cursor];
            tape[cursor] = state.writeValue(value);
            cursor += state.move(value);
            state = state.nextState(value);
        }
    }

    public int checksum() {
        int result = 0;
        for (int t = 0; t < tape.length; t++) {
            result += tape[t];
        }
        return result;
    }
}
