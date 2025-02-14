package com.flightbookin.model;

import jakarta.persistence.*;

@Entity
@Table(name = "flights")
public class Flight {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String airline;
    private String origin;
    private String destination;
    private String BookedBy;
    private Boolean booked;

    public Flight(){}

    public Flight(String airline, String origin, String destination, String BookedBy, Boolean booked){
        this.airline = airline;
        this.origin = origin;
        this.destination = destination;
        this.BookedBy = BookedBy;
        this.booked = booked;
    }

    public Long getId(){
        return id;
    }

    public String getAirline(){
        return airline;
    }

    public void setAirline(String airline){
        this.airline = airline;
    }

    public String getOrigin(){
        return origin;
    }

    public void setOrigin(String origin){
        this.origin = origin;
    }

    public String getDestination(){
        return destination;
    }

    public void setDestination(String destination){
        this.destination = destination;
    }



    public void setBookedBy(String BookedBy){
        this.BookedBy = BookedBy;
    }


    public void setbooked(Boolean booked){
        this.booked = booked;
    }

}
