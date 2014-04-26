package com.travelbuddy.web.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.travelbuddy.web.dao.Review;
import com.travelbuddy.web.dao.ReviewDao;

@Service("reviewService")
public class ReviewService {
	private ReviewDao reviewDao;
	
	@Autowired
	public void setreviewDao(ReviewDao reviewDao) {
		this.reviewDao = reviewDao;
	}
	
	public List<Review> getCurrent(){
		return reviewDao.getReviews();
	}

	public void create(Review review) {
		reviewDao.create(review);
	}

	public void throwTestException() {
		reviewDao.getReview(888888);	
	}

}
