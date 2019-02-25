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

    @SerializedName("created_at")
    private String createdAt;

    @SerializedName("text")
    private String text;

    public Sample(int id, String createdAt, String text) {
        this.id = id;
        this.createdAt = createdAt;
        this.text = text;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
