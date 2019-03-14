package com.citizenzet.zetlib.helper;


import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;

import com.citizenzet.zetlib.activity.BaseRestActivity;
import com.citizenzet.zetlib.fragment.BaseRestFragment;

/**
 * Вспомогательные методы для работы с фрагментами
 */
public class FragmentHelper {

    public static void setFragment(BaseRestActivity activity, BaseRestFragment fragment, int fragmentElementId){
        switchFragment(activity, fragment, fragmentElementId, false);
    }

    /**
     * Переключить фрагмент
     * @param activity
     * @param fragment
     */
    public static void switchFragment(BaseRestActivity activity, BaseRestFragment fragment, int fragmentElementId){
        switchFragment(activity, fragment, fragmentElementId, true);
    }

    /**
     * Переключить фрагмент
     * @param activity
     * @param fragment
     */
    private static void switchFragment(BaseRestActivity activity, BaseRestFragment fragment, int fragmentElementId, boolean isBack){
        // create a FragmentManager
        FragmentManager fm = activity.getSupportFragmentManager();
        // create a FragmentTransaction to begin the transaction and replace the Fragment
        FragmentTransaction fragmentTransaction = fm.beginTransaction();
        // replace the FrameLayout with new Fragment
        fragmentTransaction.replace(fragmentElementId, fragment);
        if (isBack) {
            fragmentTransaction.addToBackStack(null);
        }
        fragmentTransaction.commit(); // save the changes
    }
}