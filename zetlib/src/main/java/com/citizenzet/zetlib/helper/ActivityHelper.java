package com.citizenzet.zetlib.helper;

import android.app.Activity;
import android.content.Intent;

/**
 * Вспомогательные методы для работы с activity
 */
public class ActivityHelper {

    public static void goToActivity(Activity activity, final Class<? extends Activity> activityToGo){
        Intent myIntent = new Intent(activity, activityToGo);
        activity.startActivity(myIntent);
    }
}
