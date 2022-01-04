package com.example.cekpajak.models;

public class User {
    public String id ;
    public String userName;
    public String companyName;
    public String email;
    public String password;

    public User(String id, String userName,String companyName, String email, String password) {
        this.id = id;
        this.userName = userName;
        this.companyName = companyName;
        this.email = email;
        this.password = password;
    }
}
