package com.airport.tickets.controller;

import com.airport.tickets.domain.FlightDto;
import com.airport.tickets.mapper.FlightMapper;
import com.airport.tickets.service.FlightDbService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/v1")
public class FlightController {

    @Autowired
    private FlightDbService service;

    @Autowired
    private FlightMapper mapper;

    @RequestMapping(method = RequestMethod.GET, value = "/flights")
    public List<FlightDto> getFlights() {
        return mapper.mapToFlightsDtoList(service.getAllFlights());
    }
}
