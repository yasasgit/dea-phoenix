/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
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

    private static final long serialVersionUID = 1L;

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
