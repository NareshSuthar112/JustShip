package com.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.viewpager.widget.ViewPager;

import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.myapplication.Fragment.GamesFragment;
import com.myapplication.Fragment.ShopFragment;
import com.myapplication.Fragment.SuperCoinFragment;
import com.myapplication.Fragment.VideoFragment;

import java.util.ArrayList;

import devlight.io.library.ntb.NavigationTabBar;

public class BottomNavigationActivity extends AppCompatActivity {

    Fragment fragment;
    FragmentTransaction fragmentTransaction;
    BottomNavigationView bottomNavigationView;

    ViewPager viewPager;

    NavigationTabBar navigationTabBar;
    ArrayList<NavigationTabBar.Model> models = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bottom_navigation);

        navigationTabBar = findViewById(R.id.ntb);
        viewPager = findViewById(R.id.viewPager);

        models.add(
                new NavigationTabBar.Model.Builder(
                        getResources().getDrawable(R.drawable.ic_videocam_black_24dp),
                        Color.parseColor("#FF89D2F3")
                ).title("Heart")
                        .badgeTitle("NTB")
                        .build()
        );
        models.add(
                new NavigationTabBar.Model.Builder(
                        getResources().getDrawable(R.drawable.ic_videogame_asset_black_24dp),
                        Color.parseColor("#FF89D2F3")
                ).title("Cup")
                        .badgeTitle("with")
                        .build()
        );
        models.add(
                new NavigationTabBar.Model.Builder(
                        getResources().getDrawable(R.drawable.ic_local_grocery_store_black_24dp),
                        Color.parseColor("#FF89D2F3")
                ).title("Diploma")
                        .badgeTitle("state")
                        .build()
        );
        models.add(
                new NavigationTabBar.Model.Builder(
                        getResources().getDrawable(R.drawable.ic_more_horiz_black_24dp),
                        Color.parseColor("#FF89D2F3")
                ).title("Flag")
                        .badgeTitle("icon")
                        .build()
        );
        models.add(
                new NavigationTabBar.Model.Builder(
                        getResources().getDrawable(R.drawable.ic_shopping_basket_black_24dp),
                        Color.parseColor("#FF89D2F3")
                ).title("Medal")
                        .badgeTitle("777")
                        .build()
        );

        navigationTabBar.setModels(models);


        navigationTabBar.setTitleMode(NavigationTabBar.TitleMode.ACTIVE);
        navigationTabBar.setBadgeGravity(NavigationTabBar.BadgeGravity.BOTTOM);
        navigationTabBar.setBadgePosition(NavigationTabBar.BadgePosition.CENTER);
        navigationTabBar.setTypeface("fonts/custom_font.ttf");
        navigationTabBar.setIsBadged(true);
        navigationTabBar.setIsTitled(true);
        navigationTabBar.setIsTinted(true);
        navigationTabBar.setIsBadgeUseTypeface(true);
        navigationTabBar.setBadgeBgColor(Color.RED);
        navigationTabBar.setBadgeTitleColor(Color.WHITE);
        navigationTabBar.setIsSwiped(true);
        navigationTabBar.setBgColor(Color.BLACK);
        navigationTabBar.setBadgeSize(10);
        navigationTabBar.setTitleSize(10);
        navigationTabBar.setIconSizeFraction((float) 0.5);


       /* fragment = new ShopFragment();
        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.add(R.id.frame, fragment);
        fragmentTransaction.commit();*/

       /* onClick();*/
    }

   /* private void onClick() {
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                int id = menuItem.getItemId();
                Fragment fragment = null;

                if (id == R.id.item1) {
                    fragment = new ShopFragment();
                } else if (id == R.id.item2) {
                    fragment = new SuperCoinFragment();
                } else if (id == R.id.item3) {
                    fragment = new VideoFragment();
                } else if (id == R.id.item4) {
                    fragment = new GamesFragment();
                }

                FragmentManager fm = getSupportFragmentManager();
                FragmentTransaction ft = fm.beginTransaction();
                assert fragment != null;
                ft.replace(R.id.frame, fragment);
                ft.commit();
                return true;
            }
        });
    }

    public void floatClick(View view) {
       *//* if (bottomNavigationView != null){
            bottomSheetBehavior.setPeekHeight(bottomNavigationView.getHeight() + 90);
        }*//*
        final BottomSheetDialog bottomSheetDialog = new BottomSheetDialog(
                BottomNavigationActivity.this, R.style.BottomSheetDialogTheme
        );
        View bottomSheetView = LayoutInflater.from(getApplicationContext()).inflate(R.layout.bottom_layout, (LinearLayout) findViewById(R.id.btmContainer));

        bottomSheetDialog.setContentView(bottomSheetView);
        bottomSheetDialog.show();

    }*/
}