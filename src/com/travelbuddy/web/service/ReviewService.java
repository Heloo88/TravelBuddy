package com.travelbuddy.web.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.travelbuddy.web.dao.Review;
import com.travelbuddy.web.dao.ReviewDAO;

@Service("reviewService")
public class ReviewService {
	private ReviewDAO reviewDao;
	
	@Autowired
	public void setreviewDao(ReviewDAO reviewDao) {
		this.reviewDao = reviewDao;
	}
	
	public List<Review> getCurrent(){
		return reviewDao.getReviews();
	}
}
