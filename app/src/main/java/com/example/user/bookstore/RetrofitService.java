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

    public interface OnSingleBookReceivedListener{
        void onSingleBookReceived(Book book);
    }

    public void getSingleBook(int id, final OnSingleBookReceivedListener listener){
        Call<Book> call = service.getSingleBook(id);
        call.enqueue(new Callback<Book>() {
            @Override
            public void onResponse(Call<Book> call, Response<Book> response) {
                if(response.body() != null){
                    listener.onSingleBookReceived(response.body());
                }
            }
            @Override
            public void onFailure(Call<Book> call, Throwable t) {
                Log.w(TAG, "OnFailure: Get single book request failed");
            }
        });
    }

    public interface OnBooksReceivedListener {
        void onBooksReceived(List<Book> books);
    }

    public void getBooks(final OnBooksReceivedListener listener) {
        Call<List<Book>> call = service.getBooks();
        call.enqueue(new Callback<List<Book>>() {
            @Override
            public void onResponse(Call<List<Book>> call, Response<List<Book>> response) {
                if (response.body() != null) {
                    listener.onBooksReceived(response.body());
                }
            }
            @Override
            public void onFailure(Call<List<Book>> call, Throwable t) {
                Log.w(TAG, "OnFailure: Get books request failed");
            }
        });
    }


    public interface OnStoresReceivedListener {
        void onStoresReceived(List<Store> stores);
    }
    public void getStores(final OnStoresReceivedListener listener) {
        Call<List<Store>> call = service.getStores();
        call.enqueue(new Callback<List<Store>>() {
            @Override
            public void onResponse(Call<List<Store>> call, Response<List<Store>> response) {
                if (response.body() != null) {
                    listener.onStoresReceived(response.body());
                }
            }

            @Override
            public void onFailure(Call<List<Store>> call, Throwable t) {
                Log.w(TAG, "OnFailure: Get books request failed");
            }
        });
    }

    public interface OnBooksInStoreReceivedListener{
        void onBooksInStoreReceived(List<Book> books);
    }

    public void getBooksInStore(int storeId, final OnBooksInStoreReceivedListener listener){
        Call<List<Book>> call = service.getBooksInStore(storeId);
        call.enqueue(new Callback<List<Book>>() {
            @Override
            public void onResponse(Call<List<Book>> call, Response<List<Book>> response) {
                if (response.body() != null) {
                    listener.onBooksInStoreReceived(response.body());
                }
            }
            @Override
            public void onFailure(Call<List<Book>> call, Throwable t) {
                Log.w(TAG, "OnFailure: Get books request failed");
            }
        });
    }
}