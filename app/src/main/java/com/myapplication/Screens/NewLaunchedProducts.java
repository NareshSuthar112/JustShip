package com.myapplication.Screens;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.content.ContextCompat;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.AbsListView;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.google.android.material.button.MaterialButton;
import com.myapplication.R;

import java.util.ArrayList;

import butterknife.BindView;

public class NewLaunchedProducts extends AppCompatActivity {


    ArrayList<ProductModel> productModelArrayList;
    int[] images = {R.drawable.i1,R.drawable.i3,R.drawable.i4,R.drawable.i5,R.drawable.i41,R.drawable.i42,R.drawable.i72,R.drawable.i84};
    String[] name = {"Fertilizer","Fertilizer","Fertilizer","Fertilizer","Fertilizer","Fertilizer","Fertilizer","Fertilizer",};

    ImageView _img_all,_img_pesti,_img_seeds,_img_fert,_img_sub_all,_img_insect,_img_fungi,_img_herbi;

    MaterialButton all,pesticides,seeds,fertilizers,sub_all,insecticides,fungicides,herbicides;

    GridView _product_grid_data;

    LinearLayout linear_products,linear_sub_products;

    Toolbar toolbar;

    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_launched_products);

        all=findViewById(R.id.btnAll);
        pesticides=findViewById(R.id.btnPesti);
        seeds=findViewById(R.id.btnSeed);
        fertilizers=findViewById(R.id.btnFert);
        sub_all=findViewById(R.id.btnSubAll);
        insecticides=findViewById(R.id.btnInsect);
        fungicides=findViewById(R.id.btnFungi);
        herbicides=findViewById(R.id.btnHerbi);

        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        _img_all=findViewById(R.id.imgAll);
        _img_pesti=findViewById(R.id.imgPesti);
        _img_seeds=findViewById(R.id.imgSeed);
        _img_fert=findViewById(R.id.imgFert);
        _img_sub_all=findViewById(R.id.imgSubAll);
        _img_insect=findViewById(R.id.imgInsect);
        _img_fungi=findViewById(R.id.imgFungi);
        _img_herbi=findViewById(R.id.imgHerbi);

        linear_products = findViewById(R.id.linear_products);
        linear_sub_products = findViewById(R.id.linear_sub_products);

        _product_grid_data = findViewById(R.id.product_grid_data);

        productModelArrayList = new ArrayList<>();


        all.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                _img_all.setVisibility(View.VISIBLE);
                _img_pesti.setVisibility(View.GONE);
                _img_seeds.setVisibility(View.GONE);
                _img_fert.setVisibility(View.GONE);
                _img_sub_all.setVisibility(View.VISIBLE);
                _img_insect.setVisibility(View.GONE);
                _img_fungi.setVisibility(View.GONE);
                _img_herbi.setVisibility(View.GONE);


                all.setBackgroundColor(ContextCompat.getColor(NewLaunchedProducts.this,R.color.background));
                pesticides.setBackgroundColor(ContextCompat.getColor(NewLaunchedProducts.this,R.color.white));
                seeds.setBackgroundColor(ContextCompat.getColor(NewLaunchedProducts.this,R.color.white));
                fertilizers.setBackgroundColor(ContextCompat.getColor(NewLaunchedProducts.this,R.color.white));

                sub_all.setBackgroundColor(ContextCompat.getColor(NewLaunchedProducts.this,R.color.background));
                insecticides.setBackgroundColor(ContextCompat.getColor(NewLaunchedProducts.this,R.color.white));
                fungicides.setBackgroundColor(ContextCompat.getColor(NewLaunchedProducts.this,R.color.white));
                herbicides.setBackgroundColor(ContextCompat.getColor(NewLaunchedProducts.this,R.color.white));

                all.setTextColor(ContextCompat.getColor(NewLaunchedProducts.this,R.color.white));
                pesticides.setTextColor(ContextCompat.getColor(NewLaunchedProducts.this,R.color.background));
                seeds.setTextColor(ContextCompat.getColor(NewLaunchedProducts.this,R.color.background));
                fertilizers.setTextColor(ContextCompat.getColor(NewLaunchedProducts.this,R.color.background));

                sub_all.setTextColor(ContextCompat.getColor(NewLaunchedProducts.this,R.color.white));
                insecticides.setTextColor(ContextCompat.getColor(NewLaunchedProducts.this,R.color.background));
                fungicides.setTextColor(ContextCompat.getColor(NewLaunchedProducts.this,R.color.background));
                herbicides.setTextColor(ContextCompat.getColor(NewLaunchedProducts.this,R.color.background));
            }
        });

        pesticides.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                _img_all.setVisibility(View.GONE);
                _img_pesti.setVisibility(View.VISIBLE);
                _img_seeds.setVisibility(View.GONE);
                _img_fert.setVisibility(View.GONE);
                _img_sub_all.setVisibility(View.VISIBLE);
                _img_insect.setVisibility(View.GONE);
                _img_fungi.setVisibility(View.GONE);
                _img_herbi.setVisibility(View.GONE);

                all.setBackgroundColor(ContextCompat.getColor(NewLaunchedProducts.this,R.color.white));
                pesticides.setBackgroundColor(ContextCompat.getColor(NewLaunchedProducts.this,R.color.background));
                seeds.setBackgroundColor(ContextCompat.getColor(NewLaunchedProducts.this,R.color.white));
                fertilizers.setBackgroundColor(ContextCompat.getColor(NewLaunchedProducts.this,R.color.white));

                sub_all.setBackgroundColor(ContextCompat.getColor(NewLaunchedProducts.this,R.color.background));
                insecticides.setBackgroundColor(ContextCompat.getColor(NewLaunchedProducts.this,R.color.white));
                fungicides.setBackgroundColor(ContextCompat.getColor(NewLaunchedProducts.this,R.color.white));
                herbicides.setBackgroundColor(ContextCompat.getColor(NewLaunchedProducts.this,R.color.white));

                all.setTextColor(ContextCompat.getColor(NewLaunchedProducts.this,R.color.background));
                pesticides.setTextColor(ContextCompat.getColor(NewLaunchedProducts.this,R.color.white));
                seeds.setTextColor(ContextCompat.getColor(NewLaunchedProducts.this,R.color.background));
                fertilizers.setTextColor(ContextCompat.getColor(NewLaunchedProducts.this,R.color.background));

                sub_all.setTextColor(ContextCompat.getColor(NewLaunchedProducts.this,R.color.white));
                insecticides.setTextColor(ContextCompat.getColor(NewLaunchedProducts.this,R.color.background));
                fungicides.setTextColor(ContextCompat.getColor(NewLaunchedProducts.this,R.color.background));
                herbicides.setTextColor(ContextCompat.getColor(NewLaunchedProducts.this,R.color.background));
            }
        });

        seeds.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                _img_all.setVisibility(View.GONE);
                _img_pesti.setVisibility(View.GONE);
                _img_seeds.setVisibility(View.VISIBLE);
                _img_fert.setVisibility(View.GONE);
                _img_sub_all.setVisibility(View.VISIBLE);
                _img_insect.setVisibility(View.GONE);
                _img_fungi.setVisibility(View.GONE);
                _img_herbi.setVisibility(View.GONE);

                all.setBackgroundColor(ContextCompat.getColor(NewLaunchedProducts.this,R.color.white));
                pesticides.setBackgroundColor(ContextCompat.getColor(NewLaunchedProducts.this,R.color.white));
                seeds.setBackgroundColor(ContextCompat.getColor(NewLaunchedProducts.this,R.color.background));
                fertilizers.setBackgroundColor(ContextCompat.getColor(NewLaunchedProducts.this,R.color.white));

                sub_all.setBackgroundColor(ContextCompat.getColor(NewLaunchedProducts.this,R.color.background));
                insecticides.setBackgroundColor(ContextCompat.getColor(NewLaunchedProducts.this,R.color.white));
                fungicides.setBackgroundColor(ContextCompat.getColor(NewLaunchedProducts.this,R.color.white));
                herbicides.setBackgroundColor(ContextCompat.getColor(NewLaunchedProducts.this,R.color.white));

                all.setTextColor(ContextCompat.getColor(NewLaunchedProducts.this,R.color.background));
                pesticides.setTextColor(ContextCompat.getColor(NewLaunchedProducts.this,R.color.background));
                seeds.setTextColor(ContextCompat.getColor(NewLaunchedProducts.this,R.color.white));
                fertilizers.setTextColor(ContextCompat.getColor(NewLaunchedProducts.this,R.color.background));

                sub_all.setTextColor(ContextCompat.getColor(NewLaunchedProducts.this,R.color.white));
                insecticides.setTextColor(ContextCompat.getColor(NewLaunchedProducts.this,R.color.background));
                fungicides.setTextColor(ContextCompat.getColor(NewLaunchedProducts.this,R.color.background));
                herbicides.setTextColor(ContextCompat.getColor(NewLaunchedProducts.this,R.color.background));
            }
        });

        fertilizers.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                _img_all.setVisibility(View.GONE);
                _img_pesti.setVisibility(View.GONE);
                _img_seeds.setVisibility(View.GONE);
                _img_fert.setVisibility(View.VISIBLE);
                _img_sub_all.setVisibility(View.VISIBLE);
                _img_insect.setVisibility(View.GONE);
                _img_fungi.setVisibility(View.GONE);
                _img_herbi.setVisibility(View.GONE);

                all.setBackgroundColor(ContextCompat.getColor(NewLaunchedProducts.this,R.color.white));
                pesticides.setBackgroundColor(ContextCompat.getColor(NewLaunchedProducts.this,R.color.white));
                seeds.setBackgroundColor(ContextCompat.getColor(NewLaunchedProducts.this,R.color.white));
                fertilizers.setBackgroundColor(ContextCompat.getColor(NewLaunchedProducts.this,R.color.background));

                sub_all.setBackgroundColor(ContextCompat.getColor(NewLaunchedProducts.this,R.color.background));
                insecticides.setBackgroundColor(ContextCompat.getColor(NewLaunchedProducts.this,R.color.white));
                fungicides.setBackgroundColor(ContextCompat.getColor(NewLaunchedProducts.this,R.color.white));
                herbicides.setBackgroundColor(ContextCompat.getColor(NewLaunchedProducts.this,R.color.white));

                all.setTextColor(ContextCompat.getColor(NewLaunchedProducts.this,R.color.background));
                pesticides.setTextColor(ContextCompat.getColor(NewLaunchedProducts.this,R.color.background));
                seeds.setTextColor(ContextCompat.getColor(NewLaunchedProducts.this,R.color.background));
                fertilizers.setTextColor(ContextCompat.getColor(NewLaunchedProducts.this,R.color.white));

                sub_all.setTextColor(ContextCompat.getColor(NewLaunchedProducts.this,R.color.white));
                insecticides.setTextColor(ContextCompat.getColor(NewLaunchedProducts.this,R.color.background));
                fungicides.setTextColor(ContextCompat.getColor(NewLaunchedProducts.this,R.color.background));
                herbicides.setTextColor(ContextCompat.getColor(NewLaunchedProducts.this,R.color.background));
            }
        });

        sub_all.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                _img_sub_all.setVisibility(View.VISIBLE);
                _img_insect.setVisibility(View.GONE);
                _img_fungi.setVisibility(View.GONE);
                _img_herbi.setVisibility(View.GONE);

                sub_all.setBackgroundColor(ContextCompat.getColor(NewLaunchedProducts.this,R.color.background));
                insecticides.setBackgroundColor(ContextCompat.getColor(NewLaunchedProducts.this,R.color.white));
                fungicides.setBackgroundColor(ContextCompat.getColor(NewLaunchedProducts.this,R.color.white));
                herbicides.setBackgroundColor(ContextCompat.getColor(NewLaunchedProducts.this,R.color.white));

                sub_all.setTextColor(ContextCompat.getColor(NewLaunchedProducts.this,R.color.white));
                insecticides.setTextColor(ContextCompat.getColor(NewLaunchedProducts.this,R.color.background));
                fungicides.setTextColor(ContextCompat.getColor(NewLaunchedProducts.this,R.color.background));
                herbicides.setTextColor(ContextCompat.getColor(NewLaunchedProducts.this,R.color.background));

            }
        });

        insecticides.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                _img_sub_all.setVisibility(View.GONE);
                _img_insect.setVisibility(View.VISIBLE);
                _img_fungi.setVisibility(View.GONE);
                _img_herbi.setVisibility(View.GONE);

                sub_all.setBackgroundColor(ContextCompat.getColor(NewLaunchedProducts.this,R.color.white));
                insecticides.setBackgroundColor(ContextCompat.getColor(NewLaunchedProducts.this,R.color.background));
                fungicides.setBackgroundColor(ContextCompat.getColor(NewLaunchedProducts.this,R.color.white));
                herbicides.setBackgroundColor(ContextCompat.getColor(NewLaunchedProducts.this,R.color.white));

                sub_all.setTextColor(ContextCompat.getColor(NewLaunchedProducts.this,R.color.background));
                insecticides.setTextColor(ContextCompat.getColor(NewLaunchedProducts.this,R.color.white));
                fungicides.setTextColor(ContextCompat.getColor(NewLaunchedProducts.this,R.color.background));
                herbicides.setTextColor(ContextCompat.getColor(NewLaunchedProducts.this,R.color.background));

            }
        });

        fungicides.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                _img_sub_all.setVisibility(View.GONE);
                _img_insect.setVisibility(View.GONE);
                _img_fungi.setVisibility(View.VISIBLE);
                _img_herbi.setVisibility(View.GONE);

                sub_all.setBackgroundColor(ContextCompat.getColor(NewLaunchedProducts.this,R.color.white));
                insecticides.setBackgroundColor(ContextCompat.getColor(NewLaunchedProducts.this,R.color.white));
                fungicides.setBackgroundColor(ContextCompat.getColor(NewLaunchedProducts.this,R.color.background));
                herbicides.setBackgroundColor(ContextCompat.getColor(NewLaunchedProducts.this,R.color.white));

                sub_all.setTextColor(ContextCompat.getColor(NewLaunchedProducts.this,R.color.background));
                insecticides.setTextColor(ContextCompat.getColor(NewLaunchedProducts.this,R.color.background));
                fungicides.setTextColor(ContextCompat.getColor(NewLaunchedProducts.this,R.color.white));
                herbicides.setTextColor(ContextCompat.getColor(NewLaunchedProducts.this,R.color.background));
            }
        });

        herbicides.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                _img_sub_all.setVisibility(View.GONE);
                _img_insect.setVisibility(View.GONE);
                _img_fungi.setVisibility(View.GONE);
                _img_herbi.setVisibility(View.VISIBLE);

                sub_all.setBackgroundColor(ContextCompat.getColor(NewLaunchedProducts.this,R.color.white));
                insecticides.setBackgroundColor(ContextCompat.getColor(NewLaunchedProducts.this,R.color.white));
                fungicides.setBackgroundColor(ContextCompat.getColor(NewLaunchedProducts.this,R.color.white));
                herbicides.setBackgroundColor(ContextCompat.getColor(NewLaunchedProducts.this,R.color.background));

                sub_all.setTextColor(ContextCompat.getColor(NewLaunchedProducts.this,R.color.background));
                insecticides.setTextColor(ContextCompat.getColor(NewLaunchedProducts.this,R.color.background));
                fungicides.setTextColor(ContextCompat.getColor(NewLaunchedProducts.this,R.color.background));
                herbicides.setTextColor(ContextCompat.getColor(NewLaunchedProducts.this,R.color.white));
            }
        });

        for (int i = 0;i<images.length;i++){
            ProductModel model = new ProductModel(name[i],images[i]);
            productModelArrayList.add(model);
        }

        MyNewLaunchedProductAdapter myNewLaunchedProductAdapter = new MyNewLaunchedProductAdapter(NewLaunchedProducts.this,productModelArrayList);
        _product_grid_data.setAdapter(myNewLaunchedProductAdapter);

    }

}