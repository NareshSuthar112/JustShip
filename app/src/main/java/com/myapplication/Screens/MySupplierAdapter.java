package com.myapplication.Screens;

import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.button.MaterialButton;
import com.myapplication.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class MySupplierAdapter extends RecyclerView.Adapter<MySupplierAdapter.MyViewHolder> {
    Context context;
    ArrayList<ProductModel> productModelArrayList;
    public MySupplierAdapter(Context context, ArrayList<ProductModel> productModelArrayList) {
        this.context = context;
        this.productModelArrayList = productModelArrayList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.raw_supplier_details,parent,false);

        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        Picasso.get().load(productModelArrayList.get(position).getStoryUrl()).into(holder.images);

        holder.orderDetailModelArrayList = new ArrayList<>();

        for (int i = 0;i<holder.size.length;i++)
        {
            OrderDetailModel orderDetailModel = new OrderDetailModel(holder.size[i],holder.box_size[i],holder.price[i]);
            holder.orderDetailModelArrayList.add(orderDetailModel);
        }

        MyOrderAdapter myOrderAdapter = new MyOrderAdapter(context,holder.orderDetailModelArrayList);
        holder.listData.setAdapter(myOrderAdapter);

        holder.ask_price.setOnClickListener(v -> {

            holder.layoutText.setVisibility(View.VISIBLE);

            holder.order.setVisibility(View.VISIBLE);
            holder.ask_price.setVisibility(View.GONE);
        });

        holder.order.setOnClickListener(v -> {
            holder.layoutText.setVisibility(View.GONE);

            holder.order.setVisibility(View.GONE);
            holder.ask_price.setVisibility(View.VISIBLE);
            Intent intent = new Intent(context,OrderDetailsActivity.class);
            context.startActivity(intent);
        });

        setListViewHeightBasedOnChildren(holder.listData,myOrderAdapter);


        holder.view_bulk_deal.setOnClickListener(v -> showDialog());
    }

    private void showDialog() {

        MaterialButton cancel;
        //Discount details recycler

        RecyclerView discount_details_recycler;

        String[] range = {"10ltr to 50ltr","51ltr to 60ltr","61ltr to 70ltr"};
        String[] price = {"10(₹)/ltr","10(₹)/ltr","10(₹)/ltr"};
        ArrayList<BulkViewDiscountModel> bulkViewDiscountModelArrayList;

        //Packing details recycler

        RecyclerView bulk_deal_recycler;
        int[] packing = {1,500,250};
        int[] amount = {1000,500,250};
        ArrayList<BulkViewDataModel> bulkViewDataModelArrayList;

        LayoutInflater inflater = LayoutInflater.from(context);
        final View view = inflater.inflate(R.layout.raw_view_bulk_deal, null);
        AlertDialog alertDialog = new AlertDialog.Builder(context).create();
        alertDialog.setView(view);
        alertDialog.getWindow().getAttributes().windowAnimations = R.style.DialogAnimation;
        alertDialog.show();
        alertDialog.setCanceledOnTouchOutside(false);
        bulkViewDataModelArrayList = new ArrayList<>();
        bulkViewDiscountModelArrayList = new ArrayList<>();

        //find id

        bulk_deal_recycler = view.findViewById(R.id.view_bulk_deal_recycler);
        discount_details_recycler = view.findViewById(R.id.discount_qty_range_recycler);
        cancel = view.findViewById(R.id.btnCancel);

        //set data of Packing details recycler

        for (int i = 0; i<packing.length;i++){
            BulkViewDataModel bulkViewDataModel = new BulkViewDataModel(packing[i],amount[i]);
            bulkViewDataModelArrayList.add(bulkViewDataModel);
        }

        BulkViewAdapter bulkViewAdapter = new BulkViewAdapter(context,bulkViewDataModelArrayList);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(context,LinearLayoutManager.VERTICAL,false);
        bulk_deal_recycler.setLayoutManager(linearLayoutManager);
        bulk_deal_recycler.setAdapter(bulkViewAdapter);

        //set data of Discount details recycler

        for (int i=0;i<price.length;i++){
            BulkViewDiscountModel bulkViewDiscountModel = new BulkViewDiscountModel(range[i],price[i]);
            bulkViewDiscountModelArrayList.add(bulkViewDiscountModel);

        }
        BulkViewDiscountAdapter bulkViewDiscountAdapter = new BulkViewDiscountAdapter(context,bulkViewDiscountModelArrayList);
        LinearLayoutManager bulkLinear = new LinearLayoutManager(context,LinearLayoutManager.VERTICAL,false);
        discount_details_recycler.setLayoutManager(bulkLinear);
        discount_details_recycler.setAdapter(bulkViewDiscountAdapter);

        //Button click event

        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                alertDialog.dismiss();
            }
        });
    }

    @Override
    public int getItemCount() {
        return productModelArrayList.size();
    }


    public static class MyViewHolder extends RecyclerView.ViewHolder {
        ImageView images;
        MaterialButton ask_price,order,view_bulk_deal;
        LinearLayout layoutText;

        ListView listData;

        ArrayList<OrderDetailModel> orderDetailModelArrayList;

        String[] size = {"5ml","10ml","10ml","10ml","10ml","10ml","10ml","10ml"};
        String[] box_size = {"10Ltr","10Ltr","10Ltr","10Ltr","10Ltr","10Ltr","10Ltr","10Ltr"};
        String[] price = {"100.00","150.00","120.00","200.00","200.00","200.00","2000.00","2000.00"};

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            images = itemView.findViewById(R.id.product_image);
            ask_price = itemView.findViewById(R.id.btnAskPrice);
            order = itemView.findViewById(R.id.btnOrder);
            view_bulk_deal = itemView.findViewById(R.id.btnViewBulkDeal);
            layoutText = itemView.findViewById(R.id.linearText);
            listData = itemView.findViewById(R.id.listData);
        }
    }

    public static void setListViewHeightBasedOnChildren(ListView listView,MyOrderAdapter listAdapter) {
        if (listAdapter == null) {
            // pre-condition
            return;
        }

        int totalHeight = 0;
        for (int i = 0; i < listAdapter.getCount(); i++) {
            View listItem = listAdapter.getView(i, null, listView);
            listItem.measure(0, 0);
            totalHeight += listItem.getMeasuredHeight();
        }

        ViewGroup.LayoutParams params = listView.getLayoutParams();
        params.height = totalHeight + ((listView.getDividerHeight() - 30) * (listAdapter.getCount() - 1));
        listView.setLayoutParams(params);
        listView.requestLayout();
    }
}
