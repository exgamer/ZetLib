package com.citizenzet.restclient.model;

import com.google.gson.annotations.SerializedName;

/**
 * Sample model for test
 *
 * @author citizenzet
 */
public class Sample {

    @SerializedName("id")
    private int id;

    @SerializedName("create_date")
    private String createDate;

    @SerializedName("text")
    private String text;

    public Sample(int id, String createDate, String text) {
        this.id = id;
        this.createDate = createDate;
        this.text = text;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCreateDate() {
        return createDate;
    }

    public void setCreateDate(String createDate) {
        this.createDate = createDate;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
