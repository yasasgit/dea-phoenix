package com.phoenixairlines.flightmanagement.models;

import com.phoenixairlines.ConnectToDB;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class FlightAccess {

    Connection con;
    Statement statement;
    int i = 0;
    ResultSet resultSet;

    public String InsertFlightDetails(Flight flightBean) {

        String takeoff_airport = flightBean.getTakeoff_airport();
        String takeoff_time = flightBean.getTakeoff_time();
        String takeoff_date = flightBean.getTakeoff_date();
        String landing_airport = flightBean.getLanding_airport();
        String landing_time = flightBean.getLanding_time();
        String landing_date = flightBean.getLanding_date();
        String gate = flightBean.getGate();
        float cost = flightBean.getCost();
        String aircraft_id = flightBean.getAircraft_id();

        con = ConnectToDB.createConnection();

        try {
            statement = con.createStatement();
            String InsertQuery = "INSERT INTO `flight` (`takeoff_airport`, `takeoff_time`, `takeoff_date`, `landing_airport`, `landing_time`, `landing_date`, `gate`, `cost`, `aircraft_flight`) VALUES ('" + takeoff_airport + "', '" + takeoff_time + "', '" + takeoff_date + "', '" + landing_airport + "', '" + landing_time + "', '" + landing_date + "', '" + gate + "', " + cost + ", '" + aircraft_id + "');";
            i = statement.executeUpdate(InsertQuery);
        } catch (SQLException e) {
            System.out.println(e);
        }
        if (i != 0) {
            return "Flight details inserted successfully";
        } else {
            return "Flight deatails not inserted";
        }
    }

    public String UpdateFlightDetails(Flight flightBean) {

        int flight_id = flightBean.getFlight_id();
        String takeoff_airport = flightBean.getTakeoff_airport();
        String takeoff_time = flightBean.getTakeoff_time();
        String takeoff_date = flightBean.getTakeoff_date();
        String landing_airport = flightBean.getLanding_airport();
        String landing_time = flightBean.getLanding_time();
        String landing_date = flightBean.getLanding_date();
        String gate = flightBean.getGate();
        String aircraft_id = flightBean.getAircraft_id();

        con = ConnectToDB.createConnection();
        try {
            statement = con.createStatement();
            String updateQuery = "UPDATE flight SET gate='" + gate + "',takeoff_airport='" + takeoff_airport + "',takeoff_time='" + takeoff_time + "',takeoff_date='" + takeoff_date + "',landing_airport='" + landing_airport + "',landing_time='" + landing_time + "',landing_date='" + landing_date + "',aircraft_flight='" + aircraft_id + "' WHERE id=" + flight_id + ";";
            i = statement.executeUpdate(updateQuery);

        } catch (SQLException ex) {
            System.out.println(ex);
        }
        if (i != 0) {
            return "Flight details updated successfully";
        } else {
            return "Flight details not updated";
        }
    }

    public String DeleteFlightDetails(Flight flightBean) {
        int flight_id = flightBean.getFlight_id();
        con = ConnectToDB.createConnection();
        try {
            statement = con.createStatement();
            String dltQuery = "DELETE FROM flight WHERE id=" + flight_id + "; ";
            i = statement.executeUpdate(dltQuery);
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        if (i != 0) {
            return "Flight details deleted successfully";
        } else {
            return "Flight details not deleted";
        }
    }

    public List viewAllFlightDetails() {
        List flight_details = new ArrayList();
        con = ConnectToDB.createConnection();
        try {
            statement = con.createStatement();
            resultSet = statement.executeQuery("SELECT * FROM flight;");

            while (resultSet.next()) {
                int id_db = resultSet.getInt("id");
                String takeoff_airport_db = resultSet.getString("takeoff_airport");
                String takeoff_time_db = resultSet.getString("takeoff_time");
                String takeoff_date_db = resultSet.getString("takeoff_date");
                String landing_airport_db = resultSet.getString("landing_airport");
                String landing_time_db = resultSet.getString("landing_time");
                String landing_date_db = resultSet.getString("landing_date");
                String gate_db = resultSet.getString("gate");
                float cost_db = resultSet.getFloat("cost");
                String aircraft_id_db = resultSet.getString("aircraft_flight");

                flight_details.add(id_db);
                flight_details.add(takeoff_airport_db);
                flight_details.add(takeoff_time_db);
                flight_details.add(takeoff_date_db);
                flight_details.add(landing_airport_db);
                flight_details.add(landing_time_db);
                flight_details.add(landing_date_db);
                flight_details.add(gate_db);
                flight_details.add(cost_db);
                flight_details.add(aircraft_id_db);
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return flight_details;
    }

    public List searchData(Flight flightBean) {
        List searchFlight_details = new ArrayList();
        con = ConnectToDB.createConnection();

        String takeoff_date = flightBean.getTakeoff_date();
        String takeoff_airport = flightBean.getTakeoff_airport();
        String landing_airport = flightBean.getLanding_airport();

        //filter value accoridng to select category and
        try {
            statement = con.createStatement();

            resultSet = statement.executeQuery("SELECT * FROM flight WHERE takeoff_airport='" + takeoff_airport + "' AND landing_airport='" + landing_airport + "' AND takeoff_date='" + takeoff_date + "';");
            while (resultSet.next()) {
                int id_db = resultSet.getInt("id");
                String takeoff_airport_db = resultSet.getString("takeoff_airport");
                String takeoff_time_db = resultSet.getString("takeoff_time");
                String takeoff_date_db = resultSet.getString("takeoff_date");
                String landing_airport_db = resultSet.getString("landing_airport");
                String landing_time_db = resultSet.getString("landing_time");
                String landing_date_db = resultSet.getString("landing_date");
                int gate_db = resultSet.getInt("gate");
                float cost_db = resultSet.getFloat("cost");
                String aircraft_flight_db = resultSet.getString("aircraft_flight");

                searchFlight_details.add(id_db);
                searchFlight_details.add(takeoff_airport_db);
                searchFlight_details.add(takeoff_time_db);
                searchFlight_details.add(takeoff_date_db);
                searchFlight_details.add(landing_airport_db);
                searchFlight_details.add(landing_time_db);
                searchFlight_details.add(landing_date_db);
                searchFlight_details.add(gate_db);
                searchFlight_details.add(cost_db);
                searchFlight_details.add(aircraft_flight_db);
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return searchFlight_details;
    }

    public List getSelectedData(int flight_id) {

        List flight_details = new ArrayList();
        con = ConnectToDB.createConnection();
        try {
            statement = con.createStatement();
            resultSet = statement.executeQuery("SELECT * FROM flight WHERE id=" + flight_id + ";");

            while (resultSet.next()) {
                String takeoff_airport = resultSet.getString("takeoff_airport");
                String takeoff_time = resultSet.getString("takeoff_time");
                String takeoff_date = resultSet.getString("takeoff_date");
                String landing_airport = resultSet.getString("landing_airport");
                String landing_time = resultSet.getString("landing_time");
                String landing_date = resultSet.getString("landing_date");
                String gate = resultSet.getString("gate");
                float cost = resultSet.getFloat("cost");
                String aircraftId = resultSet.getString("aircraft_flight");
                int flight = resultSet.getInt("id");

                flight_details.add(takeoff_airport);
                flight_details.add(takeoff_time);
                flight_details.add(takeoff_date);
                flight_details.add(landing_airport);
                flight_details.add(landing_time);
                flight_details.add(landing_date);
                flight_details.add(gate);
                flight_details.add(cost);
                flight_details.add(aircraftId);
                flight_details.add(flight);
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return flight_details;
    }
}
