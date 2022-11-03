package com.myapplication.Screens;

import android.annotation.SuppressLint;
import android.content.Context;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.myapplication.R;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class PlaceOrderAdapter extends RecyclerView.Adapter<PlaceOrderAdapter.MyViewHolder> {
    Context context;
    ArrayList<OrderModel> orderModelArrayList;
    TextView total_amt;
    TextView total_qty_ltr;
    TextView qty_discount;
    TextView total_price_discount;
    TextView grand_total;

    public PlaceOrderAdapter(Context context, ArrayList<OrderModel> orderModelArrayList, TextView total_amt, TextView total_ltr, TextView qty_discount, TextView total_price_discount,TextView grand_total) {
        this.context = context;
        this.orderModelArrayList = orderModelArrayList;
        this.total_amt = total_amt;
        this.total_qty_ltr = total_ltr;
        this.qty_discount = qty_discount;
        this.total_price_discount = total_price_discount;
        this.grand_total = grand_total;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context).inflate(R.layout.raw_order_data,parent,false);

        return new MyViewHolder(view);
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder._packings.setText(String.valueOf(orderModelArrayList.get(position).getPacking()) + "ml");
        holder._box_size.setText(String.valueOf(orderModelArrayList.get(position).getBox_size()) + "ltr");
        holder._qty_ltr.setText(String.valueOf(orderModelArrayList.get(position).getQty_ltr()) + "ltr");
        holder._price.setText(String.valueOf(orderModelArrayList.get(position).getPrice()));
        holder._total_amount.setText(String.valueOf(orderModelArrayList.get(position).getTotal_price()));


        holder.box_qty.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @SuppressLint("SetTextI18n")
            @Override
            public void afterTextChanged(Editable s) {
                String value = s.toString();

                if (value.equals("")){

                    /*holder.total_amt = Integer.parseInt(total_ltr.getText().toString());
                    int a = Integer.parseInt(holder._total_amount.getText().toString());

                    holder.total_amt -= a;

                    *//*total_ltr.setText(String.valueOf(holder.total_amt));*//*


                    orderModelArrayList.get(position).setTotal_price(0);
                    *//*for (int i = 0;i<orderModelArrayList.size();i++){
                        holder.total_amt += orderModelArrayList.get(i).getTotal_price();
                    }*//*

                    total_ltr.setText(String.valueOf(holder.total_amt));
                    holder._qty_ltr.setText("0ltr");
                    holder._total_amount.setText("0");*/


                    int decrease_price;

                    decrease_price = getDecreasePrice(position);
                    total_amt.setText(String.valueOf(decrease_price));

                    int decrease_total_qty_ltr;

                    decrease_total_qty_ltr = getDecreaseTotalQtyLtr(position);
                    total_qty_ltr.setText(String.valueOf(decrease_total_qty_ltr));

                    int qty_dis = getDiscount();
                    total_price_discount.setText(String.valueOf(qty_dis));

                    int grand_total_amt = getGrandTotal();
                    grand_total.setText(String.valueOf(grand_total_amt));

                    orderModelArrayList.get(position).setQty_ltr(0);
                    orderModelArrayList.get(position).setTotal_price(0);
                    holder._qty_ltr.setText("0ltr");
                    holder._total_amount.setText("0");

                }else {
                    /*int sum = 0;
                    int amt = 0;
                    holder.total_amt = 0;

                    int qty = orderModelArrayList.get(position).getBox_size();
                    amt = orderModelArrayList.get(position).getPrice();

                    sum = Integer.parseInt(value);
                    sum *= qty;
                    amt *= sum;
                    holder._qty_ltr.setText(sum + "ltr");
                    holder._total_amount.setText(String.valueOf(amt));

                    orderModelArrayList.get(position).setQty_ltr(sum);
                    orderModelArrayList.get(position).setTotal_price(amt);
                    for (int i = 0;i<orderModelArrayList.size();i++){
                        holder.total_amt += orderModelArrayList.get(i).getTotal_price();
                    }

                    total_ltr.setText(String.valueOf(holder.total_amt));*/

                    int total_ltr;

                    total_ltr = getTotalLtr(value,position);
                    holder._qty_ltr.setText(String.valueOf(total_ltr) + "ltr");



                    int total_amount = getTotalAmount(position);
                    holder._total_amount.setText(String.valueOf(total_amount));


                    int sum_of_total_amount = getSumOfTotalAmount(position);
                    total_amt.setText(String.valueOf(sum_of_total_amount));



                    int sum_of_total_qty_ltr = getSumOfQtyLtr(position);
                    total_qty_ltr.setText(String.valueOf(sum_of_total_qty_ltr));


                    int qty_dis = getDiscount();
                    total_price_discount.setText(String.valueOf(qty_dis));


                    int grand_total_amt = getGrandTotal();
                    grand_total.setText(String.valueOf(grand_total_amt));
                }

            }
        });
    }

    private int getGrandTotal() {

        int total_price = Integer.parseInt(total_amt.getText().toString());
        int total_dis = Integer.parseInt(total_price_discount.getText().toString());

        return total_price - total_dis;
    }

    private int getDiscount() {
        int qty_value = Integer.parseInt(qty_discount.getText().toString());
        int qty_price = Integer.parseInt(total_qty_ltr.getText().toString());

        return qty_price * qty_value;
    }

    private int getDecreaseTotalQtyLtr(int index) {

        int total_qty = Integer.parseInt(total_qty_ltr.getText().toString());
        int qty_ltr = orderModelArrayList.get(index).getQty_ltr();

        return total_qty - qty_ltr;
    }

    private int getSumOfQtyLtr(int index) {

        int total_qty_ltr = 0;

        for (int i=0;i<orderModelArrayList.size();i++){
            total_qty_ltr += orderModelArrayList.get(i).getQty_ltr();
        }

        return total_qty_ltr;
    }

    private int getDecreasePrice(int index) {

        int total_price = Integer.parseInt(total_amt.getText().toString());
        int price = orderModelArrayList.get(index).getTotal_price();

        return total_price - price;
    }

    private int getSumOfTotalAmount(int index) {

        int total_sum = 0;

        for (int i= 0; i<orderModelArrayList.size();i++){
            total_sum += orderModelArrayList.get(i).total_price;
        }

        return total_sum;
    }

    private int getTotalAmount(int index) {

        int total_amount;
        int total_qty;
        int price;

        total_qty = orderModelArrayList.get(index).getQty_ltr();
        price = orderModelArrayList.get(index).getPrice();

        total_amount = total_qty * price;

        orderModelArrayList.get(index).setTotal_price(total_amount);

        return total_amount;
    }

    private int getTotalLtr(String value,int index) {

        int box_size;

        box_size = orderModelArrayList.get(index).getBox_size();

        box_size *= Integer.parseInt(value);
        orderModelArrayList.get(index).setQty_ltr(box_size);
        return box_size;
    }

    @Override
    public int getItemCount() {
        return orderModelArrayList.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {

        TextView _packings,_box_size,_qty_ltr,_price,_total_amount;

        EditText box_qty;
        int total_amt = 0;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            _packings = itemView.findViewById(R.id.packing);
            _box_size = itemView.findViewById(R.id.box_size);
            _qty_ltr = itemView.findViewById(R.id.ltr_qty);
            _price = itemView.findViewById(R.id.order_price);
            _total_amount = itemView.findViewById(R.id.total_amount);
            box_qty = itemView.findViewById(R.id.box_qty);

        }


    }
}
