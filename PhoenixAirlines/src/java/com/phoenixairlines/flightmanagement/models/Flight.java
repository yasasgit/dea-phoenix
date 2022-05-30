package com.phoenixairlines.flightmanagement.models;

public class Flight {

    private int flight_id;
    private String takeoff_airport;
    private String takeoff_time;
    private String takeoff_date;
    private String landing_airport;
    private String landing_time;
    private String landing_date;
    private String gate;
    private float cost;

    private String aircraft_id;

//create flight
    public Flight(String takeoff_airport, String takeoff_time, String takeoff_date, String landing_airport, String landing_time, String landing_date, String gate, float cost, String aircraft_id) {
        this.takeoff_airport = takeoff_airport;
        this.takeoff_time = takeoff_time;
        this.takeoff_date = takeoff_date;
        this.landing_airport = landing_airport;
        this.landing_time = landing_time;
        this.landing_date = landing_date;
        this.gate = gate;
        this.cost = cost;
        this.aircraft_id = aircraft_id;
    }

//update flight
    public Flight(int flight_id, String takeoff_airport, String takeoff_time, String takeoff_date, String landing_airport, String landing_time, String landing_date, String gate, float cost, String aircraft_id) {
        this.takeoff_airport = takeoff_airport;
        this.takeoff_time = takeoff_time;
        this.takeoff_date = takeoff_date;
        this.landing_airport = landing_airport;
        this.landing_time = landing_time;
        this.landing_date = landing_date;
        this.gate = gate;
        this.cost = cost;
        this.aircraft_id = aircraft_id;
        this.flight_id = flight_id;
    }
//delete flight

    public Flight(int flight_id) {
        this.flight_id = flight_id;
    }
//search flight

    public Flight(String takeoff_date, String landing_airport, String takeoff_airport) {
        this.takeoff_date = takeoff_date;
        this.landing_airport = landing_airport;
        this.takeoff_airport = takeoff_airport;
    }

    public int getFlight_id() {
        return flight_id;
    }

    public void setFlight_id(int flight_id) {
        this.flight_id = flight_id;
    }

    public String getTakeoff_airport() {
        return takeoff_airport;
    }

    public void setTakeoff_airport(String takeoff_airport) {
        this.takeoff_airport = takeoff_airport;
    }

    public String getTakeoff_time() {
        return takeoff_time;
    }

    public void setTakeoff_time(String takeoff_time) {
        this.takeoff_time = takeoff_time;
    }

    public String getTakeoff_date() {
        return takeoff_date;
    }

    public void setTakeoff_date(String takeoff_date) {
        this.takeoff_date = takeoff_date;
    }

    public String getLanding_airport() {
        return landing_airport;
    }

    public void setLanding_airport(String landing_airport) {
        this.landing_airport = landing_airport;
    }

    public String getLanding_time() {
        return landing_time;
    }

    public void setLanding_time(String landing_time) {
        this.landing_time = landing_time;
    }

    public String getLanding_date() {
        return landing_date;
    }

    public void setLanding_date(String landing_date) {
        this.landing_date = landing_date;
    }

    public String getGate() {
        return gate;
    }

    public void setGate(String gate) {
        this.gate = gate;
    }

    public float getCost() {
        return cost;
    }

    public void setCost(float cost) {
        this.cost = cost;
    }

    public String getAircraft_id() {
        return aircraft_id;
    }

    public void setAircraft_id(String aircraft_id) {
        this.aircraft_id = aircraft_id;
    }
}
