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


public class StoreAdapter extends RecyclerView.Adapter<StoreViewHolder>{

    List<Store> stores;

    public StoreAdapter() {this.stores = new ArrayList<>();}
    public StoreAdapter(List<Store> stores) {
        this.stores = stores;
    }

    @Override
    public StoreViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_item_store, parent, false);

        return new StoreViewHolder(view);

    }

    @Override
    public void onBindViewHolder(StoreViewHolder holder, int position) {
        holder.bindStoreItem(stores.get(position));
    }

    @Override
    public int getItemCount() {
        return stores.size();
    }

    public void setStores(List<Store> stores){
        this.stores = stores;
        notifyDataSetChanged();
    }
}
