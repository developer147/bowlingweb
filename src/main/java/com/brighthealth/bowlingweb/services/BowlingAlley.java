package com.brighthealth.bowlingweb.services;
import java.util.HashMap;
import java.util.Map;

import org.springframework.context.annotation.Configuration;

/*
 * To keep track of lanes within an alley.
 */
@Configuration
public class BowlingAlley {
	private static long laneNumber = 0;
	private Map<Long, BowlingLaneImpl> currentLanes = new HashMap<>();
	
	public synchronized long getLane() {
		return ++laneNumber;
	}
	
	public synchronized long freeLane() {
		return --laneNumber;
	}
	
	public void setCurrentLane(long lane, BowlingLaneImpl bowlingLaneImpl) {
		currentLanes.put(lane, bowlingLaneImpl);
	}
	
	public BowlingLaneImpl getBowlingLaneImplByLane(long lane) {
		return currentLanes.get(lane);
	}
	
	public boolean cleanup(long lane) {
		return currentLanes.remove(lane) !=  null;
	}	
}
