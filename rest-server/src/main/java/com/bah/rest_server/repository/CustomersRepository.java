package com.bah.rest_server.repository;

import org.springframework.data.repository.CrudRepository;

import com.bah.rest_server.domain.Customer;

public interface CustomersRepository extends CrudRepository<Customer, Long> {

}