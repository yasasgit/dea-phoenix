/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.phoenixairlines.models;

import com.phoenixairlines.util.ConnectToDB;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author yasas
 */
public class SessionAccess {

    public void insertToDB(UserSession sesBean) {
        Connection con = ConnectToDB.createConnection();

        int user_session_id = sesBean.getUser_session_id();
        String ip_address = sesBean.getIp_address();
        String login_time = sesBean.getLogin_time();

        String query = "INSERT INTO session (login_time,ip_address, user_session) VALUES (?,?,?) ";
        int i = 0;
        try {

            PreparedStatement stmt = con.prepareStatement(query);

            stmt.setString(1, login_time);
            stmt.setString(2, ip_address);
            stmt.setInt(3, user_session_id);

            i = stmt.executeUpdate();
            con.close();
        } catch (SQLException e) {
            System.out.println(e);

        }
    }

}
