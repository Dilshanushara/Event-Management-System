package com.example.myevent;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class Login extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }

    public void forgotpw(View view){
        Intent intent=new Intent(this,Forgotpassword.class);

        startActivity(intent);

    }

    public void afterlogin(View view){
        Intent intent=new Intent(this,Afterlogin.class);

        startActivity(intent);

    }








}
