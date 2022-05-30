package com.phoenixairlines.usermanagement.controllers;

import com.phoenixairlines.usermanagement.models.UserAccess;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ApproveUserServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String user_id = request.getParameter("user_id");

        UserAccess access = new UserAccess();
        String result = access.approveUser(user_id);

        request.setAttribute("result", result);
        RequestDispatcher rd = request.getRequestDispatcher("admin_approve_table.jsp");
        rd.forward(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }
}
