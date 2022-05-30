package com.phoenixairlines.ticketmanagement.controllers;

import com.phoenixairlines.ticketmanagement.models.TicketAccess;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class DeleteTicketServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //can be accessed by only g1staff
        int ticketId = Integer.parseInt(request.getParameter("ticket_id_delete"));

        HttpSession session = request.getSession();
        int userId = (int) session.getAttribute("user_id");
        System.out.println("user id from session " + userId);
        TicketAccess ticketBean = new TicketAccess();

        String deleteResult = ticketBean.DeleteTicketDetails(ticketId, userId);
        PrintWriter out = response.getWriter();
        out.println(deleteResult);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }
}
