package com.citizenzet.restclient.response;

import com.citizenzet.restclient.model.Sample;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Response class for Sample model
 *
 * @author citizenzet
 */
public class SampleResponse {

    @SerializedName("page")
    private int page;

    @SerializedName("results")
    private List<Sample> results;

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

    public List<Sample> getResults() {
        return results;
    }

    public void setResults(List<Sample> results) {
        this.results = results;
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
