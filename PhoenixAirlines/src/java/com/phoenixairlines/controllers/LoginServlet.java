package com.phoenixairlines.controllers;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.phoenixairlines.models.User;
import com.phoenixairlines.models.LoginAccess;
import com.phoenixairlines.models.SessionAccess;
import com.phoenixairlines.models.UserSession;

public class LoginServlet extends HttpServlet {

    public LoginServlet() {
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String ip = request.getRemoteAddr();
        int user_id;
        java.util.Date date = new java.util.Date();

        System.out.println("username password received");

        User loginBean = new User();
        LoginAccess loginAccess = new LoginAccess();
        loginBean.setUsername(username);
        loginBean.setPassword(password);

        user_id = loginAccess.getUser_id(loginBean);

        UserSession sesBean = new UserSession();
        SessionAccess sesAccess = new SessionAccess();

        HttpSession session = request.getSession(); //Creating a session
        session.setAttribute("user_id", user_id);

        sesBean.setUser_session_id(user_id);
        sesBean.setIp_address(ip);
        sesBean.setLogin_time(date.toString());

        sesAccess.insertToDB(sesBean);

        System.out.println(ip);
        System.out.println("<h2>" + "Current Date & Time: " + date.toString() + "</h2>");

        try {
            String userValidate = loginAccess.authenticateUser(loginBean);

            switch (userValidate) {
                case "Admin_Role": {
                    System.out.println("Admin Home");
                    session.setMaxInactiveInterval(20 * 60);
                    session.setAttribute("admin", username); //setting session attribute
                    request.getRequestDispatcher("/admin.jsp").forward(request, response);
                    break;
                }
                case "Client_Role": {
                    System.out.println("Client Home");
                    session.setMaxInactiveInterval(60 * 60);
                    session.setAttribute("client", username); //setting session attribute
                    request.getRequestDispatcher("/user.jsp").forward(request, response);
                    break;
                }
                case "StaffG1_Role": {
                    System.out.println("StaffG1 Home");
                    session.setMaxInactiveInterval(20 * 60);
                    session.setAttribute("staffg1", username);
                    request.getRequestDispatcher("/staffg1.jsp").forward(request, response);
                    break;
                }
                case "StaffG2_Role": {
                    System.out.println("StaffG2 Home");
                    session.setMaxInactiveInterval(20 * 60);
                    session.setAttribute("staffg2", username);
                    request.getRequestDispatcher("/staffg2.jsp").forward(request, response);
                    break;
                }
                default:
                    System.out.println("Error message = " + userValidate);
                    request.setAttribute("errMessage", userValidate);
                    request.getRequestDispatcher("/login.jsp").forward(request, response);
                    break;
            }
        } catch (IOException | ServletException e1) {
        }
    }
}
