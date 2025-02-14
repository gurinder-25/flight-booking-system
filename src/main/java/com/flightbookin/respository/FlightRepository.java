package com.flightbookin.respository;

import com.flightbookin.model.Flight;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FlightRepository extends JpaRepository<Flight, Long> {
    List<Flight> findByOriginAndDestination(String origin, String destination);
    List<Flight> findByBookedFalse();
    List<Flight> findByOriginAndDestinationAndBookedFalse(String origin, String destination);
}
