package com.myapplication.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.futuremind.recyclerviewfastscroll.SectionTitleProvider;
import com.myapplication.Model.ImageData;
import com.myapplication.R;

import java.util.ArrayList;

public class MyImageAdapter extends RecyclerView.Adapter<MyImageAdapter.MyViewHoler> implements SectionTitleProvider {
    private final Context context;
    private final ArrayList<ImageData> imageDataArrayList;

    public MyImageAdapter(Context context, ArrayList<ImageData> imageDataArrayList) {
        this.context = context;
        this.imageDataArrayList = imageDataArrayList;
    }

    @NonNull
    @Override
    public MyViewHoler onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.recycle_data, parent, false);
        return new MyViewHoler(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHoler holder, int position) {
        Glide.with(context).load(imageDataArrayList.get(position).getImage()).into(holder.imageData);
        holder.nameData.setText(imageDataArrayList.get(position).getName());
    }

    @Override
    public int getItemCount() {
        return imageDataArrayList.size();
    }

    @Override
    public String getSectionTitle(int position) {
        return imageDataArrayList.get(position).getName().substring(0,1);
    }

    static class MyViewHoler extends RecyclerView.ViewHolder {

        ImageView imageData;
        TextView nameData;

        MyViewHoler(@NonNull View itemView) {
            super(itemView);
            imageData = itemView.findViewById(R.id.imgdata);
            nameData = itemView.findViewById(R.id.tvData);
        }
    }
}
