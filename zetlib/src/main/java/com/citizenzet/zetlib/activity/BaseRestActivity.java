package com.citizenzet.zetlib.activity;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.app.AppCompatDelegate;
import android.webkit.WebView;

import com.citizenzet.zetlib.application.App;

public class BaseRestActivity extends AppCompatActivity {

//    protected boolean isFullscreen = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (App.isNightModeEnabled()) {
            /**
             * Есть багу гугла с темной темой. при инициализации webview сбрасывается тема
             * пока решается только так
             */
            new WebView(getApplicationContext());
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
        }else{
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
        }
    }

    @Override
    public void onBackPressed() {
        FragmentManager fragmentManager = getSupportFragmentManager();
        if(fragmentManager.getBackStackEntryCount() != 0) {
            fragmentManager.popBackStack();
        } else {
            super.onBackPressed();
        }
    }

//    public void fullscreenOn() {
//        // Hide UI first
//        ActionBar actionBar = getSupportActionBar();
//        if (actionBar != null) {
//            actionBar.hide();
//        }
//        isFullscreen = true;
////        if (Build.VERSION.SDK_INT < 16) {
////            getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
////                    WindowManager.LayoutParams.FLAG_FULLSCREEN);
////        }else{
////            View decorView = getWindow().getDecorView();
////            int uiOptions = View.SYSTEM_UI_FLAG_FULLSCREEN;
////            decorView.setSystemUiVisibility(uiOptions);
////        }
//
//    }
//
//    public void fullscreenOff() {
//        ActionBar actionBar = getSupportActionBar();
//        if (actionBar != null) {
//            actionBar.show();
//        }
//        isFullscreen = false;
////        if (Build.VERSION.SDK_INT < 16) {
////            getWindow().clearFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
////        }else{
////            View decorView = getWindow().getDecorView();
////            int uiOptions = View.SYSTEM_UI_FLAG_VISIBLE;
////            decorView.setSystemUiVisibility(uiOptions);
////        }
//    }


}
