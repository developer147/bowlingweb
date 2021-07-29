package com.brighthealth.bowlingweb.services;

import com.brighthealth.bowlingweb.models.Player;

public interface BowlingLane {
	void start(Player[] players);
	
	void reset();
}
