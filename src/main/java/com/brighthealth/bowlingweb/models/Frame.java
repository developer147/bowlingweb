package com.brighthealth.bowlingweb.models;

public class Frame {
	private FrameNumber frameNumber;
	private Roll roll1;
	private Roll roll2;
	private Roll roll3;
	private int score = 0;
//	//TODO: unnecessary?
//	private boolean isScoreFinal = false;
	
	public Frame(FrameNumber frameNumber, Roll roll1, Roll roll2) {
		this.frameNumber = frameNumber;
		this.roll1 = roll1;
		this.roll2 = roll2; 
	}
	
	public Roll getRoll1()  {
		return roll1;
	}
	
	public Roll getRoll2() {
		return roll2;
	}
	
	public FrameNumber getFrameNumber() {
		return frameNumber;
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
	
//	public void setScoreFinal(boolean isScoreFinal) {
//		this.isScoreFinal = isScoreFinal;
//	}
	
//	@Override
//	public String toString() {
//		return "Frame [frameNumber=" + frameNumber + ", roll1=" + roll1 + ", roll2=" + roll2 + ", score=" + score
//				+ ", isScoreFinal=" + isScoreFinal + "]";
//	}	
	
//	@Override
//	public String toString() {
//		return "Frame [frameNumber=" + frameNumber + ", roll1=" + roll1 + ", roll2=" + roll2 + ", roll3=" + roll3
//				+ ", score=" + score + "]";
//	}
	
	@Override
	public String toString() {
		return frameNumber.getValue() == 10 ?
		"Roll 1: " + roll1.getScore() + ", Roll 2: " + roll2.getScore() + ", Roll 3: " + roll3.getScore() + ", Score: " + score :
			"Roll 1: " + roll1.getScore() + ", Roll 2: " + roll2.getScore() + ", Score: " + score;
	}	
}
