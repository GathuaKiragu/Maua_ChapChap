package com.example.kiragu.maua_chapchap;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.example.kiragu.maua_chapchap.ViewHolders.FirebaseProductsViewHolder;
import com.example.kiragu.maua_chapchap.model.Products;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import org.parceler.Parcels;

import java.util.ArrayList;

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
        setUpFirebaseAdapter();
    }

    private void setUpFirebaseAdapter() {
        mFirebaseAdapter = new FirebaseRecyclerAdapter<Products, FirebaseProductsViewHolder>
                (Products.class, R.layout.product_list_item, FirebaseProductsViewHolder.class,
                        mProductReference) {

            @Override
            protected void populateViewHolder(FirebaseProductsViewHolder viewHolder,
                                              Products model, int position) {
                viewHolder.bindProduct(model);
            }
        };
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mRecyclerView.setAdapter(mFirebaseAdapter);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mFirebaseAdapter.cleanup();
    }

}
