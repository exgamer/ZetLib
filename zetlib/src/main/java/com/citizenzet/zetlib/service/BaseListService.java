package com.citizenzet.zetlib.service;

import retrofit2.Call;
import retrofit2.Retrofit;

public abstract class BaseListService<M> extends BaseRestService<M> {
    public void request(int page){
        if (isNetworkAvailable() == false){
            return;
        }
        beforeRequest();
        Retrofit retrofit = getBuilder();
        Call<M> call = getCaller(retrofit, page);
        initCall(call);
        afterRequest();
    }

    protected abstract Call<M> getCaller(Retrofit retrofit, int page);

    @Override
    protected Call getCaller(Retrofit retrofit) {
        return null;
    }
}
