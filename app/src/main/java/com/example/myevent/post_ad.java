package com.example.myevent;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class post_ad extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post_ad);
    }

    public void post_ad(View view) {
        Intent intent = new Intent(this, select_ad.class);

        startActivity(intent);
    }
}