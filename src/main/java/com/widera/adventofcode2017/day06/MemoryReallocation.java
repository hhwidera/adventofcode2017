package com.widera.adventofcode2017.day06;

import java.util.Arrays;

public class MemoryReallocation {

	private final int[] memoryBlocks;

	public MemoryReallocation(final int[] initMemoryBlocks) {
		this.memoryBlocks = initMemoryBlocks;
	}

	public int[] getActualMemoryBlocks() {
		return Arrays.copyOf(memoryBlocks, memoryBlocks.length);
	}

	public void reallocation() {
		int startBankIndex = getBankWithTheMostBlocks();
		int blocksToShare = memoryBlocks[startBankIndex];
		memoryBlocks[startBankIndex] = 0;
		shareBlocksAfterIndex(startBankIndex, blocksToShare);
	}

	private void shareBlocksAfterIndex(int index, int blocksToShare) {
		while (blocksToShare > 0) {
			index = getNextIndex(index);
			memoryBlocks[index]++;
			blocksToShare--;
		}
	}

	private int getNextIndex(int index) {
		if (index + 1 >= memoryBlocks.length) {
			return 0;
		}
		return index + 1;
	}

	private int getBankWithTheMostBlocks() {
		int largest = 0;
		for (int i = 1; i < memoryBlocks.length; i++) {
			if (memoryBlocks[i] > memoryBlocks[largest]) {
				largest = i;
			}
		}
		return largest;
	}
}
