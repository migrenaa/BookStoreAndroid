package com.example.user.bookstore;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

/**
 * Created by User on 30.6.2017 г..
 */


class StoreViewHolder extends RecyclerView.ViewHolder implements  View.OnClickListener{

    private Store mStore;
    private TextView mStoreName;

    public StoreViewHolder(View itemView) {
        super(itemView);
        mStoreName = itemView.findViewById(R.id.listed_stores_store_name);
    }

    public void bindStoreItem(Store store){
        mStore = store;
        mStoreName.setText(store.getName());
    }

    //TODO how to reuse listedbooksactivity
    @Override
    public void onClick(View view) {
        Context context = view.getContext();
        Intent intent = new Intent(context, DetailsBooksActivity.class);
        intent.putExtra("store_id_extra", mStore.getId());
        context.startActivity(intent);
    }
}