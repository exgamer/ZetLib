package com.citizenzet.zetlib.helper;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.Toolbar;

public class ToolbarHelper {
    private static String prevToolbarTitle;

    public static void setNavigationIcon(Activity activity, int toolbarId, int drawable, int width, int height){
        Toolbar toolbar = (Toolbar) activity.findViewById(toolbarId);
        Drawable icon= activity.getResources().getDrawable(drawable);
        Bitmap bitmap = ((BitmapDrawable) icon).getBitmap();
        Drawable logoDrawable = new BitmapDrawable(activity.getResources(), Bitmap.createScaledBitmap(bitmap, width, height, true));
        toolbar.setNavigationIcon(logoDrawable);
    }

    public static void setTitle(Activity activity, int toolbarId, String text){
        Toolbar toolbar = (Toolbar) activity.findViewById(toolbarId);
        prevToolbarTitle = (String) toolbar.getTitle();
        toolbar.setTitle(text);
    }

    public static void toPrevTitle(Activity activity, int toolbarId){
        if (prevToolbarTitle.equals(null)){
            return;
        }
        Toolbar toolbar = (Toolbar) activity.findViewById(toolbarId);
        toolbar.setTitle(prevToolbarTitle);
    }


}
