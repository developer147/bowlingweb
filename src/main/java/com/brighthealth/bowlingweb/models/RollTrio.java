package com.brighthealth.bowlingweb.models;

import java.util.Random;

public class RollTrio {
	private int roll1;
	private int roll2;
	private int roll3;
	
	private final static int max = 11;
	private final static int min = 0;
	
	private static Random random = new Random();
	
	
	public RollTrio(int roll1, int roll2, int roll3) {
		this.roll1 = roll1;
		this.roll2 = roll2;
		this.roll3 = roll3;
	}
	
	public int getRoll1() {
		return roll1;
	}
	
	public int getRoll2() {
		return roll2;
	}
	
	public int getRoll3() {
		return  roll3;
	}
	
	public static RollTrio getRandomRolls(boolean isLastFrame) {
		  int rollInt1 = random.nextInt(max - min) + min;
		  int rollInt2 = -1;
		  int rollInt3 = -1;
		  
		  if (isLastFrame) {
			rollInt2 = random.nextInt(max - min) + min;
			// if  second roll  is strike or spare, go for third  roll
			if (rollInt2 == 10 || (rollInt1 + rollInt2) == 10) {
				rollInt3 = random.nextInt(max - min) + min;
			}			  
		  } else if (rollInt1 != 10) { //If player gets a strike on non last frame, skip roll2
			int newMax = max - rollInt1;
			rollInt2 = random.nextInt(newMax - min) + min;
		  }
		  
		  return new RollTrio(rollInt1, rollInt2, rollInt3);
	} 	
}
