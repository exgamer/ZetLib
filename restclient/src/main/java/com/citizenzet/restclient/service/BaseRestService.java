package com.citizenzet.restclient.service;

import com.citizenzet.restclient.api.BaseRestApi;
import com.citizenzet.restclient.model.BaseRestModel;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 *
 * @author citizenzet
 */
public abstract class BaseRestService<T extends BaseRestApi, M extends BaseRestModel> {

    public void request(Callback<M> callback){
        Retrofit retrofit = this.getBuilder();
        Call<M> call = this.getCaller(retrofit);
        call.enqueue(new Callback<M>() {

            @Override

            public void onResponse(Call<M> call, Response<M> response) {
                this.onResponse(call, response);
            }

            @Override

            public void onFailure(Call<M> call, Throwable throwable) {
                this.onFailure(call, throwable);
            }
        });
    }

    /**
     * Returns retrofit query builder
     *
     * @return
     */
    public Retrofit getBuilder()  {
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
    abstract void onResponse(Call<M> call, Response<M> response);

    /**
     * Дествия при ошибке
     * @param call
     * @param throwable
     */
    abstract void onFailure(Call<M> call, Throwable throwable);

    /**
     * retrofit.getTopRatedMovies(API_KEY);
     * @param retrofit
     * @return
     */
    abstract Call<M> getCaller(Retrofit retrofit);

    /**
     * Returns host url for query
     *
     * @return
     */
    abstract String getBaseUrl();
}
