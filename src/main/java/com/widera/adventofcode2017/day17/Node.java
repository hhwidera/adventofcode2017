package com.widera.adventofcode2017.day17;

public class Node {
	
	private int item;
	private Node next;

	Node(int element, Node next) {
		this.setItem(element);
		this.setNext(next);
	}

	public int getItem() {
		return item;
	}

	public void setItem(int item) {
		this.item = item;
	}

	public Node getNext() {
		return next;
	}

	public void setNext(Node next) {
		this.next = next;
	}

}
