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
 * Created by User on 28.6.2017 г..
 */

public class ListedStoresActivity extends Activity{

    private RecyclerView mRecyclerView;
    private StoreAdapter mStoreAdaptor;
    private RecyclerView.LayoutManager mLayoutManager;
    private ArrayList<Store> stores = new ArrayList<Store>();

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

}
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
    @Override
    public void onClick(View view) {
        //TODO Implement!
    }
}



class StoreAdapter extends RecyclerView.Adapter<StoreViewHolder>{

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