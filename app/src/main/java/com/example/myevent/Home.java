package com.example.myevent;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class Home extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
    }
    public void signin1(View view){
        Intent intent=new Intent(this,Login.class);

        startActivity(intent);

    }

    public void signup1(View view){
        Intent intent=new Intent(this,SignUp.class);

        startActivity(intent);

    }
}
