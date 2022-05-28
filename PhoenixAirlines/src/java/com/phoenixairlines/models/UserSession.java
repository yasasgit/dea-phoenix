package com.phoenixairlines.models;

public class UserSession {

    private String login_time;
    private String ip_address;
    private int user_session_id;

    public UserSession(String login_time, String ip_address, int user_session_id) {
        super();
        this.login_time = login_time;
        this.ip_address = ip_address;
        this.user_session_id = user_session_id;
    }

    public UserSession() {
        super();
    }

    public int getUser_session_id() {
        return user_session_id;
    }

    public void setUser_session_id(int user_session_id) {
        this.user_session_id = user_session_id;
    }

    public String getLogin_time() {
        return login_time;
    }

    public void setLogin_time(String login_time) {
        this.login_time = login_time;
    }

    public String getIp_address() {
        return ip_address;
    }

    public void setIp_address(String ip_address) {
        this.ip_address = ip_address;
    }
}
