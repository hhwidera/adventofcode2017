package com.widera.adventofcode2017.day17;

public class Spinlock {

	private Node first;
	private Node position;
	private int bufferSize = 0;

	public Spinlock(final int size, final int circularBufferMoves) {
		build(size, circularBufferMoves);
	}

	private void build(final int size, final int circularBufferMoves) {
		first = new Node(0, null);
		position = first;
		bufferSize = 1;

		for (int s = 1; s <= size; s++) {
			if (s % 100_000 == 0) {
				System.out.println(s);
			}
			movePosition(circularBufferMoves);
			Node newValue = new Node(s, position.getNext());
			bufferSize++;
			position.setNext(newValue);
			movePosition(1);
		}
//		printBuffer();
	}

	private void movePosition(final int steps) {
		int nonCycleSteps = steps % bufferSize;
		for (int s = 0; s < nonCycleSteps; s++) {
			if (position.getNext() == null) {
				position = first;
			} else {
				position = position.getNext();
			}
		}
	}

	public int getValueAfterPosition() {
		if (position.getNext() == null) {
			return first.getItem();
		} else {
			return position.getNext().getItem();
		}
	}

	public int getValueAfterValueZero() {
		return first.getNext().getItem();
	}

	private void printBuffer() {
		String line = "";
		Node pointer = first;
		while (pointer.getNext() != null) {
			if (position == pointer) {
				line += "(" + pointer.getItem() + ") ";
			} else {
				line += " " + pointer.getItem() + "  ";
			}
			pointer = pointer.getNext();
		}
		System.out.println(line);
	}
}
