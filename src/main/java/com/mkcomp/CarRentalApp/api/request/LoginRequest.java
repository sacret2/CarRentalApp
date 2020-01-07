package com.mkcomp.CarRentalApp.api.request;

/**
 * Class used as a data wrapper for Login requests
 */
public class LoginRequest {
    public String userName;
    public String password;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
