package com.myapplication.Screens;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.myapplication.R;

import java.util.ArrayList;

public class MyCartActivity extends AppCompatActivity {

    int[] products_images = {R.drawable.i1,R.drawable.i3,R.drawable.i4,R.drawable.i5,R.drawable.i41,R.drawable.i42,R.drawable.i72,R.drawable.i84};
    String[] trade_name = {"Fertilizer","Fertilizer","Fertilizer","Fertilizer","Fertilizer","Fertilizer","Fertilizer","Fertilizer",};

    ArrayList<MyCartModel> myCartModelArrayList;

    RecyclerView _my_cart_recycler;

    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_cart);

        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbar.setNavigationOnClickListener(v -> onBackPressed());

        myCartModelArrayList = new ArrayList<>();
        _my_cart_recycler = findViewById(R.id.my_cart_recycler);

        myCartModelArrayList.clear();
        for (int i = 0;i<products_images.length;i++){
            MyCartModel myCartModel = new MyCartModel(products_images[i],trade_name[i]);
            myCartModelArrayList.add(myCartModel);
        }

        MyCartDataAdapter myCartDataAdapter = new MyCartDataAdapter(MyCartActivity.this,myCartModelArrayList);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(MyCartActivity.this,LinearLayoutManager.VERTICAL,false);
        _my_cart_recycler.setLayoutManager(linearLayoutManager);
        _my_cart_recycler.setAdapter(myCartDataAdapter);
    }
}