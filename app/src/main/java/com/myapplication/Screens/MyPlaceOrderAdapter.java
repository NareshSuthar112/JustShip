package com.myapplication.Screens;

import android.content.Context;
import android.content.Intent;
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
import java.util.List;

public class MyPlaceOrderAdapter extends RecyclerView.Adapter<MyPlaceOrderAdapter.MyViewHolder> {
    Context context;
    ArrayList<MyPlaceOrderModel> myPlaceOrderModelArrayList;
    TextView tv_grand_total;
    TextView tv_total_gst;
    TextView tv_grand_total_amount_gst;

    public MyPlaceOrderAdapter(Context context, ArrayList<MyPlaceOrderModel> myPlaceOrderModelArrayList, TextView tv_grand_total, TextView tv_total_gst, TextView tv_grand_total_amount_gst) {
        this.context = context;
        this.myPlaceOrderModelArrayList = myPlaceOrderModelArrayList;
        this.tv_grand_total = tv_grand_total;
        this.tv_total_gst = tv_total_gst;
        this.tv_grand_total_amount_gst = tv_grand_total_amount_gst;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context).inflate(R.layout.raw_place_order_details,parent,false);

        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.trade_name.setText(myPlaceOrderModelArrayList.get(position).getTrade_name());
        holder.technical_name.setText(myPlaceOrderModelArrayList.get(position).getTechnical_name());
        holder.packing.setText(String.valueOf(myPlaceOrderModelArrayList.get(position).getPacking()));
        holder.box_size.setText(String.valueOf(myPlaceOrderModelArrayList.get(position).getBox_size()));
        holder.qty_box.setText(String.valueOf(myPlaceOrderModelArrayList.get(position).getQty_box()));
        holder.qty_ltr.setText(String.valueOf(myPlaceOrderModelArrayList.get(position).getQty_ltr()));
        holder.total_amount.setText(String.valueOf(myPlaceOrderModelArrayList.get(position).getTotal_amount()));
        holder.price_ltr.setText(String.valueOf(myPlaceOrderModelArrayList.get(position).getPrice_ltr()));
        holder.discount.setText(String.valueOf(myPlaceOrderModelArrayList.get(position).getDiscount()));
        holder.net_price.setText(String.valueOf(myPlaceOrderModelArrayList.get(position).getNet_price()));
        holder.gst.setText(String.valueOf(myPlaceOrderModelArrayList.get(position).getGst()));
        holder.total_amount_gst.setText(String.valueOf(myPlaceOrderModelArrayList.get(position).getTotal_amount_gst()));

        holder.qty_box.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                String value = s.toString();

                if (value.equals("")){

                    //Grand Total

                    int grand_total = setDecreaseGrandTotal(position);
                    tv_grand_total.setText(String.valueOf(grand_total));

                    myPlaceOrderModelArrayList.get(position).setQty_ltr(0);
                    holder.qty_ltr.setText("0");

                    myPlaceOrderModelArrayList.get(position).setTotal_amount(0);
                    holder.total_amount.setText("0");

                    myPlaceOrderModelArrayList.get(position).setTotal_amount_gst(0);
                    holder.total_amount_gst.setText("0");

                    //Total GST

                    int total_gst = getTotalGST(holder,position);
                    tv_total_gst.setText(String.valueOf(total_gst));

                    //Grand Total Amount(GST)

                    int grand_total_amount_gst = getGrandTotalGST();
                    tv_grand_total_amount_gst.setText(String.valueOf(grand_total_amount_gst));

                }else {

                    //Find Qrt_Ltr

                    int total_ltr;

                    total_ltr = getTotalLtr(value,position);
                    holder.qty_ltr.setText(String.valueOf(total_ltr));

                    //Total Amount

                    int total_amount;

                    total_amount = getTotalAmount(position);
                    holder.total_amount.setText(String.valueOf(total_amount));

                    //GST

                    int gst;
                    gst = getGST(position);

                    //Total Amount(GST)

                    int total_amount_gst;

                    total_amount_gst = getTotalAmountGst(gst,position);
                    holder.total_amount_gst.setText(String.valueOf(total_amount_gst));

                    //Grand Total Amount

                    int grand_total = getGrandTotal(position);
                    tv_grand_total.setText(String.valueOf(grand_total));

                    //Total GST

                    int total_gst = getTotalGST(holder,position);
                    tv_total_gst.setText(String.valueOf(total_gst));

                    //Grand Total Amount(GST)

                    int grand_total_amount_gst = getGrandTotalGST();
                    tv_grand_total_amount_gst.setText(String.valueOf(grand_total_amount_gst));

                }
            }
        });
    }

    private int getGrandTotalGST() {

        int grand_total_amount = Integer.parseInt(tv_grand_total.getText().toString());
        int total_gst = Integer.parseInt(tv_total_gst.getText().toString());

        return grand_total_amount + total_gst;
    }

    private int getTotalGST(@NonNull MyViewHolder holder,int position) {
        /*List<Integer> total_gst = new ArrayList<>();

        if (total_gst.size() == 0){
            total_gst.add(gst);
        }else{
            for (int i =0; i<total_gst.size();i++){
                total_gst.add(gst);
            }
        }*/

        /*holder.total_gst += gst;*/
        int total_gst = 0;
        int gst_percentile;
        int total_amt;

        for (int i = 0;i<myPlaceOrderModelArrayList.size();i++){
            gst_percentile = myPlaceOrderModelArrayList.get(i).getGst();
            total_amt =  myPlaceOrderModelArrayList.get(i).getTotal_amount();
            total_gst += (gst_percentile * total_amt)/100;
        }

        return total_gst;
    }

    private int setDecreaseGrandTotal(int position) {

        int price = myPlaceOrderModelArrayList.get(position).getTotal_amount();
        int grand_total = Integer.parseInt(tv_grand_total.getText().toString());

        return grand_total - price;
    }

    private int getGrandTotal(int position) {
        int grand_total = 0;

        for (int i = 0;i<myPlaceOrderModelArrayList.size();i++){
            grand_total += myPlaceOrderModelArrayList.get(i).getTotal_amount();
        }

        return grand_total;
    }

    private int getTotalAmountGst(int gst, int position) {

        int total_amount = myPlaceOrderModelArrayList.get(position).getTotal_amount();
        int total_amount_gst = total_amount + gst;

        myPlaceOrderModelArrayList.get(position).setTotal_amount_gst(total_amount_gst);
        return total_amount_gst;
    }

    private int getGST(int position) {

        int gst_percentile = myPlaceOrderModelArrayList.get(position).getGst();
        int total_amount = myPlaceOrderModelArrayList.get(position).getTotal_amount();
        int gst;

        gst = (total_amount * gst_percentile)/100;

        return gst;
    }

    private int getTotalAmount(int position) {

        int qty_ltr = myPlaceOrderModelArrayList.get(position).getQty_ltr();
        int net_price = myPlaceOrderModelArrayList.get(position).getNet_price();
        int amt;

        amt = qty_ltr * net_price;

        myPlaceOrderModelArrayList.get(position).setTotal_amount(amt);

        return amt;
    }

    private int getTotalLtr(String value,int index) {

        int box_size;

        box_size = myPlaceOrderModelArrayList.get(index).getBox_size();

        box_size *= Integer.parseInt(value);
        myPlaceOrderModelArrayList.get(index).setQty_ltr(box_size);
        return box_size;
    }

    @Override
    public int getItemCount() {
        return myPlaceOrderModelArrayList.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {

        TextView trade_name,technical_name,packing,box_size,qty_ltr,total_amount,price_ltr,discount,net_price,gst,total_amount_gst;
        int total_gst = 0;
        EditText qty_box;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            trade_name = itemView.findViewById(R.id.trade_name);
            technical_name = itemView.findViewById(R.id.technical_name);
            packing = itemView.findViewById(R.id.packing);
            box_size = itemView.findViewById(R.id.box_size);
            qty_box = itemView.findViewById(R.id.qty_box);
            qty_ltr = itemView.findViewById(R.id.qty_ltr);
            total_amount = itemView.findViewById(R.id.total_amt);
            price_ltr = itemView.findViewById(R.id.price_ltr);
            discount = itemView.findViewById(R.id.discount);
            net_price = itemView.findViewById(R.id.net_price);
            gst = itemView.findViewById(R.id.gst);
            total_amount_gst = itemView.findViewById(R.id.total_amount_gst);
        }
    }
}
