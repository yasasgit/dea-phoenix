package com.phoenixairlines.models;

import com.phoenixairlines.util.ConnectToDB;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class LoginAccess {

    public String authenticateUser(User loginBean) {
        String username = loginBean.getUsername();
        String password = loginBean.getPassword();

        Connection con = null;
        Statement statement = null;
        ResultSet resultSet = null;

        String role = "";
        int active_status = 0;

        try {
            con = ConnectToDB.createConnection();
            statement = con.createStatement();
            resultSet = statement.executeQuery("SELECT role, is_active FROM user WHERE username='" + username + "' && password='" + password + "'");

            while (resultSet.next()) {
                role = resultSet.getString("role");
                active_status = resultSet.getInt("is_active");

                System.out.println(role);
                System.out.println(active_status);

                if (active_status == 1) {
                    switch (role) {
                        case "client":
                            return "Client_Role";
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
            System.out.println(e);
        }
        return "Incorrect Username or Password";
    }

    public int getUser_id(User loginBean) {
        String username = loginBean.getUsername();
        String password = loginBean.getPassword();

        Connection con = null;
        Statement statement = null;
        ResultSet resultSet = null;

        int user_id = 0;

        try {
            con = ConnectToDB.createConnection();
            statement = con.createStatement();
            resultSet = statement.executeQuery("SELECT id FROM user WHERE username='" + username + "' && password='" + password + "'");

            while (resultSet.next()) {
                user_id = resultSet.getInt("id");
                System.out.println(user_id);
            }
            con.close();
        } catch (SQLException e) {
            System.out.println(e);
        }
        return user_id;
    }
}
