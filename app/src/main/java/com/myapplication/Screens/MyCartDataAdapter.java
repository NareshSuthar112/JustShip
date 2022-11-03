package com.myapplication.Screens;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.myapplication.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class MyCartDataAdapter extends RecyclerView.Adapter<MyCartDataAdapter.MyViewHolder> {
    Context context;
    ArrayList<MyCartModel> myCartModelArrayList;

    public MyCartDataAdapter(Context context, ArrayList<MyCartModel> myCartModelArrayList) {
        this.context = context;
        this.myCartModelArrayList = myCartModelArrayList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.raw_my_cart_data,parent,false);

        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        Picasso.get().load(myCartModelArrayList.get(position).products_images).into(holder.product_image);
        holder.trade_name.setText(myCartModelArrayList.get(position).trade_name);
        holder.technical_name.setText(myCartModelArrayList.get(position).trade_name);
        holder.product_qty.setText(String.valueOf(20));
        holder.product_price.setText(String.valueOf(12000));
    }

    @Override
    public int getItemCount() {
        return myCartModelArrayList.size();
    }


    public static class MyViewHolder extends RecyclerView.ViewHolder {

        ImageView product_image;
        TextView trade_name,technical_name,product_qty,product_price;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            product_image = itemView.findViewById(R.id.cart_product_img);
            trade_name = itemView.findViewById(R.id.trade_name);
            technical_name = itemView.findViewById(R.id.technical_name);
            product_qty = itemView.findViewById(R.id.product_qty);
            product_price = itemView.findViewById(R.id.product_price);
        }
    }
}
