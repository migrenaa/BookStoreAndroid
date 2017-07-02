package com.example.user.bookstore;

import com.google.gson.annotations.SerializedName;

/**
 * Created by User on 18.6.2017 г..
 */

public class Book {

    @SerializedName("Id")
    private int id;

    @SerializedName("Name")
    private String name;

    @SerializedName("Price")
    private int price;

    @SerializedName("Author")
    private String author;

    @SerializedName("PictureURL")
    private String pictureURL;

    @SerializedName("Rating")
    private int rating;

    @SerializedName("Description")
    private String description;

    public String getAuthor() {
        return author;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPictureURL() {
        return pictureURL;
    }

    public int getRating() {
        return rating;
    }

    public String getDescription() {
        return description;
    }
}
