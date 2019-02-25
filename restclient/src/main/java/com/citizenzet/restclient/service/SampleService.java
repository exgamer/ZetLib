package com.citizenzet.restclient.service;

import android.util.Log;

import com.citizenzet.restclient.api.SampleApiService;
import com.citizenzet.restclient.model.pack.SamplePack;
import com.google.gson.Gson;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class SampleService extends BaseRestService {

    /**
     * execute request
     */
    public void request(){
        Retrofit retrofit = getBuilder();
        SampleApiService api = retrofit.create(SampleApiService.class);
        Call<SamplePack> call = api.list();

        call.enqueue(new Callback<SamplePack>() {
            @Override
            public void onResponse(Call<SamplePack> call, Response<SamplePack> response) {
                Log.e("!!!!","SUCESS");
                Object samples = response.body();
                Gson gson = new Gson();
                String json = gson.toJson(samples);
                Log.e("!!!!",json);
            }
            @Override
            public void onFailure(Call<SamplePack> call, Throwable throwable) {
                Log.e("!!!!", throwable.toString());
            }
        });
    }


    @Override
    protected String getBaseUrl() {
        return "http://concepture.club";
    }
}
