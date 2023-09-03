package com.example.wallpaper_app;

import android.Manifest;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;


public class Intro extends AppCompatActivity {

    Animation topAnim, bottomAnim;
    ImageView imagetop,imagebottom;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intro);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent;
                intent = new Intent(Intro.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        }, 2500);

        topAnim = AnimationUtils.loadAnimation(this,R.anim.top_animation);
        bottomAnim = AnimationUtils.loadAnimation(this,R.anim.bottom_animation);

        imagetop = findViewById(R.id.imagetop);
        imagebottom = findViewById(R.id.imagebottom);
        textView = findViewById(R.id.slogan);

        imagetop.setAnimation(topAnim);
        imagebottom.setAnimation(bottomAnim);
        textView.setAnimation(bottomAnim);

    }
}
