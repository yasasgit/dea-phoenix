package com.phoenixairlines.controllers.flight;

import com.phoenixairlines.models.FlightAccess;
import java.io.IOException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ViewFlightInfoServlet extends HttpServlet {

    public ViewFlightInfoServlet() {
        super();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) {

        try {
            FlightAccess flightAccess = new FlightAccess();
            List flightDetails = flightAccess.viewAllFlightDetails();

            request.setAttribute("result", flightDetails);

            RequestDispatcher rd = request.getRequestDispatcher("AllFlightDetails.jsp");
            rd.forward(request, response);
        } catch (ServletException | IOException ex) {
            System.out.println(ex);
        }
    }
}
