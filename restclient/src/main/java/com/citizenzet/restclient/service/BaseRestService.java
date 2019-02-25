package com.citizenzet.restclient.service;

import com.citizenzet.restclient.model.BaseRestModel;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Base rest service
 *
 * @author citizenzet
 */
public abstract class BaseRestService< M extends BaseRestModel> {
    /**
     * execute request
     */
    public void request(){
        Retrofit retrofit = this.getBuilder();
        Call<M> call = this.getCaller(retrofit);
        call.enqueue(new Callback<M>() {
            @Override
            public void onResponse(Call<M> call, Response<M> response) {
                onResponseSuccess(call, response);
            }
            @Override
            public void onFailure(Call<M> call, Throwable throwable) {
                onResponseFailure(call, throwable);
            }
        });
    }

    /**
     * Returns retrofit query builder
     *
     * @return
     */
    protected Retrofit getBuilder()  {
        return new Retrofit.Builder()
            .baseUrl(this.getBaseUrl())
            .addConverterFactory(GsonConverterFactory.create())
            .build();
    }

    /**
     * Действия при успешном запросе
     * @param call
     * @param response
     */
    protected abstract void onResponseSuccess(Call<M> call, Response<M> response);

    /**
     * Дествия при ошибке
     * @param call
     * @param throwable
     */
    protected abstract void onResponseFailure(Call<M> call, Throwable throwable);

    /**
     *  SampleApi api = retrofit.create(SampleApi.class);
     *  return api.list();
     *
     * @param retrofit
     * @return
     */
    protected abstract Call<M> getCaller(Retrofit retrofit);

    /**
     * Returns host url for query
     *
     * @return
     */
    protected abstract String getBaseUrl();
}
