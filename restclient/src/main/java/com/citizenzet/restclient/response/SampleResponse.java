package com.citizenzet.restclient.response;

import com.citizenzet.restclient.model.BaseRestModel;
import com.citizenzet.restclient.model.Sample;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * zxcvzxc
 * Response class for Sample model
 *
 * @author citizenzet
 */
public class SampleResponse extends BaseRestModel {

    @SerializedName("page")
    private int page;

    @SerializedName("models")
    private List<Sample> models;

    @SerializedName("total_results")
    private int totalResults;

    @SerializedName("total_pages")
    private int totalPages;

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public List<Sample> getModels() {
        return models;
    }

    public void setModels(List<Sample> models) {
        this.models = models;
    }

    public int getTotalResults() {
        return totalResults;
    }

    public void setTotalResults(int totalResults) {
        this.totalResults = totalResults;
    }

    public int getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(int totalPages) {
        this.totalPages = totalPages;
    }
}
