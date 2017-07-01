package com.example.user.bookstore;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by User on 28.6.2017 г..
 */

public interface RetrofitCall {
    @GET("Books")
    Call<List<Book>> getBooks();

    @GET("Store")
    Call<List<Store>> getStores();

    @GET("Books/{id}")
    Call<Book> getSingleBook(@Path("id") int bookId);

    @GET("Stores/{id}/books")
    Call<List<Book>> getBooksInStore(@Path("id") int storeId);
}
