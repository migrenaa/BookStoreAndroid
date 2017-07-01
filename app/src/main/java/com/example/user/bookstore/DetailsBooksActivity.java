package com.example.user.bookstore;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.ImageView;
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
    TextView mBookRating;
    TextView mBookPrice;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.details_item_book);
        RetrofitService services = new RetrofitService();
        mBookName = (TextView) findViewById(R.id.details_book_name);
        mBookAuthor = (TextView) findViewById(R.id.details_book_author);
        mBookDescription = (TextView) findViewById(R.id.details_book_description);
        mBookRating = (TextView) findViewById(R.id.details_book_rating);
        mBookPrice = (TextView) findViewById(R.id.details_book_price);
        mBookPicture = (ImageView) findViewById(R.id.details_book_photo);

        id = getIntent().getIntExtra("book_id_extra", 0);

        services.getSingleBook(id, new RetrofitService.OnSingleBookReceivedListener() {
            @Override
            public void onSingleBookReceived(Book book) {
                mBookName.setText(book.getName());
                mBookAuthor.setText(book.getAuthor());
                mBookDescription.setText(book.getDescription());
                mBookPrice.setText(Integer.toString(book.getPrice()));
                mBookRating.setText(Integer.toString(book.getRating()));
                Picasso.with(DetailsBooksActivity.this).load(book.getPictureURL()).into(mBookPicture);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.options_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.stores:
                startActivity(new Intent(this, ListedStoresActivity.class));
                return true;
            case R.id.books:
                startActivity(new Intent(this, ListedBooksActivity.class));
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
