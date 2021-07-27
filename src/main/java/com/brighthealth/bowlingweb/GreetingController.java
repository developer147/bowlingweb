package com.brighthealth.bowlingweb;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.brighthealth.bowlingweb.models.BowlingLaneImpl;
import com.brighthealth.bowlingweb.models.Greeting;
import com.brighthealth.bowlingweb.models.Player;

@Controller
public class GreetingController {
//	  @Autowired
//	  Map<Integer, BowlingLaneImpl> onGoingGames;
	  
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
	    //model.addAttribute("greeting", greeting);
	    //return "result";
		
	    //model.addAttribute("players", players);
		//model.addAttribute("bowlingLaneImpl", bowlingLaneImpl);
	    
	    bowlingLaneImpl.startGame(players);
	    //model.addAttribute("bowlingLaneImpl", bowlingLaneImpl);
	    model.addAttribute("players", bowlingLaneImpl.getPlayers());
	    model.addAttribute("lane", bowlingLaneImpl.getLane());
	    //return "index :: player_frame";
	    return "index";
	  }
	  
//	  @PostMapping("/nextPlay")
//	  public String nextPlay(@ModelAttribute BowlingLaneImpl bowlingLaneImpl, Model model) {
//		  model.addAttribute("bowlingLaneImpl", bowlingLaneImpl);
//		  bowlingLaneImpl.nextPlay();
//		  return "index";
//	  }
	  
//	  @PostMapping("/nextPlay/{lane}")
	  @GetMapping("/nextPlay/{lane}")
	  public String nextPlay(@PathVariable("lane") int lane, Model model) {
		  BowlingLaneImpl bowlingLaneImpl = bowlingAlleyService.getBowlingLaneImplByLane(lane);
		  
		  model.addAttribute("players", bowlingLaneImpl.getPlayers());
		  model.addAttribute("lane", bowlingLaneImpl.getLane());
	  
		  //model.addAttribute("bowlingLaneImpl", bowlingLaneImpl);
		  bowlingLaneImpl.nextPlay();
		  return "index";
	  }	  
}
