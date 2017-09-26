package com.example.kiragu.maua_chapchap.Ui;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import com.example.kiragu.maua_chapchap.R;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;


public class MainActivity extends AppCompatActivity {
    ListView mListView;
    private ValueEventListener productsListener;
    private DatabaseReference mProductsList;
//    @BindView(R.id.button2)
//    Button mButton;
private Button mButton;



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //  Firebase
        mProductsList = FirebaseDatabase
                .getInstance()
                .getReference()
                .child("products");


        productsListener = mProductsList.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for (DataSnapshot productSnapshot :dataSnapshot.getChildren()) {
                    String product = productSnapshot.getValue().toString();
                    Log.d("Products Available", "Products: " + product);
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
        mButton = (Button) findViewById(R.id.button2);

        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ProductList.class);
                startActivity(intent);
            }
        });
    }
//Removing listener when the user quits from the activity
    @Override
    protected void onDestroy() {
        super.onDestroy();
        mProductsList.removeEventListener(productsListener);
    }
}
