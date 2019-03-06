package com.citizenzet.restclient.fragment;


import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public abstract class BaseRestFragment<V extends ViewDataBinding,T extends FragmentActivity> extends Fragment {
    protected T activity;
    protected V binding;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding= DataBindingUtil.inflate(inflater, layout(), container, false);
        afterBinding();
        return binding.getRoot();
    }

    public abstract int layout();

    public void afterBinding(){

    }
}
