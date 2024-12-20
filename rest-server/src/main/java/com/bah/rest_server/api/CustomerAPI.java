package com.bah.rest_server.api;

import java.net.URI;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import org.springframework.web.util.UriComponentsBuilder;

import com.bah.rest_server.domain.Customer;
import com.bah.rest_server.repository.CustomersRepository;

@RestController
@RequestMapping("/customers")
public class CustomerAPI {
	@Autowired
	CustomersRepository repo;

	@GetMapping
	public Iterable<Customer> getAll() {
		// Workshop: Write an implementation that replies with all customers.
		// Your implementation should be no more than a few lines, at most, and make use
		// of the 'repo' object
		return repo.findAll();
	}

	@GetMapping("/{customerId}")
	public Optional<Customer> getCustomerById(@PathVariable("customerId") long id) {
		// Workshop: Write an implementation that looks up one customer. What do you
		// return if the requested
		// customer ID does not exists? This implementation could be as short as a
		// single line.

		return repo.findById(id);

	}

	@PostMapping
	public ResponseEntity<?> addCustomer(@RequestBody Customer newCustomer, UriComponentsBuilder uri) {
		// Workshop: Write an implementation that adds a new customer. Your
		// implementation should check to make sure that the name and email fields are
		// not null and that no id was passed (it will be auto generated when the record
		// is inserted. Remember REST semantics - return a reference to the newly
		// created
		// entity as a URI.
		if (newCustomer.getId() != 0 || newCustomer.getName() == null || newCustomer.getEmail() == null) {
			return ResponseEntity.badRequest().build();
		}
		newCustomer = repo.save(newCustomer);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(newCustomer.getId()).toUri();
		ResponseEntity<?> response = ResponseEntity.created(location).build();
		return response;
	}

	// lookupCustomerByName GET
	@GetMapping("/byname/{username}")
	public ResponseEntity<?> lookupCustomerByNameGet(@PathVariable("username") String username,
			UriComponentsBuilder uri) {
		// Workshop: Write an implemenatation to look up a customer by name. Think about
		// what
		// your response should be if no customer matches the name the caller is
		// searching for.
		// With the data model implemented in CustomersRepository, do you need to handle
		// more than
		// one match per request?
		Iterable<Customer> customers = repo.findAll();
		for (Customer c : customers) {
			if (c.getName().equals(username)) {
				return ResponseEntity.ok(c);
			}
		}
		return ResponseEntity.badRequest().build();
	}

	// lookupCustomerByName POST
	@PostMapping("/byname")
	public ResponseEntity<?> lookupCustomerByNamePost(@RequestBody String username, UriComponentsBuilder uri) {
		// Workshop: Write an implementation to look up a customer by name, using POST
		// semantics
		// rather than GET. You should be able to make use of most of your implmentation
		// for
		// lookupCustomerByNameGet().
		return null;
	}

	@PutMapping("/{customerId}")
	public ResponseEntity<?> putCustomer(@RequestBody Customer newCustomer,
			@PathVariable("customerId") long customerId) {
		if (newCustomer.getId() != customerId || newCustomer.getName() == null || newCustomer.getEmail() == null) {
			return ResponseEntity.badRequest().build();
		}
		newCustomer = repo.save(newCustomer);
		return ResponseEntity.ok().build();
	}

	@DeleteMapping("/{customerId}")
	public ResponseEntity<?> deleteCustomerById(@PathVariable("customerId") long id) {
		// Implement a method to delete a customer. What is an appropriate response?
		//
		// For discussion (do not worry about implementation): What are some ways of
		// handling
		// a "delete"? Is it always the right thing from a business point of view to
		// literally
		// delete a customer entry? If you did actually delete a customer entry, are
		// there issues
		// you could potentially run into later?
		
		if (repo.existsById(id) == false) {
			return ResponseEntity.badRequest().build();
		}
		repo.deleteById(id);		
		return ResponseEntity.ok().build();
	}

}
