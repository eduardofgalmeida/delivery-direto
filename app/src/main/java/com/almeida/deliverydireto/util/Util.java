package com.almeida.deliverydireto.util;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;

public class Util {

    public void mensagem(Context context, String titulo, String msg) {

        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setMessage(msg)
                .setTitle(titulo)
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.dismiss();
                    }
                });

        builder.show();

    }

}
