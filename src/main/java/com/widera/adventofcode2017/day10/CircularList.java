package com.widera.adventofcode2017.day10;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CircularList {

    private CircularListElement currentPosition;

    private CircularListElement startPoint;

    private int skipSize = 0;

    public CircularList(final List<Integer> values) {
        CircularListElement last = null;
        for (Integer value : values) {
            CircularListElement element = new CircularListElement(value);
            element.setPrev(last);
            if (last != null) {
                last.setNext(element);
            }
            last = element;
            if (currentPosition == null) {
                currentPosition = element;
                startPoint = element;
            }
        }
        last.setNext(currentPosition);
        currentPosition.setPrev(last);
    }

    public void operation(int length) {
        CircularListElement tempCurrentPointer = currentPosition;
        List<Integer> list = new ArrayList<>();
        for (int l = 0; l < length; l++) {
            list.add(tempCurrentPointer.value());
            tempCurrentPointer = tempCurrentPointer.getNext();
        }
        CircularListElement tmpElement = currentPosition;

        Collections.reverse(list);

        for (Integer newValue : list) {
            tmpElement.setValue(newValue);
            tmpElement = tmpElement.getNext();
        }

        for (int l = 0; l < length + skipSize; l++) {
            currentPosition = currentPosition.getNext();
        }
        skipSize++;
    }

    @Override
    public String toString() {
        String result = "";
        CircularListElement tempPointer = startPoint;
        do {
            if(!result.isEmpty()) {
                result += " ";
            }
            if (tempPointer.equals(currentPosition)) {
                result += "[" + tempPointer.value() + "]";
            } else {
                result += tempPointer.value();
            }
            tempPointer = tempPointer.getNext();
        } while (!startPoint.equals(tempPointer));
        return result;
    }

    public int skipSize() {
        return skipSize;
    }

    public int multiplyingFirstTwoValuesOfList() {
        return startPoint.value() * startPoint.getNext().value();
    }

    public List<Integer> spareHash() {
        List<Integer> result = new ArrayList<>();
        CircularListElement tempPointer = startPoint;
        do {
            result.add(tempPointer.value());
            tempPointer = tempPointer.getNext();
        } while (!startPoint.equals(tempPointer));
        return result;
    }
}
