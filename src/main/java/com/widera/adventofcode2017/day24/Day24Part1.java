package com.widera.adventofcode2017.day24;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

public class Day24Part1 {
	
	public static void main(String[] args) throws IOException {
		final List<Component> input = Files.lines(Paths.get("input-day24-part1.txt")).map(Component::new).collect(Collectors.toList());
		BridgeBuilder builder = new BridgeBuilder(new Component("0/0"), 0, input);
		builder.buildBridges();
		System.out.println(builder.strengthOfStrongestBridge());
	}

}
