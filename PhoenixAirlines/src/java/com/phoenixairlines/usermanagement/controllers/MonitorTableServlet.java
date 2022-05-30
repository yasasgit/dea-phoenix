package com.phoenixairlines.usermanagement.controllers;

import com.phoenixairlines.usermanagement.models.UserAccess;
import java.io.IOException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MonitorTableServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        UserAccess adc = new UserAccess();
        List mtlist = adc.getMonitorTable();
        request.setAttribute("monitor_table", mtlist);

        RequestDispatcher rd = request.getRequestDispatcher("admin_monitor_table.jsp");
        rd.forward(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }
}
