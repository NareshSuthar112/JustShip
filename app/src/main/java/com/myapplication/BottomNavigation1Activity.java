package com.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.google.android.material.snackbar.Snackbar;

import static com.myapplication.R.id.item3;

public class BottomNavigation1Activity extends AppCompatActivity {

    BottomNavigationView bottomNavigationView;
    FrameLayout frameLayout;

    int flag = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bottom_navigation1);

        bottomNavigationView = findViewById(R.id.bottomNavigationView);
        frameLayout = findViewById(R.id.frame);

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                int id = item.getItemId();

                if (id == R.id.item1){
                    final BottomSheetDialog bottomSheetDialog = new BottomSheetDialog(
                            BottomNavigation1Activity.this, R.style.BottomSheetDialogTheme
                    );
                    View bottomSheetView = LayoutInflater.from(getApplicationContext()).inflate(R.layout.bottom_layout,findViewById(R.id.btmContainer));

                    bottomSheetDialog.setContentView(bottomSheetView);
                    bottomSheetDialog.show();
                }else if (id == R.id.item2) {
                    Snackbar.make(findViewById(R.id.c1),"Hello",Snackbar.LENGTH_LONG).show();
                }else if (id == item3){
                    if (flag == 0){
                        Toast.makeText(BottomNavigation1Activity.this, "Open", Toast.LENGTH_SHORT).show();
                        flag = 1;
                    }else{
                        Toast.makeText(BottomNavigation1Activity.this, "Close", Toast.LENGTH_SHORT).show();
                        item.setIcon(R.drawable.close_icon);
                        flag = 0;
                    }
                }

                return true;
            }
        });

    }
}