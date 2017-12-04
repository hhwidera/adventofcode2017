package com.widera.adventofcode2017.day01;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class SequenceSumHalfRound {

    private final List<Integer> list;
    private final List<Integer> halfRoundList;

    public SequenceSumHalfRound(String input) {
        this.list = convertInputToList(input);
        this.halfRoundList = createHalfRoundList();
    }

    private List<Integer> createHalfRoundList() {
        List<Integer> result = new ArrayList<>();
        result.addAll(list.subList(list.size()/2, list.size()));
        result.addAll(list.subList(0, list.size()/2));
        return result;
    }

    private List<Integer> convertInputToList(String input) {
        List<Integer> result = new ArrayList<>(input.length());
        for (char number : input.toCharArray()) {
            result.add(Integer.valueOf(""+number));
        }
        return result;
    }

    public int calculate() {
        int result = 0;

        Iterator<Integer> iterator = list.iterator();
        Iterator<Integer> halfRoundIterator = halfRoundList.iterator();
        while(iterator.hasNext()) {
            Integer number = iterator.next();
            Integer halfRoundNumber = halfRoundIterator.next();
            if(number.equals(halfRoundNumber)) {
                result += number;
            }
        }

        return result;
    }
}
