package com.widera.adventofcode2017.day18;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Day18Part2 {

	public static void main(String[] args) throws IOException {
		final String[] input = Files.lines(Paths.get("input-day18-part2.txt")).toArray(String[]::new);

		ProgramParallel p0 = new ProgramParallel(input, 0);
		ProgramParallel p1 = new ProgramParallel(input, 1);
		p0.setSendingQueue(p1.getReceiveQueue());
		p1.setSendingQueue(p0.getReceiveQueue());

		while (!((p0.isWaiting() && p1.isWaiting())
				|| (p0.isTerminated() && p1.isTerminated()))) {
			p0.runNextInstruction();
			p1.runNextInstruction();
		}

		System.out.println(p1.sendMessages());
	}
}
