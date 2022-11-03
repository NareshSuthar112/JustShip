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

public class BulkViewAdapter extends RecyclerView.Adapter<BulkViewAdapter.MyViewHolder> {
    Context context;
    ArrayList<BulkViewDataModel> bulkViewDataModelArrayList;

    public BulkViewAdapter(Context context, ArrayList<BulkViewDataModel> bulkViewDataModelArrayList) {
        this.bulkViewDataModelArrayList= bulkViewDataModelArrayList;
        this.context = context;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.raw_bulk_view_data,parent,false);

        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.packing.setText(String.valueOf(bulkViewDataModelArrayList.get(position).getPacking()));
        holder.amount.setText(String.valueOf(bulkViewDataModelArrayList.get(position).getAmount()));
    }

    @Override
    public int getItemCount() {
        return bulkViewDataModelArrayList.size();
    }


    public static class MyViewHolder extends RecyclerView.ViewHolder {

        TextView packing,amount;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            packing = itemView.findViewById(R.id.tv_packing);
            amount = itemView.findViewById(R.id.tv_amount);
        }
    }
}
