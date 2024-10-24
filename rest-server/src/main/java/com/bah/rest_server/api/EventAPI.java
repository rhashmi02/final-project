package com.bah.rest_server.api;

import java.util.ArrayList;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bah.rest_server.domain.Event;

@RestController
@RequestMapping("/events")
public class EventAPI {
	//@Autowired
	//EventRepository repo;
	ArrayList<Event> eventList = new ArrayList<Event>();

	public EventAPI() {
		

		Event e1 = new Event(1L, "CNF001", "All-Java Conference", "Lectures and exhibits covering all Java topics");
		Event e2 = new Event(2L, "WKS002", "Spring Boot Workshop", "Hands-on Spring Boot Workshop");
		Event e3 = new Event(3L, "TRN001", "Angular Training Course", "Five day introductory training in Angular");
		Event e4 = new Event(4L, "RNR004", "Rock n Roll Concert", "BAH Employees RocknRoll Concert");
		
		eventList.add(e1);
		eventList.add(e2);
		eventList.add(e3);
		eventList.add(e4);
		
	}

	@GetMapping
	public Iterable<Event> getAll() {
		//  Workshop:  Implement a method to retrieve all events
		return eventList;
	}

	@GetMapping("/{eventId}")
	public Event getEventById(@PathVariable("eventId") long id) {
		//  Workshop:  Implement a method to retrieve a single event by it's ID
		Event event = null;
		for (int i = 0; i < eventList.size(); i++) {
			if (eventList.get(i).getId() == id) {
				event = eventList.get(i);
			}
		}
		return event;
	}

}
