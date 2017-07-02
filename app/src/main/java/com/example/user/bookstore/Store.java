package com.example.user.bookstore;

import com.google.gson.annotations.SerializedName;

/**
 * Created by User on 28.6.2017 г..
 */

public class Store {
    @SerializedName("Id")
    private int id;

    @SerializedName("Name")
    private String name;

    public String getName()
    {
        return name;
    }

    public int getId() {return id;}
}
