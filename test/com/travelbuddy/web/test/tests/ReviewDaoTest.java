package com.travelbuddy.web.test.tests;




import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.List;

import javax.sql.DataSource;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.travelbuddy.web.dao.Review;
import com.travelbuddy.web.dao.ReviewDao;
import com.travelbuddy.web.dao.User;
import com.travelbuddy.web.dao.UsersDao;


@ActiveProfiles("dev")
@ContextConfiguration(locations = {
		"classpath:com/travelbuddy/web/config/dao-context.xml",
		"classpath:com/travelbuddy/web/config/security-context.xml",
		"classpath:com/travelbuddy/web/test/config/datasource.xml", })
@RunWith(SpringJUnit4ClassRunner.class)
public class ReviewDaoTest {

	
	@Autowired
	private ReviewDao reviewDao;
	
	@Autowired
	private UsersDao usersDao;
	
	@Autowired
	private DataSource dataSource;

	@Before
	public void init() {
		JdbcTemplate jdbc = new JdbcTemplate(dataSource);
		
		jdbc.execute("delete from Review");
		jdbc.execute("delete from users");
	}
	
	@Test
	public void testReviews() {

		User user = new User("jeroen","Jeroen", "jeroen88", "jeroen@web.com", true, "user");
		assertTrue("User creation",usersDao.create(user));
		
		Review review = new Review(user,"Test", 1, "This is a test offer.");
		
		assertTrue("Review creation should return true", reviewDao.create(review));
		
		List<Review> reviews = reviewDao.getReviews();
		
		assertEquals("Should be one review in database.", 1, reviews.size());
		
		assertEquals("Retrieved review should match created review.", review, reviews.get(0));
		
		// Get the offer with ID filled in.
		review = reviews.get(0);
		
		review.setDescription("Updated description review.");
		assertTrue("Review update should return true", reviewDao.update(review));
		
		Review updated = reviewDao.getReview(review.getId());
		
		assertEquals("Updated review should match retrieved updated review", review, updated);
		
		reviewDao.delete(review.getId());
		
		List<Review> empty = reviewDao.getReviews();
		
		assertEquals("Review lists should be empty.", 0, empty.size());
	}
	
}