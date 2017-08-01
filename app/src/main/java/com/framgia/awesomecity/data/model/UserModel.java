package com.framgia.awesomecity.data.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by pnam2 on 7/26/2017.
 */

public class UserModel {
    @SerializedName("email")
    private String mUsername;
    @SerializedName("password")
    private String mPassword;

    public UserModel(String username, String password) {
        mUsername = username;
        mPassword = password;
    }

    public String getUsername() {
        return mUsername;
    }

    public void setUsername(String username) {
        mUsername = username;
    }

    public String getPassword() {
        return mPassword;
    }

    public void setPassword(String password) {
        mPassword = password;
    }

}
