package com.citizenzet.zetlib.helper;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;

import com.citizenzet.zetlib.activity.BaseRestActivity;
import com.citizenzet.zetlib.fragment.BaseRestFragment;

/**
 * Вспомогательные методы для работы с фрагментами
 */
public class FragmentHelper {

    /**
     * Переключить фрагмент
     * @param activity
     * @param fragment
     */
    public static void switchFragment(BaseRestActivity activity, BaseRestFragment fragment, int fragmentElementId, boolean isBack, String backStackKey, Bundle bundle){
        if (bundle != null) {
            fragment.setArguments(bundle);
        }
        // create a FragmentManager
        FragmentManager fm = activity.getSupportFragmentManager();
        // create a FragmentTransaction to begin the transaction and replace the Fragment
        FragmentTransaction fragmentTransaction = fm.beginTransaction();
        // replace the FrameLayout with new Fragment
        fragmentTransaction.replace(fragmentElementId, fragment);
        if (isBack) {
            fragmentTransaction.addToBackStack(backStackKey);
        }else{
            fm.popBackStack();
            fragmentTransaction.disallowAddToBackStack();
        }
        fragmentTransaction.commit(); // save the changes
    }

    public static void clearFragmentManager(BaseRestActivity activity){
        activity.getSupportFragmentManager().popBackStack(null, FragmentManager.POP_BACK_STACK_INCLUSIVE);
        for (Fragment fragment:activity.getSupportFragmentManager().getFragments()) {
            activity.getSupportFragmentManager().beginTransaction().remove(fragment).commit();
        }
    }
}
