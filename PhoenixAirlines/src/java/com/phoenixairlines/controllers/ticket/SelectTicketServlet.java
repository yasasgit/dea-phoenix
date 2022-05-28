package com.phoenixairlines.controllers.ticket;

import com.phoenixairlines.models.TicketAccess;
import java.io.IOException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class SelectTicketServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        TicketAccess ticketAccess = new TicketAccess();
        int userId = 0; //session.getAttribute("user");

        HttpSession session = request.getSession();
        userId = (int) session.getAttribute("user_id");
        System.out.println("user id from session " + userId);

        List reservationValues = ticketAccess.selectTicket(userId);
        request.setAttribute("reservationResult", reservationValues);
        RequestDispatcher rd = request.getRequestDispatcher("userMyReservation.jsp");
        rd.forward(request, response);
    }

}
