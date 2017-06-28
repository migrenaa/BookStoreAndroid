package com.example.user.bookstore;

import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by User on 28.6.2017 г..
 */

public class RetrofitService {


    private static final String TAG = "RetrofitServices";

    private static final String API_URL = "https://milenabooks.azurewebsites.net/api/";
    private RetrofitCall service;

    public RetrofitService() {
        Gson gson = new GsonBuilder()
                .create();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(API_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();

        service = retrofit.create(RetrofitCall.class);
    }

    public interface OnBooksReceivedListeer {
        void onBooksReceived(List<Book> books);
    }

    public void getBooks(final OnBooksReceivedListeer listener) {
        Call<List<Book>> call = service.getBooks();
        call.enqueue(new Callback<List<Book>>() {
            @Override
            public void onResponse(Call<List<Book>> call, Response<List<Book>> response) {
                if (response.body() != null) {
                    listener.onBooksReceived(response.body());
                } else {
                    Log.w(TAG, "onResponse: no body received");
                }
            }

            @Override
            public void onFailure(Call<List<Book>> call, Throwable t) {
                Log.w(TAG, "OnFailure: Get books request failed");
            }
        });
    }
}