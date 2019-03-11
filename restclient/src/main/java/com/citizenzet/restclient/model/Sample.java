package com.citizenzet.restclient.model;

import com.google.gson.annotations.SerializedName;

/**
 * Sample model for test
 *
 * @author citizenzet
 */
public class Sample extends BaseModel{

    @SerializedName("id")
    private int id;

    @SerializedName("created_at")
    private String createdAt;

    @SerializedName("text")
    private String text;

    @SerializedName("title")
    private String title;

    public Sample(int id, String createdAt, String text, String title) {
        this.id = id;
        this.createdAt = createdAt;
        this.text = text;
        this.title = title;
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

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
