package com.airport.tickets.repository;

import com.airport.tickets.domain.Flight;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface FlightRepository extends CrudRepository<Flight, Long> {

    @Override
    List<Flight> findAll();
}
