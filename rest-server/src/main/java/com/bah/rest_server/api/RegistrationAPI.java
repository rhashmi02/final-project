package com.bah.rest_server.api;

import java.util.ArrayList;
import java.util.Date;
import java.util.Optional;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bah.rest_server.domain.Event;
import com.bah.rest_server.domain.Registration;

@RestController
@RequestMapping("/registrations")
public class RegistrationAPI {

	// @Autowired
	// RegistrationRepository repo;
	ArrayList<Registration> registrationList = new ArrayList<Registration>();

	@SuppressWarnings("deprecation")
	public RegistrationAPI() {
		Registration r1 = new Registration(1L, "1", "2", new Date(), "please email me the event details");
		Registration r2 = new Registration(2L, "2", "2", new Date(), "send transportation and hotel booking");
		Registration r3 = new Registration(3L, "3", "3", new Date(), "defer payments for a week");
		
		registrationList.add(r1);
		registrationList.add(r2);
		registrationList.add(r3);
	}
	@GetMapping
	public Iterable<Registration> getAll() {
		//  Workshop:  Implementation to return existing registrations
		return registrationList;
	}

	@GetMapping("/{registrationId}")
	public Registration getRegistrationById(@PathVariable("registrationId") long id) {
		//  Workshop:  Implementation to return a single registration from an ID
		Registration registration = null;
		for (int i = 0; i < registrationList.size(); i++) {
			if (registrationList.get(i).getId() == id) {
				registration = registrationList.get(i);
			}
		}
		return registration;
	}
}
