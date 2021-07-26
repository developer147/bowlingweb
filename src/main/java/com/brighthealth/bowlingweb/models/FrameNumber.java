package com.brighthealth.bowlingweb.models;

public enum FrameNumber {
	ONE(1),
	TWO(2),
	THREE(3),
	FOUR(4),
	FIVE(5),
	SIX(6),
	SEVEN(7),
	EIGHT(8),
	NINE(9),
	TEN(10);
	
	private final int number;
	private FrameNumber(int number) {
		this.number = number;
	}
	
	public int getValue() {
		return number;
	}
	
	public static FrameNumber getFrameNumber(int number) {
		switch(number) {
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
				return TEN;				
			default:
				throw new RuntimeException(number + " is an invalid frame number.");
		}
	}
}
