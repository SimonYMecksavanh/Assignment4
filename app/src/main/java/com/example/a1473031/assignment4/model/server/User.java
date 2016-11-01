package com.example.a1473031.assignment4.model.server;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;

/**
 * Created by 1473031 on 2016-10-28.
 */
public class User {

    public User(String name, String password, String email) {
        this.name = name;
        this.email = email;

        try {
            this.password = SHA1Encryption.SHA1(password);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

    }

    public static User parse(String json){
        Gson gson = new GsonBuilder()
                .setDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSZ")
                .create();

        User user = gson.fromJson(json, User.class);
        return user;
    }



    public static User[] parseArray(String json){
        Gson gson = new GsonBuilder()
                .setDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSZ")
                .create();

        User[] users = gson.fromJson(json, User[].class);
        return users;

    }

    private String name;
    private String password;
    private String email;

    public boolean isPassword(String password) {

        try {
            password = SHA1Encryption.SHA1(password);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        if (this.password.equals(password))
            return true;
        else
            return false;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String format(){
        Gson gson = new GsonBuilder()
                .setDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSZ")
                .serializeNulls()
                .create();
        return gson.toJson(this);
    }


}
