package com.googlemaps.Glide;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;

import com.googlemaps.R;
import com.googlemaps.Retrofit.Models.ModelPhoto;

import java.util.ArrayList;

public class GlideActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_glide);
        Intent intent = getIntent();
        Bundle bundle = intent.getBundleExtra("url");
        ArrayList<String> urls = bundle.getStringArrayList("url");
        ViewPager mPager = findViewById(R.id.vpager);
        mPager.setAdapter(new SlidingAdapter(GlideActivity.this, urls));
    }
}