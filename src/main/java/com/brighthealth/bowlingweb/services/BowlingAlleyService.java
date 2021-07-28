package com.brighthealth.bowlingweb.services;
import java.util.HashMap;
import java.util.Map;

import org.springframework.context.annotation.Configuration;


@Configuration
public class BowlingAlleyService {
	private static int laneNumber = 0;
	Map<Integer, BowlingLaneImpl> currentLanes = new HashMap<>();
	
	public synchronized int getLane() {
		return ++laneNumber;
	}
	
	public synchronized int freeLane() {
		return --laneNumber;
	}
	
	public void setCurrentLane(int lane, BowlingLaneImpl bowlingLaneImpl) {
		currentLanes.put(lane, bowlingLaneImpl);
	}
	
	public BowlingLaneImpl getBowlingLaneImplByLane(int lane) {
		return currentLanes.get(lane);
	}
}
