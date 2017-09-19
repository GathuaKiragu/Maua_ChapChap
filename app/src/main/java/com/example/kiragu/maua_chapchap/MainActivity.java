package com.example.kiragu.maua_chapchap;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import com.example.kiragu.maua_chapchap.model.Products;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class MainActivity extends AppCompatActivity {
    DatabaseReference databaseProducts = FirebaseDatabase.getInstance().getReference();
    ListView mListView;
    List<Products> products = new List<Products>() {
        @Override
        public int size() {
            return 0;
        }

        @Override
        public boolean isEmpty() {
            return false;
        }

        @Override
        public boolean contains(Object o) {
            return false;
        }

        @NonNull
        @Override
        public Iterator<Products> iterator() {
            return null;
        }

        @NonNull
        @Override
        public Object[] toArray() {
            return new Object[0];
        }

        @NonNull
        @Override
        public <T> T[] toArray(@NonNull T[] a) {
            return null;
        }

        @Override
        public boolean add(Products products) {
            return false;
        }

        @Override
        public boolean remove(Object o) {
            return false;
        }

        @Override
        public boolean containsAll(@NonNull Collection<?> c) {
            return false;
        }

        @Override
        public boolean addAll(@NonNull Collection<? extends Products> c) {
            return false;
        }

        @Override
        public boolean addAll(int index, @NonNull Collection<? extends Products> c) {
            return false;
        }

        @Override
        public boolean removeAll(@NonNull Collection<?> c) {
            return false;
        }

        @Override
        public boolean retainAll(@NonNull Collection<?> c) {
            return false;
        }

        @Override
        public void clear() {

        }

        @Override
        public Products get(int index) {
            return null;
        }

        @Override
        public Products set(int index, Products element) {
            return null;
        }

        @Override
        public void add(int index, Products element) {

        }

        @Override
        public Products remove(int index) {
            return null;
        }

        @Override
        public int indexOf(Object o) {
            return 0;
        }

        @Override
        public int lastIndexOf(Object o) {
            return 0;
        }

        @Override
        public ListIterator<Products> listIterator() {
            return null;
        }

        @NonNull
        @Override
        public ListIterator<Products> listIterator(int index) {
            return null;
        }

        @NonNull
        @Override
        public List<Products> subList(int fromIndex, int toIndex) {
            return null;
        }
    };




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mListView = (ListView) findViewById(R.id.productListView);
    }

    @Override
    protected void onStart() {
        super.onStart();
        //attaching value event listener
        databaseProducts.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                //clearing the previous artist list
                products.clear();

                //iterating through all the nodes
                for (DataSnapshot postSnapshot : dataSnapshot.getChildren()) {
                    //getting product
                    Products product = postSnapshot.getValue(Products.class);
                    //adding product to the list
                    products.add(product);
                }

                //creating adapter
                ProductList productAdapter = new ProductList(MainActivity.this, products);
                //attaching adapter to the listview
                mListView.setAdapter(productAdapter);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
            }
        });
    }
}
