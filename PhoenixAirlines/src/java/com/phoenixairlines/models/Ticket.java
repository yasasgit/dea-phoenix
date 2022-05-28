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

    public Ticket(){
        super();
    }
    /**
     * @return the ticketId
     */
    public int getTicketId() {
        return ticketId;
    }

    /**
     * @param ticketId the ticketId to set
     */
    public void setTicketId(int ticketId) {
        this.ticketId = ticketId;
    }

    /**
     * @return the price
     */
    public float getPrice() {
        return price;
    }

    /**
     * @param price the price to set
     */
    public void setPrice(float price) {
        this.price = price;
    }

    /**
     * @return the userId
     */
    public int getUserId() {
        return userId;
    }

    /**
     * @param userId the userId to set
     */
    public void setUserId(int userId) {
        this.userId = userId;
    }

    /**
     * @return the flightId
     */
    public int getFlightId() {
        return flightId;
    }

    /**
     * @param flightId the flightId to set
     */
    public void setFlightId(int flightId) {
        this.flightId = flightId;
    }

    /**
     * @return the seatId
     */
    public int getSeatId() {
        return seatId;
    }

    /**
     * @param seatId the seatId to set
     */
    public void setSeatId(int seatId) {
        this.seatId = seatId;
    }

    /**
     * @return the classId
     */
    public String getClassId() {
        return classId;
    }

    /**
     * @param classId the classId to set
     */
    public void setClassId(String classId) {
        this.classId = classId;
    }

    

}
