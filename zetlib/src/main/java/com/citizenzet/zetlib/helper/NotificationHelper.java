package com.citizenzet.zetlib.helper;

import android.app.Activity;
import android.widget.Toast;

public class NotificationHelper {
    public static void toast(Activity activity, String message){
        Toast.makeText(activity.getApplicationContext(),message,Toast.LENGTH_LONG).show();
    }
}
