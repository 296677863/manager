package com.lei.Dto;

import java.io.Serializable;

/**
 * Created by lei on 12/2/2016.
 */
public class LoginDto implements Serializable{
    private String username;
    private String password;

    public LoginDto(){}

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
