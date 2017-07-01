package com.example.user.bookstore;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by User on 30.6.2017 г..
 */

public class BookAdapter extends RecyclerView.Adapter<BooksViewHolder> {

    List<Book> books;

    public BookAdapter() {
        this.books = new ArrayList<>();
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

    public void setBooks(List<Book> books) {
        this.books = books;
        notifyDataSetChanged();
    }
}