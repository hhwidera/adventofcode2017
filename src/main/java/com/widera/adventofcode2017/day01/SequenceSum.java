package com.widera.adventofcode2017.day01;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class SequenceSum {

    private final List<Integer> list;

    public SequenceSum(final String input) {
        this.list = convertInputToList(input);
    }

    private List<Integer> convertInputToList(String input) {
        List<Integer> result = new ArrayList<>(input.length() + 1);
        for (char number : input.toCharArray()) {
            result.add(Integer.valueOf(""+number));
        }
        addFirstElementAtEnd(result);
        return result;
    }

    private void addFirstElementAtEnd(List<Integer> list) {
        list.add(list.get(0));
    }

    public int calculate() {
        int result = 0;

        Integer lastNumber = null;

        Iterator<Integer> iterator = list.iterator();
        while(iterator.hasNext()) {
            Integer number = iterator.next();
            if(number.equals(lastNumber)) {
                result += number;
            }
            lastNumber = number;
        }

        return result;
    }
}
