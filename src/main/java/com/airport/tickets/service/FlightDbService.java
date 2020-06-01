package com.airport.tickets.service;

import com.airport.tickets.domain.Flight;
import com.airport.tickets.repository.FlightRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FlightDbService {

    @Autowired
    FlightRepository repository;

    public List<Flight> getAllFlights() {
        return repository.findAll();
    }
}
