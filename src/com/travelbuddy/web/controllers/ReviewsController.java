package com.travelbuddy.web.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.travelbuddy.web.dao.Review;
import com.travelbuddy.web.service.ReviewService;

@Controller
public class ReviewsController {
	private ReviewService rvService;

	@Autowired
	public void setDestService(ReviewService reviewService) {
		this.rvService = reviewService;
	}

	@RequestMapping("/reviews")
	public String showReviews(Model model) {

		List<Review> rvs = rvService.getCurrent();

		model.addAttribute("reviews", rvs);
		return "reviews";
	}
	
	@RequestMapping("/createReview")
	public String createReview() {
		return "createReview";
	}
	
	@RequestMapping("/docreate")
	public String doCreate() {
		return "reviewSubmitted";
	}
}
