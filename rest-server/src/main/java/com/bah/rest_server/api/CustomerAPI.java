package com.bah.rest_server.api;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.bah.rest_server.domain.Customer;
import com.bah.rest_server.domain.Event;
import com.bah.rest_server.repository.CustomersRepository;

@RestController
@RequestMapping("/customers")
public class CustomerAPI {
	//@Autowired
	//CustomersRepository repo;
	ArrayList<Customer> customerList = new ArrayList<Customer>();

	public CustomerAPI() {
		Customer c1 = new Customer(1L, "clement", "pass", "clement@bah.com");
		Customer c2 = new Customer(2L, "jane", "pass", "jane@bah.com");
		Customer c3 = new Customer(3L, "kyle", "pass", "kyle@bah.com");
		Customer c4 = new Customer(4L, "lexi", "pass", "lexi@bah.com");
		Customer c5 = new Customer(5L, "rayyan", "pass", "rayyan@bah.com");
		Customer c6 = new Customer(6L, "stuart", "pass", "stuart@bah.com");
		Customer c7 = new Customer(7L, "winston", "pass", "winston@bah.com");
		Customer c8 = new Customer(8L, "zach", "pass", "zach@bah.com");
		
		customerList.add(c1);
		customerList.add(c2);
		customerList.add(c3);
		customerList.add(c4);
		customerList.add(c5);
		customerList.add(c6);
		customerList.add(c7);
		customerList.add(c8);
	}

	@GetMapping
	public Iterable<Customer> getAll() {
		//  Workshop:  Write an implementation that replies with all customers.
		//  Your implementation should be no more than a few lines, at most, and make use of the 'repo' object
	
		return customerList;
	}

	@GetMapping("/{customerId}")
	public Customer getCustomerById(@PathVariable("customerId") long id) {
		//  Workshop:  Write an implementation that looks up one customer.  What do you return if the requested 
		//  customer ID does not exists?  This implementation could be as short as a single line.
	
		// return customerList.get((int) id - 1);
		Customer customer = null;
		for (int i = 0; i < customerList.size(); i++) {
			if (customerList.get(i).getId() == id) {
				customer = customerList.get(i);
			}
		}
		return customer;
				
		
	}
	
}
