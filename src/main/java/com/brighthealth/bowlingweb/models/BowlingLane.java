package com.brighthealth.bowlingweb.models;

public interface BowlingLane {
	void start(Player[] players);
	
	void stop();
	
	void pause();
	
	void reset();
}
