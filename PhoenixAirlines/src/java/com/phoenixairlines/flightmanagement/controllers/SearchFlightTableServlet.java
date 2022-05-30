package com.phoenixairlines.flightmanagement.controllers;

import com.phoenixairlines.flightmanagement.models.Flight;
import com.phoenixairlines.flightmanagement.models.FlightAccess;
import java.io.IOException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SearchFlightTableServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //can be accessed by only client g1staff g2staff
        String takeoff_date = request.getParameter("takeoff_date");
        String takeoff_airport = request.getParameter("takeoff_airport");
        String landing_airport = request.getParameter("landing_airport");
        Flight flightBean = new Flight(takeoff_date, landing_airport, takeoff_airport);
        FlightAccess flightAccess = new FlightAccess();
        List SearchFlightDetails = flightAccess.searchData(flightBean);
        request.setAttribute("flight_table", SearchFlightDetails);
        RequestDispatcher rd = request.getRequestDispatcher("all_flight_table.jsp");
        rd.forward(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }
}
