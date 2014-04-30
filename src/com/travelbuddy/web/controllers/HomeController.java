package com.travelbuddy.web.controllers;

import java.security.Principal;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.travelbuddy.web.dao.Review;
import com.travelbuddy.web.service.ReviewService;

@Controller
public class HomeController {

	private static Logger logger = Logger.getLogger(HomeController.class);
	
	@Autowired
	private ReviewService reviewService;
	
	@RequestMapping("/")
	public String showHome(Model model, Principal principal) {
		
		List<Review> rvs = reviewService.getCurrent();

		model.addAttribute("reviews", rvs);
		
		boolean hasReview=false;
		if(principal != null) { //user is logged in, principal = user object!
			hasReview = reviewService.hasReview(principal.getName());
		}
		model.addAttribute("hasReview", hasReview);
		return "home";
	}

}