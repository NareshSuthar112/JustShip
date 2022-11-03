package com.myapplication.Screens;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.myapplication.R;

import java.util.ArrayList;

public class MyCompanyPlaceOrderAdapter extends RecyclerView.Adapter<MyCompanyPlaceOrderAdapter.MyViewHolder> {
    Context context;
    ArrayList<MyCompanyModel> myCompanyModelArrayList;
    public MyCompanyPlaceOrderAdapter(Context context, ArrayList<MyCompanyModel> myCompanyModelArrayList) {
        this.context = context;
        this.myCompanyModelArrayList = myCompanyModelArrayList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context).inflate(R.layout.raw_place_company_details,parent,false);

        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.company_name.setText(myCompanyModelArrayList.get(position).company_name);
        holder.order_id.setText(myCompanyModelArrayList.get(position).order_id);
        holder.footer.setText("*Above order will be fulfilled by " + myCompanyModelArrayList.get(position).getCompany_name() + ", Ahmedabad");
        holder.btn_place_order.setText("Place Order to " + myCompanyModelArrayList.get(position).getCompany_name());

        holder.show_hide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showHideData(holder);
            }
        });

        holder.company_name.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showHideData(holder);
            }
        });

        holder.myPlaceOrderModelArrayList.clear();
        for (int i = 0;i<holder.packings.length;i++){
            MyPlaceOrderModel myPlaceOrderModel = new MyPlaceOrderModel(holder.trade_name[i],holder.technical_name[i],holder.box_size[i],holder.qty_box[i],holder.qty_ltr[i],holder.total_amount[i],holder.price_ltr[i],
                    holder.discount[i],holder.net_price[i],holder.gst[i],holder.total_amount_gst[i],holder.packings[i]);
            holder.myPlaceOrderModelArrayList.add(myPlaceOrderModel);
        }

        MyPlaceOrderAdapter myPlaceOrderAdapter = new MyPlaceOrderAdapter(context,holder.myPlaceOrderModelArrayList,holder.grand_total,holder.total_gst,holder.grand_total_amount_gst);
        LinearLayoutManager orderLinear = new LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false);
        holder.place_order_detail.setLayoutManager(orderLinear);
        holder.place_order_detail.setAdapter(myPlaceOrderAdapter);

    }

    private void showHideData(MyViewHolder holder) {
        if (holder.flag == 1){
            holder.data_layout.setVisibility(View.GONE);
            holder.show_hide.setImageResource(R.drawable.ic_baseline_keyboard_arrow_down_24);
            holder.flag = 0;
        }else if (holder.flag == 0){
            holder.data_layout.setVisibility(View.VISIBLE);
            holder.show_hide.setImageResource(R.drawable.ic_baseline_keyboard_arrow_up_24);
            holder.flag = 1;
        }
    }

    @Override
    public int getItemCount() {
        return myCompanyModelArrayList.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {

        TextView order_id,company_name,grand_total,total_gst,grand_total_amount_gst,footer;
        ImageView show_hide;
        LinearLayout data_layout;
        int flag = 1;

        RecyclerView place_order_detail;
        Button btn_place_order;

        String[] trade_name = {"Trade Name","Trade Name"};
        String[] technical_name = {"Technical Name","Technical Name"};
        int[] packings = {1,2};
        int[] box_size = {10,20};
        int[] qty_box = {5,10};
        int[] qty_ltr = {10,15};
        int[] total_amount = {12000,20000};
        int[] price_ltr = {500,800};
        int[] discount = {50,20};
        int[] net_price = {450,780};
        int[] gst = {18,20};
        int[] total_amount_gst = {12450,20780};

        ArrayList<MyPlaceOrderModel> myPlaceOrderModelArrayList;


        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            order_id = itemView.findViewById(R.id.order_id);
            company_name = itemView.findViewById(R.id.company_name);
            place_order_detail = itemView.findViewById(R.id.place_order_detail);
            show_hide = itemView.findViewById(R.id.img_show_hide);
            data_layout = itemView.findViewById(R.id.order_layout);
            grand_total = itemView.findViewById(R.id.grand_total);
            total_gst = itemView.findViewById(R.id.total_gst);
            grand_total_amount_gst = itemView.findViewById(R.id.grand_total_amount_gst);
            footer = itemView.findViewById(R.id.footer);
            btn_place_order = itemView.findViewById(R.id.place_order);

            myPlaceOrderModelArrayList = new ArrayList<>();
        }
    }
}
