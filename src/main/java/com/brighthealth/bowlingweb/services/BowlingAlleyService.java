package com.brighthealth.bowlingweb.services;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import org.springframework.context.annotation.Configuration;

import com.brighthealth.bowlingweb.models.RollPair;

@Configuration
public class BowlingAlleyService {
	private static long laneNumber = 0;
	private Map<Long, BowlingLaneImpl> currentLanes = new HashMap<>();
	private final static int max = 11;
	private final static int min = 0;
	
	private static Random random = new Random();
	
	public static RollPair getRandomRolls() {
	  int rollInt1 = random.nextInt(max - min) + min;
	  int rollInt2 = -1;
	  // If player gets a strike, skip roll2
	  if (rollInt1 != 10) {
		int newMax = max - rollInt1;
		rollInt2 = random.nextInt(newMax - min) + min;
	  }		
	  return new RollPair(rollInt1, rollInt2);
	}
	
	public static int getRoll3() {
		return random.nextInt(max - min) + min;
	}
	
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
