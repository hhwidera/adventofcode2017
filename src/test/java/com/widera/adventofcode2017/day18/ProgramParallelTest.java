package com.widera.adventofcode2017.day18;

import org.junit.Test;

import static org.junit.Assert.*;

public class ProgramParallelTest {

    @Test
    public void test() {
        String[] input = new String[] {
                "snd 1",
                "snd 2",
                "snd p",
                "rcv a",
                "rcv b",
                "rcv c",
                "rcv d"
        };

        ProgramParallel p0 = new ProgramParallel(input, 0);
        ProgramParallel p1 = new ProgramParallel(input, 1);
        p0.setSendingQueue(p1.getReceiveQueue());
        p1.setSendingQueue(p0.getReceiveQueue());

        while (!((p0.isWaiting() && p1.isWaiting())
                || (p0.isTerminated() && p1.isTerminated()))) {
            p0.runNextInstruction();
            p1.runNextInstruction();
        }

        assertEquals(3, p1.sendMessages());
    }

}