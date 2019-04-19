package com.citizenzet.zetlib.fragment;


import android.content.Context;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.citizenzet.zetlib.helper.ActivityHelper;

public abstract class BaseRestFragment<V extends ViewDataBinding,T extends FragmentActivity> extends Fragment {
    protected T activity;
    protected V binding;
    protected View _rootView;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        activity=(T)getActivity();
        init();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        if (this._rootView == null) {
            binding= DataBindingUtil.inflate(inflater, layout(), container, false);
            ActivityHelper.hideKeyboard(getActivity());
            afterBinding();
            this._rootView = binding.getRoot();
        }

        return this._rootView;
    }

    public V getBinding() {
        return binding;
    }

    public abstract int layout();

    public abstract void init();

    public void afterBinding(){

    }

    @Override
    public void setUserVisibleHint(boolean visible)
    {
        super.setUserVisibleHint(visible);
        /**
         * Так делаем чтобы фрагмент не загружался пока он невидим в табах
         */
        if (visible && isResumed())
        {
            //Only manually call onResume if fragment is already visible
            //Otherwise allow natural fragment lifecycle to call onResume
            onResume();
        }
    }
}
