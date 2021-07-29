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
	void testBetterPlayer() {
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
		bowlingLaneImpl.nextPlay(10, 1, 6);
		assertEquals(8, player1.getFrames()[0].getScore());
		assertEquals(21, player1.getFrames()[1].getScore());
		assertEquals(29, player1.getFrames()[2].getScore());
		assertEquals(38, player1.getFrames()[3].getScore());
		assertEquals(46, player1.getFrames()[4].getScore());
		assertEquals(66, player1.getFrames()[5].getScore());
		assertEquals(86, player1.getFrames()[6].getScore());
		assertEquals(116, player1.getFrames()[7].getScore());
		assertEquals(137, player1.getFrames()[8].getScore());
		assertEquals(154, player1.getFrames()[9].getScore());
	}
	
	@Test
	void testAnotherBetterPlayer() {
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
		bowlingLaneImpl.nextPlay(10, 10, 6);
		assertEquals(8, player1.getFrames()[0].getScore());
		assertEquals(21, player1.getFrames()[1].getScore());
		assertEquals(29, player1.getFrames()[2].getScore());
		assertEquals(38, player1.getFrames()[3].getScore());
		assertEquals(46, player1.getFrames()[4].getScore());
		assertEquals(66, player1.getFrames()[5].getScore());
		assertEquals(86, player1.getFrames()[6].getScore());
		assertEquals(116, player1.getFrames()[7].getScore());
		assertEquals(146, player1.getFrames()[8].getScore());
		assertEquals(172, player1.getFrames()[9].getScore());
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
	
	@Test
	void testWhenLastFrameFirstRollIsStrike() {
		Player player1 = new Player(0);
		BowlingLaneImpl bowlingLaneImpl =  new BowlingLaneImpl(1,1, Arrays.array(player1));
		bowlingLaneImpl.nextPlay(5, 3, -1);
		bowlingLaneImpl.nextPlay(3, 3, -1);
		bowlingLaneImpl.nextPlay(6, 1, -1);
		bowlingLaneImpl.nextPlay(4, 2, -1);
		bowlingLaneImpl.nextPlay(7, 2, -1);
		bowlingLaneImpl.nextPlay(0, 3, -1);
		bowlingLaneImpl.nextPlay(3, 6, -1);
		bowlingLaneImpl.nextPlay(1, 99, -1);
		bowlingLaneImpl.nextPlay(7, 2, -1);
		bowlingLaneImpl.nextPlay(10, 0, 10);
		assertEquals(8, player1.getFrames()[0].getScore());
		assertEquals(14, player1.getFrames()[1].getScore());
		assertEquals(21, player1.getFrames()[2].getScore());
		assertEquals(27, player1.getFrames()[3].getScore());
		assertEquals(36, player1.getFrames()[4].getScore());
		assertEquals(39, player1.getFrames()[5].getScore());
		assertEquals(48, player1.getFrames()[6].getScore());
		assertEquals(65, player1.getFrames()[7].getScore());
		assertEquals(74, player1.getFrames()[8].getScore());
		assertEquals(94, player1.getFrames()[9].getScore());
	}
	
	@Test
	void testWhenLastFrameSecondRollIsSpare() {
		Player player1 = new Player(0);
		BowlingLaneImpl bowlingLaneImpl =  new BowlingLaneImpl(1,1, Arrays.array(player1));
		bowlingLaneImpl.nextPlay(1, 4, -1);
		bowlingLaneImpl.nextPlay(4, 99, -1);
		bowlingLaneImpl.nextPlay(1, 5, -1);
		bowlingLaneImpl.nextPlay(3, 5, -1);
		bowlingLaneImpl.nextPlay(6, 2, -1);
		bowlingLaneImpl.nextPlay(3, 1, -1);
		bowlingLaneImpl.nextPlay(8, 0, -1);
		bowlingLaneImpl.nextPlay(4, 99, -1);
		bowlingLaneImpl.nextPlay(3, 0, -1);
		bowlingLaneImpl.nextPlay(9, 99, 6);
		assertEquals(5, player1.getFrames()[0].getScore());
		assertEquals(16, player1.getFrames()[1].getScore());
		assertEquals(22, player1.getFrames()[2].getScore());
		assertEquals(30, player1.getFrames()[3].getScore());
		assertEquals(38, player1.getFrames()[4].getScore());
		assertEquals(42, player1.getFrames()[5].getScore());
		assertEquals(50, player1.getFrames()[6].getScore());
		assertEquals(63, player1.getFrames()[7].getScore());
		assertEquals(66, player1.getFrames()[8].getScore());
		assertEquals(82, player1.getFrames()[9].getScore());
	}	
	
	
	@Test
	void testWhenLastFrameAllThreeRollsAreStrikes() {
		Player player1 = new Player(0);
		BowlingLaneImpl bowlingLaneImpl =  new BowlingLaneImpl(1,1, Arrays.array(player1));
		bowlingLaneImpl.nextPlay(1, 4, -1);
		bowlingLaneImpl.nextPlay(4, 99, -1);
		bowlingLaneImpl.nextPlay(1, 5, -1);
		bowlingLaneImpl.nextPlay(3, 5, -1);
		bowlingLaneImpl.nextPlay(6, 2, -1);
		bowlingLaneImpl.nextPlay(3, 1, -1);
		bowlingLaneImpl.nextPlay(8, 0, -1);
		bowlingLaneImpl.nextPlay(4, 99, -1);
		bowlingLaneImpl.nextPlay(3, 0, -1);
		bowlingLaneImpl.nextPlay(10, 10, 10);
		assertEquals(5, player1.getFrames()[0].getScore());
		assertEquals(16, player1.getFrames()[1].getScore());
		assertEquals(22, player1.getFrames()[2].getScore());
		assertEquals(30, player1.getFrames()[3].getScore());
		assertEquals(38, player1.getFrames()[4].getScore());
		assertEquals(42, player1.getFrames()[5].getScore());
		assertEquals(50, player1.getFrames()[6].getScore());
		assertEquals(63, player1.getFrames()[7].getScore());
		assertEquals(66, player1.getFrames()[8].getScore());
		assertEquals(96, player1.getFrames()[9].getScore());
	}
	
	@Test
	void testWhenLastFrameFirstTwoRollsAreStrikesButNotThird() {
		Player player1 = new Player(0);
		BowlingLaneImpl bowlingLaneImpl =  new BowlingLaneImpl(1,1, Arrays.array(player1));
		bowlingLaneImpl.nextPlay(1, 4, -1);
		bowlingLaneImpl.nextPlay(4, 99, -1);
		bowlingLaneImpl.nextPlay(1, 5, -1);
		bowlingLaneImpl.nextPlay(3, 5, -1);
		bowlingLaneImpl.nextPlay(6, 2, -1);
		bowlingLaneImpl.nextPlay(3, 1, -1);
		bowlingLaneImpl.nextPlay(8, 0, -1);
		bowlingLaneImpl.nextPlay(4, 99, -1);
		bowlingLaneImpl.nextPlay(3, 0, -1);
		bowlingLaneImpl.nextPlay(10, 10, 4);
		assertEquals(5, player1.getFrames()[0].getScore());
		assertEquals(16, player1.getFrames()[1].getScore());
		assertEquals(22, player1.getFrames()[2].getScore());
		assertEquals(30, player1.getFrames()[3].getScore());
		assertEquals(38, player1.getFrames()[4].getScore());
		assertEquals(42, player1.getFrames()[5].getScore());
		assertEquals(50, player1.getFrames()[6].getScore());
		assertEquals(63, player1.getFrames()[7].getScore());
		assertEquals(66, player1.getFrames()[8].getScore());
		assertEquals(90, player1.getFrames()[9].getScore());
	}
	
	@Test
	void testWhenLastFrameSecondRollIsSpareAndThirdIsStrike() {
		Player player1 = new Player(0);
		BowlingLaneImpl bowlingLaneImpl =  new BowlingLaneImpl(1,1, Arrays.array(player1));
		bowlingLaneImpl.nextPlay(1, 4, -1);
		bowlingLaneImpl.nextPlay(4, 99, -1);
		bowlingLaneImpl.nextPlay(1, 5, -1);
		bowlingLaneImpl.nextPlay(3, 5, -1);
		bowlingLaneImpl.nextPlay(6, 2, -1);
		bowlingLaneImpl.nextPlay(3, 1, -1);
		bowlingLaneImpl.nextPlay(8, 0, -1);
		bowlingLaneImpl.nextPlay(4, 99, -1);
		bowlingLaneImpl.nextPlay(3, 0, -1);
		bowlingLaneImpl.nextPlay(1, 99, 10);
		assertEquals(5, player1.getFrames()[0].getScore());
		assertEquals(16, player1.getFrames()[1].getScore());
		assertEquals(22, player1.getFrames()[2].getScore());
		assertEquals(30, player1.getFrames()[3].getScore());
		assertEquals(38, player1.getFrames()[4].getScore());
		assertEquals(42, player1.getFrames()[5].getScore());
		assertEquals(50, player1.getFrames()[6].getScore());
		assertEquals(63, player1.getFrames()[7].getScore());
		assertEquals(66, player1.getFrames()[8].getScore());
		assertEquals(86, player1.getFrames()[9].getScore());
	}
	
	@Test
	void testWhenLastFrameSecondRollIsSpareAndThirdIsNotStrike() {
		Player player1 = new Player(0);
		BowlingLaneImpl bowlingLaneImpl =  new BowlingLaneImpl(1,1, Arrays.array(player1));
		bowlingLaneImpl.nextPlay(1, 4, -1);
		bowlingLaneImpl.nextPlay(4, 99, -1);
		bowlingLaneImpl.nextPlay(1, 5, -1);
		bowlingLaneImpl.nextPlay(3, 5, -1);
		bowlingLaneImpl.nextPlay(6, 2, -1);
		bowlingLaneImpl.nextPlay(3, 1, -1);
		bowlingLaneImpl.nextPlay(8, 0, -1);
		bowlingLaneImpl.nextPlay(4, 99, -1);
		bowlingLaneImpl.nextPlay(3, 0, -1);
		bowlingLaneImpl.nextPlay(1, 99, 8);
		assertEquals(5, player1.getFrames()[0].getScore());
		assertEquals(16, player1.getFrames()[1].getScore());
		assertEquals(22, player1.getFrames()[2].getScore());
		assertEquals(30, player1.getFrames()[3].getScore());
		assertEquals(38, player1.getFrames()[4].getScore());
		assertEquals(42, player1.getFrames()[5].getScore());
		assertEquals(50, player1.getFrames()[6].getScore());
		assertEquals(63, player1.getFrames()[7].getScore());
		assertEquals(66, player1.getFrames()[8].getScore());
		assertEquals(84, player1.getFrames()[9].getScore());
	}	
	
	@Test
	void testRandomExampleFromInternet() {
		Player player1 = new Player(0);
		BowlingLaneImpl bowlingLaneImpl =  new BowlingLaneImpl(1,1, Arrays.array(player1));
		bowlingLaneImpl.nextPlay(8, 0, -1);
		bowlingLaneImpl.nextPlay(7, 0, -1);
		bowlingLaneImpl.nextPlay(5, 3, -1);
		bowlingLaneImpl.nextPlay(9, 99, -1);
		bowlingLaneImpl.nextPlay(9, 99, -1);
		bowlingLaneImpl.nextPlay(10, -1, -1);
		bowlingLaneImpl.nextPlay(8, 0, -1);
		bowlingLaneImpl.nextPlay(5, 1, -1);
		bowlingLaneImpl.nextPlay(3, 99, -1);
		bowlingLaneImpl.nextPlay(9, 0, -1);
		assertEquals(8, player1.getFrames()[0].getScore());
		assertEquals(15, player1.getFrames()[1].getScore());
		assertEquals(23, player1.getFrames()[2].getScore());
		assertEquals(42, player1.getFrames()[3].getScore());
		assertEquals(62, player1.getFrames()[4].getScore());
		assertEquals(80, player1.getFrames()[5].getScore());
		assertEquals(88, player1.getFrames()[6].getScore());
		assertEquals(94, player1.getFrames()[7].getScore());
		assertEquals(113, player1.getFrames()[8].getScore());
		assertEquals(122, player1.getFrames()[9].getScore());		
	}
	
	@Test
	void testRandomExampleFromInternet2() {
		Player player1 = new Player(0);
		BowlingLaneImpl bowlingLaneImpl =  new BowlingLaneImpl(1,1, Arrays.array(player1));
		bowlingLaneImpl.nextPlay(8, 99, -1);
		bowlingLaneImpl.nextPlay(9, 0, -1);
		bowlingLaneImpl.nextPlay(4, 4, -1);
		bowlingLaneImpl.nextPlay(7, 2, -1);
		bowlingLaneImpl.nextPlay(9, 99, -1);
		bowlingLaneImpl.nextPlay(10, -1, -1);
		bowlingLaneImpl.nextPlay(10, -1, -1);
		bowlingLaneImpl.nextPlay(8, 0, -1);
		bowlingLaneImpl.nextPlay(3, 5, -1);
		bowlingLaneImpl.nextPlay(9, 99, 7);
		assertEquals(19, player1.getFrames()[0].getScore());
		assertEquals(28, player1.getFrames()[1].getScore());
		assertEquals(36, player1.getFrames()[2].getScore());
		assertEquals(45, player1.getFrames()[3].getScore());
		assertEquals(65, player1.getFrames()[4].getScore());
		assertEquals(93, player1.getFrames()[5].getScore());
		assertEquals(111, player1.getFrames()[6].getScore());
		assertEquals(119, player1.getFrames()[7].getScore());
		assertEquals(127, player1.getFrames()[8].getScore());
		assertEquals(144, player1.getFrames()[9].getScore());		
	}
	
	
}
