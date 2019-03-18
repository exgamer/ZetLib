package com.citizenzet.zetlib.service;

import android.util.Log;

import org.json.JSONObject;

import okhttp3.Headers;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public abstract class BaseListService<M> extends BaseRestService<M> {
    public void request(int page){
        beforeRequest();
        Retrofit retrofit = getBuilder();
        Call<M> call = getCaller(retrofit, page);
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
                onCallResponse(code, headers, body, errorMessage ,message);
            }
            @Override
            public void onFailure(Call<M> call, Throwable throwable) {
                onCallFailure(throwable);
            }
        });
        afterRequest();
    }

    protected abstract Call<M> getCaller(Retrofit retrofit, int page);

    @Override
    protected Call getCaller(Retrofit retrofit) {
        return null;
    }
}
