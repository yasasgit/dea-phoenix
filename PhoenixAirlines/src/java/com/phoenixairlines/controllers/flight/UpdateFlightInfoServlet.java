package com.phoenixairlines.controllers.flight;

import com.phoenixairlines.models.Flight;
import com.phoenixairlines.models.FlightAccess;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class UpdateFlightInfoServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    public UpdateFlightInfoServlet() {
        super();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");
        String FlightId = request.getParameter("flightId");
        String Takeoff_airport = request.getParameter("takeoff_airport");
        String Takeoff_time = request.getParameter("takeoff_time");
        String Takeoff_date = request.getParameter("takeoff_date");
        String Landing_airport = request.getParameter("landing_airport");
        String Landing_time = request.getParameter("landing_time");
        String Landing_date = request.getParameter("landing_date");
        String Gate = request.getParameter("gate");
        String cost = request.getParameter("cost");
        String aircraftId = request.getParameter("aircraft_id");

        Flight flightBean = new Flight(FlightId, Takeoff_airport, Takeoff_time, Takeoff_date, Landing_airport, Landing_time, Landing_date, Gate, cost, aircraftId);
        FlightAccess flightAccess = new FlightAccess();

        String result = flightAccess.UpdateFlightDetails(flightBean);
        PrintWriter out = response.getWriter();
        out.println(result);
    }

}
