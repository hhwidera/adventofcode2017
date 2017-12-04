package com.widera.adventofcode2017.day02;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class SpreadSheetCheckSum {

    private final List<List<Integer>> spreadSheet;

    public SpreadSheetCheckSum(final List<String> rows) {
        spreadSheet = extractSpreadSheet(rows);
    }

    private List<List<Integer>> extractSpreadSheet(final List<String> rows) {
        List<List<Integer>> spreadSheet = new ArrayList<>();
        for (String row : rows) {
            List<Integer> rowIntegers = new ArrayList<>();
            for (String intAsString : row.split("\t")) {
                rowIntegers.add(Integer.valueOf(intAsString));
            }
            spreadSheet.add(rowIntegers);
        }
        return spreadSheet;
    }

    public int calculate() {
        int result = 0;
        for (List<Integer> row : spreadSheet) {
            result += calculateRowCheckSum(row);
        }
        return result;
    }

    private int calculateRowCheckSum(List<Integer> row) {
        return row.stream().max(Comparator.naturalOrder()).get()
                - row.stream().min(Comparator.naturalOrder()).get();
    }
}
