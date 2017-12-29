package com.widera.adventofcode2017.day20;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import javafx.geometry.Point3D;

public class SimulationTest {
	
	@Test
	public void test() {
		List<Particle> particales = new ArrayList<>();
		particales.add(new Particle(0, new Point3D(3, 1, -4), new Point3D(2, 0, 0), new Point3D(-1, 0, 0)));
		particales.add(new Particle(1, new Point3D(4, 1, -4), new Point3D(0, 0, 0), new Point3D(-2, 0, 0)));
		
		Simulation simulation = new Simulation(particales);
		simulation.simulate(20);
		
		assertEquals(0, simulation.particaleWithLowestDistanceToZero().getId());
	}

}
