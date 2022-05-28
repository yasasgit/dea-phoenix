package com.phoenixairlines.controllers.user;

import com.phoenixairlines.models.UserAccess;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ApproveServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String user_id = request.getParameter("user_id");

        UserAccess access = new UserAccess();
        String result = access.approveUser(user_id);
        System.out.println(result);

        RequestDispatcher rd = request.getRequestDispatcher("admin_dashboard.jsp");
        rd.forward(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }
}
