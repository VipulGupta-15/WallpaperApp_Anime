package com.example.wallpaper_app;

import androidx.appcompat.app.AppCompatActivity;

import android.app.WallpaperManager;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import java.io.IOException;

public class FullImageActivity extends AppCompatActivity {

    private ImageView fullImage;
    private Button HomeScreen,LockScreen;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_full_image);

        fullImage = findViewById(R.id.FullImage);
        HomeScreen = findViewById(R.id.HomeScreen);
        LockScreen = findViewById(R.id.LockScreen);

        Glide.with(this).load(getIntent().getStringExtra("image")).into(fullImage);

        HomeScreen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setBackground("Home Screen");
            }
        });
        LockScreen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setBackground("Lock Screen");
            }
        });
    }

    private void setBackground(String type) {
        Bitmap bitmap = ((BitmapDrawable)fullImage.getDrawable()).getBitmap();
        WallpaperManager manager = WallpaperManager.getInstance(getApplicationContext());
        Toast.makeText(FullImageActivity.this,"Wallpaper Applied",Toast.LENGTH_SHORT).show();
        try {
            if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.N){
                if(type.equals("Home Screen")){
                    manager.setBitmap(bitmap,null,true,manager.FLAG_SYSTEM);
                }
                else{
                    manager.setBitmap(bitmap,null,true,manager.FLAG_LOCK);
                }
            }
            else{
                manager.setBitmap(bitmap);
            }
        } catch (IOException e) {
            Toast.makeText(this,"Error: "+e.getMessage(),Toast.LENGTH_SHORT).show();
            e.printStackTrace();
        }
    }
}