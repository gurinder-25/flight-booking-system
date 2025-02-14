package com.flightbookin.service;

import com.flightbookin.model.Flight;
import com.flightbookin.respository.FlightRepository;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class FlightService {

    private final FlightRepository flightRepository;

    public FlightService(FlightRepository flightRepository){
        this.flightRepository = flightRepository;
    }

    public Flight addFlight(Flight flight){
        return flightRepository.save(flight);
    }

    public String deleteFlight(Long id){
        Optional<Flight> flight = flightRepository.findById(id);
        if (flight.isPresent()){
            flightRepository.deleteById(id);
            return "Flight Deleted";
        }
        return "Flight Not Found";
    }

    public List<Flight> getallFlights(){
        return flightRepository.findAll();
    }

    public List<Flight> availableFlights(){
        return flightRepository.findByBookedFalse();
    }

    public List<Flight> getSpecificFlights(String origin, String destination){
        List<Flight> flight = flightRepository.findByOriginAndDestination(origin, destination);
        return flight;
    }

    public String bookFlight(String username, String origin, String destination){
        List<Flight> flights = flightRepository.findByOriginAndDestination(origin, destination);

        if (flights.isEmpty()){
            return "No Available Flights!";
        }

        Flight flightToBook = flights.get(0);
        flightToBook.setbooked(true);
        flightToBook.setBookedBy(username);
        flightRepository.save(flightToBook);
        return "Successfully booked!";
    }
}
