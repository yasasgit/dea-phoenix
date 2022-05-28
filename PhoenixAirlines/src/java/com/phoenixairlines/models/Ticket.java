package com.phoenixairlines.models;

public class Ticket {

    private int ticketId;
    private float price;
    private int userId;
    private int flightId;
    private int seatId;
    private String classId;

    public Ticket(int ticketId, float price, int userId, int flightId, int seatId, String classId) {
        this.ticketId = ticketId;
        this.price = price;
        this.userId = userId;
        this.flightId = flightId;
        this.seatId = seatId;
        this.classId = classId;
    }

    public Ticket() {
        super();
    }

    public int getTicketId() {
        return ticketId;
    }

    public void setTicketId(int ticketId) {
        this.ticketId = ticketId;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getFlightId() {
        return flightId;
    }

    public void setFlightId(int flightId) {
        this.flightId = flightId;
    }

    public int getSeatId() {
        return seatId;
    }

    public void setSeatId(int seatId) {
        this.seatId = seatId;
    }

    public String getClassId() {
        return classId;
    }

    public void setClassId(String classId) {
        this.classId = classId;
    }
}
