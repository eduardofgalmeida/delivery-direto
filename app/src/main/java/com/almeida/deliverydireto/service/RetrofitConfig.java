package com.almeida.deliverydireto.service;

import com.almeida.deliverydireto.service.interfaces.RestaurantService;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitConfig {

    private final Retrofit retrofit;

    public RetrofitConfig(String url) {

        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .connectTimeout(1, TimeUnit.MINUTES)
                .readTimeout(30, TimeUnit.SECONDS)
                .writeTimeout(15, TimeUnit.SECONDS)
                .build();


        this.retrofit = new Retrofit.Builder()
                .baseUrl(url)
                .client(okHttpClient)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    public RestaurantService getRetaurant() {
        return this.retrofit.create(RestaurantService.class);
    }



}
