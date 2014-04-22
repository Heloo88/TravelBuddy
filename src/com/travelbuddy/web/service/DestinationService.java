package com.travelbuddy.web.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.travelbuddy.web.dao.Destination;
import com.travelbuddy.web.dao.DestinationDAO;

@Service("destinationService")
public class DestinationService {
	
	private DestinationDAO destinationDao;
	
	@Autowired
	public void setDestinationDao(DestinationDAO destinationDao) {
		this.destinationDao = destinationDao;
	}
	
	public List<Destination> getCurrent(){
		return destinationDao.getDestinations();
	}



}
