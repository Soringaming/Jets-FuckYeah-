package me.Jets.Particles;

import org.bukkit.Location;

public class Particle {
	
	public void doCircle(Location loc, Double r, String particleType, Integer y) {
		
		double t = 0;
		double x = r * Math.sin(t);
		y = y;
		double z = r * Math.cos(t);
		loc.subtract(x, y, z);

	}
	
	public void getParticle() {
		
	}

}
