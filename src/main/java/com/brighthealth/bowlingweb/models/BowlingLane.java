package com.brighthealth.bowlingweb.models;

public interface BowlingLane {
	void startGame(Player[] players);
	
	void stopGame();
	
	void pauseGame();
	
	void resetGame();
	
	Player[] getPlayers();
}
