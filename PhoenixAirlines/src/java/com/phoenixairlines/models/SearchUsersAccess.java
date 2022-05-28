package com.phoenixairlines.models;

import com.phoenixairlines.util.ConnectToDB;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class SearchUsersAccess {

    Connection con = null;
    Statement statement = null;
    ResultSet resultSet = null;

    public List viewRow(String su, String st) {
        List user_details = new ArrayList();

        try {
            con = ConnectToDB.createConnection();
            statement = con.createStatement();

            System.out.println(su);
            System.out.println(st);

            if (st.equals("username")) {
                resultSet = statement.executeQuery("select * from user where username like'%" + su + "%';");
            } else {
                resultSet = statement.executeQuery("select * from user where email like'%" + su + "%';");
            }

            while (resultSet.next()) {
                String first_name = resultSet.getString("first_name");
                String last_name = resultSet.getString("last_name");
                String email = resultSet.getString("email");
                String username = resultSet.getString("username");
                String role = resultSet.getString("role");
                System.out.println(role);

                user_details.add(first_name);
                user_details.add(last_name);
                user_details.add(email);
                user_details.add(username);
                user_details.add(role);
            }
            con.close();
        } catch (SQLException e) {
            System.out.println(e);
        }
        return user_details;
    }

    public List viewRow_admin(String su, String st) {
        List user_details = new ArrayList();

        try {
            con = ConnectToDB.createConnection();
            statement = con.createStatement();

            System.out.println(su);
            System.out.println(st);

            if (st.equals("username")) {
                resultSet = statement.executeQuery("SELECT USER.first_name, USER.last_name, USER.email, USER.username, USER.role, SESSION.login_time, SESSION.ip_address FROM SESSION INNER JOIN USER ON SESSION .user_session = USER.id where USER.username like'%" + su + "%' ORDER BY SESSION.id DESC;");
            } else {
                resultSet = statement.executeQuery("SELECT USER.first_name, USER.last_name, USER.email, USER.username, USER.role, SESSION.login_time, SESSION.ip_address FROM SESSION INNER JOIN USER ON SESSION .user_session = USER.id where USER.email like'%" + su + "%' ORDER BY SESSION.id DESC;");
            }

            while (resultSet.next()) {
                String first_name = resultSet.getString("first_name");
                String last_name = resultSet.getString("last_name");
                String email = resultSet.getString("email");
                String username = resultSet.getString("username");
                String role = resultSet.getString("role");
                String ip_address = resultSet.getString("ip_address");
                String login_time = resultSet.getString("login_time");
                System.out.println(first_name);

//                can add tr td to whlie loop in jsp for less lines
                user_details.add(first_name);
                user_details.add(last_name);
                user_details.add(email);
                user_details.add(username);
                user_details.add(role);
                user_details.add(ip_address);
                user_details.add(login_time);
            }
            con.close();
        } catch (SQLException e) {
            System.out.println(e);
        }
        return user_details;

    }
}
