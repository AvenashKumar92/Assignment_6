package com.example.avenash_2.walmartextendedapp;

import java.util.Objects;

public class User {
    private final String email;
    private final String password;
    private final String fisrtName;
    private final String lastName;

    public User(String email, String password) {
        this.email = email;
        this.password = password;
        fisrtName="";
        lastName="";
    }

    public User(String fisrtName, String lastName, String email, String password) {
        this.fisrtName=fisrtName;
        this.lastName=lastName;
        this.email = email;
        this.password = password;
    }

    public String getFisrtName() {
        return fisrtName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return email.equalsIgnoreCase(user.email) &&
                password.equals(user.password);
    }
}
