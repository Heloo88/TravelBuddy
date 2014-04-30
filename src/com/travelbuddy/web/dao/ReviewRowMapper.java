package com.travelbuddy.web.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class ReviewRowMapper implements RowMapper<Review> {

	@Override
	public Review mapRow(ResultSet rs, int rowNum) throws SQLException {
		User user = new User();
		user.setAuthority(rs.getString("authority"));
		user.setEmail(rs.getString("email"));
		user.setEnabled(true);
		user.setName(rs.getString("name"));
		user.setUsername(rs.getString("username"));
		
		Review rv = new Review();
		rv.setId(rs.getInt("id"));
		rv.setTitle(rs.getString("title"));
		rv.setRating(rs.getInt("rating"));
		rv.setDescription(rs.getString("description"));
		rv.setUser(user);
		
		return rv;
	}

}
