package com.example.myevent;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class Addevent2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addevent2);



        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }
}
