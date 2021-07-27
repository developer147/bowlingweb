package com.brighthealth.bowlingweb;

import java.util.HashMap;
import java.util.Map;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import com.brighthealth.bowlingweb.models.BowlingLaneImpl;

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
	
	
//	@Bean
//	@Scope("singleton")
//	public Map<Integer, BowlingLaneImpl> getCurrentLanes() {
//	    return currentLanes;
//	}
	
	public void setCurrentLane(int lane, BowlingLaneImpl bowlingLaneImpl) {
		currentLanes.put(lane, bowlingLaneImpl);
	}
	
	public BowlingLaneImpl getBowlingLaneImplByLane(int lane) {
		return currentLanes.get(lane);
	}

	
	
	
	
}
