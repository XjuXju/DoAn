package com.project.dung.doantn.model;

/**
 * Created by Dung on 4/17/2017.
 */

public class UserModel {
    private String userName;
    private String password;
    private Boolean isAdmin;

    public UserModel(String userName, String password,  Boolean isAdmin) {
        this.userName = userName;
        this.password = password;
        this.isAdmin = isAdmin;
    }

    public String getUserName() {
        return userName;
    }

    public String getPassword() {
        return password;
    }
}
