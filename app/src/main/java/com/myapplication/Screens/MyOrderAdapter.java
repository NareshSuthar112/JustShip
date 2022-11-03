package com.myapplication.Screens;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.myapplication.R;

import java.util.ArrayList;

public class MyOrderAdapter extends BaseAdapter {
    Context context;
    ArrayList<OrderDetailModel> orderDetailModelArrayList;
    public MyOrderAdapter(Context context, ArrayList<OrderDetailModel> orderDetailModelArrayList) {
        this.context = context;
        this.orderDetailModelArrayList = orderDetailModelArrayList;
    }

    @Override
    public int getCount() {
        return orderDetailModelArrayList.size();
    }

    @Override
    public Object getItem(int position) {
        return orderDetailModelArrayList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        convertView = LayoutInflater.from(context).inflate(R.layout.raw_ask_price_details,parent,false);

        TextView size = convertView.findViewById(R.id.size);
        TextView box_size = convertView.findViewById(R.id.box_size);
        TextView price = convertView.findViewById(R.id.price);

        size.setText(orderDetailModelArrayList.get(position).getSize());
        box_size.setText(orderDetailModelArrayList.get(position).getBox_size());
        price.setText(orderDetailModelArrayList.get(position).getPrice());

        return convertView;
    }
}
