package com.phoenixairlines;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectToDB {

    public static Connection createConnection() {
        Connection con = null;
        String driver = "com.mysql.cj.jdbc.Driver";
        String url = "jdbc:mysql://localhost:3306/phoenix_airlines_db";
        String username = "root";
        String password = "";

        try {
            try {
                Class.forName(driver);
            } catch (ClassNotFoundException e) {
                System.out.println(e);
            }

            con = DriverManager.getConnection(url, username, password);
            System.out.println("JDBC Connection successfull!" + con);
        } catch (SQLException e) {
            System.out.println("JDBC Connection Failed!" + e);
        }
        return con;
    }
}
