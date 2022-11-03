package com.myapplication.Screens;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.myapplication.R;

import java.util.ArrayList;

public class BulkViewDiscountAdapter extends RecyclerView.Adapter<BulkViewDiscountAdapter.MyViewHolder> {
    Context context;
    ArrayList<BulkViewDiscountModel> bulkViewDiscountModelArrayList;

    public BulkViewDiscountAdapter(Context context, ArrayList<BulkViewDiscountModel> bulkViewDiscountModelArrayList) {
        this.bulkViewDiscountModelArrayList = bulkViewDiscountModelArrayList;
        this.context = context;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context).inflate(R.layout.bulk_view_discount,parent,false);

        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        holder.price.setText(bulkViewDiscountModelArrayList.get(position).getPrice());
        holder.range.setText(bulkViewDiscountModelArrayList.get(position).getRange());
    }

    @Override
    public int getItemCount() {
        return bulkViewDiscountModelArrayList.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {

        TextView price,range;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            price = itemView.findViewById(R.id.bulk_dis_price);
            range = itemView.findViewById(R.id.bulk_discount_range);
        }
    }
}
