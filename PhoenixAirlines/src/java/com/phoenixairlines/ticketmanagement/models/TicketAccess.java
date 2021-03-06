package com.phoenixairlines.ticketmanagement.models;

import com.phoenixairlines.ConnectToDB;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class TicketAccess {

    Connection con = null;
    Statement statement = null;
    int i;
    ResultSet resultSet = null;

//Insert ticket details method
    public String createTicket(Ticket ticketBean) {
        //get values from ticketBean
        float price = ticketBean.getPrice();
        int userId = ticketBean.getUserId();
        int flightId = ticketBean.getFlightId();
        int seatId = ticketBean.getSeatId();
        String classId = ticketBean.getClassId();

        con = ConnectToDB.createConnection();
        try {
            statement = con.createStatement();
            String InsertQuery = "INSERT INTO ticket (price, user_ticket, flight_ticket, seat_ticket, class_ticket) VALUES ('" + price + "', '" + userId + "', '" + flightId + "', '" + seatId + "', '" + classId + "');";
            i = statement.executeUpdate(InsertQuery);
            con.close();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        if (i != 0) {
            return "Reservation details inserted successfully";
        } else {
            return "Reservation deatails not inserted";
        }
    }

//Select ticket detals method
    public List selectTicket(int currentUserId) {
        List reservationList = new ArrayList();
        //get current user id
        con = ConnectToDB.createConnection();
        try {
            statement = con.createStatement();
            resultSet = statement.executeQuery("SELECT USER.first_name,flight.takeoff_airport,flight.landing_airport,flight.takeoff_date,flight.takeoff_time,flight.gate,seat.seat_name,ticket.price,ticket.id FROM ticket INNER JOIN flight ON ticket.flight_ticket = flight.id INNER JOIN seat ON ticket.seat_ticket = seat.id INNER JOIN USER ON ticket.user_ticket = USER.id WHERE USER.id = '" + currentUserId + "';");
            while (resultSet.next()) {
                reservationList.add(resultSet.getString("USER.first_name"));
                reservationList.add(resultSet.getString("flight.takeoff_airport"));
                reservationList.add(resultSet.getString("flight.landing_airport"));
                reservationList.add(resultSet.getString("flight.takeoff_date"));
                reservationList.add(resultSet.getString("flight.takeoff_time"));
                reservationList.add(resultSet.getString("flight.gate"));
                reservationList.add(resultSet.getString("seat.seat_name"));
                reservationList.add(resultSet.getString("ticket.price"));
                reservationList.add(resultSet.getString("ticket.id"));
                reservationList.add(resultSet.getString("ticket.id"));
            }
            con.close();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return reservationList;
    }

    public List getSelectedTicketData(int ticketId) {
        List TicketDetails = new ArrayList();
        con = ConnectToDB.createConnection();
        try {
            statement = con.createStatement();
            resultSet = statement.executeQuery("SELECT flight.takeoff_airport,flight.takeoff_time,flight.takeoff_date,flight.landing_airport,flight.landing_time,flight.landing_date,flight.gate, class.id,class.type,seat.id,seat.seat_name,flight.cost FROM ticket INNER JOIN class ON ticket.class_ticket=class.id INNER JOIN seat ON ticket.seat_ticket=seat.id INNER JOIN flight ON ticket.flight_ticket=flight.id WHERE ticket.id='" + ticketId + "';");

            while (resultSet.next()) {
                String takeoff_airport = resultSet.getString("flight.takeoff_airport");
                String takeoff_time = resultSet.getString("flight.takeoff_time");
                String takeoff_date = resultSet.getString("flight.takeoff_date");
                String landing_airport = resultSet.getString("flight.landing_airport");
                String landing_time = resultSet.getString("flight.landing_time");
                String landing_date = resultSet.getString("flight.landing_date");
                String gate = resultSet.getString("flight.gate");
                float cost = resultSet.getFloat("flight.cost");
                String classId = resultSet.getString("class.id");
                String classType = resultSet.getString("class.type");
                String seatId = resultSet.getString("class.id");
                String seatNumber = resultSet.getString("seat.seat_name");

                TicketDetails.add(ticketId);
                TicketDetails.add(takeoff_airport);
                TicketDetails.add(takeoff_time);
                TicketDetails.add(takeoff_date);
                TicketDetails.add(landing_airport);
                TicketDetails.add(landing_time);
                TicketDetails.add(landing_date);
                TicketDetails.add(gate);
                TicketDetails.add(cost);
                TicketDetails.add(classId);
                TicketDetails.add(classType);
                TicketDetails.add(seatId);
                TicketDetails.add(seatNumber);
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return TicketDetails;
    }

    //update ticket details method
    public String updateTicketDetails(int ticketId, float price, String classId, int seatId, int userId) {

        con = ConnectToDB.createConnection();
        try {
            statement = con.createStatement();
            String updateQuery = "UPDATE ticket SET price='" + price + "',seat_ticket='" + seatId + "',class_ticket='" + classId + "' WHERE id='" + ticketId + "'AND user_ticket='" + userId + "'";
            i = statement.executeUpdate(updateQuery);
            con.close();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        if (i != 0) {
            return "Reservation details inserted successfully";
        } else {
            return "Reservation deatails not inserted";
        }
    }

    public String DeleteTicketDetails(int ticketId, int userId) {
        con = ConnectToDB.createConnection();
        try {
            statement = con.createStatement();
            String dltQuery = "DELETE FROM ticket WHERE id='" + ticketId + "' AND user_ticket='" + userId + "';";

            i = statement.executeUpdate(dltQuery);

        } catch (SQLException ex) {
            System.out.println(ex);
        }

        if (i != 0) {
            return "Reservation details deleted successfully";
        } else {
            return "Reservation details not deleted";
        }
    }
}
