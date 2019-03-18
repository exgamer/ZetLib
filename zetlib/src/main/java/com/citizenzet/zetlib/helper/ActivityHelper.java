package com.citizenzet.zetlib.helper;

import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;

/**
 * Вспомогательные методы для работы с activity
 */
public class ActivityHelper {

    public static void goToActivity(Activity activity, final Class<? extends Activity> activityToGo){
        goToActivity(activity, activityToGo, false);
    }

    public static void goToActivity(Activity activity, final Class<? extends Activity> activityToGo, boolean finish){
        Intent myIntent = new Intent(activity, activityToGo);
        activity.startActivity(myIntent);
        if (finish) {
            activity.finish();
        }
    }

    public static void hideKeyboard(Activity activity) {
        InputMethodManager imm = (InputMethodManager) activity.getSystemService(Activity.INPUT_METHOD_SERVICE);
        //Find the currently focused view, so we can grab the correct window token from it.
        View view = activity.getCurrentFocus();
        //If no view currently has focus, create a new one, just so we can grab a window token from it
        if (view == null) {
            view = new View(activity);
        }
        imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
    }
}
