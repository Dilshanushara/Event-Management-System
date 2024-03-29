package com.example.myevent;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import com.example.myevent.Customer.Home;
import com.example.myevent.Customer.Login;
import com.example.myevent.Customer.Register;

public class Splash extends AppCompatActivity {

    private static  int Splash=4000;

    @RequiresApi(api = Build.VERSION_CODES.P)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent i=new Intent(Splash.this, MainActivity.class);
                startActivity(i);
                finish();

            }
        },Splash);

    }
}
