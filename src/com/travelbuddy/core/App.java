package com.travelbuddy.core;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.dao.DataAccessException;

import com.travelbuddy.web.dao.Destination;
import com.travelbuddy.web.dao.DestinationDAO;

public class App {

	public static void main(String[] args) {

		ApplicationContext context = new ClassPathXmlApplicationContext(
				"com/travelbuddy/core/beans/beans.xml");

		DestinationDAO destDao = (DestinationDAO) context
				.getBean("destinationDao");

		try {
			
			/*Destination dest1 = new Destination("Mallorca","Great beaches!");
			Destination dest2 = new Destination("London","Shopping paradise");
			
			if(destDao.create(dest1)) {
				System.out.println("Created offer object.");
			};
			destDao.create(dest2);
			*/
			
			/*List<Destination> dests = new ArrayList<Destination>();
			dests.add(new Destination("Ieper","Small historic town in Belgium with a special bond with WWI"));
			dests.add(new Destination("Gent","Historic city in Belgium with a beautiful castle"));
			
			int[] rvals = destDao.create(dests);
			for(int value: rvals) {
				System.out.println("Updated " + value + " rows.");
			}*/
			
			//destDao.delete(7);
			/*Destination d = new Destination(6,"Budapest","Amazing city for fun and culture!");
			if(destDao.update(d)) {
				System.out.println("Object updated.");
			}
			else {
				System.out.println("Cannot update object");
			}*/
			List<Destination> destinations = destDao.getDestinations();

			for (Destination dest : destinations) {
				System.out.println(dest);
			}
			
			//Destination dest2 = destDao.getDestination(2);
			//System.out.println(dest2);
			

			
		} catch (DataAccessException e) {
			System.out.println(e.getMessage());
			System.out.println(e.getClass());
		}

		((ClassPathXmlApplicationContext) context).close();
	}

}