package com.myapplication.Screens;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.ImageView;

import com.myapplication.R;

import java.util.ArrayList;
import java.util.Objects;

public class SupplierDetailsActivity extends AppCompatActivity {

    ArrayList<ProductModel> productModelArrayList;
    int[] images = {R.drawable.company_logo,R.drawable.company_logo,R.drawable.company_logo,R.drawable.company_logo,R.drawable.company_logo,R.drawable.company_logo,R.drawable.company_logo,R.drawable.company_logo};
    String[] name = {"Fertilizer","Fertilizer","Fertilizer","Fertilizer","Fertilizer","Fertilizer","Fertilizer","Fertilizer",};

    RecyclerView supplier_details;

    Toolbar toolbar;

    ImageView imgSupplier;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_supplier_details);

        toolbar = findViewById(R.id.toolbar);
        imgSupplier = findViewById(R.id.imgSupplier);
        setSupportActionBar(toolbar);

        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);
        toolbar.setNavigationOnClickListener(v -> onBackPressed());

        supplier_details = findViewById(R.id.recycle_supplier_details);

        productModelArrayList = new ArrayList<>();

        for (int i = 0;i<images.length;i++){
            ProductModel model = new ProductModel(name[i],images[i]);
            productModelArrayList.add(model);
        }

        imgSupplier.setOnClickListener(v -> {
            startActivity(new Intent(Intent.CATEGORY_APP_GALLERY, Uri.parse("https://images.unsplash.com/photo-1524492412937-b28074a5d7da?ixid=MnwxMjA3fDB8MHxzZWFyY2h8MXx8aW5kaWF8ZW58MHx8MHx8&ixlib=rb-1.2.1&w=1000&q=80")));
        });



        MySupplierAdapter mySupplierAdapter = new MySupplierAdapter(SupplierDetailsActivity.this,productModelArrayList);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(SupplierDetailsActivity.this, LinearLayoutManager.VERTICAL, false);
        supplier_details.setLayoutManager(linearLayoutManager);
        supplier_details.setAdapter(mySupplierAdapter);
    }
}