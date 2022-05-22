package com.phoenixairlines.models;

public class Session {

    private String login_time;
    private String ip_address;

    public Session(String login_time, String ip_address) {
        super();
        this.login_time = login_time;
        this.ip_address = ip_address;
    }

    public Session() {
        super();
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
