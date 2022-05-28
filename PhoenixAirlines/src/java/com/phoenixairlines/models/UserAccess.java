package com.phoenixairlines.models;

import com.phoenixairlines.util.ConnectToDB;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class UserAccess {

    Connection con = null;
    Statement statement = null;
    ResultSet resultSet = null;
    int i = 0;
    String role = "";
    int active_status = 0;
    int user_id = 0;

    public User getUser_info(User loginBean) {
        String username = loginBean.getUsername();
        String password = loginBean.getPassword();

        try {
            con = ConnectToDB.createConnection();
            statement = con.createStatement();
            resultSet = statement.executeQuery("SELECT id,first_name,last_name FROM user WHERE username='" + username + "' && password='" + password + "'");

            while (resultSet.next()) {
                loginBean.setUser_id(resultSet.getInt("id"));
                loginBean.setFirst_name(resultSet.getString("first_name"));
                loginBean.setLast_name(resultSet.getString("last_name"));
            }
            con.close();
        } catch (SQLException e) {
            System.out.println(e);
        }
        return loginBean;
    }

    public String authenticateUser(User loginBean) {
        String username = loginBean.getUsername();
        String password = loginBean.getPassword();

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

    public void insertSession(User loginBean) {
        con = ConnectToDB.createConnection();

        int user_session_id = loginBean.getUser_id();
        String ip_address = loginBean.getIp_address();
        String login_time = loginBean.getLogin_time();

        String query = "INSERT INTO session (login_time,ip_address, user_session) VALUES (?,?,?)";

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

    public List getMonitorTable() {
        List user_details = new ArrayList();

        try {
            con = ConnectToDB.createConnection();
            statement = con.createStatement();

            resultSet = statement.executeQuery("SELECT USER.first_name, USER.last_name, USER.email, USER.username, USER.role, SESSION.login_time, SESSION.ip_address FROM SESSION INNER JOIN USER ON SESSION .user_session = USER.id ORDER BY SESSION.id DESC  LIMIT 20;");

//            join query and use result set metadata
            while (resultSet.next()) {
                String first_name = resultSet.getString("first_name");
                String last_name = resultSet.getString("last_name");
                String email = resultSet.getString("email");
                String username = resultSet.getString("username");
                role = resultSet.getString("role");
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

    public List getApproveTable() {
        List user_details = new ArrayList();

        try {
            con = ConnectToDB.createConnection();
            statement = con.createStatement();

            resultSet = statement.executeQuery("SELECT id,first_name,last_name,role FROM user WHERE is_active=0;");

//            join query and use result set metadata
            while (resultSet.next()) {
                user_id = resultSet.getInt("id");
                String first_name = resultSet.getString("first_name");
                String last_name = resultSet.getString("last_name");
                role = resultSet.getString("role");
                System.out.println(first_name);

//                can add tr td to whlie loop in jsp for less lines
                user_details.add(user_id);
                user_details.add(first_name);
                user_details.add(last_name);
                user_details.add(role);
            }
            con.close();
        } catch (SQLException e) {
            System.out.println(e);
        }
        return user_details;
    }

    public String Registerindb(User registerBean) {
        con = ConnectToDB.createConnection();

        String first_name = registerBean.getFirst_name();
        String last_name = registerBean.getLast_name();
        String email = registerBean.getEmail();
        String username = registerBean.getUsername();
        String password = registerBean.getPassword();
        String address = registerBean.getAddress();
        String phone_number = registerBean.getPhone_number();
        active_status = 0;
        role = registerBean.getRole();

        if (role.equals("user")) {
            active_status = 1;
        }

        String query = "INSERT INTO user (first_name, last_name, email, username, password, phone, address, role, is_active) VALUES (?,?,?,?,?,?,?,?,?) ";
        try {

            PreparedStatement stmt = con.prepareStatement(query);

            stmt.setString(1, first_name);
            stmt.setString(2, last_name);
            stmt.setString(3, email);
            stmt.setString(4, username);
            stmt.setString(5, password);
            stmt.setString(6, phone_number);
            stmt.setString(7, address);
            stmt.setString(8, role);
            stmt.setInt(9, active_status);

            i = stmt.executeUpdate();
            con.close();
        } catch (SQLException e) {
            System.out.println(e);

        }
        if (i != 0) {
            return "User is registered";
        } else {
            return "Error: User is not registered";
        }
    }

    public String approveUser(String user_id) {
        try {
            statement = con.createStatement();
            String appQuery = "UPDATE user SET is_active=1 WHERE id='" + user_id + "';";

            i = statement.executeUpdate(appQuery);

        } catch (SQLException ex) {
            System.out.println(ex);
        }

        if (i == 1) {
            return "Approved";
        } else {
            return "Error";
        }
    }

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
                role = resultSet.getString("role");
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
                role = resultSet.getString("role");
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
