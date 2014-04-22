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

@Component("destinationDao")
public class DestinationDAO {

	private NamedParameterJdbcTemplate jdbc;

	@Autowired
	public void setDataSource(DataSource jdbc) {
		this.jdbc = new NamedParameterJdbcTemplate(jdbc);
	}


	public List<Destination> getDestinations() {

		return jdbc.query("select * from Destination",
				new RowMapper<Destination>() {

					@Override
					public Destination mapRow(ResultSet rs, int rowNum)
							throws SQLException {
						Destination dest = new Destination();
						dest.setId(rs.getInt("id"));
						dest.setName(rs.getString("name"));
						dest.setDescription(rs.getString("description"));
						return dest;
					}

				});
	}

	public Destination getDestination(int id) {

		MapSqlParameterSource params = new MapSqlParameterSource();
		params.addValue("id", id);

		return jdbc.queryForObject("select * from Destination where id = :id",
				params, new RowMapper<Destination>() {

					@Override
					public Destination mapRow(ResultSet rs, int rowNum)
							throws SQLException {
						Destination dest = new Destination();
						dest.setId(rs.getInt("id"));
						dest.setName(rs.getString("name"));
						dest.setDescription(rs.getString("description"));
						return dest;
					}

				});
	}
	
	public boolean update(Destination dest) {
		BeanPropertySqlParameterSource params = new BeanPropertySqlParameterSource(dest);

		return jdbc.update("update Destination set name=:name, description=:description where id=:id", params) == 1;
	}
	
	public boolean create(Destination dest) {
		BeanPropertySqlParameterSource params = new BeanPropertySqlParameterSource(dest);
		
		return jdbc.update("insert into Destination (name,description) values (:name,:description)", params) == 1;
	}
	
	@Transactional
	public int[] create(List<Destination> destinations) {
		SqlParameterSource[] params = SqlParameterSourceUtils.createBatch(destinations.toArray());
		
		return jdbc.batchUpdate("insert into Destination (name,description) values (:name,:description)", params);
	}

	public boolean delete(int id) {
		MapSqlParameterSource paramMap = new MapSqlParameterSource("id", id);
		return jdbc.update("delete from Destination where id= :id", paramMap) == 1;
	}

}
