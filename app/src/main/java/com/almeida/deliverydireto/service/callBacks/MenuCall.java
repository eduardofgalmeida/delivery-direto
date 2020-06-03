package com.almeida.deliverydireto.service.callBacks;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Handler;
import android.os.Message;
import android.util.Log;

import com.almeida.deliverydireto.models.MenuModel;
import com.almeida.deliverydireto.service.RetrofitClientInstance;
import com.almeida.deliverydireto.service.interfaces.MenuService;
import com.almeida.deliverydireto.util.IGeral;
import com.almeida.deliverydireto.util.Util;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MenuCall {
    private List<MenuModel> ltmenuModel;
    private ProgressDialog progressBar;
    private Integer progressBarStatus;
    private Handler progressBarHandler = new Handler();
    private Context context;


    public List<MenuModel> getMenuAll(final Context context) {
        try {

            this.context = context;


            MenuService service = RetrofitClientInstance.getRetrofitInstance().create(MenuService.class);
            Call<List<MenuModel>> call = service.menuService();

            call.enqueue(new Callback<List<MenuModel>>() {


                @Override
                public void onResponse(Call<List<MenuModel>> call, Response<List<MenuModel>> response) {
                    if (response != null) {
                        if (response.isSuccessful())
                            ltmenuModel = response.body();

                        if (ltmenuModel != null) {


                            progressBar = new ProgressDialog(context);
                            progressBar.setCancelable(false);
                            progressBar.setMessage("Aguarde...\nImportando o menu.");
                            progressBar.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
                            progressBar.setProgress(0);
                            progressBar.setMax(ltmenuModel.size());
                            progressBar.show();
                            progressBar.isIndeterminate();

                            progressBarStatus = 0;

                            new Thread(new Runnable() {
                                public void run() {
                                    Integer a = 1;
                                    try {
                                        for (MenuModel vo : ltmenuModel) {

                                            progressBarStatus = a;
                                            a++;

                                            Thread.sleep(1);

                                            progressBarHandler.post(new Runnable() {
                                                public void run() {
                                                    progressBar.setProgress(progressBarStatus);
                                                }
                                            });
                                        }
                                        progressBar.dismiss();

                                        Message message = new Message();
                                        message.obj = progressBarStatus.toString();
                                        handlerResult.sendMessage(message);
                                    } catch (InterruptedException e) {
                                        e.printStackTrace();
                                    }
                                }
                            }).start();

//                            new Util().mensagem(context, "Aviso"
//                                    , "Menu importado com sucesso");
                        } else {
                            new Util().mensagem(context, "Aviso"
                                    , "Erro ao importar o menu...\nVerifique a Conexão.");
                        }
                    }
                }

                @Override
                public void onFailure(Call<List<MenuModel>> call, Throwable t) {
                    Log.e(IGeral.TAG, "Erro MenuCall:" + t.getMessage());
                    new Util().mensagem(context, "Aviso"
                            , "Erro ao conectar com a API...\nVerifique a Conexão.");
                }
            });


        } catch (Exception e) {
            e.printStackTrace();
        }

        return ltmenuModel;
    }


    private Handler handlerResult = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);

            AlertDialog.Builder builder = new AlertDialog.Builder(context);
            builder.setMessage("Menu's importados: " + ltmenuModel.size())
                    .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int id) {
                            dialog.dismiss();
                        }
                    });

            builder.show();
        }
    };
}
