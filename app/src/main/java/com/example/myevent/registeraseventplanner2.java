package com.example.myevent;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class registeraseventplanner2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registeraseventplanner2);
    }


    public void onsubmit(View view){
        Intent intent=new Intent(this,evtwelcomepg.class);

        startActivity(intent);

    }
}
