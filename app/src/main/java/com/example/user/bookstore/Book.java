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

    public Book(String name) {
        this.setName(name);
    }

    public String getName() {
        return name;
    }


    public void setName(String name) {
        this.name = name;
    }


    public int getPrice() {
        return price;
    }


    public void setPrice(int price) {
        this.price = price;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getPictureURL() {
        return pictureURL;
    }

    public void setPictureURL(String pictureURL) {
        this.pictureURL = pictureURL;
    }


    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
