package com.travelbuddy.web.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.travelbuddy.web.dao.Review;
import com.travelbuddy.web.service.ReviewService;

@Controller
public class ReviewsController {
	private ReviewService reviewService;

	@Autowired
	public void setDestService(ReviewService reviewService) {
		this.reviewService = reviewService;
	}
	/*
	@ExceptionHandler(DataAccessException.class)
	public String handleDatabaseException(DataAccessException ex) {
		return "error";
	}*/
	
	@RequestMapping("/reviews")
	public String showReviews(Model model) {
		//reviewService.throwTestException();
		List<Review> rvs = reviewService.getCurrent();

		model.addAttribute("reviews", rvs);
		return "reviews";
	}

	@RequestMapping("/createReview")
	public String createReview(Model model) {
		model.addAttribute("review",new Review());
		return "createReview";
	}

	@RequestMapping(value = "/docreate", method = RequestMethod.POST) 
	public String doCreate(Model model, @Valid Review review,
			BindingResult result) {
		if (result.hasErrors()) {
			return "createReview";
		}
		reviewService.create(review);
		System.out.println(review);
		return "reviewSubmitted";
	}
}
