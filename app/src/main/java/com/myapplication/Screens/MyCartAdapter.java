package com.myapplication.Screens;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.LayoutAnimationController;
import android.widget.ImageView;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.myapplication.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class MyCartAdapter extends RecyclerView.Adapter<MyCartAdapter.MyViewHolder> {
    Context context;
    ArrayList<CartModel> cartModelArrayList;
    LinearLayout cart_layout;

    public MyCartAdapter(Context context, ArrayList<CartModel> cartModelArrayList, LinearLayout cart_layout) {
        this.context = context;
        this.cartModelArrayList = cartModelArrayList;
        this.cart_layout = cart_layout;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context).inflate(R.layout.raw_cart_data,parent,false);

        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        Picasso.get().load(cartModelArrayList.get(position).getImage()).into(holder.imgData);

        holder._delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                cartModelArrayList.remove(position);

                if (cartModelArrayList.size() == 0){
                    cart_layout.setVisibility(View.GONE);
                }

                notifyDataSetChanged();

            }
        });

        setAnimation(holder.itemView,position);

    }

    @Override
    public int getItemCount() {
        return cartModelArrayList.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {

        ImageView imgData,_delete;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            imgData = itemView.findViewById(R.id.imgCart);
            _delete = itemView.findViewById(R.id.img_delete);
        }
    }

    private void setAnimation(View viewToAnimate, int position)
    {
        Animation animation = AnimationUtils.loadAnimation(context, R.anim.down_from_top);
        viewToAnimate.startAnimation(animation);
        // If the bound view wasn't previously displayed on screen, it's animated
       /* if (position > lastPosition)
        {

            lastPosition = position;
        }*/
    }
}
