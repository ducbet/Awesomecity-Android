package com.framgia.awesomecity.service;

import com.framgia.awesomecity.data.model.LoginModel;

import io.reactivex.Observable;
import retrofit2.Response;
import retrofit2.http.Body;
import retrofit2.http.POST;

/**
 * Created by pnam2 on 7/26/2017.
 */

public interface LoginService {
    @POST("sign_in/")
    Observable<Response<LoginResponse>> login(@Body LoginModel signin);
}
