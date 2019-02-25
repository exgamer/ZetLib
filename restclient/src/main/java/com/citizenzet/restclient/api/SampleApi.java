package com.citizenzet.restclient.api;

import com.citizenzet.restclient.response.SampleResponse;
import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Interface for sample model APIs
 *
 * @author citizenzet
 */
public interface SampleApi extends BaseRestApi{

    @GET("api/post/list")
    Call<SampleResponse> getSamplesList();
}
