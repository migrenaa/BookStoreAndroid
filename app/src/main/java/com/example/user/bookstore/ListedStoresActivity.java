package com.example.user.bookstore;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by User on 28.6.2017 г..
 */

public class ListedStoresActivity extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    private StoreAdapter mStoreAdaptor;
    private RecyclerView.LayoutManager mLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.listed_books_activity);
        mRecyclerView = (RecyclerView) findViewById(R.id.listed_books_layout);

        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);
        mStoreAdaptor = new StoreAdapter();
        mRecyclerView.setAdapter(mStoreAdaptor);

        RetrofitService services = new RetrofitService();
        services.getStores(new RetrofitService.OnStoresReceivedListener() {
            @Override
            public void onStoresReceived(List<Store> stores) {
                mStoreAdaptor.setStores(stores);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.books_option_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.books:
                startActivity(new Intent(this, ListedBooksActivity.class));
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}


