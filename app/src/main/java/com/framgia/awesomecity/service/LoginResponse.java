package com.framgia.awesomecity.service;

import com.google.gson.annotations.SerializedName;

/**
 * Created by pnam2 on 7/26/2017.
 */

public class LoginResponse {

    @SerializedName("messages")
    private String mMessage;
    @SerializedName("staff")

    private UserResponse mUserResponse;

    public UserResponse getUserResponse() {
        return mUserResponse;
    }

    public void setUserResponse(UserResponse userResponse) {
        mUserResponse = userResponse;
    }

    public String getMessage() {
        return mMessage;
    }

    public void setMessage(String message) {
        mMessage = message;
    }

    public class UserResponse {

        @SerializedName("email")
        private String mEmail;
        @SerializedName("authen_token")

        private String mToken;

        public String getEmail() {
            return mEmail;
        }

        public void setEmail(String email) {
            mEmail = email;
        }

        public String getToken() {
            return mToken;
        }

        public void setToken(String token) {
            mToken = token;
        }
    }
}
