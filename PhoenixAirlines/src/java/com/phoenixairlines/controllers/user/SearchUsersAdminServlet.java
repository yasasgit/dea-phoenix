package com.phoenixairlines.controllers.user;

import com.phoenixairlines.models.UserAccess;
import java.io.IOException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SearchUsersAdminServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String su = request.getParameter("search_user");
        String st = request.getParameter("search_type");

        UserAccess vuAccess = new UserAccess();

        List userlist = vuAccess.viewRow_admin(su, st);
        RequestDispatcher rd = request.getRequestDispatcher("admin_dashboard.jsp");
        request.setAttribute("monitor_table", userlist);
        rd.forward(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }
}
