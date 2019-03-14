package com.citizenzet.zetlib.service;

import android.app.Activity;

import com.citizenzet.zetlib.activity.BaseRestActivity;
import com.citizenzet.zetlib.fragment.BaseRestFragment;

import okhttp3.Headers;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public abstract class BaseRestService<M> {
    protected BaseRestFragment fragment;
    protected BaseRestActivity activity;

    public void setFragment(BaseRestFragment fragment){
        this.fragment = fragment;
    }

    public BaseRestFragment getFragment(){
        return this.fragment;
    }

    public Activity getActivity(){
        return this.activity;
    }

    public void setActivity(BaseRestActivity activity){
        this.activity = activity;
    }

    public Activity getFragmentActivity(){
        if (this.fragment == null){
            return null;
        }
        return this.fragment.getActivity();
    }

    public void init(BaseRestActivity activity){
        setActivity(activity);
    };

    public void init(BaseRestFragment fragment){
        setFragment(fragment);
    };

    public void beforeRequest(){

    }

    public void request(){
        beforeRequest();
        Retrofit retrofit = getBuilder();
        Call<M> call = getCaller(retrofit);
        call.enqueue(new Callback<M>() {
            @Override
            public void onResponse(Call<M> call, Response<M> response) {
                Object body = response.body();
                Headers headers = response.headers();
                int code = response.code();
                onCallResponse(code, headers, body);
            }
            @Override
            public void onFailure(Call<M> call, Throwable throwable) {
                onCallFailure(throwable);
            }
        });
        afterRequest();
    }

    public void afterRequest(){

    }

    protected abstract Call<M> getCaller(Retrofit retrofit);


    /**
     * Returns retrofit query builder
     *
     * @return
     */
    protected Retrofit getBuilder()  {
        return new Retrofit.Builder()
                .baseUrl(getBaseUrl())
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    /**
     * Returns host url for query
     *
     * @return
     */
    protected abstract String getBaseUrl();

    protected abstract void onCallResponse(int code, Headers headers, Object body);
    protected abstract void onCallFailure(Throwable throwable);

}