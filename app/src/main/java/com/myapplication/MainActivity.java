package com.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.RecyclerView;

import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.snackbar.Snackbar;
import com.myapplication.Fragment.GamesFragment;
import com.myapplication.Fragment.ShopFragment;
import com.myapplication.Fragment.SuperCoinFragment;
import com.myapplication.Fragment.VideoFragment;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import de.hdodenhof.circleimageview.CircleImageView;

import static com.myapplication.R.id.item3;

public class MainActivity extends AppCompatActivity {

    FrameLayout trans_frame;

    BottomNavigationView bottomNavigationView;

    LinearLayout more_option;
    int flag = 0;

    public boolean a = false;

    int id3;
    private final static String TAG_FRAGMENT = "TAG_FRAGMENT";

    Fragment fragment;
    FragmentTransaction fragmentTransaction;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);


        //recyclerView = findViewById(R.id.recyclerView);
        bottomNavigationView = findViewById(R.id.bottomNavigation);

        trans_frame = findViewById(R.id.frame_trans);

        more_option = findViewById(R.id.more_menu);

        showFragment();

      /*  dataModelArrayList = new ArrayList<>();


        for (int i = 0 ; i < images.length; i++){
            DataModel dataModel = new DataModel(names[i],images[i]);
            dataModelArrayList.add(dataModel);
        }

        MyDataAdapter myDataAdapter = new MyDataAdapter(getApplicationContext(),dataModelArrayList);
        LinearLayoutManager linearLayoutManager =new LinearLayoutManager(getApplicationContext(),RecyclerView.HORIZONTAL,false);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(myDataAdapter);*/


        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                int id = item.getItemId();

                Fragment fragment1 = null;


                if (id == R.id.item1){
                    more_option.setVisibility(View.GONE);
                    trans_frame.setVisibility(View.GONE);
                    if (flag == 1){
                        if (id3 != item.getItemId()){
                            bottomNavigationView.getMenu().getItem(2).setIcon(R.drawable.more_img);
                        }
                        flag = 0;
                    }
                    fragment1 = new ShopFragment();
                }
                else if (id == R.id.item2) {
                    more_option.setVisibility(View.GONE);
                    trans_frame.setVisibility(View.GONE);
                    if (flag == 1){
                        if (id3 != item.getItemId()){
                            bottomNavigationView.getMenu().getItem(2).setIcon(R.drawable.more_img);
                        }
                        flag = 0;
                    }

                    fragment1 = new SuperCoinFragment();
                }
                else if (id == item3){
                    if (flag == 0){
                        Animation animation = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.slide_up);
                        Animation aniFade = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.fadein);
                        trans_frame.startAnimation(aniFade);
                        more_option.setVisibility(View.VISIBLE);
                        trans_frame.setVisibility(View.VISIBLE);
                        more_option.setAnimation(animation);

                        id3 = item.getItemId();
                       /* final BottomSheetDialog bottomSheetDialog = new BottomSheetDialog(
                                MainActivity.this, R.style.BottomSheetDialogTheme
                        );
                        View bottomSheetView = LayoutInflater.from(getApplicationContext()).inflate(R.layout.bottom_layout,findViewById(R.id.btmContainer));

                        bottomSheetDialog.setContentView(bottomSheetView);
                        bottomSheetDialog.show();*/
                        item.setIcon(R.drawable.close_icon);
                        flag = 1;
                    }else{

                        Animation aniFade = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.fadeout);
                        trans_frame.startAnimation(aniFade);

                        Animation animation = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.slide_down);
                        more_option.setVisibility(View.GONE);
                        trans_frame.setVisibility(View.GONE);

                        more_option.setAnimation(animation);

                        item.setIcon(R.drawable.more_img);
                        flag = 0;
                    }
                }else if (id == R.id.item4){
                    more_option.setVisibility(View.GONE);
                    trans_frame.setVisibility(View.GONE);
                    if (flag == 1){
                        if (id3 != item.getItemId()){
                            bottomNavigationView.getMenu().getItem(2).setIcon(R.drawable.more_img);
                        }
                        flag = 0;
                    }
                    fragment1 = new GamesFragment();
                }else if (id == R.id.item5){
                    more_option.setVisibility(View.GONE);
                    trans_frame.setVisibility(View.GONE);
                    if (flag == 1){
                        if (id3 != item.getItemId()){
                            bottomNavigationView.getMenu().getItem(2).setIcon(R.drawable.more_img);
                        }
                        flag = 0;
                    }
                    fragment1 = new VideoFragment();

                }
                if (id3 != item.getItemId()) {

                    FragmentManager fm = getSupportFragmentManager();
                    FragmentTransaction ft = fm.beginTransaction();
                    assert fragment != null;
                    ft.replace(R.id.frame_display_data, fragment1);
                    ft.commit();
                }

                return true;
            }
        });
    }

    private void showFragment() {
        fragment = new ShopFragment();
        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.add(R.id.frame_display_data, fragment);
        fragmentTransaction.commit();

    }

    @Override
    public void onBackPressed() {

        
        FragmentManager manager = getSupportFragmentManager();
        if(manager.getBackStackEntryCount() > 0){
            manager.popBackStack();
        }
        else {
            super.onBackPressed();
        }


    }
    
    public Fragment getFragment(){
        return getSupportFragmentManager().findFragmentById(R.id.frame_display_data);
    }
}