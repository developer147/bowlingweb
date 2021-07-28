package com.brighthealth.bowlingweb.models;

public enum Roll {
	EMPTY(-1),
	MISS(0),
	ONE(1),
	TWO(2),
	THREE(3),
	FOUR(4),
	FIVE(5),
	SIX(6),
	SEVEN(7),
	EIGHT(8),
	NINE(9),
	STRIKE(10),
	SPARE(99);
	
	private final int score;
	private Roll(int score) {
		this.score = score;
	}
	
//	public static Roll getRoll2(int frameIndex,  int rollInt1, int rollInt2) {
//		Roll roll2 = null;
//		if (frameIndex != 10) {
//			roll2 = (rollInt1 + rollInt2 == 10) ? Roll.getRoll(99) : Roll.getRoll(rollInt2);
//		} else {
//			roll2  = Roll.getRoll(rollInt2);
//		}
//		return roll2;
//	}
	
//	public static int getRoll2Score(Roll roll1) {
//		return 10 - roll1.getScore();
//	}
//	
//	public static int getRoll3Score(Roll roll3) {
//		return roll3.getScore() == 99 ? 10 : roll3.getScore();
//	}
	
	public int getScore() {
//		if (this == Roll.EMPTY) 
//			return 0;
//		if (this == Roll.SPARE) {
//			return  10 - roll1Score;
//		}
		return score;
	}
	
	public static Roll getRoll(int number) {
		switch(number) {
		    case -1:
		    	return EMPTY;
			case 0:
				return MISS;
			case 1:
				return ONE;
			case 2:
				return TWO;
			case 3:
				return THREE;
			case 4:
				return FOUR;
			case 5:
				return FIVE;
			case 6:
				return SIX;
			case 7:
				return SEVEN;
			case 8:
				return EIGHT;
			case 9:
				return NINE;
			case 10:
				return STRIKE;
			case 99:
				return SPARE;
			default:
				throw new RuntimeException(number + " is an invalid roll.");
		}
		
	}
}
