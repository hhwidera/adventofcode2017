package com.widera.adventofcode2017.day02;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class SpreadSheetCheckSumTest {

    @Test
    public void test() {
        List<String> input = Arrays.asList(
                "5\t1\t9\t5",
                "7\t5\t3",
                "2\t4\t6\t8"
        );
        assertEquals(18, new SpreadSheetCheckSum(input).calculate());
    }

}