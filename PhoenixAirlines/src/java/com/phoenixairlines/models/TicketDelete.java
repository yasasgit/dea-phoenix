package com.phoenixairlines.models;

import com.phoenixairlines.util.ConnectToDB;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TicketDelete {

    Connection con;
    Statement statement;
    int i;
    ResultSet resultSet;

    public String DeleteTicketDetails(int ticketId, int userId) {
        con = ConnectToDB.createConnection();
        try {
            statement = con.createStatement();
            String dltQuery = "DELETE FROM ticket WHERE id='" + ticketId + "' AND user_ticket='" + userId + "';";

            i = statement.executeUpdate(dltQuery);

        } catch (SQLException ex) {
            System.out.println(ex);
        }

        if (i != 0) {
            return "Reservation details deleted successfully";
        } else {
            return "Reservation details not deleted";
        }
    }
}
