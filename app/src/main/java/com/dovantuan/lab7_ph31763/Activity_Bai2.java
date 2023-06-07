package com.dovantuan.lab7_ph31763;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.LinearInterpolator;
import android.widget.Button;
import android.widget.ImageView;

public class Activity_Bai2 extends AppCompatActivity {

    ImageView logofan;

    Button btnFast;
    Button btnMedium;
    Button btnSlow;
    Button btnOff;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bai2);

        logofan = findViewById(R.id.logo_fan);

        btnFast = findViewById(R.id.btn_fast);
        btnMedium = findViewById(R.id.btn_medium);
        btnSlow = findViewById(R.id.btn_slow);
        btnOff = findViewById(R.id.btn_off);

        btnFast.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startFan(200);
            }
        });

        btnMedium.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startFan(400);
            }
        });

        btnSlow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startFan(600);
            }
        });

        btnOff.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                logofan.animate().cancel();
            }
        });

    }

//    CÁCH 1

    private void startFan(long time) {
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                logofan.animate()
                        .rotationBy(360)
                        .withEndAction(this)
                        .setDuration(time)
                        .setInterpolator(new LinearInterpolator())
                        .start();
            }
        };
        logofan.animate()
                .rotationBy(360)
                .withEndAction(runnable)
                .setDuration(time)
                .setInterpolator(new LinearInterpolator())
                .start();
    }

//    //CÁCH 2
//    private void startFan(long time) {
//        Animation animation = AnimationUtils.loadAnimation(this, R.anim.anim_bai2);
//        animation.setDuration(time);
//        logofan.startAnimation(animation);
//    }

}