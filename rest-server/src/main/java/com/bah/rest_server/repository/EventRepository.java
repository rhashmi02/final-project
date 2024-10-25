package com.bah.rest_server.repository;

import org.springframework.data.repository.CrudRepository;

import com.bah.rest_server.domain.Event;

public interface EventRepository extends CrudRepository<Event, Long> {

}
