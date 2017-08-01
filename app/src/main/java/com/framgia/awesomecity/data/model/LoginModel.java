package com.framgia.awesomecity.data.model;

import android.databinding.BaseObservable;

import com.google.gson.annotations.SerializedName;

/**
 * Created by pnam2 on 7/25/2017.
 */

public class LoginModel extends BaseObservable {
    @SerializedName("sign_in")
    private UserModel mUserModel;

    public LoginModel(UserModel userModel) {
        mUserModel = userModel;
    }

    public UserModel getUserModel() {
        return mUserModel;
    }

    public void setUserModel(UserModel userModel) {
        mUserModel = userModel;
    }

}
