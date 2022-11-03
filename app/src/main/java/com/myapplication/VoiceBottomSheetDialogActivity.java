package com.myapplication;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.gif.GifDrawable;
import com.bumptech.glide.request.target.SimpleTarget;
import com.bumptech.glide.request.transition.Transition;
import com.google.android.material.bottomsheet.BottomSheetDialog;

import org.jetbrains.annotations.NotNull;

import java.util.Objects;

public class VoiceBottomSheetDialogActivity extends AppCompatActivity {

    Button btnVoice;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_voice_bottom_sheet_dialog);

        btnVoice = findViewById(R.id.btnVoice);

        btnVoice.setOnClickListener(v -> showBottomSheetDialog());
    }

    private void showBottomSheetDialog() {

        final BottomSheetDialog bottomSheetDialog = new BottomSheetDialog(VoiceBottomSheetDialogActivity.this, R.style.AppBottomSheetDialogTheme);
        bottomSheetDialog.setContentView(R.layout.raw_voice_bottom_sheet);

        /*ImageView imageView = bottomSheetDialog.findViewById(R.id.imgVoiceRipple);

        Glide.with(VoiceBottomSheetDialogActivity.this)
                .asGif().
                load(R.drawable.voice)
                .into(
                        new SimpleTarget<GifDrawable>() {
                            @Override
                            public void onResourceReady(@NonNull @NotNull GifDrawable resource, @Nullable @org.jetbrains.annotations.Nullable Transition<? super GifDrawable> transition) {
                                resource.start();
                                //resource.setLoopCount(1);
                                imageView.setImageDrawable(resource);
                            }
                        });*/

        bottomSheetDialog.show();

    }
}