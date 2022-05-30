package com.phoenixairlines.ticketmanagement.controllers;

import com.phoenixairlines.ticketmanagement.models.Ticket;
import com.phoenixairlines.ticketmanagement.models.TicketAccess;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class UpdateTicketServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //can be accessed by only g1staff client
        int ticketId = Integer.parseInt(request.getParameter("id"));
        String classId = request.getParameter("class");
        int seatId = Integer.parseInt(request.getParameter("seatNumber"));
        int seats = Integer.parseInt(request.getParameter("seats"));
        float cost = Float.parseFloat(request.getParameter("cost"));
        float price = 0;
        switch (classId) {
            case "101":
                price = (float) (cost * 1.9) * seats;
                break;
            case "102":
                price = (float) (cost * 1.5) * seats;
                break;
            default:
                price = cost * seats;
                break;
        }
        HttpSession session = request.getSession();
        int userId = (int) session.getAttribute("user_id");
        System.out.println("user id from session " + userId);

        Ticket ticketBean = new Ticket();
        TicketAccess updateTicket = new TicketAccess();
        String updateResult = updateTicket.updateTicketDetails(ticketId, price, classId, seatId, userId);
        PrintWriter out = response.getWriter();
        out.println(updateResult);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }
}
