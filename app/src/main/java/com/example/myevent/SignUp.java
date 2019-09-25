package com.example.myevent;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.example.myevent.EventPlanner.EventPlannerRegister1;

public class SignUp extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
    }
    public void regcust(View view){
        Intent intent=new Intent(this,Register.class);

        startActivity(intent);

    }
    public void regevnt(View view){
        Intent intent=new Intent(this, EventPlannerRegister1.class);

        startActivity(intent);

    }

}
