package com.example.user.bookstore;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.squareup.picasso.Picasso;

/**
 * Created by User on 30.6.2017 г..
 */

    public class BooksViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

    private Book mBook;
    private TextView mBookName;
    private TextView mBookPrice;
    private ImageView mBookPicture;

    public BooksViewHolder(View itemView) {
        super(itemView);
        mBookName = itemView.findViewById(R.id.listed_books_book_name);
        mBookPrice = itemView.findViewById(R.id.listed_books_book_price);
        mBookPicture = itemView.findViewById(R.id.listed_books_book_photoURL);
        itemView.setOnClickListener(this);
    }

    public void bindBookItem(Book book) {
        mBook = book;
        mBookName.setText(book.getName());
        mBookPrice.setText(Integer.toString(book.getPrice()) + ",00лв.");
        Picasso.with(itemView.getContext()).load(book.getPictureURL()).into(mBookPicture);
    }

    @Override
    public void onClick(View view) {
        Context context = view.getContext();
        Intent intent = new Intent(context, DetailsBooksActivity.class);
        intent.putExtra("book_id_extra", mBook.getId());
        context.startActivity(intent);
    }
}
