package com.brighthealth.bowlingweb.models;

public class RollPair {
	private int roll1;
	private int roll2;
	
	public RollPair(int roll1, int roll2) {
		this.roll1 = roll1;
		this.roll2 = roll2;
	}
	
	public int getRoll1() {
		return roll1;
	}
	
	public int getRoll2() {
		return roll2;
	}
}
