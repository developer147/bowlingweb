package com.brighthealth.bowlingweb.models;

import java.util.Arrays;

public class Player {
	private int id;
	private Frame[] frames;
	
	public Player() {
		
	}
	
	public Player(int playerId) {
		this.id = playerId;
		frames = new Frame[10];
	}
	
	public void setId(int playerId) {
		this.id = playerId;
	}
	
	public int getId() {
		return id;
	}
	
	public Frame[] getFrames() {
		return frames;
	}
	
	public void setFrames(Frame[] frames) {
		this.frames = frames;
	}
	
	public void setFrame(FrameNumber frameNumber, Frame frame) {
		frames[frameNumber.getValue()-1] = frame;
	}
	
	public Frame getFrame(FrameNumber frameNumber) {
		return frames[frameNumber.getValue()-1];
	}
	
	@Override
	public String toString() {
		return "Player [playerId=" + id + ", frames=" + Arrays.toString(frames) + "]";
	}	
}
