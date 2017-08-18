package com.framgia.awesomecity.data.model;

import android.databinding.BaseObservable;

import com.google.gson.annotations.SerializedName;

/**
 * Created by pnam2 on 7/25/2017.
 */

public class LoginModel extends BaseObservable {
    @SerializedName("sign_in")
    private User mUser;

    public LoginModel(User user) {
        mUser = user;
    }

    public User getUser() {
        return mUser;
    }

    public void setUser(User user) {
        mUser = user;
    }

}
