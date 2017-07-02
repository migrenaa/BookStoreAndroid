package com.example.user.bookstore;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

/**
 * Created by User on 29.6.2017 г..
 */

public class DetailsBooksActivity extends AppCompatActivity {

    int id;
    TextView mBookName;
    TextView mBookAuthor;
    TextView mBookDescription;
    ImageView mBookPicture;
    RatingBar mBookRating;
    TextView mBookPrice;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.details_item_book);
        RetrofitService services = new RetrofitService();
        mBookName = (TextView) findViewById(R.id.details_book_name);
        mBookAuthor = (TextView) findViewById(R.id.details_book_author);
        mBookDescription = (TextView) findViewById(R.id.details_book_description);
        mBookRating = (RatingBar) findViewById(R.id.details_book_rating);
        mBookPrice = (TextView) findViewById(R.id.details_book_price);
        mBookPicture = (ImageView) findViewById(R.id.details_book_photo);
        mBookRating.setNumStars(5);

        id = getIntent().getIntExtra("book_id_extra", 0);

        services.getSingleBook(id, new RetrofitService.OnSingleBookReceivedListener() {
            @Override
            public void onSingleBookReceived(Book book) {
                mBookName.setText(book.getName());
                mBookAuthor.setText(book.getAuthor());
                mBookDescription.setText(book.getDescription());
                mBookPrice.setText(Integer.toString(book.getPrice()) + ",00лв.");
                mBookRating.setRating(book.getRating());
                Picasso.with(DetailsBooksActivity.this).load(book.getPictureURL()).into(mBookPicture);
            }
        });
    }
}
