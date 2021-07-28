package com.brighthealth.bowlingweb.controllers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.brighthealth.bowlingweb.models.Greeting;
import com.brighthealth.bowlingweb.models.Player;
import com.brighthealth.bowlingweb.services.BowlingAlleyService;
import com.brighthealth.bowlingweb.services.BowlingLaneImpl;

@Controller
public class GreetingController {
	  @Autowired
	  BowlingAlleyService bowlingAlleyService;	  
	
	  @GetMapping("/greeting")
	  public String greetingForm(Model model) {
	    model.addAttribute("greeting", new Greeting());
	    return "greeting";
	  }

	  @PostMapping("/greeting")
	  public String greetingSubmit(@ModelAttribute Greeting greeting, Model model) {
		int laneNumber = bowlingAlleyService.getLane();
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
	  
		  bowlingLaneImpl.nextPlay();
		  return "index";
	  }	  
}
