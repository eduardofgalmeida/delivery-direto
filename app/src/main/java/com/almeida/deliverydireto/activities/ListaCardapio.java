package com.almeida.deliverydireto.activities;

import android.content.Context;
import android.nfc.Tag;
import android.os.Bundle;

import com.almeida.deliverydireto.adapters.ListaMenuAdapter;
import com.almeida.deliverydireto.models.ItemsModel;
import com.almeida.deliverydireto.models.MenuModel;
import com.almeida.deliverydireto.models.RestaurantModel;
import com.almeida.deliverydireto.service.RetrofitClientInstance;
import com.almeida.deliverydireto.service.callBacks.MenuCall;
import com.almeida.deliverydireto.service.callBacks.RestaurantCall;
import com.almeida.deliverydireto.service.interfaces.MenuService;
import com.almeida.deliverydireto.util.IGeral;
import com.almeida.deliverydireto.util.Util;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.almeida.deliverydireto.R;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;



public class ListaCardapio extends AppCompatActivity {

    Context context = ListaCardapio.this;
    private RecyclerView recyclerView;
    private ListaMenuAdapter listaMenuAdapter;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_cardapio);

//        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
//        listaMenuAdapter = new ListaMenuAdapter(this);
//        recyclerView.setAdapter(listaMenuAdapter);

        sincronizarRestaurante();
        sincronizaMenu();




    }
    public void sincronizarRestaurante() {
        new RestaurantCall().getRestaurantAll(context);
    }

    public void sincronizaMenu(){
        new MenuCall().getMenuAll(context);
    }
}