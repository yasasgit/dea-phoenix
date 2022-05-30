package com.phoenixairlines.flightmanagement.controllers;

import com.phoenixairlines.flightmanagement.models.FlightAccess;
import java.io.IOException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DefaultFlightTableServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //can be accessed by only client g1staff g2staff
        FlightAccess flightAccess = new FlightAccess();
        List flightDetails = flightAccess.viewAllFlightDetails();
        request.setAttribute("flight_table", flightDetails);
        RequestDispatcher rd = request.getRequestDispatcher("all_flight_table.jsp");
        rd.forward(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }
}
