package com.example.user.bookstore;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by User on 18.6.2017 г..
 */

public class ListedBooksActivity extends Activity {

    private RecyclerView mRecyclerView;
    private BookAdapter mBookAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    private ArrayList<Book> books = new ArrayList<Book>();


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
}


class BooksViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

    private Book mBook;
    private TextView mBookName;

    public BooksViewHolder(View itemView){
        super(itemView);
        mBookName = itemView.findViewById(R.id.listed_books_book_name);
    }

    public void bindBookItem(Book book){
        mBook = book;
        mBookName.setText(book.getName());
    }

    @Override
    public void onClick(View view) {
        //TODO implement to send you to BookActivity
    }
}
class BookAdapter extends RecyclerView.Adapter<BooksViewHolder>{

    List<Book> books;

    public BookAdapter() {this.books = new ArrayList<>();}
    public BookAdapter(List<Book> books) {
        this.books = books;
    }

    @Override
    public BooksViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_item_book, parent, false);

        return new BooksViewHolder(view);

    }

    @Override
    public void onBindViewHolder(BooksViewHolder holder, int position) {
        holder.bindBookItem(books.get(position));
    }

    @Override
    public int getItemCount() {
        return books.size();
    }

    public void setBooks(List<Book> books){
        this.books = books;
        notifyDataSetChanged();
    }
}