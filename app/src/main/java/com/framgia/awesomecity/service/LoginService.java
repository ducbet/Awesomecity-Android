package com.framgia.awesomecity.service;

import com.framgia.awesomecity.data.model.LoginModel;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Headers;
import retrofit2.http.POST;

/**
 * Created by pnam2 on 7/26/2017.
 */

public interface LoginService {
    @Headers("Content-Type: application/json")
    @POST("sign_in/")
    Call<LoginResponse> login(@Body LoginModel signin);
}
