package com.phoenixairlines.controllers.flight;

import com.phoenixairlines.models.Flight;
import com.phoenixairlines.models.FlightAccess;
import java.io.IOException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SearchFlightInfoServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String takeoff_date = request.getParameter("takeoff_date");
        String takeoff_airport = request.getParameter("takeoff_airport");
        String landing_airport = request.getParameter("landing_airport");
        System.out.println(takeoff_date);

        Flight flightBean = new Flight(takeoff_date, landing_airport, takeoff_airport);

        FlightAccess flightAccess = new FlightAccess();
        List SearchFlightDetails = flightAccess.searchData(flightBean);
        request.setAttribute("result", SearchFlightDetails);
        RequestDispatcher rd = request.getRequestDispatcher("AllFlightDetails.jsp");
        rd.forward(request, response);
    }

}
