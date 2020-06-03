package com.almeida.deliverydireto.service.interfaces;

import com.almeida.deliverydireto.models.RestaurantModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface RestaurantService {

    @GET("restaurant")
    Call<RestaurantModel> restaurantService();

}
