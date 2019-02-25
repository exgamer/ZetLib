package com.citizenzet.restclient.service;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Base rest service
 *
 * @author citizenzet
 */
public abstract class BaseRestService {


    /**
     * Returns retrofit query builder
     *
     * @return
     */
    protected Retrofit getBuilder()  {
        return new Retrofit.Builder()
            .baseUrl(getBaseUrl())
            .addConverterFactory(GsonConverterFactory.create())
            .build();
    }

    /**
     * Returns host url for query
     *
     * @return
     */
    protected abstract String getBaseUrl();

    public abstract void request();
}
