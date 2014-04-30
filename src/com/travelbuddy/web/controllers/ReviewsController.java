package com.travelbuddy.web.controllers;

import java.security.Principal;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

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

	@RequestMapping("/createreview")
	public String createReview(Model model, Principal principal) {
		
		Review review = null;
		
		if(principal != null) {
			String username = principal.getName();
			review = reviewService.getReview(username);
		}
		if(review == null) {
			review = new Review();
		}
		model.addAttribute("review",review);
		return "createreview";
	}

	@RequestMapping(value = "/docreate", method = RequestMethod.POST) 
	public String doCreate(Model model, @Valid Review review,
			BindingResult result, Principal principal, @RequestParam(value="delete", required = false) String delete) {
		if (result.hasErrors()) {
			return "createreview";
		}	
		if(delete == null) {
			String username = principal.getName();
			review.getUser().setUsername(username);
			reviewService.saveOrUpdate(review);
			System.out.println(review);
			return "reviewsubmitted";
		}
		else {
			reviewService.delete(review.getId());
			return "reviewdeleted";
		}

	}
}
