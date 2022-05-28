package com.phoenixairlines.controllers.ticket;

import com.phoenixairlines.models.TicketAccess;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class GetSelectedTicketData extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String ticket_id = request.getParameter("ticket_id");
        System.out.println(ticket_id);//for bug fixies
        int ticketId = Integer.parseInt(ticket_id);
       
        //get flight details to form
        List selectedValues = new ArrayList();
        TicketAccess ticketaccess = new TicketAccess();
        selectedValues = ticketaccess.getSelectedTicketData(ticketId);
        request.setAttribute("selectedTicketResult", selectedValues);
        RequestDispatcher rd = request.getRequestDispatcher("userUpdateReservation.jsp");
        rd.forward(request, response);
    }
    @Override
    public String getServletInfo() {
        return "Short description";
    }
}
