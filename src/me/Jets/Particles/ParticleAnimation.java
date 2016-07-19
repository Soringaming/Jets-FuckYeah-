package me.Jets.Particles;

import org.bukkit.Location;

public class ParticleAnimation {

	/*
	 * Location, radius, particleType, y value, x Offset, y Offset, z Offset,
	 * Float speed, amount, range, Boolean Reverse rotation.
	 */
	public static void doCircle(Location loc, Double r, String particleType, Double y, Float xo, Float yo, Float zo,
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

	public static void doRadialWave(Location loc, String particleType, Integer spread, Double WaveHeightStart,
			Double WaveSpeed, Double WaveAmpRate, Double WaveDecreaseRate, Double WaveMaxDistance, Float xo, Float yo, Float zo, Float speed, Integer amount, Integer range) {
		double t = 0;
		t = t + WaveSpeed * Math.PI;
		if(t < WaveMaxDistance) {
			for (double theta = 0; theta <= 2 * Math.PI; theta = theta * Math.PI / spread) {
				double x = Math.sin(theta);
				WaveHeightStart = Math.exp(WaveDecreaseRate * t) * Math.sin(t) + WaveAmpRate;
				double z = Math.sin(theta);
				loc.add(x, WaveHeightStart, z);
				ParticleEffect.fromName(particleType).display(xo, yo, zo, speed, amount, loc, range);
				loc.subtract(x, WaveHeightStart, z);
			}
		}

	}

}
