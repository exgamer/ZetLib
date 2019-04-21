package com.citizenzet.zetlib.helper;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.Toolbar;

public class ToolbarHelper {


    public static void setNavigationIcon(Activity activity, int toolbarId, int drawable, int width, int height){
        Toolbar toolbar = (Toolbar) activity.findViewById(toolbarId);
        Drawable icon= activity.getResources().getDrawable(drawable);
        Bitmap bitmap = ((BitmapDrawable) icon).getBitmap();
        Drawable logoDrawable = new BitmapDrawable(activity.getResources(), Bitmap.createScaledBitmap(bitmap, width, height, true));
        toolbar.setNavigationIcon(logoDrawable);
    }

    public static void setTitle(Activity activity, int toolbarId, String text){
        Toolbar toolbar = (Toolbar) activity.findViewById(toolbarId);
        toolbar.setTitle(text);
    }
}
