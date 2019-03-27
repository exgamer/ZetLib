package com.citizenzet.zetlib.activity;

import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;

public class BaseRestActivity extends AppCompatActivity {
    @Override
    public void onBackPressed() {
        FragmentManager fragmentManager = getSupportFragmentManager();
        if(fragmentManager.getBackStackEntryCount() != 0) {
            fragmentManager.popBackStack();
        } else {
            super.onBackPressed();
        }
    }
}
