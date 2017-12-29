package com.widera.adventofcode2017.day20;

import javafx.geometry.Point3D;

public class Particle {

	private final int id;
	
	private boolean isAlive = true;
	
	private Point3D position;
	private Point3D velocity;
	private final Point3D acceleration;
	
	public Particle(final int id, final Point3D position, final Point3D velocity, final Point3D acceleration) {
		this.id = id;
		this.position = position;
		this.velocity = velocity;
		this.acceleration = acceleration;
	}
	
	public void die() {
		isAlive = false;
	}
	
	public boolean isAlive() {
		return isAlive;
	}
	
	public void simulate() {
		increaseVelocity();
		increasePosition();
	}
	
	private void increaseVelocity() {
		velocity = velocity.add(acceleration);
	}
	
	private void increasePosition() {
		position = position.add(velocity);
	}
	
	public Point3D position() {
		return position.add(Point3D.ZERO);
	}
	
	public Point3D velocity() {
		return velocity.add(Point3D.ZERO);
	}

	public int getId() {
		return id;
	}

	public double distanceToZero() {
		return Math.abs(position.getX()) +
				Math.abs(position.getY()) +
				Math.abs(position.getZ());
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Particle other = (Particle) obj;
		if (id != other.id)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Particle [id=" + id + ", position=" + position + ", velocity=" + velocity + ", acceleration="
				+ acceleration + ", distanceToZero=" + distanceToZero() + "]";
	}
	
}
