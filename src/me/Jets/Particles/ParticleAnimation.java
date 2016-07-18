package me.Jets.Particles;

import org.bukkit.Location;

public class ParticleAnimation {
	
	/*
	 * Location, radius, particleType, y value, x Offset, y Offset, z Offset,
	 * Float speed, amount, range, Boolean Reverse rotation.
	 */
	public void doCircle(Location loc, Double r, String particleType, Integer y, Float xo, Float yo, Float zo,
			Float speed, Integer amount, Integer range, Boolean reverse) {

		double t = 0;
		double x;
		double z;
		if (!reverse) {
			x = r * Math.sin(t);
			z = r * Math.cos(t);
		} else {
			x = r * Math.cos(t);
			z = r * Math.sin(t);
		}
		loc.subtract(x, y, z);
		ParticleEffect.fromName(particleType).display(xo, yo, zo, speed, amount, loc, range);
		loc.add(x, y, z);

	}

}
