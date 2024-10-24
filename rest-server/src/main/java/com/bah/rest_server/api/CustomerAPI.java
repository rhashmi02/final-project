package com.bah.rest_server.api;

import java.util.ArrayList;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.bah.rest_server.domain.Customer;

@RestController
@RequestMapping("/customers")
public class CustomerAPI {
	//@Autowired
	//CustomersRepository repo;
	ArrayList<Customer> customerList = new ArrayList<Customer>();

	public CustomerAPI() {
		Customer c1 = new Customer(1L, "clement", "clement@bah.com", "pass");
		Customer c2 = new Customer(2L, "jane", "jane@bah.com", "pass");
		Customer c3 = new Customer(3L, "kyle", "kyle@bah.com", "pass");
		Customer c4 = new Customer(4L, "lexi", "lexi@bah.com", "pass");
		Customer c5 = new Customer(5L, "rayyan", "rayyan@bah.com", "pass");
		Customer c6 = new Customer(6L, "stuart", "stuart@bah.com", "pass");
		Customer c7 = new Customer(7L, "winston", "winston@bah.com", "pass");
		Customer c8 = new Customer(8L, "zach", "zach@bah.com", "pass");
		
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
