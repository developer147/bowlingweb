package com.brighthealth.bowlingweb.services;

import com.brighthealth.bowlingweb.models.Frame;
import com.brighthealth.bowlingweb.models.FrameNumber;
import com.brighthealth.bowlingweb.models.Player;
import com.brighthealth.bowlingweb.models.Roll;
import com.brighthealth.bowlingweb.models.RollTrio;

public class BowlingLaneImpl implements BowlingLane {
	private int totalPlayers = -1;
	private Player[] players = null;
	private int currentFrameIndex = 1;
	private int currentPlayerIndex = 0;
	private long lane;
	
	public BowlingLaneImpl(int totalPlayers, long lane) {
		this.totalPlayers = totalPlayers; 
		this.lane = lane;
		this.players = initializePlayers(this.totalPlayers);
	}
	
	public BowlingLaneImpl(int totalPlayers, long lane, Player[] players) {
		this.totalPlayers = totalPlayers; 
		this.lane = lane;
		this.players = players;
	}	

	@Override
	public void start(Player[] players) {
		RollTrio rollTrio = RollTrio.getRandomRolls(false);
		nextPlay(rollTrio.getRoll1(), rollTrio.getRoll2(), rollTrio.getRoll3());
	}
	
	public boolean nextPlay(int rollInt1, int rollInt2, int rollInt3) {
		FrameNumber currentFrameNumber = FrameNumber.getFrameNumber(currentFrameIndex);
		FrameNumber previousFrameNumber = currentFrameIndex == 1 ? null : FrameNumber.getFrameNumber(currentFrameIndex - 1);
		FrameNumber lastToPreviousFrameNumber = currentFrameIndex <= 2 ? null : FrameNumber.getFrameNumber(currentFrameIndex - 2);
		FrameNumber secondLastToPreviousFrameNumber = currentFrameIndex <= 3 ? null : FrameNumber.getFrameNumber(currentFrameIndex - 3);
		
		Player currentPlayer = players[currentPlayerIndex];
		
		Frame previousFrame = previousFrameNumber ==  null ? null : currentPlayer.getFrame(previousFrameNumber);
		Frame lastToPreviousFrame = lastToPreviousFrameNumber == null ? null : currentPlayer.getFrame(lastToPreviousFrameNumber);
		Frame secondLastToPreviousFrame = secondLastToPreviousFrameNumber == null ? null : currentPlayer.getFrame(secondLastToPreviousFrameNumber);
		
		Roll roll1 = Roll.getRoll(rollInt1);				
		
		whenRollOneIsNotStrike(roll1, 
				previousFrame, 
				lastToPreviousFrame, 
				secondLastToPreviousFrame);
		
		whenRollOneIsStrike(roll1, 
				previousFrame, 
				lastToPreviousFrame, 
				secondLastToPreviousFrame);		
		
		// 99 is an arbitrary number to mark a spare.
		Roll roll2 = null;
		if (currentFrameIndex != 10) {
			roll2 = rollInt1 + rollInt2 == 10 ? Roll.getRoll(99) : Roll.getRoll(rollInt2);
		} else {
			roll2  = Roll.getRoll(rollInt2);
		}
		
		//Roll roll2 = Roll.getRoll2(currentFrameIndex, rollInt1, rollInt2);
		
		Frame currentFrame = new Frame(currentFrameNumber, 
					roll1, 
					roll2);				
		
		if (currentFrameIndex == 10) {
			if (roll1 == Roll.STRIKE || roll2 == Roll.SPARE) {
				currentFrame.setRoll3(Roll.getRoll(rollInt3));
			}
		}
		
		whenRollTwoIsNotEmpty(roll1, roll2, 
				previousFrame, 
				lastToPreviousFrame, 
				secondLastToPreviousFrame);
		
		whenRollOneIsNotStrikeAndRollTwoIsNotSpare(roll1, roll2,
				currentFrameIndex,
				currentFrame,
				previousFrame,
				previousFrameNumber,
				currentPlayer);
		
		// 10th is special because of the third potential roll so need extra care.
		if (currentFrameIndex == 10) {
			whenFrameIsTen(roll1, roll2,
					currentFrameIndex, 
					currentFrame,
					previousFrame);
		}
		
		currentPlayer.setFrame(currentFrameNumber, currentFrame);
		
		if (currentPlayerIndex == totalPlayers - 1) {
			currentFrameIndex++;
			currentPlayerIndex  =  0;
		} else {
			currentPlayerIndex++;
		}
		
		if (currentFrameIndex == 11) {
			return true;
		}
		return false;		
	}
	
	public  boolean isLastFrame() {
		return currentFrameIndex == 10 && currentPlayerIndex == totalPlayers - 1; 
	}
	
	private void whenFrameIsTen(Roll roll1, Roll roll2,
			int currentFrameIndex, 
			Frame currentFrame,
			Frame previousFrame) {

			Roll roll3 = currentFrame.getRoll3();
			int roll3Score = 0;
			if (roll3 != null) {
				roll3Score = roll3.getScore() == 99 ? 10 : roll3.getScore();
			}
			
			if (roll1 == Roll.STRIKE && roll2 == Roll.STRIKE) {
				currentFrame.setScore(previousFrame.getScore() + 20 + roll3Score);
			//} else if (roll1 != Roll.STRIKE && roll2 == Roll.STRIKE) {
			//	currentFrame.setScore(previousFrame.getScore() + roll1.getScore() + 10 + roll3Score);
			} else if (roll1 != Roll.STRIKE && roll2 == Roll.SPARE) {
				currentFrame.setScore(previousFrame.getScore() + 10 + roll3Score);
			} else {
				currentFrame.setScore(previousFrame.getScore() + roll1.getScore() + roll2.getScore() + roll3Score);
			}
			
			// best case scenario in the 10th frame
//			if (roll1 == Roll.STRIKE && roll2 == Roll.STRIKE && roll3 == Roll.STRIKE) {
//				// taken  care
//				currentFrame.setScore(previousFrame.getScore() + 30);
//			} else if (roll1 == Roll.STRIKE && roll2 == Roll.STRIKE && roll3 != Roll.STRIKE) {
//				// taken care
//				currentFrame.setScore(previousFrame.getScore() + 20 + roll3Score);
//			} else if (roll1 == Roll.STRIKE && roll2 == Roll.SPARE && roll3 == Roll.STRIKE) {
//				// can't happen
//			} else if (roll1 == Roll.STRIKE && roll2 == Roll.SPARE && roll3 != Roll.STRIKE) {
//				// can't happen
//			} else if (roll1 == Roll.STRIKE && roll2 != Roll.STRIKE && roll2 != Roll.SPARE && roll3 == Roll.STRIKE) {
//				// can't happen
//			} else if (roll1 == Roll.STRIKE && roll2 != Roll.STRIKE && roll2 != Roll.SPARE && roll3 != Roll.STRIKE) {
//				// can't happen
//			} else if (roll1 != Roll.STRIKE && roll2 == Roll.STRIKE && roll3 == Roll.STRIKE) {
//				// taken care
//			} else if (roll1 != Roll.STRIKE && roll2 == Roll.STRIKE && roll3 != Roll.STRIKE) {
//				// taken care
//			} else if (roll1 != Roll.STRIKE && roll2 == Roll.SPARE && roll3 == Roll.STRIKE) {
//				// can't happen
//			} else if (roll1 != Roll.STRIKE && roll2 == Roll.SPARE && roll3 != Roll.STRIKE) {
//			    // can't happen	
//			} else if (roll1 != Roll.STRIKE && roll2 != Roll.STRIKE && roll2 != Roll.SPARE && roll3 == Roll.STRIKE) {
//				
//			} else if (roll1 != Roll.STRIKE && roll2 != Roll.STRIKE && roll2 != Roll.SPARE && roll3 != Roll.STRIKE) {
//				
//			}
			
//			else if (roll1 == Roll.STRIKE && roll2 != Roll.STRIKE  && roll2 != Roll.SPARE) {
//				currentFrame.setScore(previousFrame.getScore() + 10 + roll2.getScore());
//			} else if (roll1 != Roll.STRIKE && (roll2 == Roll.STRIKE || roll2 == Roll.SPARE)) {
//				int roll2Score = roll2.getScore();
//				// if roll2 is a spare, we can't use 99 but calculate the real value using roll1
//				if (roll2 ==  Roll.SPARE) {
//					roll2Score = 10 - roll1.getScore();
//				}					
//				currentFrame.setScore(previousFrame.getScore() +  roll1.getScore() + roll2Score + roll3.getScore());
//			}
			
			
//			if (roll1 == Roll.STRIKE || roll2 == Roll.SPARE) {
//				currentFrame.setScore(previousFrame.getScore() + roll1.getScore() + roll2.getScore() + roll3.getScore());
//			} else {
//				currentFrame.setScore(previousFrame.getScore() + roll1.getScore() + roll2.getScore());
//			}
	}	
	
	private void whenRollOneIsNotStrike(Roll roll1, Frame previousFrame,
			Frame lastToPreviousFrame,
			Frame secondLastToPreviousFrame
			) {
		// if roll1 is not a strike, check previous frame's second roll and
		// if it's a spare, set last frame's score.
		if (roll1 != Roll.STRIKE) {
			if (previousFrame != null) {
				// if roll1 is not a strike, check previous frame's second roll and
				// if it's a spare, set last frame's score.					
				if (previousFrame.getRoll2() == Roll.SPARE) {
					if (lastToPreviousFrame != null) {
						previousFrame.setScore(lastToPreviousFrame.getScore() + 10 + roll1.getScore());
					} else {
						previousFrame.setScore(10 + roll1.getScore());
					}
				// if roll1 is not a strike, and previous frame's first roll is a strike,
				// and last to previous frame's first roll is also a strike then 
				// update last to previous frame's score.
				} else if (previousFrame.getRoll1()  == Roll.STRIKE) {
					if (lastToPreviousFrame != null && lastToPreviousFrame.getRoll1() == Roll.STRIKE) {
						if (secondLastToPreviousFrame != null) {
							lastToPreviousFrame.setScore(secondLastToPreviousFrame.getScore() + 20 + roll1.getScore()); 
						} else {
							lastToPreviousFrame.setScore(20 + roll1.getScore());
						}
					}
				}
			}
		}		
	}
	
	private void whenRollOneIsStrike(Roll roll1, Frame previousFrame,
			Frame lastToPreviousFrame,
			Frame secondLastToPreviousFrame) {
		if (roll1 == Roll.STRIKE) {
			if (previousFrame != null) {
				// if first roll is a strike, and previous frame's second roll was a spare
				// update previous frame's score.
				if (previousFrame.getRoll2() == Roll.SPARE) {
					if (lastToPreviousFrame != null) {
						previousFrame.setScore(lastToPreviousFrame.getScore() + 20);
					} else {
						previousFrame.setScore(20);
					}
					// if first roll is a strike, and last two were also strikes,
					// update last to previous frame's score.s
				} else if (previousFrame.getRoll1() == Roll.STRIKE) {
					if (lastToPreviousFrame != null && lastToPreviousFrame.getRoll1() == Roll.STRIKE) {
						if (secondLastToPreviousFrame != null) {
							lastToPreviousFrame.setScore(secondLastToPreviousFrame.getScore() + 30);
						} else {
							lastToPreviousFrame.setScore(30);
						}
					}
				}
			}
		}		
	}
	
	private void whenRollTwoIsNotEmpty(Roll roll1, Roll roll2, Frame previousFrame,
			Frame lastToPreviousFrame,
			Frame secondLastToPreviousFrame) {
		if (roll2 != Roll.EMPTY) {
			// check if previous frame had a strike. If  yes, update previous frame score.
			if (previousFrame != null) {
				if (previousFrame.getRoll1() == Roll.STRIKE) {
					int roll2Score = roll2.getScore();
					// if roll2 is a spare, we can't use 99 but calculate the real value using roll1
					if (roll2 ==  Roll.SPARE) {
						roll2Score = 10 - roll1.getScore();
					}
					if (lastToPreviousFrame != null) {
						previousFrame.setScore(lastToPreviousFrame.getScore() + 10 + roll1.getScore() + roll2Score);
					} else {
						previousFrame.setScore(10 + roll1.getScore() + roll2Score);
					}
				}
			}
		}		
	}
	
	private void whenRollOneIsNotStrikeAndRollTwoIsNotSpare(Roll roll1, Roll roll2,
			int currentFrameIndex,
			Frame currentFrame,
			Frame previousFrame,
			FrameNumber previousFrameNumber,
			Player currentPlayer) {
		// When player's frame does not have a strike or a spare, update frame's score immediately.
		if (roll1 != Roll.STRIKE && roll2 != Roll.SPARE) {
			int currentFrameScore = roll1.getScore() + roll2.getScore();
			if (currentFrameIndex == 1) {
				currentFrame.setScore(currentFrameScore);
			} else {
				previousFrame = currentPlayer.getFrame(previousFrameNumber);
				currentFrame.setScore(previousFrame.getScore() + currentFrameScore);
			}
		}		
	}
	
	@Override
	public void stop() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void reset() {
		// TODO Auto-generated method stub
		
	}
	
	public Player[] getPlayers() {
		return this.players;
	}
	
	public long getLane() {
		return lane;
	}	
	
	private Player[] initializePlayers(int totalPlayers) {
		Player[] players = new Player[totalPlayers];
		//Initialize players
		for (int player = 0; player < totalPlayers; player++) {
			players[player] = new Player(player);
		}
		return players;
	}

	@Override
	public void pause() {
		// TODO Auto-generated method stub
		
	}	
}