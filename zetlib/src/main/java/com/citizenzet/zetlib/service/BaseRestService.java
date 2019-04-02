package com.citizenzet.zetlib.service;

import android.app.Activity;
import android.util.Log;
import android.view.View;

import com.citizenzet.zetlib.activity.BaseRestActivity;
import com.citizenzet.zetlib.application.App;
import com.citizenzet.zetlib.fragment.BaseRestFragment;
import com.citizenzet.zetlib.helper.NotificationHelper;

import org.json.JSONObject;

import java.util.concurrent.TimeUnit;

import okhttp3.Headers;
import okhttp3.OkHttpClient;
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

    public void onResume(){}

    public void beforeRequest(){

    }

    protected void onNoInternetSnackClick(View v){

    }

    protected View.OnClickListener getOnNoInternetSnackClickListener(){
        return new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onNoInternetSnackClick(v);
            }
        };
    }

    protected boolean isNetworkAvailable(){
        if (App.isNetworkAvailable() == false || App.isOnline() == false) {
            View view = null;
            if (getActivity() != null){
                View currentFocus = getActivity().getWindow().getCurrentFocus();
                if (currentFocus != null)
                    view = currentFocus.getRootView();
            }else{
                view = getFragment().getView();
            }

            NotificationHelper.snack(view, "No internet connection","Try again", getOnNoInternetSnackClickListener());
            return false;
        }
        return true;
    }

    public void request(){
        if (isNetworkAvailable() == false){
            return;
        }
        beforeRequest();
        Retrofit retrofit = getBuilder();
        Call<M> call = getCaller(retrofit);
        initCall(call);
        afterRequest();
    }

    protected void initCall(Call<M> call){
        call.enqueue(new Callback<M>() {
            @Override
            public void onResponse(Call<M> call, Response<M> response) {
                Object body = response.body();
                String errorMessage;
                try {
                    JSONObject jObjError = new JSONObject(response.errorBody().string());
                    errorMessage = jObjError.getString("message");
                } catch (Exception e) {
                    errorMessage = e.getMessage();
                }
                String message = response.message();
                Headers headers = response.headers();
                int code = response.code();
                Log.d("REQUEST BASE URL", getBaseUrl());
                Log.d("RESPONSE CODE", String.valueOf(code));
                Log.d("RESPONSE HEADERS", headers.toString());
                if (message != null) {
                    Log.d("RESPONSE MESSAGE", message);
                }
                Log.d("RESPONSE ERROR MESSAGE ", errorMessage);
                onCallResponse(code, headers, body, errorMessage, message);
            }
            @Override
            public void onFailure(Call<M> call, Throwable throwable) {
                onCallFailure(throwable);
            }
        });
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
                .client(new OkHttpClient.Builder()
                        .connectTimeout(1, TimeUnit.MINUTES)
                        .writeTimeout(1, TimeUnit.MINUTES)
                        .readTimeout(1, TimeUnit.MINUTES)
                        .build())
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

    protected abstract void onCallResponse(int code, Headers headers, Object body, String errorMessage, String message);
    protected abstract void onCallFailure(Throwable throwable);

    public void onDestroy(){}

}
