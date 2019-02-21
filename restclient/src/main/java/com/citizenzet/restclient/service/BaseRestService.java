package com.citizenzet.restclient.service;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 *
 * @author citizenzet
 */
public abstract class BaseRestService<T> {


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
     * Returns host url for query
     *
     * @return
     */
    abstract String getBaseUrl();
}
