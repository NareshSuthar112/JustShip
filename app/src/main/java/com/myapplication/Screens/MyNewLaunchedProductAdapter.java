package com.myapplication.Screens;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.cardview.widget.CardView;

import com.myapplication.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class MyNewLaunchedProductAdapter extends BaseAdapter {
    Context context;
    ArrayList<ProductModel> productModelArrayList;

    public MyNewLaunchedProductAdapter(Context context, ArrayList<ProductModel> productModelArrayList) {
        this.context = context;
        this.productModelArrayList = productModelArrayList;
    }

    @Override
    public int getCount() {
        return productModelArrayList.size();
    }

    @Override
    public Object getItem(int position) {
        return productModelArrayList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @SuppressLint("ViewHolder")
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        convertView = LayoutInflater.from(context).inflate(R.layout.raw_new_product,parent,false);

        ImageView _product_image;
        TextView _trade_name;
        TextView _technical_name;
        CardView products_card;

        _product_image = convertView.findViewById(R.id.product_image);
        _trade_name = convertView.findViewById(R.id.trade_name);
        _technical_name = convertView.findViewById(R.id.technical_name);
        products_card = convertView.findViewById(R.id.product_card);

        Picasso.get().load(productModelArrayList.get(position).getStoryUrl()).into(_product_image);
        _trade_name.setText(productModelArrayList.get(position).getName());
        _technical_name.setText(productModelArrayList.get(position).getName());

        products_card.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context,SupplierDetailsActivity.class);
                context.startActivity(intent);
            }
        });

        return convertView;
    }
}
