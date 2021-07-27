package com.brighthealth.bowlingweb.models;

public class Frame {
	private FrameNumber frameNumber;
	private Roll roll1;
	private Roll roll2;
	private Roll roll3;
	private int score = 0;
	
	public Frame() {
	}
	
	public Frame(FrameNumber frameNumber, Roll roll1, Roll roll2) {
		this.frameNumber = frameNumber;
		this.roll1 = roll1;
		this.roll2 = roll2; 
	}
	
	public Roll getRoll1()  {
		return roll1;
	}
	
	public void setRoll1(Roll roll1) {
		this.roll1  = roll1;
	}
	
	public Roll getRoll2() {
		return roll2;
	}
	
	public void setRoll2(Roll roll2) {
		this.roll2  = roll2;
	}	
	
	public FrameNumber getFrameNumber() {
		return frameNumber;
	}
	
	public void setFrameNumber(FrameNumber frameNumber) {
		this.frameNumber  = frameNumber;
	}
	
	public void setScore(int score) {
		this.score = score;
	}
	
	// Roll3 is special. Only applicable in 10th frame when second roll
	// is either a strike or a spare.
	public void setRoll3(Roll roll) {
		assert frameNumber == FrameNumber.TEN;
		assert roll2 == Roll.STRIKE || roll2 == Roll.SPARE;
		this.roll3 = roll;
	}
	
	public Roll getRoll3() {
		assert frameNumber == FrameNumber.TEN;
		assert roll2 == Roll.STRIKE || roll2 == Roll.SPARE;
		return roll3;
	}	
	
	public int getScore() {
		return score;
	}
	
	@Override
	public String toString() {
		Roll roll3Val = roll3 != null ? roll3 : Roll.EMPTY;
		
		return frameNumber.getValue() == 10 ?
		"Roll 1: " + roll1 + ", Roll 2: " + roll2 + ", Roll 3: " +  roll3Val + ", Score: " + score :
			"Roll 1: " + roll1 + ", Roll 2: " + roll2 + ", Score: " + score;
	}	
}
