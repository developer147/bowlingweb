package com.brighthealth.bowlingweb.models;

import java.util.Random;

public class BowlingLaneModel {
	public int getTotalPlayers() {
		return totalPlayers;
	}
	public Player[] getPlayers() {
		return players;
	}
	public void setPlayers(Player[] players) {
		this.players = players;
	}
	public int getCurrentFrameIndex() {
		return currentFrameIndex;
	}
	public void setCurrentFrameIndex(int currentFrameIndex) {
		this.currentFrameIndex = currentFrameIndex;
	}
	public int getCurrentPlayerIndex() {
		return currentPlayerIndex;
	}
	public void setCurrentPlayerIndex(int currentPlayerIndex) {
		this.currentPlayerIndex = currentPlayerIndex;
	}
	public int getMax() {
		return max;
	}
	public void setMax(int max) {
		this.max = max;
	}
	public int getMin() {
		return min;
	}
	public void setMin(int min) {
		this.min = min;
	}
	public Random getRandom() {
		return random;
	}
	public void setRandom(Random random) {
		this.random = random;
	}
	private int totalPlayers = -1;
	private Player[] players = null;
	private int currentFrameIndex = 1;
	private int currentPlayerIndex = 0;
	int max = 11;
	int min = 0;
	Random random;
	
	
}
