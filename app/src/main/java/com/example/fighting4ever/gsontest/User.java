package com.example.fighting4ever.gsontest;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Fighting4Ever on 2016/4/21.
 */
public class User {
    private String username;
    @SerializedName(value = "phonenumber", alternate = {"phone","phone_num"})
    private String phonenumber;
    private String email;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPhonenumber() {
        return phonenumber;
    }

    public void setPhonenumber(String phonenumber) {
        this.phonenumber = phonenumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "UserName: " + username + "\n"
                + "PhoneNum: " + phonenumber + "\n"
                + "Email: " + email;
    }
}
