package com.phoenixairlines.controllers;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.phoenixairlines.models.User;
import com.phoenixairlines.models.LoginDao;

public class LoginServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    public LoginServlet() {
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        System.out.println("Inside servlet");
        User loginBean = new User();

        loginBean.setUsername(username);
        loginBean.setPassword(password);

        LoginDao loginDao = new LoginDao();

        //get ip address
        try {
            String userValidate = loginDao.authenticateUser(loginBean);

            switch (userValidate) {
                case "Admin_Role": {
                    System.out.println("Admin Home");
                    HttpSession session = request.getSession(); //Creating a session
                    session.setMaxInactiveInterval(2 * 60);
                    session.setAttribute("admin", username); //setting session attribute
//                    request.setAttribute("username", username);
                    request.getRequestDispatcher("/admin.jsp").forward(request, response);
                    break;
                }
                case "User_Role": {
                    System.out.println("User Home");
                    HttpSession session = request.getSession(); //Creating a session
                    session.setMaxInactiveInterval(10 * 60);
                    session.setAttribute("user", username); //setting session attribute
//                    request.setAttribute("username", username);
                    request.getRequestDispatcher("/user.jsp").forward(request, response);
                    break;
                }
                case "StaffG1_Role": {
                    System.out.println("StaffG1 Home");
                    HttpSession session = request.getSession();
                    session.setMaxInactiveInterval(2 * 60);
                    session.setAttribute("staffg1", username);
//                    request.setAttribute("username", username);
                    request.getRequestDispatcher("/staffg1.jsp").forward(request, response);
                    break;
                }
                case "StaffG2_Role": {
                    System.out.println("StaffG2 Home");
                    HttpSession session = request.getSession();
                    session.setMaxInactiveInterval(2 * 60);
                    session.setAttribute("staffg2", username);
//                    request.setAttribute("username", username);
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
