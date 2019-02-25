package com.citizenzet.restclient.service;

import android.util.Log;
import com.citizenzet.restclient.api.SampleApiService;
import com.citizenzet.restclient.model.pack.SamplePack;
import com.google.gson.Gson;
import okhttp3.Headers;
import retrofit2.Call;
import retrofit2.Retrofit;

public class SampleService2 extends BaseRestService2<SamplePack>{

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
    protected void onCallResponse(int code, Headers headers, Object body) {
        Log.e("!!!!","SUCCESS");
        Log.e("!!!! code",String.valueOf(code));
        Log.e("!!!! headers",headers.toString());
        Gson gson = new Gson();
        String json = gson.toJson(body);
        Log.e("!!!!",json);
    }

    @Override
    protected void onCallFailure(Throwable throwable) {
        Log.e("!!!!", throwable.toString());
    }
}
