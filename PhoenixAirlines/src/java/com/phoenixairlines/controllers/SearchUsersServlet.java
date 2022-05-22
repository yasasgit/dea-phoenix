package com.phoenixairlines.controllers;

import com.phoenixairlines.models.SearchUsersDao;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SearchUsersServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String su = request.getParameter("search_user");
        String st = request.getParameter("search_type");

//       use referrer to get requested page
        SearchUsersDao vuDao = new SearchUsersDao();
        List userlist = vuDao.viewRow(su, st);

        request.setAttribute("result", userlist);

        RequestDispatcher rd = request.getRequestDispatcher("admin.jsp");
        rd.forward(request, response);

    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }
}
