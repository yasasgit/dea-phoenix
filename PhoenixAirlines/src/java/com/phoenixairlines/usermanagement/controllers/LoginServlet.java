package com.phoenixairlines.usermanagement.controllers;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.phoenixairlines.usermanagement.models.User;
import com.phoenixairlines.usermanagement.models.UserAccess;

public class LoginServlet extends HttpServlet {

    public LoginServlet() {
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String ip = request.getRemoteAddr();
        java.util.Date date = new java.util.Date();

        System.out.println("username, password, ip, login time received");

        User loginBean = new User();
        UserAccess loginAccess = new UserAccess();

        loginBean.setUsername(username);
        loginBean.setPassword(password);

        loginBean = loginAccess.getUser_info(loginBean);

        HttpSession session = request.getSession(); //Creating a session

        System.out.println(ip + " Current Date & Time: " + date.toString());

        session.setAttribute("user_id", loginBean.getUser_id());

        loginBean.setIp_address(ip);
        loginBean.setLogin_time(date.toString());

        loginAccess.insertSession(loginBean);

        String name = loginBean.getFirst_name() + " " + loginBean.getLast_name();

        try {
            String userValidate = loginAccess.authenticateUser(loginBean);

            switch (userValidate) {
                case "Admin_Role": {
                    session.setMaxInactiveInterval(20 * 60);
                    session.setAttribute("admin", username);
                    session.setAttribute("user_name", name);
                    request.getRequestDispatcher("/admin_dashboard.jsp").forward(request, response);
                    break;
                }
                case "Client_Role": {
                    session.setMaxInactiveInterval(60 * 60);
                    session.setAttribute("client", username);
                    session.setAttribute("user_name", name);
                    request.getRequestDispatcher("/client_dashboard.jsp").forward(request, response);
                    break;
                }
                case "StaffG1_Role": {
                    session.setMaxInactiveInterval(20 * 60);
                    session.setAttribute("staffg1", username);
                    session.setAttribute("user_name", name);
                    request.getRequestDispatcher("/staffg1_dashboard.jsp").forward(request, response);
                    break;
                }
                case "StaffG2_Role": {
                    session.setMaxInactiveInterval(20 * 60);
                    session.setAttribute("staffg2", username);
                    session.setAttribute("user_name", name);
                    request.getRequestDispatcher("/staffg2_dashboard.jsp").forward(request, response);
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
