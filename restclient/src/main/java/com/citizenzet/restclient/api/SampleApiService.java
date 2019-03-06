package com.citizenzet.restclient.api;

import com.citizenzet.restclient.model.pack.SamplePack;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Interface for sample model APIs
 *
 * @author citizenzet
 */
public interface SampleApiService {

    @GET("api/post/list")
    Call<SamplePack> list(@Query("page") int page);
}
