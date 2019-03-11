package com.citizenzet.restclient.model;

import com.google.gson.annotations.SerializedName;

public class User extends BaseModel {
    @SerializedName("id")
    private int id;

    @SerializedName("token")
    private String token;

    @SerializedName("identity")
    private String identity;

    public User(int id, String token ){
        this.id = id;
        this.token = token;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}

