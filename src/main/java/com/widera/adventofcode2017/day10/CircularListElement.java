package com.widera.adventofcode2017.day10;

public class CircularListElement {

    private CircularListElement prev;
    private CircularListElement next;

    private Integer value;

    CircularListElement(final Integer value) {
        this.value = value;
    }

    public CircularListElement getPrev() {
        return prev;
    }

    public void setPrev(CircularListElement prev) {
        this.prev = prev;
    }

    public CircularListElement getNext() {
        return next;
    }

    public void setNext(CircularListElement next) {
        this.next = next;
    }

    public Integer value() {
        return value;
    }

    public void setValue(final Integer value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return ""+value;
    }
}
