package com.myapplication.Screens;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.cardview.widget.CardView;
import androidx.core.widget.NestedScrollView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.app.ActivityOptions;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Vibrator;
import android.util.Pair;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.WindowManager;
import android.view.animation.AnimationUtils;
import android.view.animation.LayoutAnimationController;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.badge.BadgeDrawable;
import com.google.android.material.badge.BadgeUtils;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.snackbar.BaseTransientBottomBar;
import com.google.android.material.snackbar.Snackbar;
import com.myapplication.MainActivity;
import com.myapplication.R;

import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

public class OrderDetailsActivity extends AppCompatActivity {

    int[] packing = {5,10,10,10,10,10,10};
    int[] box_size = {5,10,10,10,10,10,10};
    int[] qty_ltr = {0,0,0,0,0,0,0};
    int[] price = {50,100,200,250,500,750,1000};
    int[] total_price = {0,0,0,0,0,0,0};

    ArrayList<OrderModel> orderModelArrayList;
    ArrayList<CartModel> cartModelArrayList;

    TextView total_ltr,total_amt,qty_discount,total_price_discount,grand_total,technical_name;

    RecyclerView order_details,cart_recycle;

    LinearLayout cart_layout,whole_layout;

    MaterialButton add_to_cart,btn_place_order;

    NestedScrollView product_scroll;

    Toolbar toolbar;

    AlertDialog alertDialog;

    MovableFloatingActionButton _cart_floating;

    CardView image_card;

    int cnt = 0;
    BadgeDrawable badgeDrawable;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_details);

        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbar.setNavigationOnClickListener(v -> onBackPressed());

        order_details = findViewById(R.id.orderData);
        total_amt = findViewById(R.id.total_price);
        total_ltr = findViewById(R.id.total_ltr);
        qty_discount = findViewById(R.id.qty_ltr_discount);
        total_price_discount = findViewById(R.id.total_discount_price);
        grand_total = findViewById(R.id.grand_total);
        cart_recycle = findViewById(R.id.cart_data_recycler);
        add_to_cart = findViewById(R.id.btn_add_to_cart);
        product_scroll = findViewById(R.id.product_scroll);
        whole_layout = findViewById(R.id.whole_layout);
        btn_place_order = findViewById(R.id.btn_place_order);
        _cart_floating = findViewById(R.id.cart_floating);
        image_card = findViewById(R.id.product_card);
        technical_name = findViewById(R.id.technical_name);

        cart_layout = findViewById(R.id.cart_layout);

        orderModelArrayList = new ArrayList<>();
        cartModelArrayList = new ArrayList<>();

        for (int i = 0;i<packing.length;i++){
            OrderModel orderModel = new OrderModel(packing[i],box_size[i],qty_ltr[i],price[i],total_price[i]);
            orderModelArrayList.add(orderModel);
        }

        PlaceOrderAdapter placeOrderAdapter = new PlaceOrderAdapter(OrderDetailsActivity.this,orderModelArrayList,total_amt,total_ltr,qty_discount,total_price_discount,grand_total);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(OrderDetailsActivity.this, LinearLayoutManager.VERTICAL, false);
        order_details.setLayoutManager(linearLayoutManager);
        order_details.setAdapter(placeOrderAdapter);


        add_to_cart.setOnClickListener(v -> {
            cart_layout.setVisibility(View.VISIBLE);
            product_scroll.fullScroll(ScrollView.FOCUS_DOWN);
            CartModel mo = new CartModel(R.drawable.i1);
            cartModelArrayList.add(mo);

            MyCartAdapter myCartAdapter = new MyCartAdapter(OrderDetailsActivity.this,cartModelArrayList,cart_layout);
            LinearLayoutManager cartLinear = new LinearLayoutManager(OrderDetailsActivity.this, LinearLayoutManager.HORIZONTAL, false);
            cart_recycle.setLayoutManager(cartLinear);
            cart_recycle.setAdapter(myCartAdapter);

            showCustomDialog();

            Vibrator vibrator;
            vibrator = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
            vibrator.vibrate(100);

            Timer t = new Timer();
            t.scheduleAtFixedRate(new TimerTask() {
                @Override
                public void run() {
                    alertDialog.dismiss();
                    t.cancel();
                }
            },1000,1000);

            cnt++;
            badgeDrawable.setNumber(cnt);

        });

        btn_place_order.setOnClickListener(v -> {
            Intent intent = new Intent(OrderDetailsActivity.this,PlaceOrderActivity.class);
            startActivity(intent);
        });

        _cart_floating.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            @SuppressLint("UnsafeExperimentalUsageError")
            @Override
            public void onGlobalLayout() {
                 badgeDrawable = BadgeDrawable.create(OrderDetailsActivity.this);
                badgeDrawable.setNumber(cnt);

                badgeDrawable.setHorizontalOffset(55);
                badgeDrawable.setVerticalOffset(55);
                BadgeUtils.attachBadgeDrawable(badgeDrawable, _cart_floating, null);

                _cart_floating.getViewTreeObserver().removeOnGlobalLayoutListener(this);
            }
        });

        _cart_floating.setOnClickListener(v -> {
            /*OrderDetailsActivity.this.startActivity(new Intent(OrderDetailsActivity.this,MyCartActivity.class),
                    ActivityOptions.makeSceneTransitionAnimation(OrderDetailsActivity.this, new Pair[]{new Pair(OrderDetailsActivity.this.image_card,"product_card"),
                            new Pair(OrderDetailsActivity.this.technical_name,"trade_name")
                    }).toBundle());*/
            Intent intent = new Intent(OrderDetailsActivity.this,MyCartActivity.class);
            startActivity(intent);
        });

    }

    private void showCustomDialog() {

        ViewGroup viewGroup = findViewById(android.R.id.content);

        View dialogView = LayoutInflater.from(this).inflate(R.layout.my_dialog, viewGroup, false);

        AlertDialog.Builder builder = new AlertDialog.Builder(this,R.style.CustomAlertDialog);

        builder.setView(dialogView);

        alertDialog = builder.create();
        WindowManager.LayoutParams lp = new WindowManager.LayoutParams();
        lp.copyFrom(alertDialog.getWindow().getAttributes());
        lp.width = 100;
        lp.height = 100;
        alertDialog.show();
    }

}