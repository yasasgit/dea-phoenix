package com.phoenixairlines.models;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class LoginDao {

    public String authenticateUser(User loginBean) {
        String username = loginBean.getUsername();
        String password = loginBean.getPassword();
        System.out.println(username);

        Connection con = null;
        Statement statement = null;
        ResultSet resultSet = null;

        String role = "";
        int active_status = 0;

        try {
            con = ConnectToDB.createConnection();
            statement = con.createStatement();
            resultSet = statement.executeQuery("select role,active_status from user where username='" + username + "' && password='" + password + "'");

            while (resultSet.next()) {
                role = resultSet.getString("role");
                active_status = resultSet.getInt("active_status");
                System.out.println(role);
                System.out.println(active_status);

                if (active_status == 1) {
                    switch (role) {
                        case "user":
                            return "User_Role";
                        case "staffg1":
                            return "StaffG1_Role";
                        case "staffg2":
                            return "StaffG2_Role";
                        case "admin":
                            return "Admin_Role";
                        default:
                            break;
                    }
                    //session method
                } else {
                    return "Your account is not active";
                }

            }
            con.close();
        } catch (SQLException e) {
        }

        return "Incorrect Username or Password";
    }
}
