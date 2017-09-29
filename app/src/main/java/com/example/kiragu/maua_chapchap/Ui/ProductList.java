package com.example.kiragu.maua_chapchap.Ui;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.kiragu.maua_chapchap.R;
import com.example.kiragu.maua_chapchap.ViewHolders.FirebaseProductsViewHolder;
import com.example.kiragu.maua_chapchap.model.Products;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import butterknife.Bind;
import butterknife.ButterKnife;
/**
 * Created by gathua on 9/19/17.
 */

public class ProductList extends AppCompatActivity{
    private DatabaseReference mProductReference;
    private FirebaseRecyclerAdapter mFirebaseAdapter;

    @Bind(R.id.recyclerView) RecyclerView mRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.product_list_activity);
        ButterKnife.bind(this);

          mProductReference = FirebaseDatabase.getInstance().getReference("products");
//        Query mQuery = mProductReference.orderByChild("timestamp");
        setUpFirebaseAdapter();
    }


    /**
        Setting up FirebaseAdapter
     */

    private void setUpFirebaseAdapter() {
        mFirebaseAdapter = new FirebaseRecyclerAdapter<Products, FirebaseProductsViewHolder>
                (Products.class, R.layout.product_list_item, FirebaseProductsViewHolder.class,
                        mProductReference) {


// Calling the bindProduct method from the FirebaseProductsViewHolder
            @Override
            protected void populateViewHolder(FirebaseProductsViewHolder viewHolder,
                                              Products model, int position) {
                viewHolder.bindProduct(model);
            }
        };

        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));

//        Setting adapter to the recyclerview
        mRecyclerView.setAdapter(mFirebaseAdapter);
    }


//Cleaning up the adapter once the activity is destroyed
    @Override
    protected void onDestroy() {
        super.onDestroy();
        mFirebaseAdapter.cleanup();
    }

}
