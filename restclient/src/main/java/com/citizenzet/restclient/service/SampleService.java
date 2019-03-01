package com.citizenzet.restclient.service;

import android.util.Log;

import com.citizenzet.restclient.activity.BaseRestActivity;
import com.citizenzet.restclient.api.SampleApiService;
import com.citizenzet.restclient.model.Sample;
import com.citizenzet.restclient.model.pack.SamplePack;
import com.google.gson.Gson;

import java.util.List;

import okhttp3.Headers;
import retrofit2.Call;
import retrofit2.Retrofit;

public class SampleService extends BaseRestService<SamplePack> {

    @Override
    protected Call getCaller(Retrofit retrofit) {
        SampleApiService api = retrofit.create(SampleApiService.class);
        return api.list();
    }

    @Override
    protected String getBaseUrl() {
        return "http://concepture.club";
    }

    @Override
    protected void onCallResponse(int code, Headers headers, Object body, BaseRestActivity activity) {
        Log.e("!!!!","SUCCESS");
        Log.e("!!!! code",String.valueOf(code));
        Log.e("!!!! headers",headers.toString());
        SamplePack sp = (SamplePack) body;
        List<Sample> list = sp.getModels();


        Gson gson = new Gson();
        String json = gson.toJson(list);


        Log.e("!!!!",json);
    }

    @Override
    protected void onCallFailure(Throwable throwable, BaseRestActivity activity) {
        Log.e("!!!!", throwable.toString());
    }
}
