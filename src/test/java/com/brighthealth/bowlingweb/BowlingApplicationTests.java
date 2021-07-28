package com.brighthealth.bowlingweb;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.assertj.core.util.Arrays;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.brighthealth.bowlingweb.models.Player;
import com.brighthealth.bowlingweb.services.BowlingLaneImpl;

@SpringBootTest
class BowlingApplicationTests {
	@Test
	// example taken from https://www.bowl.com/Welcome/Welcome_Home/Keeping_Score/
	void testAnAveragePlayer() {
		Player player1 = new Player(0);
		BowlingLaneImpl bowlingLaneImpl =  new BowlingLaneImpl(1,1, Arrays.array(player1));
		bowlingLaneImpl.nextPlay(8, 0, -1);
		bowlingLaneImpl.nextPlay(5, 99, -1);
		bowlingLaneImpl.nextPlay(3, 5, -1);
		bowlingLaneImpl.nextPlay(8, 1, -1);
		bowlingLaneImpl.nextPlay(7, 1, -1);
		bowlingLaneImpl.nextPlay(10, -1, -1);
		bowlingLaneImpl.nextPlay(9, 99, -1);
		bowlingLaneImpl.nextPlay(10, -1, -1);
		bowlingLaneImpl.nextPlay(10, -1, -1);
		bowlingLaneImpl.nextPlay(8, 99, 6);
		assertEquals(8, player1.getFrames()[0].getScore());
		assertEquals(21, player1.getFrames()[1].getScore());
		assertEquals(29, player1.getFrames()[2].getScore());
		assertEquals(38, player1.getFrames()[3].getScore());
		assertEquals(46, player1.getFrames()[4].getScore());
		assertEquals(66, player1.getFrames()[5].getScore());
		assertEquals(86, player1.getFrames()[6].getScore());
		assertEquals(114, player1.getFrames()[7].getScore());
		assertEquals(134, player1.getFrames()[8].getScore());
		assertEquals(150, player1.getFrames()[9].getScore());
	}
	
	@Test
	// my own case
	void testAnotherAveragePlayer() {
		Player player1 = new Player(0);
		BowlingLaneImpl bowlingLaneImpl =  new BowlingLaneImpl(1,1, Arrays.array(player1));
		bowlingLaneImpl.nextPlay(2, 4, -1);
		bowlingLaneImpl.nextPlay(1, 99, -1);
		bowlingLaneImpl.nextPlay(10, -1, -1);
		bowlingLaneImpl.nextPlay(3, 99, -1);
		bowlingLaneImpl.nextPlay(0, 8, -1);
		bowlingLaneImpl.nextPlay(10, -1, -1);
		bowlingLaneImpl.nextPlay(2, 99, -1);
		bowlingLaneImpl.nextPlay(1, 5, -1);
		bowlingLaneImpl.nextPlay(10, -1, -1);
		bowlingLaneImpl.nextPlay(3, 99, 6);
		assertEquals(6, player1.getFrames()[0].getScore());
		assertEquals(26, player1.getFrames()[1].getScore());
		assertEquals(46, player1.getFrames()[2].getScore());
		assertEquals(56, player1.getFrames()[3].getScore());
		assertEquals(64, player1.getFrames()[4].getScore());
		assertEquals(84, player1.getFrames()[5].getScore());
		assertEquals(95, player1.getFrames()[6].getScore());
		assertEquals(101, player1.getFrames()[7].getScore());
		assertEquals(121, player1.getFrames()[8].getScore());
		assertEquals(137, player1.getFrames()[9].getScore());
	}	
	
	@Test
	void testBestPlayer() {
		Player player1 = new Player(0);
		BowlingLaneImpl bowlingLaneImpl =  new BowlingLaneImpl(1,1, Arrays.array(player1));
		bowlingLaneImpl.nextPlay(10, -1, -1);
		bowlingLaneImpl.nextPlay(10, -1, -1);
		bowlingLaneImpl.nextPlay(10, -1, -1);
		bowlingLaneImpl.nextPlay(10, -1, -1);
		bowlingLaneImpl.nextPlay(10, -1, -1);
		bowlingLaneImpl.nextPlay(10, -1, -1);
		bowlingLaneImpl.nextPlay(10, -1, -1);
		bowlingLaneImpl.nextPlay(10, -1, -1);
		bowlingLaneImpl.nextPlay(10, -1, -1);
		bowlingLaneImpl.nextPlay(10, 10, 10);
		assertEquals(30, player1.getFrames()[0].getScore());
		assertEquals(60, player1.getFrames()[1].getScore());
		assertEquals(90, player1.getFrames()[2].getScore());
		assertEquals(120, player1.getFrames()[3].getScore());
		assertEquals(150, player1.getFrames()[4].getScore());
		assertEquals(180, player1.getFrames()[5].getScore());
		assertEquals(210, player1.getFrames()[6].getScore());
		assertEquals(240, player1.getFrames()[7].getScore());
		assertEquals(270, player1.getFrames()[8].getScore());
		assertEquals(300, player1.getFrames()[9].getScore());
	}	
	
	@Test
	void testWorstPlayer() {
		Player player1 = new Player(0);
		BowlingLaneImpl bowlingLaneImpl =  new BowlingLaneImpl(1,1, Arrays.array(player1));
		bowlingLaneImpl.nextPlay(0, 0, -1);
		bowlingLaneImpl.nextPlay(0, 0, -1);
		bowlingLaneImpl.nextPlay(0, 0, -1);
		bowlingLaneImpl.nextPlay(0, 0, -1);
		bowlingLaneImpl.nextPlay(0, 0, -1);
		bowlingLaneImpl.nextPlay(0, 0, -1);
		bowlingLaneImpl.nextPlay(0, 0, -1);
		bowlingLaneImpl.nextPlay(0, 0, -1);
		bowlingLaneImpl.nextPlay(0, 0, -1);
		bowlingLaneImpl.nextPlay(0, 0, -1);
		assertEquals(0, player1.getFrames()[0].getScore());
		assertEquals(0, player1.getFrames()[1].getScore());
		assertEquals(0, player1.getFrames()[2].getScore());
		assertEquals(0, player1.getFrames()[3].getScore());
		assertEquals(0, player1.getFrames()[4].getScore());
		assertEquals(0, player1.getFrames()[5].getScore());
		assertEquals(0, player1.getFrames()[6].getScore());
		assertEquals(0, player1.getFrames()[7].getScore());
		assertEquals(0, player1.getFrames()[8].getScore());
		assertEquals(0, player1.getFrames()[9].getScore());
	}		
}
