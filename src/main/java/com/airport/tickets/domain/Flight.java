package com.airport.tickets.domain;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity(name = "flights")
public class Flight {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "flightTo")
    private String flightTo;

    @Column(name = "startTime")
    private LocalDateTime startTime;

    public Flight() {

    }

    public Flight(Long id, String flightTo, LocalDateTime startTime) {
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
