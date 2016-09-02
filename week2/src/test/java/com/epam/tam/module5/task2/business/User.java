package com.epam.tam.module5.task2.business;

import com.epam.tam.module5.task2.util.TestProperties;

/**
 * Created by Tatyana_Korobitsina on 9/2/2016.
 */
public class User {

    private String username;
    private String password;

    public User() {
    }

    public void setUsername(String name) {
        this.username = name;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
}

