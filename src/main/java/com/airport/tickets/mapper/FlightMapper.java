package com.airport.tickets.mapper;

import com.airport.tickets.domain.Flight;
import com.airport.tickets.domain.FlightDto;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class FlightMapper {

    public FlightDto mapToFlightDto(final Flight flight) {
        return new FlightDto(flight.getId(), flight.getFlightTo(), flight.getStartTime());
    }

    public Flight mapToFlight(final FlightDto flightDto) {
        return new Flight(flightDto.getId(), flightDto.getFlightTo(), flightDto.getStartTime());
    }

    public List<FlightDto> mapToFlightsDtoList(final List<Flight> flights) {
        return flights.stream()
                .map(i -> new FlightDto(i.getId(), i.getFlightTo(), i.getStartTime()))
                .collect(Collectors.toList());
    }
}
