package com.travelbuddy.web.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.travelbuddy.web.dao.Destination;
import com.travelbuddy.web.service.DestinationService;

@Controller
public class DestinationsController {
	private DestinationService destService;

	@Autowired
	public void setDestService(DestinationService destinationService) {
		this.destService = destinationService;
	}

	@RequestMapping("/destinations")
	public String showDestinations(Model model) {

		List<Destination> dests = destService.getCurrent();

		model.addAttribute("destinations", dests);
		return "destinations";
	}
	
	@RequestMapping(value ="/test", method=RequestMethod.GET)
	public String showTest(Model model,@RequestParam("id") String id) {
		System.out.println("Id is: " + id);
		return "home";
	}
	
	@RequestMapping("/createDestination")
	public String createDestination() {
		return "createDestination";
	}
}
