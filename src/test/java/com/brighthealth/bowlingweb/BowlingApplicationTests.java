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
	void contextLoads() {
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
}
