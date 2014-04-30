package com.travelbuddy.web.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSourceUtils;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component("reviewDao")
public class ReviewDao {

	private NamedParameterJdbcTemplate jdbc;

	@Autowired
	public void setDataSource(DataSource jdbc) {
		this.jdbc = new NamedParameterJdbcTemplate(jdbc);
	}


	public List<Review> getReviews() {

		return jdbc.query("select * from Review, users where Review.username=users.username",
				new ReviewRowMapper());
	}
	
	public List<Review> getReviews(String username) {

		return jdbc.query("select * from Review, users where Review.username=users.username and Review.username=:username",
				new MapSqlParameterSource("username", username), new ReviewRowMapper());
	}
	

	public Review getReview(int id) {

		MapSqlParameterSource params = new MapSqlParameterSource();
		params.addValue("id", id);

		return jdbc.queryForObject("select * from Review, users where Review.username=users.username and users.enabled=true and id=:id",
				params, new ReviewRowMapper());
	}
	
	public boolean update(Review rv) {
		BeanPropertySqlParameterSource params = new BeanPropertySqlParameterSource(rv);

		return jdbc.update("update Review set title=:title, rating=:rating, description=:description where id=:id", params) == 1;
	}
	
	public boolean create(Review rv) {
		BeanPropertySqlParameterSource params = new BeanPropertySqlParameterSource(rv);
		
		return jdbc.update("insert into Review (username,title,rating,description) values (:username, :title,:rating,:description)", params) == 1;
	}
	
	@Transactional
	public int[] create(List<Review> reviews) {
		SqlParameterSource[] params = SqlParameterSourceUtils.createBatch(reviews.toArray());
		
		return jdbc.batchUpdate("insert into Review (username,title,rating,description) values (:username, :title,:rating,:description)", params);
	}

	public boolean delete(int id) {
		MapSqlParameterSource paramMap = new MapSqlParameterSource("id", id);
		return jdbc.update("delete from Review where id= :id", paramMap) == 1;
	}

}
