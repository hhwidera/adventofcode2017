package com.widera.adventofcode2017.day20;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javafx.geometry.Point3D;

public class Day20Part2 {
	
	public static void main(String[] args) throws IOException {
		final String[] input = Files.lines(Paths.get("input-day20-part2.txt")).toArray(String[]::new);
		List<Particle> particles = new ArrayList<>();
		Pattern pattern = Pattern.compile("p=<(.*)>, v=<(.*)>, a=<(.*)>");
		int idCounter = 0;
		for (String line : input) {
			Matcher matcher = pattern.matcher(line);
			matcher.find();
			particles.add(new Particle(idCounter, point(matcher.group(1)), point(matcher.group(2)), point(matcher.group(3))));
			idCounter++;
		}
		
		Simulation simulation = new Simulation(particles);
		simulation.simulate(1_000);
		
		System.out.println(simulation.sizeOfSurvivorParticles());
	}

	private static Point3D point(final String pointAsString) {
		String[] parts = pointAsString.split(",");
		return new Point3D(Double.valueOf(parts[0]), Double.valueOf(parts[1]), Double.valueOf(parts[2]));
	}
	
}
