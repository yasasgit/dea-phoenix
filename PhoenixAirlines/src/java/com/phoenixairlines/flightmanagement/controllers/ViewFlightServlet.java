package com.phoenixairlines.flightmanagement.controllers;

import com.phoenixairlines.flightmanagement.models.FlightAccess;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ViewFlightServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        //can be accessed by only client
        int flight_id = Integer.parseInt(request.getParameter("flight_id"));

        //get flight details to form
        List selectedValues = new ArrayList();
        FlightAccess ticketaccess = new FlightAccess();
        selectedValues = ticketaccess.getSelectedData(flight_id);
        request.setAttribute("view_flight", selectedValues);
        RequestDispatcher rd = request.getRequestDispatcher("all_view_flight.jsp");
        rd.forward(request, response);
    }
}
