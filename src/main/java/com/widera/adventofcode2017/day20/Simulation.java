package com.widera.adventofcode2017.day20;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Simulation {
	
	private final List<Particle> particles;
	
	public Simulation(final List<Particle> particles) {
		this.particles = particles;
	}
	
	public void simulate(int rounds) {
		for (int r = 1; r <= rounds; r++) {
			System.out.println("round " + r);
			particles.forEach(Particle::simulate);
			particles.stream().filter(Particle::isAlive).collect(Collectors.groupingBy(Particle::position))
			.values().stream().filter(group -> group.size() > 1).flatMap(List::stream).forEach(Particle::die);
		}
	}

	public Particle particaleWithLowestDistanceToZero() {
		return particles.stream().min(Comparator.comparing(Particle::distanceToZero)).get();
	}

	public long sizeOfSurvivorParticles() {
		return particles.stream().filter(Particle::isAlive).count();
	}
}
