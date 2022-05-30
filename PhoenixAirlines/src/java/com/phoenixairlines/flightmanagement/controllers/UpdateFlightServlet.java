package com.phoenixairlines.flightmanagement.controllers;

import com.phoenixairlines.flightmanagement.models.Flight;
import com.phoenixairlines.flightmanagement.models.FlightAccess;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class UpdateFlightServlet extends HttpServlet {

    public UpdateFlightServlet() {
        super();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //can be accessed by only g1staff
        int flight_id = Integer.parseInt(request.getParameter("flight_id"));
        String takeoff_airport = request.getParameter("takeoff_airport");
        String takeoff_time = request.getParameter("takeoff_time");
        String takeoff_date = request.getParameter("takeoff_date");
        String landing_airport = request.getParameter("landing_airport");
        String landing_time = request.getParameter("landing_time");
        String landing_date = request.getParameter("landing_date");
        String gate = request.getParameter("gate");
        float cost = Float.parseFloat(request.getParameter("cost"));
        String aircraft_id = request.getParameter("aircraft_id");

        Flight flightBean = new Flight(flight_id, takeoff_airport, takeoff_time, takeoff_date, landing_airport, landing_time, landing_date, gate, cost, aircraft_id);
        FlightAccess flightAccess = new FlightAccess();

        String result = flightAccess.UpdateFlightDetails(flightBean);
        request.setAttribute("result", result);
        RequestDispatcher rd = request.getRequestDispatcher("result.jsp");
        rd.forward(request, response);
    }
}
