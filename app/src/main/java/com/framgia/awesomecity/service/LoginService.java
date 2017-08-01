package com.framgia.awesomecity.service;

import com.framgia.awesomecity.data.model.LoginModel;
import com.framgia.awesomecity.data.model.TableModel;

import java.util.List;

import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;
import io.reactivex.observers.DisposableObserver;
import retrofit2.Call;
import retrofit2.Response;

import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.POST;

/**
 * Created by pnam2 on 7/26/2017.
 */

public interface LoginService {
    @POST("sign_in/")
    Observable<Response<LoginResponse>> login(@Body LoginModel signin);
    @GET("tables/")
    Observable<List<TableModel>> getTableList(@Header("AUTHENTICATE-TOKEN") String token);

}
