package com.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;

import com.scwang.wave.MultiWaveHeader;

public class WaveViewActivity extends AppCompatActivity {

    MultiWaveHeader waveHeader;

    CardView btnLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wave_view);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP){
            Window window = getWindow();
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.setStatusBarColor(getResources().getColor(R.color.status_color));
        }

        btnLogin = findViewById(R.id.btnLogin);
        waveHeader = findViewById(R.id.wave);


        btnLogin.setOnClickListener(v -> startActivity(new Intent(WaveViewActivity.this,CustomKeyboardActivity.class)));

        /*waveHeader.setColorAlpha(.5f);
        waveHeader.setGradientAngle(360);
        waveHeader.setProgress(.6f);
        waveHeader.setVelocity(2f);*/

        waveHeader.start();
        //waveHeader.stop();
        //waveHeader.isRunning();
    }
}