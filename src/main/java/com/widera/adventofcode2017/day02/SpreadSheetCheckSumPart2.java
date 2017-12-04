package com.widera.adventofcode2017.day02;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class SpreadSheetCheckSumPart2 {

    private final List<List<Integer>> spreadSheet;

    public SpreadSheetCheckSumPart2(final List<String> rows) {
        spreadSheet = extractSpreadSheet(rows);
    }

    private List<List<Integer>> extractSpreadSheet(final List<String> rows) {
        List<List<Integer>> spreadSheet = new ArrayList<>();
        for (String row : rows) {
            List<Integer> rowIntegers = new ArrayList<>();
            for (String intAsString : row.split("\t")) {
                rowIntegers.add(Integer.valueOf(intAsString));
            }
            rowIntegers.sort(Comparator.naturalOrder());
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
        for (int i = 0; i < row.size(); i++) {
            Integer div = row.get(i);
            for(int a = i + 1; a < row.size(); a++) {
                if (row.get(a) % div == 0) {
                    return row.get(a) / div;
                }
            }
        }
        return 0;
    }
}
