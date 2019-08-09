package com.example.myevent;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class edit_ad extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_ad);
    }

    public void save_ad(View view) {
        Intent intent = new Intent(this, select_ad.class);

        startActivity(intent);
    }

    public void cancel(View view) {
        Intent intent = new Intent(this, select_ad.class);

        startActivity(intent);
    }
}