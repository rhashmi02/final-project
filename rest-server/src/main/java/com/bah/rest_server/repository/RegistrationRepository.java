package com.bah.rest_server.repository;

import org.springframework.data.repository.CrudRepository;

import com.bah.rest_server.domain.Registration;

public interface RegistrationRepository extends CrudRepository<Registration, Long> {

}
