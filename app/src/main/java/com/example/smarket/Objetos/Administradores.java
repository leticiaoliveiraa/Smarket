package com.example.smarket.Objetos;

import java.util.Objects;

public class Administradores {

    String username;
    String password;

    public Administradores(String username, String password) {
        this.username = username;
        this.password = password;
    }

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

    @Override
    public String toString() {
        return "Administradores{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}

