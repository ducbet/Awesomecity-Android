package com.framgia.awesomecity.service;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by pnam2 on 7/26/2017.
 */

public class ServiceGenerator {
    public static final String BASE_URL = "http://192.168.1.96:3000/api/";

    private static Retrofit sRetrofit = null;
    private static Retrofit.Builder sRetrofitBuilder = new Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create());

    private static HttpLoggingInterceptor sHttpLoggingInterceptor = new HttpLoggingInterceptor()
            .setLevel(HttpLoggingInterceptor.Level.BODY);

    private static OkHttpClient.Builder sOkHttpClientBuilder = new OkHttpClient.Builder()
            .addInterceptor(sHttpLoggingInterceptor);

    private static OkHttpClient sOkHttpClient = sOkHttpClientBuilder.build();

    public static <T> T createService(Class<T> serviceClass) {
        if (sRetrofit == null) {
            sRetrofit = sRetrofitBuilder.client(sOkHttpClient).build();
        }
        return sRetrofit.create(serviceClass);
    }
}


