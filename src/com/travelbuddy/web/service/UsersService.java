package com.travelbuddy.web.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Service;

import com.travelbuddy.web.dao.User;
import com.travelbuddy.web.dao.UsersDao;

@Service("usersService")
public class UsersService {
	private UsersDao usersDao;
	
	@Autowired
	public void setreviewDao(UsersDao usersDao) {
		this.usersDao = usersDao;
	}
	
	public void create(User user) {
		usersDao.create(user);
	}

	public boolean exists(String username) {
		return usersDao.exists(username);
	}

	@Secured("ROLE_ADMIN")
	public List<User> getAllUsers() {
		return usersDao.getAllUsers();
	}


}
