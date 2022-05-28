package com.phoenixairlines.controllers;

import com.phoenixairlines.models.SearchUsersAccess;
import java.io.IOException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SearchUsers_sServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String su = request.getParameter("search_user");
        String st = request.getParameter("search_type");

        SearchUsersAccess vuAccess = new SearchUsersAccess();

        String ref = request.getHeader("Referer");
        System.out.println(ref);

        List userlist = vuAccess.viewRow(su, st);
        RequestDispatcher rd = request.getRequestDispatcher("staffg1.jsp");
        request.setAttribute("result", userlist);
        rd.forward(request, response);

    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }
}
