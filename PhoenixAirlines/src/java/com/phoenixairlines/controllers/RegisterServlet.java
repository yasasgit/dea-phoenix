package com.phoenixairlines.controllers;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.phoenixairlines.models.User;
import com.phoenixairlines.models.RegisterAccess;

public class RegisterServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    public RegisterServlet() {
        super();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        System.out.println("inside post");
        response.setContentType("text/html");

        String first_name = request.getParameter("first_name");
        String last_name = request.getParameter("last_name");
        String username = request.getParameter("username");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String address = request.getParameter("address");
        String phone_number = request.getParameter("phone_number");
        String role = request.getParameter("role");

        User registerBean = new User(first_name, last_name, email, username, password, address, phone_number, role);
        RegisterAccess registerAccess = new RegisterAccess();

        String result = registerAccess.Registerindb(registerBean);
        if (result.equals("User is registered")) {
            request.setAttribute("errMessage", result);
            RequestDispatcher dispatcher = request.getRequestDispatcher("login.jsp");
            dispatcher.include(request, response);
        } else {
            request.setAttribute("errMessage", result);
            RequestDispatcher dispatcher = request.getRequestDispatcher("register.jsp");
            dispatcher.include(request, response);
        }
    }
}
