package com.travelbuddy.web.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.travelbuddy.web.dao.Destination;
import com.travelbuddy.web.dao.DestinationDao;

@Service("destinationService")
public class DestinationService {
	
	private DestinationDao destinationDao;
	
	@Autowired
	public void setDestinationDao(DestinationDao destinationDao) {
		this.destinationDao = destinationDao;
	}
	
	public List<Destination> getCurrent(){
		return destinationDao.getDestinations();
	}



}
