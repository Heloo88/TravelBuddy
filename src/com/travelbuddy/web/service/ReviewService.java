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

	public boolean hasReview(String name) {
		
		if(name == null) return false;
		
		List<Review> reviews = reviewDao.getReviews(name);
		if(reviews.size() == 0) {
			return false;
		}
		return true;
	}

	public Review getReview(String username) {
		
		if(username == null) {
			return null;
		}
		List<Review> reviews = reviewDao.getReviews(username);
		if(reviews.size() == 0) {
			return null;
		}
		
		return reviews.get(0);
	}

	public void saveOrUpdate(Review review) {
		if(review.getId() != 0) {
			reviewDao.update(review);
		}
		else {
			reviewDao.create(review);
		}
		
	}

	public void delete(int id) {
		reviewDao.delete(id);		
	}

}
