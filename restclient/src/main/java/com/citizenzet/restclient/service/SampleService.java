package com.citizenzet.restclient.service;

import android.util.Log;

import com.citizenzet.restclient.api.SampleApi;
import com.citizenzet.restclient.response.SampleResponse;
import com.google.gson.Gson;

import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;

public class SampleService extends BaseRestService<SampleResponse> {

    @Override
    protected void onResponseSuccess(Call call, Response response) {
        Log.e("!!!!","SUCESS");
        Object movies = response.body();
        Gson gson = new Gson();
        String json = gson.toJson(movies);
        Log.e("!!!!",json);


    }

    @Override
    protected void onResponseFailure(Call call, Throwable throwable) {

    }

    @Override
    protected Call getCaller(Retrofit retrofit) {
        SampleApi api = retrofit.create(SampleApi.class);
        return api.list();
    }


    @Override
    protected String getBaseUrl() {
        return "http://concepture.club";
    }
}
