package com.citizenzet.restclient.helper;

import android.app.Activity;
import android.content.Intent;

public class ActivityHelper {

    public static void goToActivity(Activity activity, final Class<? extends Activity> activityToGo){
        Intent myIntent = new Intent(activity, activityToGo);
        activity.startActivity(myIntent);
    }
}
