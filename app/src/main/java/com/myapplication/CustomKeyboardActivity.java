package com.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.res.ColorStateList;
import android.os.Bundle;
import android.widget.LinearLayout;

public class CustomKeyboardActivity extends AppCompatActivity {

    LinearLayout llNum1, llNum2, llNum3, llNum4, llNum5, llNum6, llNum7, llNum8, llNum9, llNum0, llBackSpace;

    CardView card1, card2, card3, card4;

    String num1 = "", num2 = "", num3 = "", num4 = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom_keyboard);
        init();

        llNum0.setOnClickListener(v -> {
            if (num1.equals("")) {
                num1 = "0";
                card1.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.black)));
            } else if (num2.equals("")) {
                num2 = "0";
                card2.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.black)));
            } else if (num3.equals("")) {
                num3 = "0";
                card3.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.black)));
            } else if (num4.equals("")) {
                num4 = "0";
                card4.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.black)));
            }
        });

        llNum1.setOnClickListener(v -> {
            if (num1.equals("")) {
                num1 = "1";
                card1.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.black)));
            } else if (num2.equals("")) {
                num2 = "1";
                card2.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.black)));
            } else if (num3.equals("")) {
                num3 = "1";
                card3.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.black)));
            } else if (num4.equals("")) {
                num4 = "1";
                card4.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.black)));
            }
        });

        llNum2.setOnClickListener(v -> {
            if (num1.equals("")) {
                num1 = "2";
                card1.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.black)));
            } else if (num2.equals("")) {
                num2 = "2";
                card2.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.black)));
            } else if (num3.equals("")) {
                num3 = "2";
                card3.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.black)));
            } else if (num4.equals("")) {
                num4 = "2";
                card4.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.black)));
            }
        });

        llNum3.setOnClickListener(v -> {
            if (num1.equals("")) {
                num1 = "3";
                card1.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.black)));
            } else if (num2.equals("")) {
                num2 = "3";
                card2.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.black)));
            } else if (num3.equals("")) {
                num3 = "3";
                card3.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.black)));
            } else if (num4.equals("")) {
                num4 = "3";
                card4.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.black)));
            }
        });

        llNum4.setOnClickListener(v -> {
            if (num1.equals("")) {
                num1 = "4";
                card1.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.black)));
            } else if (num2.equals("")) {
                num2 = "4";
                card2.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.black)));
            } else if (num3.equals("")) {
                num3 = "4";
                card3.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.black)));
            } else if (num4.equals("")) {
                num4 = "4";
                card4.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.black)));
            }
        });

        llNum5.setOnClickListener(v -> {
            if (num1.equals("")) {
                num1 = "5";
                card1.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.black)));
            } else if (num2.equals("")) {
                num2 = "5";
                card2.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.black)));
            } else if (num3.equals("")) {
                num3 = "5";
                card3.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.black)));
            } else if (num4.equals("")) {
                num4 = "5";
                card4.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.black)));
            }
        });

        llNum6.setOnClickListener(v -> {
            if (num1.equals("")) {
                num1 = "6";
                card1.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.black)));
            } else if (num2.equals("")) {
                num2 = "6";
                card2.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.black)));
            } else if (num3.equals("")) {
                num3 = "6";
                card3.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.black)));
            } else if (num4.equals("")) {
                num4 = "6";
                card4.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.black)));
            }
        });

        llNum7.setOnClickListener(v -> {
            if (num1.equals("")) {
                num1 = "7";
                card1.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.black)));
            } else if (num2.equals("")) {
                num2 = "7";
                card2.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.black)));
            } else if (num3.equals("")) {
                num3 = "7";
                card3.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.black)));
            } else if (num4.equals("")) {
                num4 = "7";
                card4.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.black)));
            }
        });

        llNum8.setOnClickListener(v -> {
            if (num1.equals("")) {
                num1 = "8";
                card1.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.black)));
            } else if (num2.equals("")) {
                num2 = "8";
                card2.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.black)));
            } else if (num3.equals("")) {
                num3 = "8";
                card3.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.black)));
            } else if (num4.equals("")) {
                num4 = "8";
                card4.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.black)));
            }
        });

        llNum9.setOnClickListener(v -> {
            if (num1.equals("")) {
                num1 = "9";
                card1.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.black)));
            } else if (num2.equals("")) {
                num2 = "9";
                card2.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.black)));
            } else if (num3.equals("")) {
                num3 = "9";
                card3.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.black)));
            } else if (num4.equals("")) {
                num4 = "9";
                card4.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.black)));
            }
        });

        llBackSpace.setOnClickListener(v -> {
            if (!num4.equals("")) {
                num4 = "";
                card4.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.blue)));
            } else if (!num3.equals("")) {
                num3 = "";
                card3.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.blue)));
            } else if (!num2.equals("")) {
                num2 = "";
                card2.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.blue)));
            } else if (!num1.equals("")) {
                num1 = "";
                card1.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.blue)));
            }
        });
    }

    private void init() {
        llNum1 = findViewById(R.id.llNum1);
        llNum2 = findViewById(R.id.llNum2);
        llNum3 = findViewById(R.id.llNum3);
        llNum4 = findViewById(R.id.llNum4);
        llNum5 = findViewById(R.id.llNum5);
        llNum6 = findViewById(R.id.llNum6);
        llNum7 = findViewById(R.id.llNum7);
        llNum8 = findViewById(R.id.llNum8);
        llNum9 = findViewById(R.id.llNum9);
        llNum0 = findViewById(R.id.llNum0);
        llBackSpace = findViewById(R.id.llBackSpace);
        card1 = findViewById(R.id.card1);
        card2 = findViewById(R.id.card2);
        card3 = findViewById(R.id.card3);
        card4 = findViewById(R.id.card4);
    }
}