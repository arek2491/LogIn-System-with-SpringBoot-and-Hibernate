package com.airport.tickets.domain;

import java.time.LocalDateTime;

public class FlightDto {

    private Long id;
    private String flightTo;
    private LocalDateTime startTime;

    public FlightDto(Long id, String flightTo, LocalDateTime startTime) {
        this.id = id;
        this.flightTo = flightTo;
        this.startTime = startTime;
    }

    public Long getId() {
        return id;
    }

    public String getFlightTo() {
        return flightTo;
    }

    public LocalDateTime getStartTime() {
        return startTime;
    }
}
