package com.myapplication.Screens;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.button.MaterialButton;
import com.myapplication.MainActivity;
import com.myapplication.R;

import java.util.ArrayList;
import java.util.List;

public class Dashboard extends AppCompatActivity {

    ArrayList<ProductModel> productModelArrayList;
    int[] images = {R.drawable.i1,R.drawable.i3,R.drawable.i4,R.drawable.i5,R.drawable.i41,R.drawable.i42,R.drawable.i72,R.drawable.i84};
    String[] name = {"Fertilizer","Fertilizer","Fertilizer","Fertilizer","Fertilizer","Fertilizer","Fertilizer","Fertilizer",};

    RecyclerView product_recycle,new_products_recycle,bulk_deal_recycle;

    MaterialButton all,pesticides,seeds,fertilizers;

    TextView _new_launched_product_view_all;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        productModelArrayList = new ArrayList<>();
        product_recycle = findViewById(R.id.product_recycle);
        new_products_recycle = findViewById(R.id.new_product_recycle);
        bulk_deal_recycle = findViewById(R.id.bulk_deal_recycle);

        all = findViewById(R.id.btnAll);
        pesticides = findViewById(R.id.btnPesti);
        seeds = findViewById(R.id.btnSeed);
        fertilizers = findViewById(R.id.btnFert);

        _new_launched_product_view_all = findViewById(R.id.new_launched_view_all);

        for (int i = 0;i<images.length;i++){
            ProductModel model = new ProductModel(name[i],images[i]);
            productModelArrayList.add(model);
        }

        MyProductAdapter myProductAdapter = new MyProductAdapter(Dashboard.this,productModelArrayList);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(Dashboard.this, LinearLayoutManager.HORIZONTAL, false);
        product_recycle.setLayoutManager(linearLayoutManager);
        product_recycle.setAdapter(myProductAdapter);

        LinearLayoutManager newLinearManager = new LinearLayoutManager(Dashboard.this, LinearLayoutManager.HORIZONTAL, false);
        new_products_recycle.setLayoutManager(newLinearManager);
        new_products_recycle.setAdapter(myProductAdapter);

        LinearLayoutManager bulkDealLinearManager = new LinearLayoutManager(Dashboard.this, LinearLayoutManager.HORIZONTAL, false);
        bulk_deal_recycle.setLayoutManager(bulkDealLinearManager);
        bulk_deal_recycle.setAdapter(myProductAdapter);


        _new_launched_product_view_all.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Dashboard.this,NewLaunchedProducts.class);
                startActivity(intent);
            }
        });

        all.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
/*                all.setStrokeWidth(2);
                pesticides.setStrokeWidth(0);
                seeds.setStrokeWidth(0);
                fertilizers.setStrokeWidth(0);

                Intent intent =new Intent(Dashboard.this, MainActivity.class);
                startActivity(intent);*/
            }
        });

        pesticides.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
/*                all.setStrokeWidth(0);
                pesticides.setStrokeWidth(2);
                seeds.setStrokeWidth(0);
                fertilizers.setStrokeWidth(0);*/
            }
        });

        seeds.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
   /*             all.setStrokeWidth(0);
                pesticides.setStrokeWidth(0);
                seeds.setStrokeWidth(2);
                fertilizers.setStrokeWidth(0);*/
            }
        });

        fertilizers.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
/*                all.setStrokeWidth(0);
                pesticides.setStrokeWidth(0);
                seeds.setStrokeWidth(0);
                fertilizers.setStrokeWidth(2);*/
            }
        });

    }

/*    @Override
    protected void onStart() {
        super.onStart();
        all.setStrokeWidth(0);
        pesticides.setStrokeWidth(0);
        seeds.setStrokeWidth(0);
        fertilizers.setStrokeWidth(0);
    }*/
}