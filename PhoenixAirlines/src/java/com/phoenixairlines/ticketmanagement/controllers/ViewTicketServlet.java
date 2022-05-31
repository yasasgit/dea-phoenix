package com.phoenixairlines.ticketmanagement.controllers;

import com.phoenixairlines.ticketmanagement.models.TicketAccess;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class ViewTicketServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //view + searchbyuser can be accessed by only g1staff g2staff
        //view can be accessed by only client
        TicketAccess ticketAccess = new TicketAccess();
        int userId = 0;
        //session.getAttribute("user");

        HttpSession session = request.getSession();
        userId = (int) session.getAttribute("user_id");
        System.out.println("user id from session " + userId);

        List reservationValues = ticketAccess.selectTicket(userId);
        request.setAttribute("reservationResult", reservationValues);
        RequestDispatcher rd = request.getRequestDispatcher("client_ticket_table.jsp");
        rd.forward(request, response);

        String ticket_id = request.getParameter("ticket_id");
        System.out.println(ticket_id);//for bug fixies
        int ticketId = Integer.parseInt(ticket_id);

        //get flight details to form
//        List selectedValues = new ArrayList();
//        TicketAccess ticketaccess = new TicketAccess();
//        selectedValues = ticketaccess.getSelectedTicketData(ticketId);
//        request.setAttribute("selectedTicketResult", selectedValues);
//        RequestDispatcher rd = request.getRequestDispatcher("userUpdateReservation.jsp");
//        rd.forward(request, response);
    }

}
