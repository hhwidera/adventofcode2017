package com.widera.adventofcode2017.day20;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
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
	
	
	@Test
	public void testCollide() {
		Particle particle0 = new Particle(0, new Point3D(-6, 0, 0), new Point3D(3, 0, 0), new Point3D(0, 0, 0));
		Particle particle1 = new Particle(1, new Point3D(-4, 0, 0), new Point3D(2, 0, 0), new Point3D(0, 0, 0));
		Particle particle2 = new Particle(2, new Point3D(-2, 0, 0), new Point3D(1, 0, 0), new Point3D(0, 0, 0));
		Particle particle3 = new Particle(3, new Point3D(3, 0, 0), new Point3D(-1, 0, 0), new Point3D(0, 0, 0));
		List<Particle> particales = Arrays.asList(particle0, particle1, particle2, particle3);
		
		
		Simulation simulation = new Simulation(particales);
		
		simulation.simulate(1);
		
		assertTrue(particle0.isAlive());
		assertTrue(particle1.isAlive());
		assertTrue(particle2.isAlive());
		assertTrue(particle3.isAlive());
		
		assertEquals(4, simulation.sizeOfSurvivorParticles());
		
		simulation.simulate(1);
		
		assertFalse(particle0.isAlive());
		assertFalse(particle1.isAlive());
		assertFalse(particle2.isAlive());
		assertTrue(particle3.isAlive());
		
		assertEquals(1, simulation.sizeOfSurvivorParticles());
		
		simulation.simulate(1);
		
		assertFalse(particle0.isAlive());
		assertFalse(particle1.isAlive());
		assertFalse(particle2.isAlive());
		assertTrue(particle3.isAlive());
		
		assertEquals(1, simulation.sizeOfSurvivorParticles());
	}

}
