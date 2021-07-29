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
import com.brighthealth.bowlingweb.services.BowlingAlleyService;
import com.brighthealth.bowlingweb.services.BowlingLaneImpl;

@Controller
public class BowlingController {
	  @Autowired
	  BowlingAlleyService bowlingAlleyService;	  
	
	  @GetMapping("/")
	  public String playerCountForm(Model model) {
	    model.addAttribute("PlayerCount", new PlayerCount());
	    return "PlayerCount";
	  }

	  @PostMapping("/")
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
