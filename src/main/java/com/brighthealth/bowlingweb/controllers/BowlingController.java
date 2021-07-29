package com.brighthealth.bowlingweb.controllers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.brighthealth.bowlingweb.models.Player;
import com.brighthealth.bowlingweb.models.PlayerCount;
import com.brighthealth.bowlingweb.models.RollTrio;
import com.brighthealth.bowlingweb.services.BowlingAlley;
import com.brighthealth.bowlingweb.services.BowlingLaneImpl;

/*
 * Controller to drive a bowling lane for a set of players
 */
@Controller
public class BowlingController {
	  @Autowired
	  BowlingAlley bowlingAlleyService;	  
	
	  /*
	   * Home Page
	   */
	  @GetMapping("/")
	  public String playerCountForm(Model model) {
	    model.addAttribute("PlayerCount", new PlayerCount());
	    return "PlayerCount";
	  }

	  /*
	   * Takes the user input and kick starts the game.
	   */
	  public String playerCountSubmit(@ModelAttribute PlayerCount greeting, Model model) {
		long laneNumber = bowlingAlleyService.getLane();
		BowlingLaneImpl bowlingLaneImpl = new BowlingLaneImpl(greeting.getCount(), laneNumber);
		bowlingAlleyService.setCurrentLane(laneNumber, bowlingLaneImpl);
		
		Player[] players =  bowlingLaneImpl.getPlayers();
	    
	    bowlingLaneImpl.start(players);
	    model.addAttribute("players", bowlingLaneImpl.getPlayers());
	    model.addAttribute("lane", bowlingLaneImpl.getLane());
	    return "index";
	  }
	  
	  /*
	   * Each time this method is called, it plays one round/frame.
	   * For example, if there are 6 players and 10 frames (this is constant)..
	   * first call to this method player 1 frame 1, next time player 2 frame 1
	   * so on and so forth. Before the game completes, this method will be called
	   * 60 times (6 players times 10 frames)
	   */
	  @GetMapping("/nextPlay/{lane}")
	  public String nextPlay(@PathVariable("lane") int lane, Model model) {
		  BowlingLaneImpl bowlingLaneImpl = bowlingAlleyService.getBowlingLaneImplByLane(lane);
		  
		  model.addAttribute("players", bowlingLaneImpl.getPlayers());
		  model.addAttribute("lane", bowlingLaneImpl.getLane());
		  
		  RollTrio rollTrio = RollTrio.getRandomRolls(bowlingLaneImpl.isLastFrame());
	  
		  boolean isGameOver = bowlingLaneImpl.nextPlay(rollTrio.getRoll1(),  rollTrio.getRoll2(), 
				  rollTrio.getRoll3());
		  model.addAttribute("isGameOver", isGameOver);
		  
		  if (isGameOver) {
			  bowlingAlleyService.cleanup(lane);
		  }
		  
		  return "index";
	  }	  
}
