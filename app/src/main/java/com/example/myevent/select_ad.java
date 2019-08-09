package com.example.myevent;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class select_ad extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_ad);
    }

    public void add1(View view) {
        Intent intent = new Intent(this, edit_ad.class);

        startActivity(intent);
    }

    public void add2(View view) {
        Intent intent = new Intent(this, edit_ad.class);

        startActivity(intent);
    }

    public void add3(View view) {
        Intent intent = new Intent(this, edit_ad.class);

        startActivity(intent);
    }

    public void add4(View view) {
        Intent intent = new Intent(this, edit_ad.class);

        startActivity(intent);
    }

    public void add5(View view) {
        Intent intent = new Intent(this, edit_ad.class);

        startActivity(intent);
    }
}