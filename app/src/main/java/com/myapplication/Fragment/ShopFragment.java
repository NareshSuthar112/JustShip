package com.myapplication.Fragment;

import android.annotation.SuppressLint;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.myapplication.Adapter.ImageLiveDataAdapter;
import com.myapplication.Instance.ApiClientInstance;
import com.myapplication.Instance.ApiInterface;
import com.myapplication.Model.ImageLiveData;
import com.myapplication.R;
import com.squareup.picasso.Picasso;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import de.hdodenhof.circleimageview.CircleImageView;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

@SuppressLint("NonConstantResourceId")
public class ShopFragment extends Fragment {


    List<ImageLiveData> imageLiveData;
    Call<List<ImageLiveData>> call;
    ApiInterface apiInterface;

    @BindView(R.id.tvNames1)
    TextView names1;

    @BindView(R.id.tvNames2)
    TextView names2;

    @BindView(R.id.tvNames3)
    TextView names3;

    @BindView(R.id.tvNames4)
    TextView names4;

    @BindView(R.id.tvNames5)
    TextView names5;

    @BindView(R.id.tvNames6)
    TextView names6;

    @BindView(R.id.profile_image1)
    CircleImageView img1;

    @BindView(R.id.profile_image2)
    CircleImageView img2;

    @BindView(R.id.profile_image3)
    CircleImageView img3;

    @BindView(R.id.profile_image4)
    CircleImageView img4;

    @BindView(R.id.profile_image5)
    CircleImageView img5;

    @BindView(R.id.profile_image6)
    CircleImageView img6;

    @BindView(R.id.frame1)
    LinearLayout linearLayout;

    @BindView(R.id.re1)
    RelativeLayout r1;

    @BindView(R.id.re2)
    RelativeLayout r2;

    @BindView(R.id.re3)
    RelativeLayout r3;

    @BindView(R.id.re4)
    RelativeLayout r4;

    @BindView(R.id.re5)
    RelativeLayout r5;

    @BindView(R.id.re6)
    RelativeLayout r6;

    @BindView(R.id.tv_cat_names)
    TextView category_name;

    @BindView(R.id.tv_cat_details)
    TextView category_details;

    @BindView(R.id.progress_bar)
    ProgressBar progressBar;

    @BindView(R.id.card_data1)
    CardView card_data1;

    @BindView(R.id.card_data2)
    CardView card_data2;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_shop, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        ButterKnife.bind(this,view);

        apiInterface = ApiClientInstance.getRetrofit().create(ApiInterface.class);
        loadData();

        progressBar.setVisibility(View.VISIBLE);


        Animation cardAnimation = AnimationUtils.loadAnimation(getActivity(),R.anim.left_to_right);
        card_data2.setAnimation(cardAnimation);

        img1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                card_data2.setAnimation(cardAnimation);
                card_data2.setVisibility(View.VISIBLE);
                GradientDrawable drawable1 = new GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, new int[]{0xFFEFAFAF, 0xFFEFAFAF});
                drawable1.setCornerRadii(new float[]{0, 0, 80f, 80f, 0, 0, 0, 0});
                linearLayout.setBackground(drawable1);
                GradientDrawable drawable = new GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, new int[]{0xFFEFAFAF, 0xFFEFAFAF});
                drawable.setCornerRadii(new float[]{0, 0, 50f, 50f, 0, 0, -50f, -50f});
                r1.setBackground(drawable);
                r2.setBackgroundColor(getResources().getColor(R.color.white));
                r3.setBackgroundColor(getResources().getColor(R.color.white));
                r4.setBackgroundColor(getResources().getColor(R.color.white));
                r5.setBackgroundColor(getResources().getColor(R.color.white));
                r6.setBackgroundColor(getResources().getColor(R.color.white));

                if (imageLiveData.get(0).getName() != null && imageLiveData.get(0).getName_Guj() != null) {
                    category_name.setText(imageLiveData.get(0).getName());
                    category_details.setText(imageLiveData.get(0).getName_Guj());
                }

                if (imageLiveData.get(0).getDetail_Guj() == null){
                    card_data2.setVisibility(View.GONE);
                }
            }
        });

        img2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                card_data2.setAnimation(cardAnimation);
                card_data2.setVisibility(View.VISIBLE);
                GradientDrawable drawable1 = new GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, new int[]{0xFF618C62, 0xFF618C62});
                drawable1.setCornerRadii(new float[]{0, 0, 80f, 80f, 0, 0, 0, 0});
                linearLayout.setBackground(drawable1);
                r1.setBackgroundColor(getResources().getColor(R.color.white));
                GradientDrawable drawable = new GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, new int[]{0xFF618C62, 0xFF618C62});
                drawable.setCornerRadii(new float[]{50f, 50f, 50f, 50f, 0, 0, 0, 0});
                r2.setBackground(drawable);
                r3.setBackgroundColor(getResources().getColor(R.color.white));
                r4.setBackgroundColor(getResources().getColor(R.color.white));
                r5.setBackgroundColor(getResources().getColor(R.color.white));
                r6.setBackgroundColor(getResources().getColor(R.color.white));

                if (imageLiveData.get(1).getName() != null && imageLiveData.get(1).getName_Guj() != null) {

                    category_name.setText(imageLiveData.get(1).getName());
                    category_details.setText(imageLiveData.get(1).getName_Guj());
                }

                if (imageLiveData.get(1).getDetail_Guj() == null){
                    card_data2.setVisibility(View.GONE);
                }
            }
        });

        img3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                card_data2.setVisibility(View.VISIBLE);
                GradientDrawable drawable1 = new GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, new int[]{0xFFFFEB3B, 0xFFFFEB3B});
                drawable1.setCornerRadii(new float[]{0, 0, 80f, 80f, 0, 0, 0, 0});
                linearLayout.setBackground(drawable1);
                r1.setBackgroundColor(getResources().getColor(R.color.white));
                r2.setBackgroundColor(getResources().getColor(R.color.white));
                GradientDrawable drawable = new GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, new int[]{0xFFFFEB3B, 0xFFFFEB3B});
                drawable.setCornerRadii(new float[]{50f, 50f, 50f, 50f, 0, 0, 0, 0});
                r3.setBackground(drawable);
                r4.setBackgroundColor(getResources().getColor(R.color.white));
                r5.setBackgroundColor(getResources().getColor(R.color.white));
                r6.setBackgroundColor(getResources().getColor(R.color.white));

                if (imageLiveData.get(2).getName() != null && imageLiveData.get(2).getName_Guj() != null) {
                    category_name.setText(imageLiveData.get(2).getName());
                    category_details.setText(imageLiveData.get(2).getName_Guj());
                }

                if (imageLiveData.get(2).getDetail_Guj() == null){
                    card_data2.setVisibility(View.GONE);
                }
            }
        });

        img4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                card_data2.setVisibility(View.VISIBLE);
                GradientDrawable drawable1 = new GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, new int[]{0xFF89D2F3, 0xFF89D2F3});
                drawable1.setCornerRadii(new float[]{0, 0, 80f, 80f, 0, 0, 0, 0});
                linearLayout.setBackground(drawable1);
                r1.setBackgroundColor(getResources().getColor(R.color.white));
                r2.setBackgroundColor(getResources().getColor(R.color.white));
                r3.setBackgroundColor(getResources().getColor(R.color.white));
                GradientDrawable drawable = new GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, new int[]{0xFF89D2F3, 0xFF89D2F3});
                drawable.setCornerRadii(new float[]{50f, 50f, 50f, 50f, 0, 0, 0, 0});
                r4.setBackground(drawable);
                r5.setBackgroundColor(getResources().getColor(R.color.white));
                r6.setBackgroundColor(getResources().getColor(R.color.white));

                if (imageLiveData.get(3).getName() != null && imageLiveData.get(3).getName_Guj() != null) {
                    category_name.setText(imageLiveData.get(3).getName());
                    category_details.setText(imageLiveData.get(3).getName_Guj());
                }

                if (imageLiveData.get(3).getDetail_Guj() == null){
                    card_data2.setVisibility(View.GONE);
                }
            }
        });

        img5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                card_data2.setVisibility(View.VISIBLE);
                GradientDrawable drawable1 = new GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, new int[]{0xFFEC714B, 0xFFEC714B});
                drawable1.setCornerRadii(new float[]{0, 0, 80f, 80f, 0, 0, 0, 0});
                linearLayout.setBackground(drawable1);
                r1.setBackgroundColor(getResources().getColor(R.color.white));
                r2.setBackgroundColor(getResources().getColor(R.color.white));
                r3.setBackgroundColor(getResources().getColor(R.color.white));
                r4.setBackgroundColor(getResources().getColor(R.color.white));
                GradientDrawable drawable = new GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, new int[]{0xFFEC714B, 0xFFEC714B});
                drawable.setCornerRadii(new float[]{50f, 50f, 50f, 50f, 0, 0, 0, 0});
                r5.setBackground(drawable);
                r6.setBackgroundColor(getResources().getColor(R.color.white));

                if (imageLiveData.get(4).getName() != null && imageLiveData.get(4).getName_Guj() != null) {
                    category_name.setText(imageLiveData.get(4).getName());
                    category_details.setText(imageLiveData.get(4).getName_Guj());
                }

                if (imageLiveData.get(4).getDetail_Guj() == null){
                    card_data2.setVisibility(View.GONE);
                }
            }
        });

        img6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                card_data2.setVisibility(View.VISIBLE);
                GradientDrawable drawable1 = new GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, new int[]{0xFFA274F4, 0xFFA274F4});
                drawable1.setCornerRadii(new float[]{0, 0, 80f, 80f, 0, 0, 0, 0});
                linearLayout.setBackground(drawable1);
                r1.setBackgroundColor(getResources().getColor(R.color.white));
                r2.setBackgroundColor(getResources().getColor(R.color.white));
                r3.setBackgroundColor(getResources().getColor(R.color.white));
                r4.setBackgroundColor(getResources().getColor(R.color.white));
                r5.setBackgroundColor(getResources().getColor(R.color.white));
                GradientDrawable drawable = new GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, new int[]{0xFFA274F4, 0xFFA274F4});
                drawable.setCornerRadii(new float[]{50f, 50f, 0, 0, 0, 0, 0, 0});
                r6.setBackground(drawable);

                if (imageLiveData.get(5).getName() != null && imageLiveData.get(5).getName_Guj() != null) {
                    category_name.setText(imageLiveData.get(5).getName());
                    category_details.setText(imageLiveData.get(5).getName_Guj());
                }

                if (imageLiveData.get(5).getDetail_Guj() == null){
                    card_data2.setVisibility(View.GONE);
                }
            }
        });
    }

    public void loadData() {

        imageLiveData = new ArrayList<>();
        imageLiveData.clear();

        call = apiInterface.getAllPhotos();
        call.enqueue(new Callback<List<ImageLiveData>>() {
            @Override
            public void onResponse(@NotNull Call<List<ImageLiveData>> call, @NotNull Response<List<ImageLiveData>> response) {
                //  progressDoalog.dismiss();
                // generateDataList(response.body());
                if (response.code() == 200) {

                    imageLiveData.addAll(response.body());
                    setImageData(response.body());
                    category_name.setText(imageLiveData.get(0).getName());
                    category_details.setText(imageLiveData.get(0).getName_Guj());

                    if (imageLiveData.get(0).getDetail_Guj() == null){
                        card_data2.setVisibility(View.GONE);
                    }

                    progressBar.setVisibility(View.GONE);
                }
            }

            @Override
            public void onFailure(@NotNull Call<List<ImageLiveData>> call, @NotNull Throwable t) {
                //    progressDoalog.dismiss();
                Toast.makeText(getActivity(), "Something went wrong...Please try later!", Toast.LENGTH_SHORT).show();
                progressBar.setVisibility(View.GONE);
            }
        });
    }

    public void setImageData(List<ImageLiveData> imageLiveData) {

        Picasso.get().load("http://192.168.1.103:4000/FarmPhotos/Crops/"+imageLiveData.get(0).getPhoto()).placeholder(R.drawable.img7).into(img1);
        Picasso.get().load("http://192.168.1.103:4000/FarmPhotos/Crops/"+imageLiveData.get(1).getPhoto()).placeholder(R.drawable.img7).into(img2);
        Picasso.get().load("http://192.168.1.103:4000/FarmPhotos/Crops/"+imageLiveData.get(2).getPhoto()).placeholder(R.drawable.img7).into(img3);
        Picasso.get().load("http://192.168.1.103:4000/FarmPhotos/Crops/"+imageLiveData.get(3).getPhoto()).placeholder(R.drawable.img7).into(img4);
        Picasso.get().load("http://192.168.1.103:4000/FarmPhotos/Crops/"+imageLiveData.get(4).getPhoto()).placeholder(R.drawable.img7).into(img5);
        Picasso.get().load("http://192.168.1.103:4000/FarmPhotos/Crops/"+imageLiveData.get(5).getPhoto()).placeholder(R.drawable.img7).into(img6);

        names1.setText(imageLiveData.get(0).getName());
        names2.setText(imageLiveData.get(1).getName());
        names3.setText(imageLiveData.get(2).getName());
        names4.setText(imageLiveData.get(3).getName());
        names5.setText(imageLiveData.get(4).getName());
        names6.setText(imageLiveData.get(5).getName());

        progressBar.setVisibility(View.GONE);
    }

}
