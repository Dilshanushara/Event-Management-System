package com.example.myevent.EventPlanner;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.example.myevent.Model.EventPlanner;
import com.example.myevent.R;

public class EventPlannerRegister1 extends AppCompatActivity {

    EditText name,email,phone,age;
    Button next,BtnEventPlannerSignIn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registeraseventplanner);

        name = (EditText)findViewById(R.id.EdtEventplannerName);
        email = (EditText)findViewById(R.id.EdtEventPlannerEmail);
        phone = (EditText)findViewById(R.id.EdtEventPlannerPhone);
        age = (EditText)findViewById(R.id.EdtEventPlannerAge);

        next = (Button)findViewById(R.id.btnEventPlannerNext);
        BtnEventPlannerSignIn = (Button)findViewById(R.id.BtnEventPlannerSignIn);




        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String EventPlannerName= name.getText().toString();
                String EventPlannerEmail=email.getText().toString();
                String EventPlannerPhone=phone.getText().toString();
                String EventPlannerAge=age.getText().toString();

                Intent intent=new Intent(EventPlannerRegister1.this, EventPlannerRegister2.class);
                intent.putExtra("EventPlannerName",EventPlannerName);
                intent.putExtra("EventPlannerEmail",EventPlannerEmail);
                intent.putExtra("EventPlannerPhone",EventPlannerPhone);
                intent.putExtra("EventPlannerAge",EventPlannerAge);




                startActivity(intent);
                finish();

            }
        });



        BtnEventPlannerSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent reg1=new Intent(EventPlannerRegister1.this, EventPlannerSignIn.class);
                startActivity(reg1);
            }
        });







    }



}
