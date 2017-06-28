package com.example.user.bookstore;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by User on 28.6.2017 г..
 */

public interface RetrofitCall {
    @GET("Books")
    Call<List<Book>> getBooks();

    @GET("Store")
    Call<List<Store>> getStores();
}
