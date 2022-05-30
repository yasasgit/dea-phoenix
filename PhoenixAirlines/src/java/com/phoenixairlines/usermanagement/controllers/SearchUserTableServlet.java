package com.phoenixairlines.usermanagement.controllers;

import com.phoenixairlines.usermanagement.models.UserAccess;
import java.io.IOException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SearchUserTableServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String su = request.getParameter("search_user");
        String st = request.getParameter("search_type");

        UserAccess vuAccess = new UserAccess();

        List adminuserlist = vuAccess.viewRow_admin(su, st);
        request.setAttribute("monitor_table", adminuserlist);

        List staffuserlist = vuAccess.viewRow(su, st);
        request.setAttribute("user_table", staffuserlist);
        RequestDispatcher rd = request.getRequestDispatcher("admin_monitor_table.jsp");
        rd.forward(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }
}
