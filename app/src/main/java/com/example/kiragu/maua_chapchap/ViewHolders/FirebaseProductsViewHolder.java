package com.example.kiragu.maua_chapchap.ViewHolders;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.kiragu.maua_chapchap.R;
import com.example.kiragu.maua_chapchap.model.Products;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.squareup.picasso.Picasso;

/**
 * Created by gathua on 9/25/17.
 */

public class FirebaseProductsViewHolder extends RecyclerView.ViewHolder {
    private static final int MAX_WIDTH = 200;
    private static final int MAX_HEIGHT = 200;
    View mView;
    Context mContext;

    public FirebaseProductsViewHolder(View itemView) {
        super(itemView);
        mView = itemView;
        mContext = itemView.getContext();
    }

    public void bindProduct(Products products) {
        ImageView productimage = (ImageView) mView.findViewById(R.id.imageView);
        TextView productName = (TextView) mView.findViewById(R.id.productNameTextView);
        TextView priceTag = (TextView) mView.findViewById(R.id.priceTextView);
        TextView productDescription = (TextView) mView.findViewById(R.id.descriptionTextView);

        Picasso.with(mContext)
                .load(products.getImage())
                .resize(MAX_WIDTH, MAX_HEIGHT)
                .centerCrop()
                .into(productimage);

        productName.setText(products.getProduct_name());
        productDescription.setText(products.getDescription());
        Integer price = products.getPrice();
        priceTag.setText(price.toString());
    }
}
