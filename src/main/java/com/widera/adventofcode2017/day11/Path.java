package com.widera.adventofcode2017.day11;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Path {
	
	private final List<HexGridMove> steps;
	
	private HexGridPosition position;
	
	private int furthestStepsAway;

	public Path(final String pathAsString) {
		this.steps = convertInSteps(pathAsString);
		this.position = new HexGridPosition(0, 0, 0);
		this.furthestStepsAway = 0;
	}

	private List<HexGridMove> convertInSteps(String pathAsString) {
		List<HexGridMove> result = new ArrayList<>();
		for (String stepAsString : pathAsString.split(",")) {
			result.add(HexGridMove.get(stepAsString));
		}
		return result;
	}

	public void go() {
		for (HexGridMove step : steps) {
			position = position.add(step.move());
			if (stepsAwayFromStart() > furthestStepsAway) {
				furthestStepsAway = stepsAwayFromStart();
			}
		}
	}

	public int stepsAwayFromStart() {
		int[] median = new int[] {position.x(), position.y(), position.z()};
		Arrays.sort(median);
		HexGridPosition vector = new HexGridPosition(median[1] * 1, median[1] * 1, median[1] * 1);
		HexGridPosition minimiseVector = position.sub(vector);
		return Math.abs(minimiseVector.x())
				+ Math.abs(minimiseVector.y())
				+ Math.abs(minimiseVector.z());
	}

	public int furthestStepsAwayFromStart() {
		return furthestStepsAway;
	}
}
