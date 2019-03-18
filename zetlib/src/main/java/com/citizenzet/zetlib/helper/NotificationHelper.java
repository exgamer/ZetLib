package com.citizenzet.zetlib.helper;

import android.app.Activity;
import android.support.design.widget.Snackbar;
import android.view.View;
import android.widget.Toast;

public class NotificationHelper {
    public static void toast(Activity activity, String message){
        Toast.makeText(activity.getApplicationContext(),message,Toast.LENGTH_LONG).show();
    }

    public static void snack(View view, String message, View.OnClickListener onClickListener){
        Snackbar.make(view, message, Snackbar.LENGTH_LONG)
                .setAction("Action", onClickListener).show();
    }

    public static void snack(View view, String message){
        Snackbar.make(view, message, Snackbar.LENGTH_LONG)
                .setAction("Action", null).show();
    }
}
