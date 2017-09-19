package com.example.kiragu.maua_chapchap;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.kiragu.maua_chapchap.model.Products;
import java.util.List;

/**
 * Created by gathua on 9/19/17.
 */

public class ProductList extends ArrayAdapter<Products> {
    private Activity context;
    List<Products> products;

    public ProductList(Activity context, List<Products> products) {
        super(context, R.layout.product_list, products);
        this.context = context;
        this.products = products;
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();
        View listViewItem = inflater.inflate(R.layout.product_list, null, true);

        TextView productName = (TextView) listViewItem.findViewById(R.id.productNameTextView);
        TextView description = (TextView) listViewItem.findViewById(R.id.descriptionTextView);
        TextView price = (TextView) listViewItem.findViewById(R.id.priceTextView);


        Products product = products.get(position);
        productName.setText(product.getProduct_name());
        description.setText(product.getDescription());
        price.setText(product.getPrice());



        return listViewItem;
    }

}
