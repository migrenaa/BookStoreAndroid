package com.example.user.bookstore;


import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import java.util.List;

/**
 * Created by User on 18.6.2017 г..
 */

public class ListedBooksActivity extends AppCompatActivity  {

    private RecyclerView mRecyclerView;
    private BookAdapter mBookAdapter;
    private RecyclerView.LayoutManager mLayoutManager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.listed_books_activity);
        mRecyclerView = (RecyclerView) findViewById(R.id.listed_books_layout);

        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);
        mBookAdapter = new BookAdapter();
        mRecyclerView.setAdapter(mBookAdapter);

        RetrofitService services = new RetrofitService();
        services.getBooks(new RetrofitService.OnBooksReceivedListener() {
            @Override
            public void onBooksReceived(List<Book> books) {
                mBookAdapter.setBooks(books);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.stores_option_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.stores:
                startActivity(new Intent(this, ListedStoresActivity.class));
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}