package com.almeida.deliverydireto.service.callBacks;

import android.content.Context;
import android.util.Log;

import com.almeida.deliverydireto.models.RestaurantModel;
import com.almeida.deliverydireto.service.RetrofitClientInstance;
import com.almeida.deliverydireto.service.interfaces.RestaurantService;
import com.almeida.deliverydireto.util.IGeral;
import com.almeida.deliverydireto.util.Util;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RestaurantCall {
    private List<RestaurantModel> ltRestaurant;
    private RestaurantModel restaurantModel;
    private Context context;

    public List<RestaurantModel> getRestaurantAll(final Context context) {
        try {
            this.context = context;

            RestaurantService service = RetrofitClientInstance.getRetrofitInstance().create(RestaurantService.class);
            Call<RestaurantModel> call = service.restaurantService();

            call.enqueue(new Callback<RestaurantModel>() {
                @Override
                public void onResponse(Call<RestaurantModel> call, Response<RestaurantModel> response) {
                    if (response != null) {
                        if (response.isSuccessful()) {
                            restaurantModel = response.body();

                            if (restaurantModel != null) {
                               new Util().mensagem(context, "Aviso"
                                        , "Restaurante sincronizado com sucesso");
                            } else {
                                new Util().mensagem(context, "Aviso"
                                        , "Erro ao sincronizar restaurante...\nVerifique a Conexão.");
                            }
                        }
                    }
                }

                @Override
                public void onFailure(Call<RestaurantModel> call, Throwable t) {
                    Log.e(IGeral.TAG, "Erro RestaurantCall:" + t.getMessage());
                    new Util().mensagem(context, "Aviso"
                            , "Erro ao conectar com a API...\nVerifique a Conexão.");
                }
            });


        } catch (
                Exception e) {
            e.printStackTrace();
        }

        return ltRestaurant;

    }

}
