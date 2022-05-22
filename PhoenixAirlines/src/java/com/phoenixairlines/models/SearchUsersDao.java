package com.phoenixairlines.models;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class SearchUsersDao {

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
                String password = resultSet.getString("password");
                String address = resultSet.getString("address");
                String phone_number = resultSet.getString("phone_number");
                String role = resultSet.getString("role");
                System.out.println(role);

                user_details.add(first_name);
                user_details.add(last_name);
                user_details.add(email);
                user_details.add(username);
                user_details.add(password);
                user_details.add(address);
                user_details.add(phone_number);
                user_details.add(role);
                user_details.add("<br>");
            }
            con.close();
        } catch (SQLException e) {
        }
        return user_details;
    }
}
