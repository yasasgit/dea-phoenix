package com.phoenixairlines.controllers.flight;

import com.phoenixairlines.models.Flight;
import com.phoenixairlines.models.FlightAccess;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DeleteFlightInfoServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    public DeleteFlightInfoServlet() {
        super();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");
        String FlightId = request.getParameter("flightId");

        Flight flightBean = new Flight(FlightId);
        FlightAccess flightAccess = new FlightAccess();

        String result = flightAccess.DeleteFlightDetails(flightBean);
        PrintWriter out = response.getWriter();
        out.println(result);

    }

}
