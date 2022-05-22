package com.phoenixairlines.controllers;

import com.phoenixairlines.models.AdminDCDao;
import java.io.IOException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AdminDCServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        AdminDCDao adc = new AdminDCDao();
        List dclist = adc.getDynamicContent();

        request.setAttribute("dc", dclist);

        RequestDispatcher rd = request.getRequestDispatcher("admin.jsp");
        rd.forward(request, response);

    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }
}
