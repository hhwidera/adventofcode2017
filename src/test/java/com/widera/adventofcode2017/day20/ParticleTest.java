package com.widera.adventofcode2017.day20;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import javafx.geometry.Point3D;

public class ParticleTest {
	
	private static final double DELTA = 1e-5;
	
	@Test
	public void testParticle0Position() {
		Particle particle = new Particle(0, new Point3D(3, 0, 0), new Point3D(2, 0, 0), new Point3D(-1, 0, 0));
		
		assertEquals(new Point3D(3, 0, 0), particle.position());
		particle.simulate();
		assertEquals(new Point3D(4, 0, 0), particle.position());
		particle.simulate();
		assertEquals(new Point3D(4, 0, 0), particle.position());
		particle.simulate();
		assertEquals(new Point3D(3, 0, 0), particle.position());
	}
	
	@Test
	public void testParticle1Position() {
		Particle particle = new Particle(1, new Point3D(4, 0, 0), new Point3D(0, 0, 0), new Point3D(-2, 0, 0));
		
		assertEquals(new Point3D(4, 0, 0), particle.position());
		particle.simulate();
		assertEquals(new Point3D(2, 0, 0), particle.position());
		particle.simulate();
		assertEquals(new Point3D(-2, 0, 0), particle.position());
		particle.simulate();
		assertEquals(new Point3D(-8, 0, 0), particle.position());
	}

	@Test
	public void testParticleDistance() {
		Particle particle = new Particle(0, new Point3D(3, -2, 1), new Point3D(2, 0, 0), new Point3D(-1, 0, 0));
		
		assertEquals(6d, particle.distanceToZero(), DELTA);
	}
}
