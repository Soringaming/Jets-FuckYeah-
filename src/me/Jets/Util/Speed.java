package me.Jets.Util;

public class Speed {
	private double mps;
	private double mpt;
	private double kph;
	private double mph;
	
	public Speed setMetersPerSecond(double mps) {
		this.mps = mps;
		
		mpt = mps * 0.05;
		kph = mps * 3.6;
		mph = mps * 2.2369363;
		return this;
	}
	
	public Speed setMetersPerTick(double mpt) {
		this.mpt = mpt;
		
		mps = mpt * 20;
		kph = mpt * 72;
		mph = mpt * 44.738726;
		return this;
	}
	
	public Speed setKilometersPerHour(double kph) {
		this.kph = kph;
		
		mps = kph * 0.27777778;
		mpt = kph * 0.013888889;
		mph = kph * 0.62137119;
		return this;
	}
	
	public Speed setMilesPerHour(double mph) {
		this.mph = mph;
		
		mps = mph * 0.44704;
		mpt = mph * 0.022352;
		kph = mph * 1.609344;
		return this;
	}
	
	public double getMetersPerSecond(Speed speed) {
		return speed.mps;
	}
	
	public double getMetersPerTick(Speed speed) {
		return speed.mpt;
	}
	
	public double getKilometersPerHour(Speed speed) {
		return speed.kph;
	}
	
	public double getMilesPerHour(Speed speed) {
		return speed.mph;
	}
}