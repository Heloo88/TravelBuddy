package com.travelbuddy.web.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
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

	@Secured({"ROLE_USER","ROLE_ADMIN"})
	public void create(Review review) {
		reviewDao.create(review);
	}

}
