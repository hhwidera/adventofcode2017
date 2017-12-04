package com.widera.adventofcode2017.day02;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class SpreadSheetCheckSumPart2Test {

    @Test
    public void test() {
        List<String> input = Arrays.asList(
                "5\t9\t2\t8",
                "9\t4\t7\t3",
                "3\t8\t6\t5"
        );
        assertEquals(9, new SpreadSheetCheckSumPart2(input).calculate());
    }

}