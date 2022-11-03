package com.myapplication.Screens;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;

import com.myapplication.R;

import java.util.ArrayList;

public class PlaceOrderActivity extends AppCompatActivity {

    String[] order_id = {"Order#201","Order#202","Order#203","Order#204","Order#205","Order#206"};
    String[] company_name ={"Gujarat Pesticides","Gujarat Pesticides","Gujarat Pesticides","Gujarat Pesticides","Gujarat Pesticides","Gujarat Pesticides"};

    ArrayList<MyCompanyModel> myCompanyModelArrayList;

    RecyclerView _place_order_company_data;

    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_place_order);

        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        _place_order_company_data = findViewById(R.id.place_order_company_data);
        myCompanyModelArrayList = new ArrayList<>();

        myCompanyModelArrayList.clear();
        for (int i = 0;i<order_id.length;i++){
            MyCompanyModel myCompanyModel = new MyCompanyModel(order_id[i],company_name[i]);
            myCompanyModelArrayList.add(myCompanyModel);
        }

        MyCompanyPlaceOrderAdapter myCompanyPlaceOrderAdapter = new MyCompanyPlaceOrderAdapter(PlaceOrderActivity.this,myCompanyModelArrayList);
        LinearLayoutManager companyLinear = new LinearLayoutManager(PlaceOrderActivity.this, LinearLayoutManager.VERTICAL, false);
        _place_order_company_data.setLayoutManager(companyLinear);
        _place_order_company_data.setAdapter(myCompanyPlaceOrderAdapter);

    }
}