package com.flightbookin.controller;

import com.flightbookin.model.Flight;
import com.flightbookin.service.FlightService;
import com.flightbookin.service.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/flights")
public class FlightController {

    private final FlightService flightService;
    private final UserService userService;


    public FlightController(FlightService flightService, UserService userService){
        this.flightService = flightService;
        this.userService = userService;
    }

    @PostMapping("/addflights")
    public Flight addFlight(@RequestBody Flight flight){
        return flightService.addFlight(flight);
    }

    @DeleteMapping("/deleteflight/{id}")
    public Map<String, String> deleteFlight(@PathVariable Long id){
        String message = flightService.deleteFlight(id);
        return Map.of("message", message);
    }

    @GetMapping("/getflights")
    public List<Flight> getAllFlights(){
        return flightService.getallFlights();
    }

    @GetMapping("/availableflights")
    public List<Flight> availableFlights(){
        return flightService.availableFlights();
    }

    @GetMapping("/getspecificflights")
    public List<Flight> getSpecifiedFlights(@RequestParam String origin, String destination){
        return flightService.getSpecificFlights(origin, destination);
    }

    @PostMapping("/bookflight")
    public Map<String, String> bookFlight(@RequestBody Map<String, String> request){
        String username = request.get("username");
        String origin = request.get("origin");
        String destination = request.get("destination");

        if (!userService.isUserLoggedIn(username)){
            return Map.of("message","You must first Log in!");
        }

        String updatedFlights = flightService.bookFlight(username, origin, destination);
        return Map.of("message", updatedFlights);
    }

}
