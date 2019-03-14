package com.citizenzet.zetlib.service;

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

    protected abstract Call<M> getCaller(Retrofit retrofit, int page);

    @Override
    protected Call getCaller(Retrofit retrofit) {
        return null;
    }
}
