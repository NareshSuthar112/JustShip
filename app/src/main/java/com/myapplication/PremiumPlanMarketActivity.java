package com.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("ALL")
public class PremiumPlanMarketActivity extends AppCompatActivity {

    RecyclerView rvListOfPremium;

    String[] AllFeatures = {"Unlimited Products Addition", "Taluka Of Marketing", "Unlimited Customers Addition",
            "Unlimited Product Discount Offers Creation", "Unlimited Special Offers Creation"
            , "Unlimited Combo Offers Creation", "Create Catalogues", "Share Catalogues", "Auto reply to Product Inquiry from Farmers", "Receive Orders from Farmers",
            "Purchase Inquiry to Sellers", "Product Inquiries from Farmers"};
    String[] NonPaid = {"✓", "3", "✓", "5", "1", "1", "✓", "x",
            "✓", "✓", "10/month", "50/month"};
    String[] Certified = {"✓", "3", "✓", "✓", "✓", "✓", "✓", "✓", "✓", "✓", "100/month", "250/month"};
    String[] Premium = {"✓", "5", "✓", "✓", "✓", "✓", "✓", "✓", "✓", "✓", "500/month", "1000/month"};

    List<PlanModel> planModelList = new ArrayList<>();

    LinearLayout llUpgrade;
    LinearLayout llVIP;

    TextView tvViewDetailsCertified, tvViewDetailsCertifiedBilling;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_premium_plan_merket);
        Window window = getWindow();
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
        window.setStatusBarColor(getResources().getColor(R.color.black));
        findViews();


        for (int i = 0; i < AllFeatures.length; i++) {
            PlanModel planModel = new PlanModel();
            planModel.setAllFeatures(AllFeatures[i]);
            planModel.setNonPaid(NonPaid[i]);
            planModel.setCertified(Certified[i]);
            planModel.setPremium(Premium[i]);
            planModelList.add(planModel);
        }

        PlanAdapter planAdapter = new PlanAdapter(PremiumPlanMarketActivity.this, planModelList);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(PremiumPlanMarketActivity.this, RecyclerView.VERTICAL, false);
        rvListOfPremium.setLayoutManager(linearLayoutManager);
        rvListOfPremium.setAdapter(planAdapter);

        GradientDrawable SelectedBorder = new GradientDrawable();
        SelectedBorder.setColor(0x9F257BBD);
        SelectedBorder.setCornerRadius(8);
        SelectedBorder.setStroke(5, 0x0A377C);

        GradientDrawable UnSelectedBorder = new GradientDrawable();
        UnSelectedBorder.setColor(0x000000);
        UnSelectedBorder.setCornerRadius(8);
        UnSelectedBorder.setStroke(5, 0x66FFFFFF);

        /* llUpgrade.setOnClickListener(v -> {
            llUpgrade.setBackground(SelectedBorder);
            llVIP.setBackground(UnSelectedBorder);
        });

        llVIP.setOnClickListener(v -> {

            llUpgrade.setBackground(UnSelectedBorder);
            llVIP.setBackground(SelectedBorder);
        });*/

        tvViewDetailsCertified.setOnClickListener(v -> showDialog(PremiumPlanMarketActivity.this));

        tvViewDetailsCertifiedBilling.setOnClickListener(v -> showDialog(PremiumPlanMarketActivity.this));

    }

    private void findViews() {
        rvListOfPremium = findViewById(R.id.rvListOfPremium1);
        llUpgrade = findViewById(R.id.llUpgrade);
        llVIP = findViewById(R.id.llVIP);
        tvViewDetailsCertified = findViewById(R.id.tvViewDetailsCertified);
        tvViewDetailsCertifiedBilling = findViewById(R.id.tvViewDetailsCertifiedBilling);
    }

    public void showDialog(Activity activity) {
        final Dialog dialog = new Dialog(activity);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setCancelable(true);
        dialog.setContentView(R.layout.raw_emen_certified_dialog);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(android.graphics.Color.TRANSPARENT));

        CardView cardPay = dialog.findViewById(R.id.cardPay);

        cardPay.setOnClickListener(v -> dialog.dismiss());

        dialog.show();
    }
}

class PlanModel {
    String allFeatures;
    String nonPaid;
    String certified;
    String premium;

    public String getAllFeatures() {
        return allFeatures;
    }

    public void setAllFeatures(String allFeatures) {
        this.allFeatures = allFeatures;
    }

    public String getNonPaid() {
        return nonPaid;
    }

    public void setNonPaid(String nonPaid) {
        this.nonPaid = nonPaid;
    }

    public String getCertified() {
        return certified;
    }

    public void setCertified(String certified) {
        this.certified = certified;
    }

    public String getPremium() {
        return premium;
    }

    public void setPremium(String premium) {
        this.premium = premium;
    }
}

class PlanAdapter extends RecyclerView.Adapter<PlanAdapter.MyViewHolder> {

    Context context;
    List<PlanModel> planModelList;

    public PlanAdapter(Context context, List<PlanModel> planModelList) {
        this.context = context;
        this.planModelList = planModelList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context).inflate(R.layout.raw_table, parent, false);

        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        if (planModelList.size() - 2 <= position) {

            holder.allFeatures.setText(planModelList.get(position).getAllFeatures());
            holder.tvPremium.setText(planModelList.get(position).getPremium());
            holder.tvVIP.setText(planModelList.get(position).getCertified());
            holder.tvFree.setText(planModelList.get(position).getNonPaid());

            holder.allFeatures.setTypeface(holder.allFeatures.getTypeface(), Typeface.BOLD);

        } else {

            holder.allFeatures.setText(planModelList.get(position).getAllFeatures());
            holder.tvPremium.setText(planModelList.get(position).getPremium());
            holder.tvVIP.setText(planModelList.get(position).getCertified());
            holder.tvFree.setText(planModelList.get(position).getNonPaid());
        }
    }

    @Override
    public int getItemCount() {
        return planModelList.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {

        TextView allFeatures, tvFree, tvVIP, tvPremium;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            allFeatures = itemView.findViewById(R.id.AllFeatures);
            tvPremium = itemView.findViewById(R.id.tvPremium);
            tvFree = itemView.findViewById(R.id.tvFree);
            tvVIP = itemView.findViewById(R.id.tvVIP);
        }
    }
}