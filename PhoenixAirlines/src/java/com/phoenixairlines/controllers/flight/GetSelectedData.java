package com.phoenixairlines.controllers.flight;

import com.phoenixairlines.models.TicketAccess;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class GetSelectedData extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String flight = request.getParameter("flightId");
        System.out.println(flight);
        int flightId = Integer.parseInt(flight);

        //get flight details to form
        List selectedValues = new ArrayList();
        TicketAccess ticketaccess = new TicketAccess();
        selectedValues = ticketaccess.getSelectedData(flightId);
        request.setAttribute("selectedResult", selectedValues);
        RequestDispatcher rd = request.getRequestDispatcher("AddReservationForm.jsp");
        rd.forward(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }
}
