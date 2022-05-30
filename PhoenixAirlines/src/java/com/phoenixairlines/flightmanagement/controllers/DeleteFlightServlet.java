package com.phoenixairlines.flightmanagement.controllers;

import com.phoenixairlines.flightmanagement.models.Flight;
import com.phoenixairlines.flightmanagement.models.FlightAccess;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DeleteFlightServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        //can be accessed by only g1staff
        int flight_id = Integer.parseInt(request.getParameter("flight_id"));

        Flight flightBean = new Flight(flight_id);
        FlightAccess flightAccess = new FlightAccess();

        String result = flightAccess.DeleteFlightDetails(flightBean);

        request.setAttribute("result", result);
        RequestDispatcher rd = request.getRequestDispatcher("all_flight_table.jsp");
        rd.forward(request, response);
    }
}
