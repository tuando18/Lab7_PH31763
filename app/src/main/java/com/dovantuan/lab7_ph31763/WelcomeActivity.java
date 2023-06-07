package com.dovantuan.lab7_ph31763;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class WelcomeActivity extends AppCompatActivity {

    private static final int SPLASH_DURATION = 3000; // Thời gian chờ (3 giây)

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.welcome_main);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(WelcomeActivity.this, Activity_Bai2.class);
                startActivity(intent);
                finish();
            }
        },3000);

        ImageView logo1 = findViewById(R.id.logo1);
        TextView tv1 = findViewById(R.id.text1);

        Animation anim1 = AnimationUtils.loadAnimation(this,R.anim.anim1);
        logo1.startAnimation(anim1);

        Animation anim2 = AnimationUtils.loadAnimation(this,R.anim.anim2);
        tv1.startAnimation(anim2);
    }
}