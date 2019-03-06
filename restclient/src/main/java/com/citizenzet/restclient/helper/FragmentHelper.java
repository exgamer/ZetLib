package com.citizenzet.restclient.helper;


import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;

import com.citizenzet.restclient.activity.BaseRestActivity;
import com.citizenzet.restclient.fragment.BaseRestFragment;

/**
 * Вспомогательные методы для работы с фрагментами
 */
public class FragmentHelper {

    /**
     * Переключить фрагмент
     * @param activity
     * @param fragment
     */
    public static void switchFragment(BaseRestActivity activity, BaseRestFragment fragment, int fragmentElementId){
        // create a FragmentManager
        FragmentManager fm = activity.getSupportFragmentManager();
        // create a FragmentTransaction to begin the transaction and replace the Fragment
        FragmentTransaction fragmentTransaction = fm.beginTransaction();
        // replace the FrameLayout with new Fragment
        fragmentTransaction.replace(fragmentElementId, fragment);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit(); // save the changes
    }
}
