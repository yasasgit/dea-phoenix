package com.phoenixairlines.models;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class RegisterDao {

    public String Registerindb(User registerBean) {
        Connection con = ConnectToDB.createConnection();

        String first_name = registerBean.getFirst_name();
        String last_name = registerBean.getLast_name();
        String email = registerBean.getEmail();
        String username = registerBean.getUsername();
        String password = registerBean.getPassword();
        String address = registerBean.getAddress();
        String phone_number = registerBean.getPhone_number();
        int active_status = 0;
        String role = registerBean.getRole();

        if (role.equals("user")) {
            active_status = 1;
        }

        String query = "INSERT INTO user (first_name, last_name, email, username, password, address, phone_number , active_status, role) VALUES (?,?,?,?,?,?,?,?,?) ";
        int i = 0;
        try {

            PreparedStatement stmt = con.prepareStatement(query);

            stmt.setString(1, first_name);
            stmt.setString(2, last_name);
            stmt.setString(3, email);
            stmt.setString(4, username);
            stmt.setString(5, password);
            stmt.setString(6, address);
            stmt.setString(7, phone_number);
            stmt.setInt(8, active_status);
            stmt.setString(9, role);

            i = stmt.executeUpdate();
            con.close();
        } catch (SQLException e) {

        }
        if (i != 0) {
            return "User is registered";
        } else {
            return "Error: User is not registered";
        }
    }
}
